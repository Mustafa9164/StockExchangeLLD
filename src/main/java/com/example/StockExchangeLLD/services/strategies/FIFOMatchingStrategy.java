package com.example.StockExchangeLLD.services.strategies;

import com.example.StockExchangeLLD.constants.OrderStatus;
import com.example.StockExchangeLLD.constants.OrderType;
import com.example.StockExchangeLLD.models.Order;
import com.example.StockExchangeLLD.models.Trade;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FIFOMatchingStrategy implements  OrderMatchingStrategy{

    @Override
    public String getStrategyName() {
        return null;
    }

    @Override
    public List<Trade> matchOrder(Order newOrder, List<Order> existingOrders) {

        if(newOrder.getOrderType().equals(OrderType.BUY))
        {

                return matchBuyOrder(newOrder,existingOrders);
         }
        else
        {
            return matchSellOrder(newOrder,existingOrders);
        }
    }

    private List<Trade> matchBuyOrder(Order buyOrder, List<Order> existingOrders) {
        List<Trade> trades=new ArrayList<>();

        List<Order> matchingSellOrders = existingOrders.stream()
                .filter(orders -> orders.getOrderType().equals(OrderType.SELL))
                .filter(order -> order.getStockId().equals(buyOrder.getStockId()))
                .filter(order -> order.getPrice() <= (buyOrder.getPrice()))
                .filter(order -> order.getOrderStatus().equals(OrderStatus.ACCEPTED))
                .sorted(Comparator.comparing(Order::getPrice).thenComparing(Order::getOrderAcceptedTimeStamp))
                .collect(Collectors.toList());

        int remainingQuantity=buyOrder.getRemainingQuantity();

        for(Order sellOrder: matchingSellOrders){
            if(remainingQuantity <= 0) break;
            int tradeQuantity=Math.min(remainingQuantity,sellOrder.getRemainingQuantity()){
                Double tradePrice= sellOrder.getPrice();

                Trade trade=Trade.builder()
                        .buyOrderId(buyOrder.getOrderId())
                        .sellerOrderId(sellOrder.getOrderId())
                        .stockId(buyOrder.getStockId())
                        .quantity(tradeQuantity)
                        .price(tradePrice)
                        .build();

                trades.add(trade);

                buyOrder.setFilledQuantity(buyOrder.getFilledQuantity()+tradeQuantity);
                buyOrder.setRemainingQuantity(buyOrder.getRemainingQuantity()-tradeQuantity);


                sellOrder.setFilledQuantity(sellOrder.getFilledQuantity()+tradeQuantity);
                sellOrder.setRemainingQuantity(sellOrder.getRemainingQuantity()-tradeQuantity);

                remainingQuantity-=tradeQuantity;

                log.info("Trade: {} -{} - {} -{} ", trade.getTradeId(),trade.getBuyOrderId(),trade.getSellerOrderId(),trade.getQuantity(),trade.getPrice());
            }

        }
        return trades;

    }


    private List<Trade> matchSellOrder(Order sellOrder, List<Order> existingOrders) {

    }

}
