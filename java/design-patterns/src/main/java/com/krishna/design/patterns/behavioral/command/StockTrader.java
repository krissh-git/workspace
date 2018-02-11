package com.krishna.design.patterns.behavioral.command;

import java.util.ArrayDeque;
import java.util.Queue;

public class StockTrader {

    private Queue<OrderCommand> commands = new ArrayDeque<OrderCommand>();

    public void addOrder(OrderCommand orderCommand) {
        commands.add(orderCommand);
    }

    public void executeOrder() {
        commands.forEach(OrderCommand::execute);
    }
}
