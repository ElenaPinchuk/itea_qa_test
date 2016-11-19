package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ResultPageSecond extends BasePage {

    @FindBy(id="logo")
    private WebElement googleLogo;

    @FindBy(xpath = "//div[@id='rso']//div/h3")
    private List<WebElement> searchResultsTextList;

    public ResultPageSecond(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(googleLogo);
    }

    /**
     * Gets the number of results to be displayed on the page.
     * @return int that displays the result number on page.
     */
    public int getSearchResultsOnPageCount() {
        return searchResultsTextList.size();
    }

    /**
     * Verifies that each result in a list contains search term.
     */
    public boolean checkSearchTermForEachResult(String searchTerm) {
        for (int i = 0; i < searchResultsTextList.size(); i++) {
            searchResultsTextList.get(i).getText().contains(searchTerm);
            if (searchTerm != null && searchTerm.equals(searchResultsTextList)); {
                return true;
            }
        }
        return false;
    }
}

