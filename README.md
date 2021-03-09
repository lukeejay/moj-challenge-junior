# moj-lukeejay-challenge

## Running the Application

To run the program use the following command  

```
gradlew.bat run --console=plain
```
--console=plain is needed to hide the default gradle progress which will display a progress bar interrupting the output of the program

The user will then be prompted to enter a product code 

```
Please input product code or exit:

```

Here there are the options to enter a product code or to exit the program to give a summary of the total amount

When exit is selected the results should be in the format below

```
Offer name: Strawberry Bulk Buy -£1.50
Total Spend was : £13.50
```

Displayed will be the amount saved per offer and the final total of the basket. 

## Running Tests

Tests can be run and status viewed by using:

```
gradle.bat clean test
```

## Running a Release

The release should be run by extracting the zip folder and running either bin/app.bat or bin/app depending on the OS


## My approach

There are 4 main elements to the program 

### Checkout

The checkout is constructed with a ScannerService, ProductService and OfferService

The checkout holds the basket map which maps a list of Products to the amount of times they have occured

The checkout uses the ScannerService to scan items (in this case the user input) 

It uses the ProductService to then lookup the product code scanned and get the correct Product object

It then uses the offer service to calculate any offers that should applied on the final basket and outputs the final cost.

### Product Service

The ProductService allows products to be looked up by their product code in this implenentation the products are just set by constants in the code.

### Scanner

The Scanner is the input component and the main way the user will interact with the program (in this case it is just a wrapper around a System.in scanner)  

### Offer Service

The OfferService will calculate the total discount applied by a set of offers. In this implementation the offers are set by constants in the code. 




