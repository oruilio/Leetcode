//Rui Li
//Pro 121 Easy

/*
 Say you have an array for which the ith element is the price of a given stock on day i.
 
 If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 
 Note that you cannot sell a stock before you buy one.
 
 Example 1:
 
 Input: [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Not 7-1 = 6, as selling price needs to be larger than buying price.
 Example 2:
 
 Input: [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        /*
         //sol1:
         int res=0;
         for(int i=prices.length-1; i>=0; i--){
         int tmp=0;
         for(int j=i-1; j>=0; j--){
         if(tmp<prices[i]-prices[j]){
         tmp=prices[i]-prices[j];
         }
         }
         if(res<tmp){
         res=tmp;
         }
         }
         return res;
         */
        
        //sol2:
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            if(maxProfit<prices[i]-minPrice){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}
