
public class BuyAndSellStock {
      public static int buy_sell_stock(int price[]) {
            int buyPrice = Integer.MAX_VALUE;
            int maxPrice = 0;
            for (int i = 0; i < price.length; i++) {
                  if (buyPrice < price[i]) {
                        int profit = price[i] - buyPrice;
                        maxPrice = Math.max(maxPrice, profit);
                  } else {
                        buyPrice = price[i];
                  }
            }
            return maxPrice;
      }

      public static void main(String[] args) {
            int price[] = { 7, 1, 5, 3, 6, 4 };
            int res = buy_sell_stock(price);
            System.out.println("Max profit is " + res);
      }
}
