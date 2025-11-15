package com.example.StockExchangeLLD.services.strategies;

import com.example.StockExchangeLLD.models.Order;
import com.example.StockExchangeLLD.models.Trade;

import java.util.List;

public interface OrderMatchingStrategy {

    String getStrategyName();

    List<Trade> matchOrder(Order order, List<Order> existingOrders);

}
