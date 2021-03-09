package moj.lukeejay.challenge.products.services;

import java.util.HashMap;
import java.util.Map;

import moj.lukeejay.challenge.products.Product;
import moj.lukeejay.challenge.products.ProductImpl;

/**
 * ConstantProductService is a class that provides products via a list of constant products defined in the class.
 */
public class ConstantProductService implements ProductService {

    private static final Product FRUIT_TEA = new ProductImpl( "FR1", "Fruit Tea", 3.11 );
    private static final Product STRAWBERRIES = new ProductImpl( "SR1", "Strawberries", 5.00 );
    private static final Product COFFEE = new ProductImpl( "CF1", "Coffee", 11.23 );

    private Map<String, Product> products = new HashMap<>();

    /**
     * Constructor to add defined products into the products map
     */
    public ConstantProductService(){

        products.put( FRUIT_TEA.getProductCode(), FRUIT_TEA );
        products.put( STRAWBERRIES.getProductCode(), STRAWBERRIES );
        products.put( COFFEE.getProductCode(), COFFEE );
    
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Product> getProducts() {
        
        return products;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product getProductFromCode( String code ) {
        
        return products.get(code);
    }

}