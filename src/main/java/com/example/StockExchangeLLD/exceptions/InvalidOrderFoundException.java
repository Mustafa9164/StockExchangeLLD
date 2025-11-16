package com.example.StockExchangeLLD.exceptions;

public class InvalidOrderFoundException extends  TradingException{

    public InvalidOrderFoundException(String message) {
        super("Invalid Order "+message);
    }
}
