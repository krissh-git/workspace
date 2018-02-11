package com.krishna.design.patterns.behavioral.command;

public class BuyOrderCommand implements OrderCommand {

    private StockTrade stockTrade;

    public BuyOrderCommand(StockTrade stockTrade) {
        this.stockTrade = stockTrade;
    }

    @Override
    public void execute() {
        stockTrade.buy();

    }
}
