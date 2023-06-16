/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.features;

import com.testmart.model.Cart;
import com.testmart.model.Product;
import com.testmart.serviceimpl.CartServiceImpl;
import com.testmart.serviceimpl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class TestMartAppFeaturesShould {

    @Test
    public void printValidProductTitles_forGivenCriteria(){
    // Given
        TestMartAppFeatures testMartAppFeatures = getTestMartAppFeaturesInstance();
    // When
        testMartAppFeatures.getProductTitlesByWorseRating(4.02);
    }

    @Test
    public void getCart_withHighestTotalValue(){
    // Given
        TestMartAppFeatures testMartAppFeatures = getTestMartAppFeaturesInstance();
    // When
        Cart cartWithHighestTotal = testMartAppFeatures.getCartWithHighestTotal();
    // Then
        Assertions.assertNotNull(cartWithHighestTotal);
        Assertions.assertEquals(9064, cartWithHighestTotal.getTotal());
    }

    @Test
    public void getCart_withLowestTotalValue(){
    // Given
        TestMartAppFeatures testMartAppFeatures = getTestMartAppFeaturesInstance();
    // When
        Cart cartWithLowestTotal = testMartAppFeatures.getCartWithLowestTotal();
    // Then
        Assertions.assertNotNull(cartWithLowestTotal);
        Assertions.assertEquals(315, cartWithLowestTotal.getTotal());
    }

    @Test
    public void getUsersCartProducts_withImages(){
    // Given
        TestMartAppFeatures testMartAppFeatures = getTestMartAppFeaturesInstance();
    // When
        List<Product> products = testMartAppFeatures.addProductImagesToUserCart(1);
    // Then
        Assertions.assertNotNull(products);
        products.stream().forEach(product -> {
            List<String> images = product.getImages();
            Assertions.assertNotNull(images);
            Assertions.assertTrue(images.size()>0);
        });
    }

    private static TestMartAppFeatures getTestMartAppFeaturesInstance(){
        return new TestMartAppFeatures(new ProductServiceImpl(), new CartServiceImpl());
    }
}
