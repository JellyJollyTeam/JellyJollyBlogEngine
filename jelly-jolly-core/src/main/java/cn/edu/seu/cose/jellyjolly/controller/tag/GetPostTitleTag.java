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

package cn.edu.seu.cose.jellyjolly.controller.tag;

import cn.edu.seu.cose.jellyjolly.dao.BlogPostDataAccess;
import cn.edu.seu.cose.jellyjolly.dao.DataAccessException;
import cn.edu.seu.cose.jellyjolly.dao.DataAccessFactory;
import cn.edu.seu.cose.jellyjolly.dao.DataAccessFactoryManager;
import cn.edu.seu.cose.jellyjolly.dto.BlogPost;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class GetPostTitleTag extends SimpleTagSupport {

    private BlogPostDataAccess blogPostDao;

    private long postId;

    private static BlogPostDataAccess getBlogPostDataAccess() {
            DataAccessFactoryManager manager =
                DataAccessFactoryManager.getInstance();
            DataAccessFactory factory = manager.getAvailableFactory();
            return factory.getBlogPostDataAccess();
    }

    public GetPostTitleTag() {
            blogPostDao = getBlogPostDataAccess();
    }

    public void setPostId(Object postId) {
        this.postId = (Long) postId;
    }

    @Override
    public void doTag() throws IOException {
        try {
            BlogPost post = blogPostDao.getPostById(postId);
            String title = post.getTitle();
            getJspContext().getOut().print(title);
        } catch (DataAccessException ex) {
            Logger.getLogger(GetPostTitleTag.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

}
