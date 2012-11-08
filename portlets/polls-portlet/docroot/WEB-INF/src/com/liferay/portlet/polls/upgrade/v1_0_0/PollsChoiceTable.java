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

package com.liferay.portlet.polls.upgrade.v1_0_0;

import java.sql.Types;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PollsChoiceTable {

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"choiceId", Types.BIGINT},
		{"questionId", Types.BIGINT},
		{"name", Types.VARCHAR},
		{"description", Types.VARCHAR}
	};
	
	public static final String TABLE_NAME = "Polls_PollsChoice";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_34C7EF05 on Polls_PollsChoice (questionId)",
		"create unique index IX_A1F22704 on Polls_PollsChoice (questionId, name)",
		"create index IX_3A6EE84 on Polls_PollsChoice (uuid_)"
	};
	
	public static final String TABLE_SQL_CREATE = "create table Polls_PollsChoice (uuid_ VARCHAR(75) null,choiceId LONG not null primary key,questionId LONG,name VARCHAR(75) null,description STRING null)";

	public static final String TABLE_SQL_DROP = "drop table Polls_PollsChoice";

}