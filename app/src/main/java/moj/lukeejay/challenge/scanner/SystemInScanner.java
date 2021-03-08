package moj.lukeejay.challenge.scanner;

import java.util.Scanner;

/**
 * Interface for the scanning of products into the system
 */
public class SystemInScanner implements moj.lukeejay.challenge.scanner.Scanner {
    
    private Scanner userInputScanner;

    public SystemInScanner() {

        this.userInputScanner = new Scanner( System.in );
    
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String readProductCode() {
        
        String productCodeInput = null;

        System.out.println( "Please input product code");

        productCodeInput = userInputScanner.next();
 
        return productCodeInput;

    }
}
