/*
 * Copyright (C) 2012 Colleage of Software Engineering, Southeast University
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cn.edu.seu.cose.jellyjolly.dao;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class DataAccessFactoryManager {

    private static final String NA_FACTORY_HINT = "No Available Factory";

    private static final String REGISTER_FACTORY_HINT = "Registering factory: ";

    private static final String REGISTER_FAILURE_HINT = "Fail to register factory: ";

    private static DataAccessFactoryManager managerInstance;

    private Map<String, Class<? extends DataAccessFactory>> factoryInstances;

    private static String getRegisterHint(String factoryClassName) {
        StringBuilder builder = new StringBuilder();
        builder.append(REGISTER_FACTORY_HINT).append(factoryClassName);
        return builder.toString();
    }

    private static String getRegisterFailureHint(String className) {
        StringBuilder builder = new StringBuilder();
        builder.append(REGISTER_FAILURE_HINT).append(className);
        return builder.toString();
    }

    public static DataAccessFactoryManager getInstance() {
        if (managerInstance == null) {
            managerInstance = new DataAccessFactoryManager();
        }
        return managerInstance;
    }

    protected DataAccessFactoryManager() {
        factoryInstances =
                new HashMap<String, Class<? extends DataAccessFactory>>();
        init();
    }

    private synchronized void init() {
        if (!factoryInstances.isEmpty()) {
            factoryInstances.clear();
        }
    }

    public synchronized void register(String className) {
        register(className, className);
    }

    public synchronized void register(String name, String className) {
        try {
            Class<?> cls = Class.forName(className);
            if (!DataAccessFactory.class.isAssignableFrom(cls)) {
                Logger.getLogger(DataAccessFactoryManager.class.getName())
                        .log(Level.SEVERE, getRegisterFailureHint(className));
                return;
            }

            Logger.getLogger(DataAccessFactoryManager.class.getName())
                    .log(Level.INFO, getRegisterHint(className));
            factoryInstances.put(name, (Class<?  extends DataAccessFactory>) cls);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccessFactoryManager.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void reload() {
        init();
    }

    public void clear() {
        factoryInstances.clear();
    }

    public DataAccessFactory getDataAccessFactory(String name) {
        Class<? extends DataAccessFactory> factoryCls =
                factoryInstances.get(name);
        try {
            Constructor<? extends DataAccessFactory> constructor =
                    factoryCls.getConstructor();
            return (DataAccessFactory) constructor.newInstance();
        } catch (Exception ex) {
            Logger.getLogger(DataAccessFactoryManager.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    public DataAccessFactory getAvailableFactory() {
        Collection<Class<? extends DataAccessFactory>> c =
                factoryInstances.values();
        Iterator<Class<? extends DataAccessFactory>> it = c.iterator();
        if (!it.hasNext()) {
            Logger.getLogger(DataAccessFactoryManager.class.getName())
                    .log(Level.SEVERE, NA_FACTORY_HINT);
            return null;
        }

        Class<? extends DataAccessFactory> factoryCls = it.next();
        try {
            Constructor<? extends DataAccessFactory> constructor =
                    factoryCls.getConstructor();
            return constructor.newInstance();
        } catch (Exception ex) {
            Logger.getLogger(DataAccessFactoryManager.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
    }

}
