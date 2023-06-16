/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.serviceimpl;

import com.testmart.model.Product;
import com.testmart.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class ProductServiceImplShould {

    @Test
    public void returnAllProducts(){
    // Given
        ProductService productService = getProductServiceInstance();
    // When
        List<Product> products = productService.getAllProducts();
    // Then
        Assertions.assertNotNull(products);
        Assertions.assertTrue(products.size()>0);
    }

    private static Stream<Object[]> productCriteriaDataProvider() {
        return Stream.of(
                new Object[]{2, 100, "stock", 0},
                new Object[]{2, 2, null, 2},
                new Object[]{2, 2, "stock", 2}
        );
    }

    @ParameterizedTest
    @MethodSource("productCriteriaDataProvider")
    public void returnCorrectProducts_asPerQueryParam(int limit, int skip, String fieldName, int count){
    // Given
        ProductService productService = getProductServiceInstance();
    // When
        List<Product> products = productService.getAllProducts(limit, skip, fieldName);
    // Then
        Assertions.assertNotNull(products);
        Assertions.assertEquals(count, products.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void returnCorrectProduct_forGivenUserId(int productId){
    // Given
        ProductService productService = getProductServiceInstance();
    // When
        Product product = (Product) productService.getProduct(productId);
    // Then
        Assertions.assertNotNull(product);
        Assertions.assertEquals(productId, product.getId());
    }

    private static Stream<Object[]> productDataProvider() {
        return Stream.of(
                new Object[]{"iPhone",1, 2}, // title
                new Object[]{"video calls",8, 1} // description
        );
    }

    @ParameterizedTest
    @MethodSource("productDataProvider")
    public void returnCorrectProducts_asPerQueryParam(String queryParam, int productId, int count){
    // Given
        ProductService productService = getProductServiceInstance();
    // When
        List<Product> products = productService.searchProducts(queryParam);
    // Then
        Assertions.assertNotNull(products);
        Assertions.assertEquals(productId, products.get(0).getId());
        Assertions.assertEquals(count, products.size());
    }

    @Test
    public void returnAllCategories(){
    // Given
        ProductService productService = getProductServiceInstance();
    // When
        List<String> categories = productService.getCategories();
    // Then
        Assertions.assertNotNull(categories);
        Assertions.assertTrue(categories.size()>0);
    }

    private static Stream<Object[]> categoryDataProvider() {
        return Stream.of(
                new Object[]{"laptops",6, 5},
                new Object[]{"furniture",31, 5}
        );
    }

    @ParameterizedTest
    @MethodSource("categoryDataProvider")
    public void returnCorrectProducts_asPerCategory(String categoryName, int productId, int count){
    // Given
        ProductService productService = getProductServiceInstance();
    // When
        List<Product> products = productService.getProductsByCategory(categoryName);
    // Then
        Assertions.assertNotNull(products);
        Assertions.assertEquals(productId, products.get(0).getId());
        Assertions.assertEquals(count, products.size());
    }

    private static ProductService getProductServiceInstance(){
        return new ProductServiceImpl();
    }
}
