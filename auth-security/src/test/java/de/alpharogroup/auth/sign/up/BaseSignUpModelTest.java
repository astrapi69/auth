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

/**
 * The unit test class for the class {@link BaseSignUpModel}
 */
public class BaseSignUpModelTest
{

	/**
	 * Test method for {@link BaseSignUpModel} constructors and builders
	 */
	@Test
	public final void testConstructors()
	{
		BaseSignUpModel model = new BaseSignUpModel();
		assertNotNull(model);
		model.setEmail("foo@bar.org");
		model.setPassword("secret");
		model.setRepeatPassword("secret");
		model.setTermOfUseAccepted(true);
		assertTrue(model.getEmail().equals("foo@bar.org"));
		assertTrue(model.getPassword().equals("secret"));
		assertTrue(model.getRepeatPassword().equals("secret"));
		assertTrue(model.isTermOfUseAccepted() == true);
		model = new BaseSignUpModel("foo@bar.org", "secret", "secret", true);
		assertNotNull(model);
		assertTrue(model.getEmail().equals("foo@bar.org"));
		assertTrue(model.getPassword().equals("secret"));
		assertTrue(model.getRepeatPassword().equals("secret"));
		assertTrue(model.isTermOfUseAccepted() == true);
		model = BaseSignUpModel.builder().email("foo@bar.org").password("secret")
			.repeatPassword("secret").termOfUseAccepted(true).build();
		assertNotNull(model);
		assertTrue(model.getEmail().equals("foo@bar.org"));
		assertTrue(model.getPassword().equals("secret"));
		assertTrue(model.getRepeatPassword().equals("secret"));
		assertTrue(model.isTermOfUseAccepted() == true);
	}

	/**
	 * Test method for {@link BaseSignUpModel#equals(Object)} , {@link BaseSignUpModel#hashCode()}
	 * and {@link BaseSignUpModel#toString()}
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
		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(BaseSignUpModel.class);
		expected = Optional.empty();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link BaseSignUpModel}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(BaseSignUpModel.class);
	}
}
