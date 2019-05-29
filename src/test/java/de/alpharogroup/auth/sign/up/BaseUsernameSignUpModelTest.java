/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
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
package de.alpharogroup.auth.sign.up;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.evaluate.object.api.ContractViolation;
import de.alpharogroup.evaluate.object.checkers.EqualsHashCodeAndToStringCheck;
import de.alpharogroup.evaluate.object.verifier.ContractVerifier;

/**
 * The unit test class for the class {@link BaseUsernameSignUpModel}
 */
public class BaseUsernameSignUpModelTest
{

	/**
	 * Test method for {@link BaseUsernameSignUpModel} constructors and builders
	 */
	@Test
	public final void testConstructors()
	{
		UsernameSignUpModel model = new BaseUsernameSignUpModel();
		assertNotNull(model);
		model.setEmail("foo@bar.org");
		model.setPassword("secret");
		model.setRepeatPassword("secret");
		model.setTermOfUseAccepted(true);
		model.setUsername("jim");
		assertTrue(model.getEmail().equals("foo@bar.org"));
		assertTrue(model.getPassword().equals("secret"));
		assertTrue(model.getRepeatPassword().equals("secret"));
		assertTrue(model.isTermOfUseAccepted() == true);
		assertTrue(model.getUsername().equals("jim"));
		model = new BaseUsernameSignUpModel("foo@bar.org", "secret", "secret", true, "jim");
		assertNotNull(model);
		assertTrue(model.getEmail().equals("foo@bar.org"));
		assertTrue(model.getPassword().equals("secret"));
		assertTrue(model.getRepeatPassword().equals("secret"));
		assertTrue(model.isTermOfUseAccepted() == true);
		assertTrue(model.getUsername().equals("jim"));
		model = BaseUsernameSignUpModel.builder().email("foo@bar.org").password("secret")
			.repeatPassword("secret").termOfUseAccepted(true).username("jim").build();
		assertNotNull(model);
		assertTrue(model.getEmail().equals("foo@bar.org"));
		assertTrue(model.getPassword().equals("secret"));
		assertTrue(model.getRepeatPassword().equals("secret"));
		assertTrue(model.isTermOfUseAccepted() == true);
		assertTrue(model.getUsername().equals("jim"));
	}

	/**
	 * Test method for {@link BaseUsernameSignUpModel#equals(Object)} ,
	 * {@link BaseUsernameSignUpModel#hashCode()} and {@link BaseUsernameSignUpModel#toString()}
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
	 * @throws ClassNotFoundException
	 *             occurs if a given class cannot be located by the specified class loader
	 * @throws NoSuchFieldException
	 *             is thrown if no such field exists
	 */
	@Test
	public void testEqualsHashcodeAndToStringWithClass()
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
		InstantiationException, IOException, ClassNotFoundException, NoSuchFieldException
	{
		Optional<ContractViolation> expected;
		Optional<ContractViolation> actual;
		actual = EqualsHashCodeAndToStringCheck
			.equalsHashcodeAndToString(BaseUsernameSignUpModel.class);
		expected = Optional.empty();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link BaseUsernameSignUpModel}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(BaseUsernameSignUpModel.class);
	}

	/**
	 * Test method for {@link BaseUsernameSignUpModel#equals(Object)} ,
	 * {@link BaseUsernameSignUpModel#hashCode()} and {@link BaseUsernameSignUpModel#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(BaseUsernameSignUpModel.class).verify();
	}

}
