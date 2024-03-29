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

import static org.testng.AssertJUnit.assertTrue;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import io.github.astrapi69.evaluate.object.evaluators.EqualsEvaluator;
import io.github.astrapi69.evaluate.object.evaluators.HashcodeEvaluator;
import io.github.astrapi69.evaluate.object.evaluators.ToStringEvaluator;
import io.github.astrapi69.evaluate.object.verifier.ContractVerifier;

/**
 * The unit test class for the class {@link Credentials}
 */
public class CredentialsTest
{


	/**
	 * Test method for {@link Credentials#equals(Object)} , {@link Credentials#hashCode()} and
	 * {@link Credentials#toString()}
	 */
	@Test
	public void testCredentials()
	{
		Credentials expected;
		Credentials actual;
		expected = Credentials.builder().build();
		actual = Credentials.builder().build();
		assertTrue(HashcodeEvaluator.evaluateEquality(expected, actual));
		assertTrue(ToStringEvaluator.evaluate(Credentials.class));
		assertTrue(ToStringEvaluator.evaluateConsistency(actual));

		actual = Credentials.builder().username("john").build();
		assertTrue(HashcodeEvaluator.evaluateUnequality(expected, actual));

		assertTrue(EqualsEvaluator.evaluateConsistency(expected, actual));
	}

	/**
	 * Test method for {@link Credentials}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(Credentials.class);
	}

	/**
	 * Test method for {@link Credentials#equals(Object)} , {@link Credentials#hashCode()} and
	 * {@link Credentials#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(Credentials.class).verify();
	}

}
