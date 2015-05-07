package Zcode.Z_code;

import java.util.*;
public class StringChain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringChain sc = new StringChain();
		String[] input = {"a", "ab", "abc", "abdf", "abcdf", "abcadf", "pabcadf" };
		// expected result: 4
		System.out.println(sc.longestChain(input));
	}
		
	//DP
	public int longestChain(String[] input) {

		Arrays.sort(input, new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		Map<Integer, Set<String>> lenMap = new HashMap<Integer, Set<String>>();
		for (String s : input) {
			if (lenMap.containsKey(s.length())) {
				lenMap.get(s.length()).add(s);
			} 
			else {
				Set<String> set = new HashSet<String>();
				set.add(s);
				lenMap.put(s.length(), set);
			}
		}

		Map<String, Integer> localMaxMap = new HashMap<String, Integer>();
		int longest = 0;
		for (String s : input) {
			
			int localMax;
			if(s.length() == 1) {
				localMax = 1;
			}
			else {
				localMax = subMaxLength(s, localMaxMap) + 1;
			}
			
			longest = Math.max(localMax, longest);
			localMaxMap.put(s, localMax);
		}

		return longest;
	}
	// get the passing string's greatest substring chain length
	private int subMaxLength(String s, Map<String, Integer> localMaxMap) {
		String sub;
		int maxLen = 0;
		for(int i=0; i<s.length(); i++) {
			sub = s.substring(0, i) + s.substring(i+1, s.length());
			if(localMaxMap.containsKey(sub)) {
				maxLen = Math.max(maxLen,  localMaxMap.get(sub));
			}
		}
		return maxLen;
	}	
}
