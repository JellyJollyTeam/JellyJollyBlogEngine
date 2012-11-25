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

package cn.edu.seu.cose.jellyjolly.model.dao.jdbc.sae;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class SaeConnectionFactory {
    
    private static final String JDBC_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    
    private static final String JDBC_BASE_URL =
            "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_";
    
    private String jdbcUrl;
    
    private String username;
    
    private String password;
    
    private static SaeConnectionFactory instance;
    
    public static SaeConnectionFactory getInstance() {
        if (instance == null) {
            instance = new SaeConnectionFactory();
        }
        return instance;
    }
    
    protected SaeConnectionFactory() {
        //jdbcUrl = JDBC_BASE_URL + SaeUserInfo.getAppName();
        //username = SaeUserInfo.getAccessKey();
        //password = SaeUserInfo.getSecretKey();
        try {
            Class.forName(JDBC_DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaeConnectionFactory.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

}
