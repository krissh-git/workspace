package com.krishna.design.patterns.behavioral.command;

public class SellOrderCommand implements OrderCommand {

    private StockTrade stockTrade;

    public SellOrderCommand(StockTrade stockTrade) {
        this.stockTrade = stockTrade;
    }

    @Override
    public void execute() {
        stockTrade.sell();

    }
}
