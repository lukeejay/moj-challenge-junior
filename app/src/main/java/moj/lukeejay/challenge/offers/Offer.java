package moj.lukeejay.challenge.offers;

import java.util.Map;

import moj.lukeejay.challenge.products.Product;

/**
 * Interface for offers that will be subtracted from a checkout total
 */
public interface Offer {
    
    /**
     * Gets the name of the specific offer
     * @return the name of the offer
     */
    public String getOfferName();


    /**
     * Gets the total discount applied to the basket by this offer
     * @param basket the basket of items
     * @return the amount of discount in pounds
     */
    public double getTotalDiscount( Map<Product, Integer> basket );


}
