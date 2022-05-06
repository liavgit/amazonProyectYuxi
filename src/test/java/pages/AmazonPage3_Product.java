package pages;

public class AmazonPage3_Product extends BasePage {
    
    public static String selectQuantityDropdown = "//span[@class='a-dropdown-label']";
    public static String selectQuantity2 = "//li[@class='a-dropdown-item' and @aria-labelledby='quantity_1']";
    public static String addToCarButton = "//input[@id='add-to-cart-button']";
    public static String addedToCartLabel = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']";
    public static String goToCartButton = "//a[@href='/gp/cart/view.html?ref_=sw_gtc']";
    public static String productPriceLabel = "//span[@class='a-price a-text-price a-size-medium apexPriceToPay']";

    public void selectQuantity(Integer value) {
        click(selectQuantityDropdown);
        click(selectQuantity2);
    }

    /*public void addProductQuantity(Integer value) {
        click(addToCarButton);
    }*/

    public void addProductToCart() {
       click(addToCarButton);
    }

    public void goToCart() {
        click(goToCartButton);
    }

    public Double getproductPrice() {
         String price = getInnerText(productPriceLabel);
         price = price.substring(1, 6);
         Double priceDouble = Double.parseDouble(price);
         return priceDouble;
    }

    public String getCartPageLabel() {
        return getInnerText(AmazonPage3_Product.addedToCartLabel);
    }

    //get the price of the product
    //productPriceString = BasePage.getInnerText(AmazonPage3_Product.productPriceLabel);
}
