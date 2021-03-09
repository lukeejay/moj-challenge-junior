package moj.lukeejay.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import moj.lukeejay.challenge.offers.services.OfferService;
import moj.lukeejay.challenge.products.services.ConstantProductService;
import moj.lukeejay.challenge.products.services.ProductService;
import moj.lukeejay.challenge.scanner.Scanner;

/**
 * Tests for the checkout class
 */
public class CheckoutTest {

    @Mock
    Scanner scanner;

    @Mock
    ProductService mockProductService;

    @Mock
    OfferService offerService;

    private Checkout checkout;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    public void checkoutCanScanUntilExit() {

        this.checkout = new Checkout( mockProductService, scanner, offerService);

        mockScannerInput( "CF1", "FR1", "SR1", "Exit" );

        checkout.startScanning();

        Mockito.verify( mockProductService, Mockito.times( 3 ) ).getProductFromCode( Mockito.anyString() );

    }

    private void mockScannerInput(String ... inputs) {
        Mockito.when( scanner.readProductCode() ).thenAnswer( new Answer<String>(){

            private int count = 0;
            @Override
            public String answer( InvocationOnMock invocation ) throws Throwable {
                String result = null;

                if( count < inputs.length ) {
                    result = inputs[count];
                    count++;
                }

                return result;
            }
            
        } );
    }

    @Test 
    public void testTotalOfItemsWithNoOffer() {
        this.checkout = new Checkout( new ConstantProductService(), scanner, offerService );

        mockScannerInput( "CF1", "FR1", "SR1", "Exit" );

        checkout.startScanning();

        Assertions.assertEquals( 19.34, checkout.calculateTotal() ) ;
    }


    @Test
    public void testTotalOfMultipleSameItemsWithNoOffer() {
        this.checkout = new Checkout( new ConstantProductService(), scanner, offerService );

        mockScannerInput( "SR1", "SR1", "SR1", "SR1", "Exit" );

        checkout.startScanning();

        checkout.calculateTotal();

        Assertions.assertEquals(20, checkout.calculateTotal() );

    }
}
