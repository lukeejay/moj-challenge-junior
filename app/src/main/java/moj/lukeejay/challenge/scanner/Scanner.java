package moj.lukeejay.challenge.scanner;

/**
 * Interface for the scanning of products into the system
 */
public interface Scanner {
    
    /**
     * Reads the product code from a product
     * @return the product code as a string
     */
    public String readProductCode();
}
