package pages;

//public static String categoryFreeShiping = "//h2[text()='FREE Shipping to Colombia']";*/

public class AmazonPage1_Home extends BasePage {

    //public static String cards = "//div[@class='a-cardui-header']";
    //public static String categoriesDropdown = "//div[@id='nav-search-dropdown-card']";
    //public static String leftDrawer = "//div[@id='s-refinements']";
    public static String searchProductsField = "//input[@id='twotabsearchtextbox']";
    public static String searchButton = "//input[@id='nav-search-submit-button']";
    
     
    public void navigateToAmazon() {
        navigateTo("https://www.amazon.com/");
    }

    public void searchProduct(String value) {
        click(searchProductsField);
        fill(searchProductsField, value);
        click(searchButton);
    }

    /*public boolean checkIfCategoryIsDisplayed(String value) { //cada valor sale de la tabla de HomeAmazon.feature
        boolean isDisplayed = false;
        for (int i = 1; i <= getElementSize(cards); i++) { //se va leyendo cada carta / getElementSize viene de basepage para coger el tamaño de ese arreglo 
            String text = getInnerText("(//div[@class='a-cardui-header'])[" + i + "]");//toma el valor de la carta que encuentra en amazon .. viene de basepage
            if (text.equals(value)) { //mira si son iguales los textos
                isDisplayed = true;
                break;//rompe el for
            }
        }
        return isDisplayed;//retorna el valor sea verdadero o falso 
    }*/

    /*public void searchCategory(String value) {
        click(categoriesDropdown);
        click("//option[text()='" + value + "']");
        click(searchButton);
        find(leftDrawer);
    }*/
    
}