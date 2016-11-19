package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(searchField);
    }

    /**
     * Gets loaded current page.
     * @return boolean with true value.
     */
    public boolean isPageLoaded() {
        return waitUntilElementDisplayed(searchField, 5).isDisplayed();
    }

    /**
     * Displays the result for search term submitted.
     * @param searchTerm Text value that is entered when searching.
     * @return ResultPageFirst with search results.
     */


    public ResultPageFirst fillSearchTermAndSubmit(String searchTerm) {
        searchField.clear();
        searchField.sendKeys(searchTerm);
        searchField.submit();
        return new ResultPageFirst(driver);
    }
}

