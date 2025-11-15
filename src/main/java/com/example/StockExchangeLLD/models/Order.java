package com.example.StockExchangeLLD.models;

import com.example.StockExchangeLLD.constants.OrderStatus;
import com.example.StockExchangeLLD.constants.OrderType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @Builder.Default
    private String orderId= UUID.randomUUID().toString();

    @NotBlank(message = "User Id is Required")
    private String userId;

    @NotNull(message = "Order type is required")
    private OrderType orderType;

    @NotNull(message = "Stock Id is required")
    private String stockId;

    @NotNull(message = "Quantity is required")
    private int quantity;

    @NotNull(message = "Price is required")
    private double price;

    @Builder.Default
    private OrderStatus orderStatus= OrderStatus.ACCEPTED;

    @Builder.Default
    private int filledQuantity=0;

    @Builder.Default
    private int remainingQuantity=0;
}
