package Zcode.Z_code;

public class StockMaxProfits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
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

}
