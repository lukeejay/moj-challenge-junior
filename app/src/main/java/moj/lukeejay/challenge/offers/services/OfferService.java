package moj.lukeejay.challenge.offers.services;

import java.util.Map;
import java.util.Set;

import moj.lukeejay.challenge.offers.Offer;
import moj.lukeejay.challenge.products.Product;

/**
 * Service that lists the available offers and the amount that the offers will reduce from a basket of products
 */
public interface OfferService {

    /**
     * Gets the available offers
     * 
     * @return the set of available offers
     */
    public Set<Offer> getAvailableOffers();

    /**
     * Given a basket of items computes the total savings to the customer
     * 
     * @param basket the basket of items being purchased
     * @return the change in price of the total amount of the basket in pounds
     */
    public double computeTotalOfferAmount(Map<Product, Integer> basket);
}
