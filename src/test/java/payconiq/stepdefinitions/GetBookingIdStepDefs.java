package payconiq.stepdefinitions;

import payconiq.utilities.UsableMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

import static payconiq.TestBase.Base.baseUrl;
import static io.restassured.RestAssured.given;

public class GetBookingIdStepDefs  {
    Response response;


    @Given("user sends the get request to {string}")
    public void user_sends_the_get_request_to(String endPoint) throws IOException {
        response =given().accept(ContentType.JSON).when().get(baseUrl + endPoint);
        response.prettyPrint();
        System.out.println(UsableMethods.getIdList());


    }
    @When("user gets the status code {int}")
    public void user_gets_the_status_code(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }
    @Then("user verify the respond body contains {string}")
    public void user_verify_the_respond_body_contains(String bookingid) {
        Assert.assertTrue(response.asString().contains("bookingid"));

    }
    @Then("user verify the valid booking {string}")
    public void user_verify_the_valid_booking(String Ids ) throws IOException {
        Assert.assertTrue(response.asString().contains(UsableMethods.getId()));

    }



}
