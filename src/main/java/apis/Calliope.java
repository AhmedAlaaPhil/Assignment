package apis;

public class Calliope {
    private String xAPIKey = "NmU0ZDY0MWJiMTMzMGZkZmFiZmY5MTkyN2E3NmE4OTM2NTVjMGM5YWNjNjYzYjUzMzM1NDNkNWZlMjlkYjZkZjM0";
    private String baseURL = "https://app.calliope.pro/api/v2/profile/";
    private String myTestResultsTestNGPathURL = "4528/import/testng";
    private String myTestResultsTestNGFile = "test-output/testng-results.xml";

    public String getxAPIKey() {
        return xAPIKey;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public String getMyTestResultsTestNGPathURL() {
        return myTestResultsTestNGPathURL;
    }

    public String getMyTestResultsTestNGFile() {
        return myTestResultsTestNGFile;
    }
}
