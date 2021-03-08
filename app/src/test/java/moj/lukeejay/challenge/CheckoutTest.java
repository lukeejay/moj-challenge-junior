package moj.lukeejay.challenge;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import moj.lukeejay.challenge.products.services.ProductService;
import moj.lukeejay.challenge.scanner.Scanner;

/**
 * Tests for the checkout class
 */
public class CheckoutTest {

    @Mock
    Scanner scanner;

    @Mock
    ProductService productService;

    private Checkout checkout;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks( this );
        this.checkout = new Checkout( productService, scanner );
    }

    @Test
    public void checkoutCanScanUntilExit() {

        List<String> productCodes = Arrays.asList( "CF1", "FR1", "SR1", "Exit" );

        Mockito.when( scanner.readProductCode() ).thenAnswer( new Answer<String>(){

            private int count = 0;
            @Override
            public String answer( InvocationOnMock invocation ) throws Throwable {
                String result = productCodes.get( count );
                count++;

                return result;
            }
            
        } );

        checkout.start();

        Mockito.verify( productService, Mockito.times( 3 ) ).getProductFromCode( Mockito.anyString() );

    }
}
