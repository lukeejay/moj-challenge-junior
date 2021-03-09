package moj.lukeejay.challenge;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import moj.lukeejay.challenge.offers.services.ConstantOfferService;
import moj.lukeejay.challenge.offers.services.OfferService;
import moj.lukeejay.challenge.products.Product;
import moj.lukeejay.challenge.products.services.ConstantProductService;
import moj.lukeejay.challenge.products.services.ProductService;
import moj.lukeejay.challenge.scanner.Scanner;
import moj.lukeejay.challenge.scanner.SystemInScanner;


/**
 * Class for the Checkout Program, this program will check the System.in for product codes being input
 */
public class Checkout {

    private final ProductService productService;
    private Scanner scanner;
    private Map<Product, Integer> basket = new HashMap<>();
    private OfferService offerService; 

    /**
     * Constructor for the checkout program, injects the product service and the scanner
     * 
     * @param productService product service used to map scanned product codes to their product
     * @param scanner the scanner to take an input of product codes
     * @param offerService the offer service to give available offers
     */
    public Checkout( ProductService productService, Scanner scanner, OfferService offerService ) {
        this.productService = productService;
        this.scanner = scanner;
        this.offerService = offerService;
    }

    /**
     * Starts the checkout program
     */
    public void startScanning() {

            while( true ) {

                String scannedProductCode = scanner.readProductCode();
                if( scannedProductCode!=null ) {

                    if( scannedProductCode.equalsIgnoreCase( "exit" ) || scannedProductCode.equalsIgnoreCase( "total" ) ){
                        break;
                    }

                    Product scannedProduct = readProductCode( scannedProductCode );

                    if( scannedProduct!=null ) {
                        basket.computeIfPresent( scannedProduct , (key, value) -> value + 1 );
                        basket.putIfAbsent( scannedProduct, 1 );
                    }

                }
            }
    }


    /**
     * Calculate total spend of the checkout
     * 
     * @param checkoutBasket the basket of products
     * @return the amount of money spent in pounds
     */
    private double calculateTotalSpend( Map<Product, Integer> checkoutBasket ) {
        
        double totalSpend = 0;
        
        for( Entry<Product, Integer> basketItem : checkoutBasket.entrySet() ) {
            totalSpend += basketItem.getKey().getProductPrice() * basketItem.getValue();
        }

        return totalSpend;
    }

    /**
     * Reads the product code and gives an output to the user depending on the result
     * 
     * @param code the product code
     * @return the product if found or null
     */
    private Product readProductCode( String code ) {
        
        Product scannedProduct = productService.getProductFromCode( code );
        
        if( scannedProduct==null ){
            System.err.println( "Unknown product code entered: " + code );
        }

        return scannedProduct;
        
    }

    /**
     * Calculates the final total of the shop
     * 
     * @return the final total in pounds
     */
    public double calculateTotal() {
        
        double totalSpend = 0;

        double subTotal = calculateTotalSpend( basket );

        double offerAmount = offerService.computeTotalOfferAmount(basket);

        totalSpend = subTotal + offerAmount;

        DecimalFormat currencyFormat = new DecimalFormat("0.00");

        System.out.println( "Total Spend was : £" + currencyFormat.format( totalSpend ) );

        return totalSpend;
    }

    public static void main( String[] args ) {

        Checkout checkout = new Checkout( new ConstantProductService(), new SystemInScanner(), new ConstantOfferService() );
        checkout.startScanning();
        checkout.calculateTotal();
        
    }


}