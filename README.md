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






