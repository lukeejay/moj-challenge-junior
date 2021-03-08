package moj.lukeejay.challenge;

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

    public Checkout( ProductService productService, Scanner scanner ) {
        this.productService = productService;
        this.scanner = scanner;
    }

    /**
     * Starts the checkout program
     */
    public void start() {

            while( true ) {

                String scannedProductCode = scanner.readProductCode();
                if( scannedProductCode!=null ) {

                    if( scannedProductCode.equalsIgnoreCase("exit") ){
                        break;
                    }

                    readProductCode(scannedProductCode);
                    

                }
            }
    }

    /**
     * Reads the product code and gives an output to the user depending on the result
     * @param code the product code
     * @return the product if found or null
     */
    private Product readProductCode(String code) {
        
        Product scannedProduct = productService.getProductFromCode( code );
        
        if( scannedProduct!=null ){
            System.out.println( scannedProduct.getProductName() );
        } else {
            System.err.println("Unknown product code entered: " + code);
        }

        return scannedProduct;
        
    }



    public static void main(String[] args) {

        Checkout checkout = new Checkout( new ConstantProductService(), new SystemInScanner() );
        checkout.start();
        
    }
}