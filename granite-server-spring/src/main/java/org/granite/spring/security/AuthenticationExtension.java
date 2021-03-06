/**
 *   GRANITE DATA SERVICES
 *   Copyright (C) 2006-2015 GRANITE DATA SERVICES S.A.S.
 *
 *   This file is part of the Granite Data Services Platform.
 *
 *   Granite Data Services is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or (at your option) any later version.
 *
 *   Granite Data Services is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 *   General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free Software
 *   Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,
 *   USA, or see <http://www.gnu.org/licenses/>.
 */
package org.granite.spring.security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpSession;

/**
 * Created by william on 23/01/14.
 */
public interface AuthenticationExtension extends ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext);

    public Authentication buildAuthentication(String user, String password);

    public void setAuthenticationManager(AuthenticationManager authenticationManager);

    public void setAuthenticationManagerBeanName(String authenticationManagerBeanName);

    public AuthenticationManager selectAuthenticationManager(Authentication authentication);

    public void endSession(HttpSession session);
}
