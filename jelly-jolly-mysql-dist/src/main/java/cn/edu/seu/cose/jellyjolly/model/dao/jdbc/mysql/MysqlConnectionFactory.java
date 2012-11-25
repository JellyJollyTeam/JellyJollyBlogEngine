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

package cn.edu.seu.cose.jellyjolly.model.dao.jdbc.mysql;

import cn.edu.seu.cose.jellyjolly.model.dao.jdbc.ConnectionFactory;
import cn.edu.seu.cose.jellyjolly.model.dao.jdbc.JdbcDataAccessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class MysqlConnectionFactory implements ConnectionFactory {
    
    private DataSource dataSource;
    
    public MysqlConnectionFactory() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/jellyjolly_schema");
        } catch (NamingException ex) {
            Logger.getLogger(MysqlConnectionFactory.class.getName())
                    .log(Level.SEVERE, ex.getMessage());
        }
    }

    @Override
    public Connection newConnection() throws JdbcDataAccessException {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            throw new JdbcDataAccessException(ex);
        }
    }

    @Override
    public void closeConnection(Connection connection) throws JdbcDataAccessException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw new JdbcDataAccessException(ex);
        }
    }

    @Override
    public void rollbackConnection(Connection connection) throws JdbcDataAccessException {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException ex) {
            throw new JdbcDataAccessException(ex);
        }
    }

}
