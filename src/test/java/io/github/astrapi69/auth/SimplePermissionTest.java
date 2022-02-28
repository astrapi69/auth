/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.auth;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import io.github.astrapi69.auth.SimplePermission;
import org.meanbean.test.BeanTester;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.astrapi69.BaseTestCase;
import io.github.astrapi69.auth.api.Permission;
import io.github.astrapi69.evaluate.object.verifier.ContractVerifier;
import io.github.astrapi69.file.csv.CsvFileExtensions;
import io.github.astrapi69.file.search.PathFinder;

/**
 * The unit test class for the class {@link SimplePermission}
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public class SimplePermissionTest extends BaseTestCase
{

	/** The permissions. */
	List<String> permissions;

	/**
	 * Sets up method will be invoked before every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeMethod
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		final File srctestresDir = PathFinder.getSrcTestResourcesDir();
		final File resources = new File(srctestresDir, "resources");
		final File userrole = new File(resources, "userrole");
		this.permissions = CsvFileExtensions.readFileToList(userrole);
	}

	/**
	 * Tear down method will be invoked after every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@AfterMethod
	@Override
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	/**
	 * Test method for {@link SimplePermission#getDescription()}
	 */
	@Test
	public void testGetDescription()
	{
		final Permission ar = new SimplePermission();
		final String expected = "read data from table rooms";
		final String far = this.permissions.get(0);
		ar.setDescription(far);
		ar.setPermissionName(far);
		final String compare = far;
		actual = expected.equals(compare);
		assertTrue(actual);
	}

	/**
	 * Test method for {@link SimplePermission#getPermissionName()}
	 */
	@Test
	public void testGetName()
	{
		final Permission ar = new SimplePermission();
		final String expected = "read data from table rooms";
		final String far = this.permissions.get(0);
		ar.setDescription(far);
		ar.setPermissionName(far);
		final String compare = far;
		actual = expected.equals(compare);
		assertTrue(actual);
	}

	/**
	 * Test method for {@link SimplePermission}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(SimplePermission.class);
	}

	/**
	 * Test method for {@link SimplePermission#equals(Object)} , {@link SimplePermission#hashCode()}
	 * and {@link SimplePermission#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(SimplePermission.class).verify();
	}

}
