package com.example.StockExchangeLLD.data;

import com.example.StockExchangeLLD.models.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderBook {

    void addOrder(Order order);

    boolean removeOrder(String orderId, String stockSymbol);

    boolean updateOrder(Order updateOrder);

    List<Order> getOrders(String stockSymbol);

    Optional<Order> getOrderBySymbol(String symbol);

    Optional<Order> getOrderByOrderId(String orderId);
}
