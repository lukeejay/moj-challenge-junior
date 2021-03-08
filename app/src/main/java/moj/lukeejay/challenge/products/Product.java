package moj.lukeejay.challenge.products;

/**
 * Defines a product from a store
 */
public interface Product {
    
    /**
     * Gets the code of a product
     */
    public String getProductCode();

    /**
     * Gets the name of the product
     */
    public String getProductName();

    /**
     * Gets the price of the product
     */
    public double getProductPrice();

    /**
     * Sets the product name"
     * 
     * @param productName the name of the product
     */
    public void setProductName(String productName);

    /**
     * Sets the product code
     * 
     * @param productCode the code of the product
     */
    public void setProductCode(String productCode);

    /**
     * Sets the product price
     * 
     * @param productPrice the price of the product in pounds
     */
    public void setProductPrice(double productPrice);
}
