package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Page that defines the first results page.
 * Finds and matches elements of the page.
 */
public class ResultPageFirst extends BasePage {

    @FindBy(id = "center_col")
    private WebElement centralColumn;
   @FindBy(id = "lst-ib")
   private WebElement searchField;

    @FindBy(xpath = "//a[@class='_Fmb ab_button']")
    private List<WebElement> searchResultsDescriptionsList;

    @FindBy(id = "pnnext")
    private WebElement nextPageButton;

    /**
     * Initiates elements of the class using the Page Factory Pattern.
     * @param driver Browser driver that supports dynamic web pages.
     */
    public ResultPageFirst(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(searchField);
    }

    /**
     * Gets the number of results to be displayed on the page.
     * @return int that displays the result number on page.
     */
    public int getSearchResultsOnPageCount() {
      waitUntilElementDisplayed(nextPageButton);
        return searchResultsDescriptionsList.size();
    }

    /**
     * Verifies that each result in a list contains search term.
     */
    public boolean checkSearchTermForEachResultInList(String searchTerm) {
        for (int i = 0; i < searchResultsDescriptionsList.size(); i++) {
            searchResultsDescriptionsList.get(i).getText().contains(searchTerm);
            waitUntilElementDisplayed(nextPageButton);
            if (searchTerm != null && searchTerm.equals(searchResultsDescriptionsList)); {
                return true;
            }
        }
        return false;
    }

    /**
     * Redirects to the next page.
     * @return SearchPageSecond with search results.
     */
    public ResultPageSecond clickNextPageButton() {
        nextPageButton.click();
        waitUntilElementDisplayed(centralColumn);
        return new ResultPageSecond(driver);
    }
}

