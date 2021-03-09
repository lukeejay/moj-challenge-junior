package moj.lukeejay.challenge.offers;

import java.util.Map;

import moj.lukeejay.challenge.products.Product;

/**
 * The buy one get one free offer
 */
public class BOGOF implements Offer {

    private String name;

    private Product validProduct;

    /**
     * Constructor for the buy one get one free offer
     * 
     * @param name the name of offer
     * @param validProduct the product this offer is valid with
     */
    public BOGOF( String name, Product validProduct ) {
        this.name = name;
        this.validProduct = validProduct;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public String getOfferName() {
        return name;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public double getTotalDiscount( Map<Product, Integer> basket ) {
        
        Integer numberOfValidProducts = basket.getOrDefault(validProduct, 0);

        return numberOfValidProducts / -2 * validProduct.getProductPrice();
    }
    
}
