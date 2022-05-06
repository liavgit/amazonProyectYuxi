package pages;

public class AmazonPage4_Cart extends BasePage {

    public static String cartPageLabel = "//div[@id='sc-active-cart']";
    public static String quantitySelected = "//*[@class='a-dropdown-prompt']";
    public static String cartTotalPriceWhole = "//form[@id='gutterCartViewForm']//span[@class='a-price-whole']";
    public static String cartTotalPriceFraction ="//form[@id='gutterCartViewForm']//span[@class='a-price-fraction']";
    public static String cartTotalPrice = "//div[@id='proceed-to-checkout-desktop-container']//form[@id='gutterCartViewForm']//span[contains(@class, 'a-size-medium a-color-base sc-price')]";
    public static String selectQuantityDropdown = "//span[@class='a-button a-button-dropdown quantity']";
    public static String selectQuantity1 = "//li[@tabindex='0' and @aria-labelledby='quantity_1']";
    //Double totalPriceDouble;
    Boolean flag = false;
    
    public Double getCartTotalPrice() {
        String totalPrice = "";
        
        try {
            if (BasePage.toBeVisible(cartTotalPriceWhole)) {
                String priceWhole  = getText(cartTotalPriceWhole);
                String priceFraction  = getText(cartTotalPriceFraction);
                totalPrice = priceWhole + "." + priceFraction;    
            }
        } catch (Exception e) {
            flag = true;
        }

        if (flag = false) {
            totalPrice  = getText(cartTotalPrice);
            flag = true;
        }
                
        /*if (BasePage.toBeVisible(cartTotalPriceWhole)) {
            String priceWhole  = getText(cartTotalPriceWhole);
            String priceFraction  = getText(cartTotalPriceFraction);
            totalPrice = priceWhole + "." + priceFraction;    
        } else {
            totalPrice  = getText(cartTotalPrice);
        }*/
        Double totalPriceDouble = Double.parseDouble(totalPrice);
        return totalPriceDouble;
    }

    public String getCartPageLabel() {
        //return getInnerText(AmazonPage4_Cart.cartPageLabel);
        return getText(AmazonPage4_Cart.cartPageLabel);
    }

    public String getSelectedQuantity() {
        return getInnerText(AmazonPage4_Cart.quantitySelected);
    }

    public void selectQuantity() {
        click(selectQuantityDropdown);
        click(selectQuantity1);
    }

}