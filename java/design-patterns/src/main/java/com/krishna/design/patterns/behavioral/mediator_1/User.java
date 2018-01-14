package com.krishna.design.patterns.behavioral.mediator_1;

public abstract class User {


    protected ChatMediator chatMediator;
    protected String name;

    public User(ChatMediator chatMediator, String name) {
        this.chatMediator = chatMediator;
        this.name = name;
    }

    abstract void sendMessage(String message);

    abstract void receiveMessage(String message);

}

