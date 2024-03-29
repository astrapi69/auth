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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.meanbean.test.BeanTester;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.astrapi69.auth.api.Permission;
import io.github.astrapi69.auth.api.Role;
import io.github.astrapi69.auth.api.User;
import io.github.astrapi69.collections.set.SetFactory;
import io.github.astrapi69.evaluate.object.verifier.ContractVerifier;
import io.github.astrapi69.file.csv.CsvFileExtensions;
import io.github.astrapi69.file.search.PathFinder;

/**
 * The unit test class for the class {@link SimpleUser}.
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public class SimpleUserTest
{

	/** The accessrights1. */
	List<String> accessrights1;

	/** The accessrights2. */
	List<String> accessrights2;

	/** The ars. */
	Set<Permission> ars;

	/** The ars2. */
	Set<Permission> ars2;

	/** The testrole. */
	Role<Permission> testrole;

	/** The testrole2. */
	Role<Permission> testrole2;

	/** The testuser. */
	User<Permission, Role<Permission>> testuser;

	/**
	 * Sets up method will be invoked before every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeMethod
	protected void setUp() throws Exception
	{
		final File srctestresDir = PathFinder.getSrcTestResourcesDir();
		final File resources = new File(srctestresDir, "resources");
		final File userrole = new File(resources, "userrole");
		final File directorrole = new File(resources, "directorrole");
		this.accessrights1 = CsvFileExtensions.readFileToList(userrole);
		this.accessrights2 = CsvFileExtensions.readFileToList(directorrole);
		this.ars = new HashSet<>(this.accessrights1.size());
		this.ars2 = new HashSet<>(this.accessrights2.size());
		for (final String object : this.accessrights1)
		{
			final Permission accrig = new SimplePermission();
			accrig.setDescription(object);
			accrig.setPermissionName(object);
			this.ars.add(accrig);
		}
		for (final String object : this.accessrights2)
		{
			this.ars2
				.add(SimplePermission.builder().description(object).permissionName(object).build());
		}
		this.testrole = SimpleRole.builder().permissions(this.ars).build();

		this.testrole2 = SimpleRole.builder().description("").rolename("").permissions(this.ars2)
			.build();


		this.testuser = SimpleUser.builder().roles(SetFactory.newHashSet()).username("Leonidas")
			.role(this.testrole).role(this.testrole2).build();
	}

	/**
	 * Tear down method will be invoked after every unit test method in this class.
	 */
	@AfterMethod
	protected void tearDown()
	{
		this.testuser = null;
	}

	/**
	 * Test method for {@link SimpleUser} constructor
	 */
	@Test
	public void testConstructors()
	{
		SimpleUser user = new SimpleUser();
		assertNotNull(user);
		user.addRole(testrole);
		assertTrue(user.getRoles().contains(testrole));
		user.removeRole(testrole);
		assertFalse(user.getRoles().contains(testrole));
		user.setActive(true);
		assertTrue(user.isActive());
		user.setLocked(true);
		assertTrue(user.isLocked());
	}

	/**
	 * Test method for {@link SimpleUser#getRoles()}.
	 */
	@Test(enabled = true)
	public void testGetRoles()
	{
		final Set<Permission> expected = new HashSet<>(this.ars);
		expected.addAll(this.ars2);
		final Set<Role<Permission>> compare = this.testuser.getRoles();
		for (final Role<Permission> role2 : compare)
		{
			final Object obj = role2;
			final Role<Permission> role = (SimpleRole)obj;
			final Set<Permission> ar = role.getPermissions();
			for (final Permission object : ar)
			{
				final boolean result = expected.contains(object);
				assertTrue(result);
			}
		}
	}

	/**
	 * Test method for {@link SimpleUser#getUsername()}.
	 */
	@Test
	public void testGetUsername()
	{
		final String expected = "Leonidas";
		final String compare = this.testuser.getUsername();
		final boolean result = expected.equals(compare);
		assertTrue(result);
	}

	/**
	 * Test method for {@link SimpleUser}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(SimpleUser.class);
	}

	/**
	 * Test method for {@link SimpleUser#equals(Object)} , {@link SimpleUser#hashCode()} and
	 * {@link SimpleUser#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(SimpleUser.class).verify();
	}

}
