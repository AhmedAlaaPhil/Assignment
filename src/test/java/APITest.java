import apis.PetStore;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.StringHelper;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITest {

    // pet store instants
   PetStore petStore = new PetStore();
   // request headers
   Header header = new Header("Content-Type", "application/json");

   /*
   * Test case 1 : create an item in the database
   * Priority : High
   * create records in the BD for the website
   * */
    @Test
    public void TC01_POSTPet() throws IOException {
        // make the request , assert on the statues code and extract the response
             Response response =    given()
                .baseUri(petStore.getBaseURL())
                .body(petStore.getPostPetBody())
                .header(header)
                .when()
                .post(petStore.getPostPetPathURL())
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();
             // extreact body from the response
             ResponseBody responseBody = response.getBody();

       // remove white spaces from responses body and assert
        Assert.assertEquals(StringHelper.removeWhiteSpaces(responseBody.prettyPrint() ), petStore.getPostPetResponses());
    }


    /*
    * Test case 2 : check items in the database
    * Priority :High
    * Check if there are records in the DB
    * assert that the response body is not empty
    * */
    @Test
    public void TC02_GETInventory(){
        given()
                .baseUri(petStore.getBaseURL())
                .header(header)
                .when()
                .get(petStore.getGetInventoryPathURL())
                .then()
                .assertThat()
                .statusCode(200)
                .body("isEmpty()", Matchers.is(false));



    }

    /*
    * Test case 3 : check the login functionality for the website
    * Priority :medium
    * assert that body contains logged-in user
    * */

    @Test
    public void  TC03_GETLogin(){
        given()
                .baseUri(petStore.getBaseURL())
                .header(header)
                .queryParam("username" , petStore.getGetLoginUserName())
                .queryParam("password" , petStore.getGetLoginPass())
                .when()
                .get(petStore.getGetLoginPathURL())
                .then()
                .assertThat()
                .statusCode(200)
                .body("message" , containsString("logged in user session"));



    }

}
