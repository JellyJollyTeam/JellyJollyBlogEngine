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
import cn.edu.seu.cose.jellyjolly.dto.BlogPost;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public interface BlogPostService {

    BlogPost getBlogPostById(long id) throws DataAccessException;

    Collection<BlogPost> getBlogPostsOrderByDateDescending(
            long index, long count) throws DataAccessException;

    Collection<BlogPost> getBlogPostsByKeyword(String keyword)
            throws DataAccessException;

    Collection<BlogPost> getBlogPostsByCategory(int categoryId)
            throws DataAccessException;

    BlogPost createBlogPost(String title, String content, long authorUserId,
            int categoryId, Date publishDate) throws DataAccessException;

    void changeTitle(String title) throws DataAccessException;

    void changeContext(String content) throws DataAccessException;

    void changeCategory(int categoryId) throws DataAccessException;

    void changeAuthor(long authorUserId) throws DataAccessException;

    void updateBlogPost(BlogPost blogPost) throws DataAccessException;

    void deleteBlogPostById(long id) throws DataAccessException;
}
