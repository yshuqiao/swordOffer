//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/63.%20%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E5%A4%A7%E5%88%A9%E6%B6%A6.md
//剑指63. 股票的最大利润
//Leetcode：121. Best Time to Buy and Sell Stock
//可以有一次买入和一次卖出，买入必须在前。求最大收益。
//思路：使用贪心策略，假设第i轮进行卖出操作，买入操作价格应该在i之前并且价格最低。
public class MaxProfit {
    public int maxProfit(int[] prices){
        if(prices==null||prices.length==0)
            return 0;
        int soFarMin = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            soFarMin = Math.min(soFarMin,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-soFarMin);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxStock = new MaxProfit();
        int[] prices={7,1,5,3,6,4};
        int max = maxStock.maxProfit(prices);
        System.out.println(max);
    }
}
