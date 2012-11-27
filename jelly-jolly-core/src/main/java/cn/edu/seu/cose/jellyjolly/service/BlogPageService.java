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
package cn.edu.seu.cose.jellyjolly.service;

import cn.edu.seu.cose.jellyjolly.dao.DataAccessException;
import cn.edu.seu.cose.jellyjolly.dto.BlogPage;
import java.util.List;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public interface BlogPageService {

    BlogPage getBlogPageById(int id) throws DataAccessException;

    List<String> getBlogPageTitles() throws DataAccessException;

    BlogPage addBlogPage(String title, String content)
            throws DataAccessException;

    void changeTitle(int id, String title) throws DataAccessException;

    void changeContent(int id, String content) throws DataAccessException;

    void deleteBlogPageById(int id) throws DataAccessException;
}
