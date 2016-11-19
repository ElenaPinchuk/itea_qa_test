package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ResultPageFirst extends BasePage {

    @FindBy(id="logo")
    private WebElement googleLogo;

    @FindBy(xpath = "//a[@class='_Fmb ab_button']")
    private List<WebElement> searchResultsDescriptionsList;

    @FindBy(id = "pnnext")
    private WebElement nextPageButton;

    public ResultPageFirst(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(googleLogo);
    }

    /**
     * Gets the number of results to be displayed on the page.
     * @return int that displays the result number on page.
     */
    public int getSearchResultsOnPageCount() {
        return searchResultsDescriptionsList.size();
    }

    /**
     * Verifies that each result in a list contains search term.
     */
    public boolean checkSearchTermForEachResultInList(String searchTerm) {
        for (int i = 0; i < searchResultsDescriptionsList.size(); i++) {
            searchResultsDescriptionsList.get(i).getText().contains(searchTerm);
            if (searchTerm != null && searchTerm.equals(searchResultsDescriptionsList)); {
                return true;
            }
        }
        return false;
    }

    /**
     * Clicks the advanced link
     * @return SearchPage with advanced search
     */
    public ResultPageSecond clicknextPageButton() {
        nextPageButton.click();
        return new ResultPageSecond(driver);
    }

}

