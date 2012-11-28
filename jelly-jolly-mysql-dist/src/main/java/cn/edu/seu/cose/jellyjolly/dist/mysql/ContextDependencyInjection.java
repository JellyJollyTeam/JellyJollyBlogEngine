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
package cn.edu.seu.cose.jellyjolly.dist.mysql;

import cn.edu.seu.cose.jellyjolly.dao.DataAccessFactory;
import cn.edu.seu.cose.jellyjolly.dao.jdbc.MysqlDataAccessFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class ContextDependencyInjection implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(
            ContextDependencyInjection.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        try {
            Reader configReader = getConfigReader(ctx);
            Properties cfgpp = getConfigPropertiesByReader(configReader);
            DataSource dataSource = getDataSourceByProperties(cfgpp);
            injectContextDependency(dataSource, ctx);
        } catch (Exception ex) {
            logger.log(Level.SEVERE,
                    "Failed during injecting the context dependency");
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    private Reader getConfigReader(ServletContext ctx)
            throws FileNotFoundException {
        String realPath = ctx.getRealPath("/");
        String dbcpConfigPath = new StringBuilder().append(realPath)
                .append("WEB-INF/dbcp.jdbc.properties").toString();
        logger.log(Level.INFO, new StringBuilder()
                .append("Reading config from: ")
                .append(dbcpConfigPath)
                .toString());
        File dbcpConfigFile = new File(dbcpConfigPath);
        Reader configReader = new FileReader(dbcpConfigFile);
        return configReader;
    }

    private Properties getConfigPropertiesByReader(Reader configReader)
            throws IOException {
        Properties cfgpp = new Properties();
        cfgpp.load(configReader);
        return cfgpp;
    }

    private DataSource getDataSourceByProperties(Properties cfgpp) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(cfgpp.getProperty(
                "jdbc.driverClassName"));
        dataSource.setUrl(cfgpp.getProperty("jdbc.url"));
        dataSource.setUsername(cfgpp.getProperty("jdbc.username"));
        dataSource.setPassword(cfgpp.getProperty("jdbc.password"));
        return dataSource;
    }

    private void injectContextDependency(DataSource dataSource,
            ServletContext ctx) {
        DataAccessFactory dataAccessFactory =
                new MysqlDataAccessFactory(dataSource);
        ctx.setAttribute("cn.edu.seu.cose.jellyjolly.adminUserDataAccess",
                dataAccessFactory.getAdminUserDataAccess());
        ctx.setAttribute("cn.edu.seu.cose.jellyjolly.blogInfoDataAccess",
                dataAccessFactory.getBlogInfoDataAccess());
        ctx.setAttribute("cn.edu.seu.cose.jellyjolly.blogPageDataAccess",
                dataAccessFactory.getBlogPageDataAccess());
        ctx.setAttribute("cn.edu.seu.cose.jellyjolly.blogPostDataAccess",
                dataAccessFactory.getBlogPostDataAccess());
        ctx.setAttribute("cn.edu.seu.cose.jellyjolly.categoryDataAccess",
                dataAccessFactory.getCategoryDataAccess());
        ctx.setAttribute("cn.edu.seu.cose.commentDataAccess.",
                dataAccessFactory.getCommentDataAccess());
        ctx.setAttribute("cn.edu.seu.cose.linkDataAccess.",
                dataAccessFactory.getLinkDataAccess());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
