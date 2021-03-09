package moj.lukeejay.challenge.offers.services;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import moj.lukeejay.challenge.products.Product;
import static moj.lukeejay.challenge.products.services.ConstantProductService.COFFEE;
import static moj.lukeejay.challenge.products.services.ConstantProductService.FRUIT_TEA;
import static moj.lukeejay.challenge.products.services.ConstantProductService.STRAWBERRIES;

/**
 * Runs tests on offers applying to basket
 */
public class ConstantOfferServiceTest {
    

    private Map<Product, Integer> basket;
    private ConstantOfferService service;

    @BeforeEach
    public void setup() {
        this.basket = new HashMap<>();
        this.service = new ConstantOfferService();
    }
    @Test
    public void emptyBasketHasNoDiscount() {

        double total = service.computeTotalOfferAmount(new HashMap<>());

        Assertions.assertEquals(0, total);
    }

    @Test
    public void strawberryBulkDealAppliesOnThreeOrMore() {

        // Test offer applied on lower limit
        basket.put(STRAWBERRIES, 3);

        double offerApplied = service.computeTotalOfferAmount(basket);

        Assertions.assertEquals(-1.5, offerApplied);


        //Test offer not applied when not met the lower limit
        basket.put(STRAWBERRIES, 2);

        double offerNotApplied = service.computeTotalOfferAmount(basket);

        Assertions.assertEquals(0, offerNotApplied);


        //Test 10 strawberries have discount on all
        basket.put(STRAWBERRIES, 10);

        double tenOffersApplied = service.computeTotalOfferAmount(basket);

        Assertions.assertEquals(-5, tenOffersApplied);
    }

    @Test
    public void strawberryDealAppliesWithExtraProducts() {
        basket.put(COFFEE, 2);

        basket.put(STRAWBERRIES, 3);

        double offerApplied = service.computeTotalOfferAmount(basket);

        Assertions.assertEquals(-1.50, offerApplied);
    }

    @Test
    public void bogofAppliesAfterTwoFruitTea() {
        basket.put(FRUIT_TEA, 2);

        double offerApplied = service.computeTotalOfferAmount(basket);

        Assertions.assertEquals(FRUIT_TEA.getProductPrice() * -1, offerApplied);

        basket.put(FRUIT_TEA, 1);

        double offerNotApplied = service.computeTotalOfferAmount(basket);

        Assertions.assertEquals(0, offerNotApplied);
    }

    @Test
    public void bogofAppliesOnlyEveryTwoItems() {
        basket.put(FRUIT_TEA, 3);

        double offerAppliedOnce = service.computeTotalOfferAmount(basket);

        Assertions.assertEquals(FRUIT_TEA.getProductPrice() * -1, offerAppliedOnce);
    
        basket.put(FRUIT_TEA, 4);

        double offerAppliedTwice = service.computeTotalOfferAmount(basket);

        Assertions.assertEquals(FRUIT_TEA.getProductPrice() * -2 , offerAppliedTwice);
    }
}
