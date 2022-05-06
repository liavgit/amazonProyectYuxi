package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import pages.AmazonPage1_Home;
import pages.AmazonPage2_Results;
import pages.AmazonPage3_Product;
import pages.AmazonPage4_Cart;
import pages.BasePage;

public class HomeAmazonSteps {
  AmazonPage1_Home amazonPage1_Home = new AmazonPage1_Home();
  AmazonPage2_Results amazonPage2_Results = new AmazonPage2_Results();
  AmazonPage3_Product amazonPage3_Product = new AmazonPage3_Product();
  AmazonPage4_Cart amazonPage4_Cart = new AmazonPage4_Cart();
  String category;
  private static double productPrice=0.0;
  Double productPriceInCart;
  Double caculatedTotalPrice;
  Integer quantity2;

  @Given("I am on the Amazon Home page")
  public void i_am_on_the_Amazon_Home_page() {
    //Navigate to amazon
    amazonPage1_Home.navigateToAmazon();
    //Assert that I am in the Amazon page
    Assert.assertEquals("Amazon home page load properly","https://www.amazon.com/",BasePage.getUrl());
  }

  //String "Hats for men"
  @Given("I Search for hats with the category {string} in the products search field")
  public void i_Search_for_hats_with_the_category_in_the_products_search_field(String value) {
    //Search for the product
    amazonPage1_Home.searchProduct(value);
    //Assert that I am on the results page
    amazonPage2_Results.checkIfResultsPageContainsSearchText(value);
  }

  //String: "Results"
  @Given("I select the first product on the {string} page")
  public void i_select_the_first_product_on_the_page(String value) {
    //Get the name of the first product
    //....................................
    //Select the first product
    amazonPage2_Results.selectProduct();
    //Assert that the first product page is displayed and has the product name
    //....................................
  }

  //int: 2
  @When("I select quantity {int} for the selected product")
  public void i_select_quantity_for_the_selected_product(Integer int1) {
    quantity2 = int1;
    //get the price of the product
    productPrice = amazonPage3_Product.getproductPrice();
    //Select 2 products
    amazonPage3_Product.selectQuantity(int1);
    //assert the quantity was selected sucessfully
    //....................................
  }

  @When("I add the product to the cart")
  public void i_add_the_product_to_the_cart() {
    //add the product to the cart
    amazonPage3_Product.addProductToCart();
    //Asert that product was added to cart properly
    Assert.assertEquals("Product added to cart properly","Added to Cart",amazonPage3_Product.getCartPageLabel());
  }

  @Then("I open the cart to continue with the purchase")
  public void i_open_the_cart_to_continue_with_the_purchase() {
    //open the cart
    amazonPage3_Product.goToCart();
    //ASSERT i am in the cart page
    BasePage.toContain(amazonPage4_Cart.getCartPageLabel(), "Shopping Cart");
    //ASSERT quantity is correct
    String quantity = String.valueOf(quantity2);
    Assert.assertEquals("Quantity is correct",quantity,amazonPage4_Cart.getSelectedQuantity());
    //ASSERT price is correct
    caculatedTotalPrice =  (productPrice * quantity2);
    System.out.println("caculatedTotalPrice: "+caculatedTotalPrice);
    Assert.assertEquals(caculatedTotalPrice, amazonPage4_Cart.getCartTotalPrice());
  }
  
  @Then("I Reduce the quantity from {int} to {int} in Cart for the product selected")
  public void i_Reduce_the_quantity_from_to_in_Cart_for_the_product_selected(Integer int1, Integer int2) {
    //change product to 1
    amazonPage4_Cart.selectQuantity();
    //asser quantity is correct
    String expectedQuantity = String.valueOf(int2);
    Assert.assertEquals("Quantity is correct",expectedQuantity,amazonPage4_Cart.getSelectedQuantity());
    //get new price appearing in the cart
    /*BasePage.waiting();
    productPriceInCart = amazonPage4_Cart.getCartTotalPrice();
    System.out.println("productPriceInCart: "+productPriceInCart);
    System.out.println("productPrice: "+productPrice);
    //asser price is correct
    Assert.assertTrue(productPrice ==productPriceInCart);*/
  }

}