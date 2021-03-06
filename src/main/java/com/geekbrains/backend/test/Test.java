package com.geekbrains.backend.test;

import java.io.IOException;

import com.geekbrains.backend.test.miniMarket.MiniMarketService;
import com.geekbrains.backend.test.miniMarket.model.CategoryResponse;
import com.geekbrains.backend.test.miniMarket.model.ProductResponse;

public class Test {
    public static void main(String[] args) throws IOException {
        MiniMarketService service = new MiniMarketService();
        ProductResponse product = service.getProduct(2L);
        System.out.println(product);
        CategoryResponse category = service.getCategory(1L);
        System.out.println(category);
    }
}
