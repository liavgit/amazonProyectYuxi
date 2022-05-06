package pages;

public class AmazonPage2_Results extends BasePage {
    
    public static String productResultPage = "//span[@class='a-size-medium-plus a-color-base a-text-normal']";
    public static String resultsPageContainsSearchText = "//span[@class='a-color-state a-text-bold']";
    public static String imageList = "(//img[@class='s-image' and @data-image-index='1'])[1]";

    public boolean checkIfProductResultsPageDisplays(String value) {
        boolean isDisplayed = false;
        for (int i = 1; i <= getElementSize(productResultPage); i++) {
            String text = getInnerText("(//span[@class='a-size-medium-plus a-color-base a-text-normal'])[" + i + "]");
            if (text.equals(value)) {
                isDisplayed = true;
                break;  
            }
        }
        return isDisplayed;
    }

    public boolean checkIfResultsPageContainsSearchText(String value) {
        boolean isDisplayed = false;
        String searchText = BasePage.getInnerText(resultsPageContainsSearchText);
        if (searchText == value) {
            isDisplayed = true;
        }
        return isDisplayed;
    }

    public void selectProduct() {
        click(imageList);
    }

}
