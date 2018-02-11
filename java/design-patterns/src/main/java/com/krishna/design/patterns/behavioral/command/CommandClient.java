package com.krishna.design.patterns.behavioral.command;

public class CommandClient {
    public static void main(String[] args) {
        StockTrade stockTrade = new StockTrade();
        OrderCommand buyOrderCommand = new BuyOrderCommand(stockTrade);
        OrderCommand sellOrderCommand = new SellOrderCommand(stockTrade);

        StockTrader stockTrader = new StockTrader();
        stockTrader.addOrder(buyOrderCommand);
        stockTrader.addOrder(sellOrderCommand);

        stockTrader.executeOrder();
    }
}
