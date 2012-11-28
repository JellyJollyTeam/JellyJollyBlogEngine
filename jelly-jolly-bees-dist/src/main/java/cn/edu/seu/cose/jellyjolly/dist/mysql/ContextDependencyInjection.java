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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class ContextDependencyInjection implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(
            ContextDependencyInjection.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.log(Level.INFO,
                "Injecting the context dependency");
        ServletContext ctx = sce.getServletContext();
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup(
                    "java:comp/env/jdbc/jellyjolly_schema");
            injectContextDependency(dataSource, ctx);
        } catch (Exception ex) {
            logger.log(Level.SEVERE,
                    "Failed during injecting the context dependency");
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        logger.log(Level.INFO, "Context dependency Injected");
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
        ctx.setAttribute("cn.edu.seu.cose.jellyjolly.commentDataAccess",
                dataAccessFactory.getCommentDataAccess());
        ctx.setAttribute("cn.edu.seu.cose.jellyjolly.linkDataAccess",
                dataAccessFactory.getLinkDataAccess());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
