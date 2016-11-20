# itea_qa_test
ITEA exam test automation project

##Task: ##
Use IntellijIDEA to create new Java/MVN project that verifies google search engine.

###Expected result: ###
Automated test by following scenario:
1. Open FireFox web browser
2. Navigate to Google.com
3. Enter "ITEA" into search field
4. Click on "Search" button
5. Verify "searchResults" page is loaded
6. Verify there are 7 search results displayed on "searchResults" page
7. Verify that each result item on 1st page contains search term
8. Click on 2nd searchResults page link
9. Verify there are 10 search results displayed on 2nd "searchResults" page
10. Verify that each result item on 2nd page contains search term.

## Realization: ##
Best practices I have used during this task execution:
* have given meaningful names to methods, variables that define the exact explanation of their content;
* followed the Java Naming Conventions rules;
* used Page Object and Page Factory patterns;
* avoided hardcode, have not used Sleep and System.out.println methods;
* used data provider

### Follow functionality is realized: ###
** To run tests you need firefox v 49.0.2 (latest one can brake selenium integration with firefox) **
Automated test steps 1-8, which contain following tests:
*Check that search engine returns results
*Check that search engine returns 7 results on "Itea" search query on the first page
*Check that search engine result page supports navigation to next page (by click on "Next" button)
*Check that "next" button on the search engine result page forwards to correct page
*Check that search engine returns results on second page too

## To do list: ##
*Check that search result quantity at second result page (check that Google search engine returns 10 results).
*Check that each result item on second result page contains search term.