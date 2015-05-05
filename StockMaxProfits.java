package Zcode.Z_code;

import java.util.Stack;

public class StockMaxProfits {

	/**
	 * @param args
	 * https://www.hackerrank.com/challenges/stockmax
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 5, 2, 8, 7, 6, 1, 12, 22, 3, 41, 3, 7};
		System.out.println(calProfit(arr));
		System.out.println(calProfitSJ(arr));
	}
	// O(N)
	public static long calProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        Stack<Integer> highes = new Stack<Integer>();
        int localHigh = prices[len-1];
        for (int i=len-2; i>=0; i--) {
            if (prices[i] < prices[i+1] && prices[i+1] >= localHigh) {
                highes.push(i+1);
                localHigh = prices[i+1];
            }
        }
        if (highes.isEmpty()) {
            return 0;
        }
        int index = 0, high = highes.pop();
        long profit = 0;
        while (index < len) {
            while (index < high) {
                profit += prices[high] - prices[index];
                index++;
            }
            index = high+1;
            if (highes.isEmpty()) {
                break;
            } else {
                high = highes.pop();
            }
        }
        return profit;
    }

	//bad
	public static long calProfitSJ(int[] prices) {
		if(prices == null || prices.length < 2) {
			return 0;
		}
		long max = 0;
		return helper(prices, 0);
	}
	
	private static long helper(int[] prices, int start) {
		if(start >= prices.length) {
			return 0;
		}
		int highestIndex = start;
		for(int i=start+1; i<prices.length; i++) {
			if(prices[i] > prices[highestIndex]) {
				highestIndex = i;
			}
		}
		long profit = 0;
		int hightest = prices[highestIndex];
		for(int j=start; j<highestIndex; j++) {
			profit +=  hightest - prices[j];
		}
		return profit + helper(prices, highestIndex+1);
	}
	
	public static int xor(int[] input) {
		if (input == null || input.length == 0) {
			return 0;
		}
		int len = input.length;
		int[][] dp = new int[len][len];
		// Basic subarrays.
		for (int i=0; i<len; i++) {
			dp[0][i] = input[i];
		}
		// First loop, length of subarrays.
		// Starts from 2.
		for (int i=2; i<=len; i++) {
			for (int j=0; j<=len-i; j++) {
				dp[i-1][j] = input[j] ^ dp[i-2][j+1];
			}
		}
		
		int res = 0;
		// XOR all subarrays. 0 does not matter. because num ^ 0 = num.
		for (int i=0; i<len; i++) {
			for (int j=0; j<len; j++) {
				res ^= dp[i][j];
			}
		}
		return res;
	}
}
