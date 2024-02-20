package com.company.project;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.*;
import com.company.project.entity.Product;
import com.company.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    protected void test() {
        Product p1 = new Product();
        p1.setStockKeepingUnit("sku-product-1-1");
        p1.setName("product-1");
        p1.setDescription("product-1-description");
        p1.setPrice(BigDecimal.valueOf(100));
        p1.setImageUrl("product-image-1.png");
        p1.setActive(true);

        Product p2 = new Product();
        p2.setStockKeepingUnit("sku-product-2-1");
        p2.setName("product-2");
        p2.setDescription("product-2-description");
        p2.setPrice(BigDecimal.valueOf(200));
        p2.setImageUrl("product-image-2.png");
        p2.setActive(true);

        Product p3 = new Product();
        p3.setStockKeepingUnit("sku-product-3-1");
        p3.setName("product-3");
        p3.setDescription("product-3-description");
        p3.setPrice(BigDecimal.valueOf(50));
        p3.setImageUrl("product-image-3.png");
        p3.setActive(true);

        Product p4 = new Product();
        p4.setStockKeepingUnit("sku-product-4-1");
        p4.setName("product-4");
        p4.setDescription("product-4-description");
        p4.setPrice(BigDecimal.valueOf(500));
        p4.setImageUrl("product-image-4.png");
        p4.setActive(true);

        Product p5 = new Product();
        p5.setStockKeepingUnit("sku-product-5-1");
        p5.setName("product-5");
        p5.setDescription("product-5-description");
        p5.setPrice(BigDecimal.valueOf(300));
        p5.setImageUrl("product-image-5.png");
        p5.setActive(true);

        Product p6 = new Product();
        p6.setStockKeepingUnit("sku-product-6-1");
        p6.setName("product-6");
        p6.setDescription("product-6-description");
        p6.setPrice(BigDecimal.valueOf(400));
        p6.setImageUrl("product-image-6.png");
        p6.setActive(true);

        Product p7 = new Product();
        p7.setStockKeepingUnit("sku-product-7-1");
        p7.setName("product-7");
        p7.setDescription("product-7-description");
        p7.setPrice(BigDecimal.valueOf(200));
        p7.setImageUrl("product-image-7.png");
        p7.setActive(true);

        Product p8 = new Product();
        p8.setStockKeepingUnit("sku-product-8-1");
        p8.setName("product-8");
        p8.setDescription("product-8-description");
        p8.setPrice(BigDecimal.valueOf(50));
        p8.setImageUrl("product-image-8.png");
        p8.setActive(true);

        Product p9 = new Product();
        p9.setStockKeepingUnit("sku-product-9-1");
        p9.setName("product-9");
        p9.setDescription("product-9-description");
        p9.setPrice(BigDecimal.valueOf(600));
        p9.setImageUrl("product-image-9.png");
        p9.setActive(true);

        Product p10 = new Product();
        p10.setStockKeepingUnit("sku-product-10-1");
        p10.setName("product-10");
        p10.setDescription("product-10-description");
        p10.setPrice(BigDecimal.valueOf(50));
        p10.setImageUrl("product-image-10.png");
        p10.setActive(true);

        productService.saveAll(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
    }

}
