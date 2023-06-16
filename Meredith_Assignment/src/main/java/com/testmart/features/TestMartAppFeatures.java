/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.features;

import com.testmart.model.Cart;
import com.testmart.model.CartItem;
import com.testmart.model.Product;
import com.testmart.service.CartService;
import com.testmart.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class TestMartAppFeatures {

    private static final Logger LOG = LogManager.getLogger();

    private ProductService<Product, String> productService;
    private CartService cartService;

    public TestMartAppFeatures(ProductService productService, CartService cartService){
        this.productService = productService;
        this.cartService = cartService;
    }

    /**
     * Prints the titles of all products that have a rating less than or equal to the provided criteria.
     * @param rating The rating threshold.
     */
    public void getProductTitlesByWorseRating(double rating){
        LOG.debug("getProductTitlesByWorseRating() called with rating={}",rating);
        LOG.info("Below are the product titles with less than or equal to provided rating={}",rating);
        this.productService.getAllProducts(0, 0, "title,rating")
                            .stream()
                            .filter(product -> product.getRating()<=rating)
                            .forEach(product -> {
                                LOG.info(product.getTitle());
                            });
    }

    /**
     * Returns the cart with the highest total value.
     * @returns The cart with the highest total value.
     */
    public Cart getCartWithHighestTotal(){
        LOG.debug("getCartWithHighestTotal() called");
        Optional<Cart> cartOptional = this.cartService.getAllCarts().stream().max(Comparator.comparing(Cart::getTotal));
        return cartOptional.get();
    }

    /**
     * Returns the cart with the lowest total value.
     * @returns The cart with the lowest total value.
     */
    public Cart getCartWithLowestTotal(){
        LOG.debug("getCartWithLowestTotal() called");
        Optional<Cart> cartOptional = this.cartService.getAllCarts().stream().min(Comparator.comparing(Cart::getTotal));
        return cartOptional.get();
    }

    /**
     * Enriches the product information in a user's cart by adding product images.
     * The current product information in a cart has limited fields.
     * This method adds the `images` field for each product in a given user's cart.
     * Note: This method only applies to the first element from the `carts[]` JSON response.
     * @param userId The ID of the user whose cart's product information will be enriched.
     * @returns A list of products with enriched information in the user's cart.
     */
    public List<Product> addProductImagesToUserCart(Integer userId){
        LOG.debug("addProductImagesToUserCart() called with userId={}", userId);
        List<CartItem> cartItems = ((List<Cart>) this.cartService.getUserCarts(userId))
                                                                 .stream()
                                                                 .map(userCart -> userCart.getProducts())
                                                                 .flatMap(product -> product.stream())
                                                                 .collect(Collectors.toList());

        LOG.debug("Total {} products found in carts.", cartItems.size());
        List<Product> products = cartItems.stream()
                                          .map(this::convertToProduct)
                                          .collect(Collectors.toList());
        return products;
    }

    private Product convertToProduct(CartItem cartItem) {
        Product product = this.productService.getProduct(cartItem.getId());
        Product enrichedProduct = new Product(cartItem);
        if(product!=null) {
            enrichedProduct.setImages(product.getImages());
        }else{
            LOG.warn("No images present for product with id={}",product.getId());
        }
        return enrichedProduct;
    }
}
