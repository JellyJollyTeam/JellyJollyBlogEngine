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

package cn.edu.seu.cose.jellyjolly.rest.dto.adapter;

import cn.edu.seu.cose.jellyjolly.dto.BlogPost;
import cn.edu.seu.cose.jellyjolly.rest.dto.BlogPostInstance;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class BlogPostInstanceAdapter implements
        Adapter<BlogPost, BlogPostInstance> {

    public BlogPostInstanceAdapter() {

    }

    @Override
    public BlogPostInstance adapt(BlogPost adaptee) {
        BlogPostInstance target = new BlogPostInstance();
        // ...
        return target;
    }

}
