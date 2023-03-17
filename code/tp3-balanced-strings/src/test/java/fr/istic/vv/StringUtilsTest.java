package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

java class StringUtilsTest {
@Test
  public void testEmptyString() {
    assertTrue(isBalanced(""));
  }

  @Test
  public void testBalancedString() {
    assertTrue(isBalanced("()"));
    assertTrue(isBalanced("[]"));
    assertTrue(isBalanced("{}"));
    assertTrue(isBalanced("({[]})"));
    assertTrue(isBalanced("{()}[{}]"));
  }

  @Test
  public void testUnbalancedString() {
    assertFalse(isBalanced("("));
    assertFalse(isBalanced(")"));
    assertFalse(isBalanced("({[}])"));
    assertFalse(isBalanced("{()}[{}]]"));
  }

}