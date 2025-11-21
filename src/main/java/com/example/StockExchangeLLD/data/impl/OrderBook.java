package com.example.StockExchangeLLD.data.impl;

import com.example.StockExchangeLLD.data.IOrderBook;
import com.example.StockExchangeLLD.models.Order;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReadWriteLock;

public class OrderBook implements IOrderBook {

    private final ConcurrentMap<String, List<Order>> orderBook=new ConcurrentHashMap<>();

    private final ConcurrentMap<String, ReadWriteLock> symbolLocks=new ConcurrentHashMap<>();


    @Override
    public void addOrder(Order order) {

       /* String stockId = order.getStockId();

        ReadWriteLock lock=getOrCreateLock(stockId);

        lock.writeLock().lock();*/


    }

    @Override
    public boolean removeOrder(String orderId, String stockSymbol) {
        return false;
    }

    @Override
    public boolean updateOrder(Order updateOrder) {
        return false;
    }

    @Override
    public List<Order> getOrders(String stockSymbol) {
        return null;
    }

    @Override
    public Optional<Order> getOrderBySymbol(String symbol) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> getOrderByOrderId(String orderId) {
        return Optional.empty();
    }
}
