import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    // T.C. = O(n)
    // S.C. = O(1)
    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }





    // user inputs
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of days:");
        int numDays = sc.nextInt();
        int[] prices = new int[numDays];
        System.out.println("Enter the stock prices for " + numDays + " days:");

        for (int i = 0; i < numDays; i++) {
            prices[i] = sc.nextInt();
        }

        int maxProfit = maxProfit(prices);
        System.out.println("The maximum profit that can be made is: " + maxProfit);
    }
}
