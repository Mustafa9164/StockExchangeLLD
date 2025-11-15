package com.example.StockExchangeLLD.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Stock {

    @Builder.Default
    private String stockId= UUID.randomUUID().toString();

    @NotBlank(message = "stock name is required")
    private String stockName;

    @NotBlank(message = "stock symbol is required")
    private String stockSymbol;

    @NotBlank(message = "stock price is required")
    private double stockPrice;
}
