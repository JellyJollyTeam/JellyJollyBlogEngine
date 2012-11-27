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
import cn.edu.seu.cose.jellyjolly.dto.AdminUser;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public interface AdminUserService {

    AdminUser getAdminUserById(long id) throws DataAccessException;

    AdminUser authenicate(String username, String password)
            throws DataAccessException, NotAuthenicatedException;

    AdminUser createAdminUser(String username, String password, String email,
            String homePage, String displayName) throws DataAccessException;

    AdminUser deleteAdminUserById(long id) throws DataAccessException;

    void changeUsername(long id, String username) throws DataAccessException;

    void changePassword(long id, String password) throws DataAccessException;

    void changeEmail(long id, String email) throws DataAccessException;

    void changeDisplayName(long id, String displayName)
            throws DataAccessException;

    void changeHomePage(long id, String homePage) throws DataAccessException;

    AdminUser deleteAdminUserByUsername(String username)
            throws DataAccessException;

    class NotAuthenicatedException extends Exception {

        public NotAuthenicatedException() {
            super("not authenicated");
        }

        public NotAuthenicatedException(String username) {
            super(username + " not authenicated");
        }
    }
}
