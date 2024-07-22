package assignment;

//StringUtil.java
public class StringUtil {

 // Method to check if a string is a palindrome
 public boolean isPalindrome(String str) {
     if (str == null) {
         return false;
     }
     String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
     return new StringBuilder(cleanStr).reverse().toString().equals(cleanStr);
 }

 // Method to reverse a string
 public String reverse(String str) {
     if (str == null) {
         return null;
     }
     return new StringBuilder(str).reverse().toString();
 }

 // Method to check if a string is empty or null
 public boolean isEmptyOrNull(String str) {
     return str == null || str.isEmpty();
 }
}
