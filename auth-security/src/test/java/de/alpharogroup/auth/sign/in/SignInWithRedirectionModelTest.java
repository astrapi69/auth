/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.auth.sign.in;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;
import org.testng.annotations.Test;

import de.alpharogroup.evaluate.object.api.ContractViolation;
import de.alpharogroup.evaluate.object.checkers.EqualsHashCodeAndToStringCheck;

/**
 * The unit test class for the class {@link SignInWithRedirectionModel}
 */
public class SignInWithRedirectionModelTest
{

	/**
	 * Test method for {@link SignInWithRedirectionModel} constructors and builders
	 */
	@Test
	public final void testConstructors()
	{
		SignInWithRedirectionModel<String> model = new SignInWithRedirectionModel<>();
		assertNotNull(model);
		model = new SignInWithRedirectionModel<>("foo@bar.org", "secret", String.class, "jim");
		assertNotNull(model);
		assertTrue(model.getEmail().equals("foo@bar.org"));
		assertTrue(model.getPassword().equals("secret"));
		assertTrue(model.getUsername().equals("jim"));
		model = SignInWithRedirectionModel.<String> builder().email("foo@bar.org")
			.password("secret").username("jim").redirectPage(String.class).build();
		assertNotNull(model);
		assertTrue(model.getEmail().equals("foo@bar.org"));
		assertTrue(model.getPassword().equals("secret"));
		assertTrue(model.getUsername().equals("jim"));
		assertTrue(model.getRedirectPage().equals(String.class));
	}

	/**
	 * Test method for {@link SignInWithRedirectionModel#equals(Object)} ,
	 * {@link SignInWithRedirectionModel#hashCode()} and
	 * {@link SignInWithRedirectionModel#toString()}
	 * 
	 * @throws IllegalAccessException
	 *             if the caller does not have access to the property accessor method
	 * @throws InstantiationException
	 *             if a new instance of the bean's class cannot be instantiated
	 * @throws InvocationTargetException
	 *             if the property accessor method throws an exception
	 * @throws NoSuchMethodException
	 *             if an accessor method for this property cannot be found
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 */
	@Test
	public void testEqualsHashcodeAndToStringWithClass() throws NoSuchMethodException,
		IllegalAccessException, InvocationTargetException, InstantiationException, IOException
	{
		Optional<ContractViolation> expected;
		Optional<ContractViolation> actual;
		final SignInWithRedirectionModel<String> first = new SignInWithRedirectionModel<>(
			"foo@bar.org", "secret", String.class, "jim");
		final SignInWithRedirectionModel<String> second = new SignInWithRedirectionModel<>();
		final SignInWithRedirectionModel<String> third = SignInWithRedirectionModel
			.<String> builder().email("foo@bar.org").password("secret").username("jim")
			.redirectPage(String.class).build();
		final SignInWithRedirectionModel<String> fourth = third;
		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(first, second, third,
			fourth);
		expected = Optional.empty();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link SignInWithRedirectionModel}
	 */
	@Test
	public void testWithBeanTester()
	{
		final Configuration configuration = new ConfigurationBuilder()
			.ignoreProperty("redirectPage").build();
		final BeanTester beanTester = new BeanTester();
		beanTester.addCustomConfiguration(SignInWithRedirectionModel.class, configuration);
		beanTester.testBean(SignInWithRedirectionModel.class);
	}

}
