/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */

package com.liferay.portlet.polls.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.polls.model.PollsQuestion;
import com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class PollsQuestionPermission {

	public static void check(
			PermissionChecker permissionChecker, long questionId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, questionId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, PollsQuestion question,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, question, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long questionId,
			String actionId)
		throws PortalException, SystemException {

		PollsQuestion question = PollsQuestionLocalServiceUtil.getQuestion(
			questionId);

		return contains(permissionChecker, question, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, PollsQuestion question,
		String actionId) {

		if (permissionChecker.hasOwnerPermission(
				question.getCompanyId(), PollsQuestion.class.getName(),
				question.getQuestionId(), question.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			question.getGroupId(), PollsQuestion.class.getName(),
			question.getQuestionId(), actionId);
	}

}