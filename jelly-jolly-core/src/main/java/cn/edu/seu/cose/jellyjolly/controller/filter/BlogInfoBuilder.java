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

package cn.edu.seu.cose.jellyjolly.controller.filter;

import cn.edu.seu.cose.jellyjolly.model.bean.BlogInfo;
import cn.edu.seu.cose.jellyjolly.model.dao.BlogInfoDataAccess;
import cn.edu.seu.cose.jellyjolly.model.dao.DataAccessException;
import cn.edu.seu.cose.jellyjolly.model.dao.DataAccessFactory;
import cn.edu.seu.cose.jellyjolly.model.dao.DataAccessFactoryManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class BlogInfoBuilder extends HttpFilter {
    
    private static final String ATTR_BLOG_INFO = "blogInfo";
    
    private static BlogInfoDataAccess getBlogInfoDataAccess() {
        DataAccessFactoryManager manager =
                DataAccessFactoryManager.getInstance();
        DataAccessFactory factory = manager.getAvailableFactory();
        return factory.getBlogInfoDataAccess();
    }
    
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            BlogInfoDataAccess blogInfoDao = getBlogInfoDataAccess();
            BlogInfo blogInfo = blogInfoDao.getBlogInfoInstance();
            request.setAttribute(ATTR_BLOG_INFO, blogInfo);
        } catch (DataAccessException ex) {
            Logger.getLogger(BlogInfoBuilder.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
            response.sendError(500, ex.getMessage());
            return;
        }
        Logger.getLogger(BlogInfoBuilder.class.getName())
                .log(Level.INFO, "BlogInfoBuilder");
        chain.doFilter(request, response);
    }

}
