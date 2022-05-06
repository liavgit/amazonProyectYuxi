Feature: Test Finding a product and adding it to the cart on Amazon Page
    @regression
    Scenario: A user searches a product (hat) and add it to the cart
        Given I am on the Amazon Home page
        And I Search for hats with the category "Hats" in the products search field
        And I select the first product on the "RESULTS" page
        When I select quantity 2 for the selected product
        And I add the product to the cart
        Then I open the cart to continue with the purchase
        And I Reduce the quantity from 2 to 1 in Cart for the product selected

        