package com.example.StockExchangeLLD.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Trade {

    @Builder.Default
    private String tradeId= UUID.randomUUID().toString();

    @NotBlank(message = "Buyer order ID is required")
    private String buyOrderId;

    @NotBlank(message = "Seller order ID is required")
    private String sellerOrderId;

    @NotBlank(message = "stock id is required")
    private String stockId;

    @NotNull(message = "Quantity is required")
    private int quantity;

    @NotNull(message = "price is required")
    private double price;

    @Builder.Default
    private LocalDateTime orderAcceptedTimeStamp=LocalDateTime.now();
}
