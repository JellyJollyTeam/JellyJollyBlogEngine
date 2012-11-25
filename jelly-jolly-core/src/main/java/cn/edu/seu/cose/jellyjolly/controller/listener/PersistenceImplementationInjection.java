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
package cn.edu.seu.cose.jellyjolly.controller.listener;

import cn.edu.seu.cose.jellyjolly.model.dao.DataAccessFactoryManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author rAy <predator.ray@gmail.com>
 */
@WebListener()
public class PersistenceImplementationInjection
        implements ServletContextListener {
    
    private static final String FACTORY_IMPL_CLASS_NAME = "dao-factory-class-name";
    
    private static final String EXCEPTION_MESSAGE = "context-param: "
            + FACTORY_IMPL_CLASS_NAME + " is empty";
    
    private static final String INJECT_HINT = "Injecting ";
    
    private static String getInjectHint(String factoryImplClassName) {
        StringBuilder builder = new StringBuilder();
        builder.append(INJECT_HINT).append(factoryImplClassName);
        return builder.toString();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String factoryImplClassName =
                context.getInitParameter(FACTORY_IMPL_CLASS_NAME);
        if (factoryImplClassName == null) {
            Logger.getLogger(PersistenceImplementationInjection.class.getName())
                    .log(Level.SEVERE, EXCEPTION_MESSAGE);
            return;
        }
        Logger.getLogger(PersistenceImplementationInjection.class.getName())
                .log(Level.INFO, getInjectHint(factoryImplClassName));
        DataAccessFactoryManager manager = DataAccessFactoryManager.getInstance();
        manager.register(factoryImplClassName, factoryImplClassName);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DataAccessFactoryManager manager = DataAccessFactoryManager.getInstance();
        manager.clear();
    }

}
