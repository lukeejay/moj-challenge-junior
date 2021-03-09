package moj.lukeejay.challenge.offers;

import java.util.Map;

import moj.lukeejay.challenge.products.Product;

/**
 * Offer for buying bulk of a specified product
 */
public class BulkOffer implements Offer {

    private Product validProduct;
    private String name;
    private double discountMultiplier;
    private int validAmount;

    /**
     * Constructor for the bulk offer
     * @param name the name of the offer
     * @param validProduct the product this order is valid for
     * @param validAmount the amount of items that need to be bought for this offer to be valid
     * @param discountMultiplier the multiplier for the price
     */
    public BulkOffer( String name, Product validProduct, int validAmount, double discountMultiplier ) {
        this.name = name;
        this.validProduct = validProduct;
        this.discountMultiplier = discountMultiplier;
        this.validAmount = validAmount;
    }

    @Override
    public String getOfferName() {
        return name;
    }

    @Override
    public double getTotalDiscount(Map<Product, Integer> basket) {
        
        int numberOfValidProducts = basket.getOrDefault(validProduct, 0);

        if(numberOfValidProducts >= validAmount) {
            double savingMultiplier = 1 - discountMultiplier;
            double totalDiscount =  numberOfValidProducts * validProduct.getProductPrice() * savingMultiplier * -1;
            return Math.round(totalDiscount * 100.0) / 100.0;
        }

        return 0;
    }
    
}
