package moj.lukeejay.challenge.products.services;

import java.util.Map;

import moj.lukeejay.challenge.products.Product;

/**
 * Service to get the products of a store
 */
public interface ProductService {

    /**
     * Gets the products
     * @return the products in a map by productCode
     */
    public Map<String, Product> getProducts();

    /**
     * Gets the product from it's product code
     * @param code the product code
     * @return the product related to this code or null
     */
    public Product getProductFromCode(String code);
}
