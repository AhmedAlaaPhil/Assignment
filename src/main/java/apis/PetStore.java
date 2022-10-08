package apis;

import utilities.StringHelper;

import java.io.IOException;

public class PetStore {
    // String Base URL
    private String baseURL = "https://petstore.swagger.io/v2";
    //Data for POST /Pet endpoint
    private String postPetPathURL = "/pet";
    private String postPetRequestBody = "src/main/resources/jsonFiles/PostPetRequest.json";
    private String postPetResponsesBody = "src/main/resources/jsonFiles/PostPetResponses.json";


    //Data for  GET /store/inventory
    private String getInventoryPathURL = "/store/inventory";

    //Data for GET /user/login
    private String getLoginPathURL = "/user/login";
    private String getLoginUserName = "username";
    private String getLoginPass = "pass";
    private String getLoginResponsesBody = "src/main/resources/jsonFiles/GetLoginResponses.json";


    ////////////////////////////////////


    // Function to process and return the post body from json file POST /pet
    public String getPostPetBody () throws IOException {
        String results ;

        results = StringHelper.convertJsonToString(postPetRequestBody);
        return  results;

    }
    // Function to process and return the responses json file for POST /pet
    public String getPostPetResponses () throws IOException {
        String results ;
        results = StringHelper.convertJsonToString(postPetResponsesBody);
        results = StringHelper.removeWhiteSpaces(results);

        return  results;
    }
    // Function to process and return the responses json file for GET /login
    public String getGETLoginResponses () throws IOException {
        String results ;
        results = StringHelper.convertJsonToString(getLoginResponsesBody);
        results = StringHelper.removeWhiteSpaces(results);

        return  results;
    }





    // Getters
    public String getBaseURL() {
        return baseURL;
    }
    public String getPostPetPathURL() {
        return postPetPathURL;
    }

    public String getGetInventoryPathURL() {
        return getInventoryPathURL;
    }

    public String getGetLoginPathURL() {
        return getLoginPathURL;
    }

    public String getGetLoginUserName() {
        return getLoginUserName;
    }

    public String getGetLoginPass() {
        return getLoginPass;
    }

}
