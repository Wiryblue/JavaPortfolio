package Collections.Collection;

import java.util.Map;

public class StockMain {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);


        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.Items().keySet()){
            System.out.println(s);
        }
        Basket wirysBasket = new Basket("wiry");
        sellItem(wirysBasket, "car", 1);
        System.out.println(wirysBasket);

        sellItem(wirysBasket, "car", 1);
        System.out.println(wirysBasket);

        sellItem(wirysBasket, "car", 1);
        sellItem(wirysBasket, "cheese", 100);
        System.out.println(wirysBasket);

        sellItem(wirysBasket, "juice", 4);
        sellItem(wirysBasket, "cup", 12);
        sellItem(wirysBasket, "bread", 1);
        System.out.println(wirysBasket);

//        temp = new StockItem("pen", 1.12, 46);
//        stockList.Items().put(temp.getName(), temp); // this will not work becuase map is unmodifiable/

        stockList.Items().get("car").adjustStock(2000); // collection is unmodifiable but not the objects within it
        stockList.Items().get("car").adjustStock(-1000);
        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        System.out.println("There are no more " + item + "s in stock.");
        return 0;
    }
}
