/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portlet.directory.usergroup.viewusergroupuser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownUserTest extends BaseTestCase {
	public void testTearDownUser() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.open("/web/guest/home/");
				loadRequiredJavaScriptModules();

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("link=Control Panel")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();
				selenium.clickAt("link=Users and Organizations",
					RuntimeVariables.replace("Users and Organizations"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();
				selenium.clickAt("link=Search All Users",
					RuntimeVariables.replace("Search All Users"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();

				boolean basic1Visible = selenium.isVisible("link=\u00ab Basic");

				if (!basic1Visible) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace("\u00ab Basic"));

			case 2:
				selenium.type("//input[@name='_125_keywords']",
					RuntimeVariables.replace("usersn"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();

				boolean UsersExists = selenium.isPartialText("//div[5]",
						"No users were found");

				if (UsersExists) {
					label = 3;

					continue;
				}

				selenium.clickAt("//input[@name='_125_allRowIds']",
					RuntimeVariables.replace("Check All"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Deactivate']"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to deactivate the selected users[\\s\\S]$"));

			case 3:
				selenium.clickAt("link=Advanced \u00bb",
					RuntimeVariables.replace("Advanced \u00bb"));

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//select[@id='_125_status']")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.select("//select[@id='_125_status']",
					RuntimeVariables.replace("Inactive"));
				selenium.clickAt("//div[2]/span[2]/span/input",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();

				boolean user1Deleted = selenium.isElementPresent(
						"//input[@name='_125_rowIds']");

				if (!user1Deleted) {
					label = 4;

					continue;
				}

				selenium.clickAt("//input[@name='_125_rowIds']",
					RuntimeVariables.replace("Entry Check Box"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to permanently delete the selected users[\\s\\S]$"));

				boolean user2Deleted = selenium.isElementPresent(
						"//input[@name='_125_rowIds']");

				if (!user2Deleted) {
					label = 5;

					continue;
				}

				selenium.clickAt("//input[@name='_125_rowIds']",
					RuntimeVariables.replace("Entry Check Box"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to permanently delete the selected users[\\s\\S]$"));

				boolean user3Deleted = selenium.isElementPresent(
						"//input[@name='_125_rowIds']");

				if (!user3Deleted) {
					label = 6;

					continue;
				}

				selenium.clickAt("//input[@name='_125_rowIds']",
					RuntimeVariables.replace("Entry Check Box"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to permanently delete the selected users[\\s\\S]$"));

				boolean user4Deleted = selenium.isElementPresent(
						"//input[@name='_125_rowIds']");

				if (!user4Deleted) {
					label = 7;

					continue;
				}

				selenium.clickAt("//input[@name='_125_rowIds']",
					RuntimeVariables.replace("Entry Check Box"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to permanently delete the selected users[\\s\\S]$"));

				boolean user5Deleted = selenium.isElementPresent(
						"//input[@name='_125_rowIds']");

				if (!user5Deleted) {
					label = 8;

					continue;
				}

				selenium.clickAt("//input[@name='_125_rowIds']",
					RuntimeVariables.replace("Entry Check Box"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				loadRequiredJavaScriptModules();
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to permanently delete the selected users[\\s\\S]$"));

			case 4:
			case 5:
			case 6:
			case 7:
			case 8:

				boolean basic2Visible = selenium.isVisible("link=\u00ab Basic");

				if (!basic2Visible) {
					label = 9;

					continue;
				}

				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace("\u00ab Basic"));

			case 9:
			case 100:
				label = -1;
			}
		}
	}
}