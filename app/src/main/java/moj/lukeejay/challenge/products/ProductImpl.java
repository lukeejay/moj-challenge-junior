package moj.lukeejay.challenge.products;

/**
 * Implementation class of a standard {@link Product}
 */
public class ProductImpl implements Product {

    private String productCode;
    private String productName;
    private double productPrice;

    /**
     * Constructor with injection for all fields of the product
     * 
     * @param productCode the code
     * @param productName the name
     * @param productPrice the price in pounds
     */
    public ProductImpl(String productCode, String productName, double productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProductCode() {
        return this.productCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProductName() {
        return this.productName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getProductPrice() {
        return this.productPrice;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setProductCode(String productCode) {
        this.productCode = productCode;        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
