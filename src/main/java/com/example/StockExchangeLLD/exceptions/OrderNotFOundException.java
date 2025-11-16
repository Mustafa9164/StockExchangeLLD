package com.example.StockExchangeLLD.exceptions;

public class OrderNotFOundException extends TradingException{

    public OrderNotFOundException(String orderId) {
        super("Order id is not Found "+orderId);
    }
}
