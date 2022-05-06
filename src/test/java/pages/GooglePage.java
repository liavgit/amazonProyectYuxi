package pages;

import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage{

    public GooglePage(WebDriver driver) {
        super();
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

}
