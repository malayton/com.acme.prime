package com.acme.prime.eval.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.acme.prime.eval.provider.EvalImpl;

/*
 * Example JUNit test case
 *
 */

public class EvalImplTest {
	private static final double DELTA = 1e-15;

	/*
	 * Example test method
	 */

	@Test
	public void simple() throws Exception {
		EvalImpl t = new EvalImpl();
		assertNotNull(t);
		assertEquals(3.0, t.eval("1 + 2"), DELTA);
		assertEquals(30.0, t.eval("45 - 15"), DELTA);
		assertEquals(20.0, t.eval("4 * 5"), DELTA);
		assertEquals(8.0, t.eval("40 / 5"), DELTA);
	}

}
//import junit.framework.TestCase;
//
//public class EvalImplTest extends TestCase {
//	public void testSimple() throws Exception {
//		EvalImpl t = new EvalImpl();
//		assertEquals(3.0, t.eval("1 + 2"));
//	}
//}
