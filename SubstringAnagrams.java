package Zcode.Z_code;

public class SubstringAnagrams {

	/**
	 * @param args
	 * 
// String input (M)2 n5 i! h- R5 a
// String pattern (N)

// # output me the number of substrings in input that is an anagram of pattern
// input：abcba
// pattern：abc  
// ~> 2   {abc, cba}
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int countAnagrams(String source, String pattern) {
		int count = 0;
		int sLen = source.length();
		int pLen = pattern.length();
		if(sLen < pLen) {
			return count;
		}
		
	}
}
