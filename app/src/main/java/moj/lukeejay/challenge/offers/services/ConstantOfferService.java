package moj.lukeejay.challenge.offers.services;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import moj.lukeejay.challenge.offers.BOGOF;
import moj.lukeejay.challenge.offers.BulkOffer;
import moj.lukeejay.challenge.offers.Offer;
import moj.lukeejay.challenge.products.Product;
import moj.lukeejay.challenge.products.services.ConstantProductService;

/**
 * Offer service using constant values
 */
public class ConstantOfferService implements OfferService {

    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat( "0.00" );

    private Set<Offer> availableOffers = new HashSet<>();
    

    /**
     * Constructor for the offer service
     */
    public ConstantOfferService() {
        ConstantProductService productService = new ConstantProductService();
        Offer fruitTeaBOGOF = new BOGOF( "Fruit Tea BOGOF", productService.getProductFromCode( "FR1" ) );
        Offer strawberryBulkBuy = new BulkOffer( "Strawberry Bulk Buy", productService.getProductFromCode( "SR1" ), 3, 0.9 );

        availableOffers.add( fruitTeaBOGOF );
        availableOffers.add( strawberryBulkBuy );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Offer> getAvailableOffers() {
        return availableOffers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double computeTotalOfferAmount( Map<Product, Integer> basket ) {
        
        double basketReduction = 0; 
        for ( Offer offer : availableOffers ) {
            double offerReduced = offer.getTotalDiscount( basket );
            if( offerReduced < 0 ) {
                System.out.println( "Offer name: " + offer.getOfferName() + " -\u00A3" + CURRENCY_FORMAT.format( offerReduced * - 1 ) );
            }

            basketReduction += offerReduced;
        }
        return basketReduction;
    }
}
