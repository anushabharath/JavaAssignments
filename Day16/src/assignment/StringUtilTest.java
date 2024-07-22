package assignment;

//StringUtilTest.java
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringUtilTest {

 private StringUtil stringUtil;

 @BeforeClass
 public static void setUpBeforeClass() throws Exception {
     System.out.println("This runs once before any of the test methods.");
 }

 @AfterClass
 public static void tearDownAfterClass() throws Exception {
     System.out.println("This runs once after all the test methods.");
 }

 @Before
 public void setUp() throws Exception {
     stringUtil = new StringUtil();
     System.out.println("This runs before each test method.");
 }

 @After
 public void tearDown() throws Exception {
     System.out.println("This runs after each test method.");
 }

 @Test
 public void testIsPalindrome() {
     assertTrue(stringUtil.isPalindrome("madam"));
     assertTrue(stringUtil.isPalindrome("A man a plan a canal Panama"));
     assertFalse(stringUtil.isPalindrome("hello"));
     assertFalse(stringUtil.isPalindrome(null));
 }

 @Test
 public void testReverse() {
     assertEquals("madam", stringUtil.reverse("madam"));
     assertEquals("amanaP lanac a nalp a nam A", stringUtil.reverse("A man a plan a canal Panama"));
     assertEquals("olleh", stringUtil.reverse("hello"));
     assertEquals(null, stringUtil.reverse(null));
 }

 @Test
 public void testIsEmptyOrNull() {
     assertTrue(stringUtil.isEmptyOrNull(null));
     assertTrue(stringUtil.isEmptyOrNull(""));
     assertFalse(stringUtil.isEmptyOrNull("hello"));
 }
}

