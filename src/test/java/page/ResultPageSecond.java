package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Page that defines the second results page.
 * Finds and matches elements of the page.
 */
public class ResultPageSecond extends BasePage {

    @FindBy(id = "center_col")
    private WebElement centralColumn;

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(id = "pnnext")
    private WebElement nextPageButton;

    @FindBy(xpath = "//div[@id='rso']//div/h3")
    private List<WebElement> searchResultsTextList;

    /**
     * Initiates elements of the class using the Page Factory Pattern.
     * @param driver Browser driver that supports dynamic web pages.
     */
    public ResultPageSecond(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(centralColumn);
    }

    /**
     * Gets loaded current page.
     * @return boolean with true value.
     */
    public boolean isPageLoaded() {
        return waitUntilElementDisplayed(centralColumn, 5).isDisplayed();
  }

    /**
     * Gets the number of results to be displayed on the page.
     * @return int that displays the result number on page.
     */
    public int getSearchResultsOnPageNumber() {
        //waitUntilElementDisplayed(centralColumn);
        return searchResultsTextList.size();
    }

    /**
     * Verifies that each result in a list contains search term.
     */
    public boolean checkSearchTermForEachResult(String searchTerm) {
        for (int i = 0; i < searchResultsTextList.size(); i++) {
            searchResultsTextList.get(i).getText().contains(searchTerm);
            waitUntilElementDisplayed(centralColumn);
            if (searchTerm != null && searchTerm.equals(searchResultsTextList)); {
                return true;
            }
        }
        return false;
    }
}

