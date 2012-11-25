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

package cn.edu.seu.cose.jellyjolly.controller.servlet;

import cn.edu.seu.cose.jellyjolly.model.dao.BlogInfoDataAccess;
import cn.edu.seu.cose.jellyjolly.model.dao.DataAccessException;
import cn.edu.seu.cose.jellyjolly.model.dao.DataAccessFactory;
import cn.edu.seu.cose.jellyjolly.model.dao.DataAccessFactoryManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
@WebServlet(name = "BlogInfoOperation", urlPatterns = {"/admin/info"})
public class BlogInfoOperation extends HttpServlet {
    
    private static final String PARAM_TITLE = "title";
    
    private static final String PARAM_SUBTITLE = "subtitle";
    
    private static final String PARAM_URL = "url";
    
    private static BlogInfoDataAccess getBlogInfoDataAccess() {
            DataAccessFactoryManager manager =
                DataAccessFactoryManager.getInstance();
            DataAccessFactory factory = manager.getAvailableFactory();
            return factory.getBlogInfoDataAccess();
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String title = request.getParameter(PARAM_TITLE);
        String subtitle = request.getParameter(PARAM_SUBTITLE);
        String url = request.getParameter(PARAM_URL);
        
        BlogInfoDataAccess blogInfoDao = getBlogInfoDataAccess();
        
        try {
            if (title != null) {
                blogInfoDao.setBlogTitle(title);
            }
            if (subtitle != null) {
                blogInfoDao.setBlogSubTitle(subtitle);
            }
            if (url != null) {
                blogInfoDao.setBlogUrl(url);
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(BlogInfoOperation.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
            response.sendError(500, ex.getMessage());
        }
    }

}
