package com.xwd.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.xwd.stack.Stack;

public class StackTest {
	@Test
	public void testIsValid() {
		assertEquals(Stack.isValid("(){}{}[]"), true);
		assertEquals(Stack.isValid("(]"), false);
		assertEquals(Stack.isValid("]"), false);
		assertEquals(Stack.isValid("[]"), true);
	}
}
