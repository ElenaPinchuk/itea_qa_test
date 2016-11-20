package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *Page that defines the main page.
 * Finds and matches elements of the page.
 */
public class HomePage extends BasePage {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(name = "btnG")
    private WebElement searchButton;

    /**
     * Initiates elements of the class using the Page Factory Pattern.
     * @param driver Browser driver that supports dynamic web pages.
     */
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
     * @param searchTerm Text value that is entered when searching.
     * @return ResultPageFirst with the results of search.
     */
        public ResultPageFirst fillSearchTermAndSubmit(String searchTerm) {
        searchField.clear();
        searchField.sendKeys(searchTerm);
        searchButton.click();
            waitUntilElementDisplayed(searchField);
        return new ResultPageFirst(driver);
    }
}


