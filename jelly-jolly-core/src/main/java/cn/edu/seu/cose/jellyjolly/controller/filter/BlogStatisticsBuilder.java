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

import cn.edu.seu.cose.jellyjolly.model.bean.BlogStatistics;
import cn.edu.seu.cose.jellyjolly.model.dao.BlogPageDataAccess;
import cn.edu.seu.cose.jellyjolly.model.dao.BlogPostDataAccess;
import cn.edu.seu.cose.jellyjolly.model.dao.CategoryDataAccess;
import cn.edu.seu.cose.jellyjolly.model.dao.CommentDataAccess;
import cn.edu.seu.cose.jellyjolly.model.dao.DataAccessException;
import cn.edu.seu.cose.jellyjolly.model.dao.DataAccessFactory;
import cn.edu.seu.cose.jellyjolly.model.dao.DataAccessFactoryManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class BlogStatisticsBuilder extends HttpFilter {
    
    private static final String ATTR_BLOG_STATISTICS = "blogstat";
    
    private DataAccessFactory factory;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        DataAccessFactoryManager manager = DataAccessFactoryManager.getInstance();
        factory = manager.getAvailableFactory();
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            BlogPostDataAccess blogPostDao = factory.getBlogPostDataAccess();
            long postCount = blogPostDao.getPostNumber();
            
            BlogPageDataAccess blogPageDao = factory.getBlogPageDataAccess();
            int pageCount = blogPageDao.getPageCount();
            
            CategoryDataAccess categoryDao = factory.getCategoryDataAccess();
            int categoryCount = categoryDao.getCategoryNumber();
            
            CommentDataAccess commentDao = factory.getCommentDataAccess();
            long commentCount = commentDao.getCommentNumber();
            
            BlogStatistics statistics = new BlogStatistics();
            statistics.setCategoryCount(categoryCount);
            statistics.setCommentCount(commentCount);
            statistics.setPageCount(pageCount);
            statistics.setPostCount(postCount);
            
            request.setAttribute(ATTR_BLOG_STATISTICS, statistics);
            chain.doFilter(request, response);
        } catch (DataAccessException ex) {
            Logger.getLogger(BlogStatisticsBuilder.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
            response.sendError(500, ex.getMessage());
        }
    }

}
