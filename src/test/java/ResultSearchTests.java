
import org.testng.Assert;
import org.testng.annotations.*;
import page.HomePage;
import page.ResultPageFirst;
import page.ResultPageSecond;


public class ResultSearchTests extends BaseTest {

    @DataProvider(name = "searchTerms")
    public Object[][] searchTermsData() {
        return new Object[][]{
                {"ITEA", "ITEA"},
                {"itea", "itea"},
        };
    }

    /**
     * Verifies searching for term submitted on search.
     * @param searchTerm Text value that is entered when searching.
     * @param expectedContainedTerm Expected search term after searching.
     */
    @Test(dataProvider = "searchTerms")
    public void ResultsSearchTest(String searchTerm, String expectedContainedTerm) {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageLoaded());
        ResultPageFirst resultPageFirst = homePage.fillSearchTermAndSubmit(searchTerm);
        Assert.assertEquals(resultPageFirst.getSearchResultsOnPageCount(), 7, "Actual results on page number is wrong");
        Assert.assertTrue(resultPageFirst.checkSearchTermForEachResultInList(expectedContainedTerm), "Expected search term is not found in results list");
        resultPageFirst.clickNextPageButton();
        ResultPageSecond resultPageSecond = new ResultPageSecond(getDriver());
        Assert.assertEquals(resultPageSecond.getSearchResultsOnPageNumber(), 10, "Actual results on page number is wrong");
        Assert.assertTrue(resultPageSecond.checkSearchTermForEachResult(expectedContainedTerm), "Expected search term is not found in results list");
    }
}








