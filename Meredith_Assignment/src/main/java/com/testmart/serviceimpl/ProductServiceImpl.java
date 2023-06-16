/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.serviceimpl;

import com.testmart.model.Product;
import com.testmart.model.Products;
import com.testmart.service.ProductService;
import com.testmart.util.JacksonReaderUtil;
import com.testmart.util.OkHttpClientUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.testmart.constant.CommonConstants.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LogManager.getLogger();

    @Override
    public List<Product> getAllProducts() {
        LOG.debug("getAllProducts() called");
        String response = OkHttpClientUtil.getHttpRequest(PRODUCTS_RESOURCE);
        Products products = JacksonReaderUtil.getObject(response, Products.class);
        return (products!=null)?products.getProducts(): Collections.emptyList();
    }

    @Override
    public List<Product> getAllProducts(int limit, int skip, String... fields) {
        LOG.debug("getAllProducts() called with limit={}, skip={}, and fields={}",limit, skip, fields);
        StringBuilder urlBuilder = new StringBuilder(PRODUCTS_RESOURCE).append("?limit="+limit)
                                                                       .append("&skip="+skip);
        if(fields!=null && fields.length>0){
            urlBuilder.append("&select=");
            for(String field: fields){
                urlBuilder.append(field+",");
            }
            int last = urlBuilder.length() - 1;
            urlBuilder.replace(last, last+1, ""); // Remove last comma
        }
        String response = OkHttpClientUtil.getHttpRequest(urlBuilder.toString());
        Products products = JacksonReaderUtil.getObject(response, Products.class);
        return (products!=null)?products.getProducts(): Collections.emptyList();
    }

    @Override
    public Product getProduct(Integer productId) {
        LOG.debug("getProduct() called with productId={}", productId);
        String response = OkHttpClientUtil.getHttpRequest(PRODUCTS_RESOURCE+"/"+productId);
        Product product = JacksonReaderUtil.getObject(response, Product.class);
        return product;
    }

    @Override
    public List<Product> searchProducts(String query) {
        LOG.debug("searchProducts() called with query={}", query);
        String response = OkHttpClientUtil.getHttpRequest(PRODUCTS_RESOURCE+"/search?q="+query);
        Products products = JacksonReaderUtil.getObject(response, Products.class);
        return (products!=null)?products.getProducts(): Collections.emptyList();
    }

    @Override
    public List<String> getCategories() {
        LOG.debug("getCategories() called");
        String response = OkHttpClientUtil.getHttpRequest(CATEGORIES_RESOURCE);
        String[] categories = JacksonReaderUtil.getObject(response, String[].class);
        return (categories!=null)?Arrays.asList(categories): Collections.emptyList();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        LOG.debug("getProductsByCategory() called with categoryName={}", categoryName);
        String response = OkHttpClientUtil.getHttpRequest(PRODUCT_CATEGORY_RESOURCE+"/"+categoryName);
        Products products = JacksonReaderUtil.getObject(response, Products.class);
        return (products!=null)?products.getProducts(): Collections.emptyList();
    }
}
