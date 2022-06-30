package Payconiq.stepdefinitions;

import Payconiq.TestBase.Base;
import Payconiq.utilities.UsableMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DeleteBookingStepDefs extends Base {
    Response response;
    String BeforeTheDelete=UsableMethods.getId();

    public DeleteBookingStepDefs() throws IOException {
    }

    @Given("user sends a delete request to booking {string}")
    public void userSendsADeleteRequestToBooking(String IdToBeDeleted) throws IOException {

        String ReadyToken = UsableMethods.createToken();
        String singleId= UsableMethods.getId();
        System.out.println(ReadyToken);
        System.out.println("Before Deleting the ID "+BeforeTheDelete);

        response= given().headers("Cookie",ReadyToken,"Content-Type", ContentType.JSON).when().delete(baseUrl+ "booking/"+ singleId);
        response.prettyPrint();
        System.out.println("After Deleting the ID "+singleId);

    }
    @When("user gets the delete status code {int}")
    public void userGetsTheDeleteStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }


    @Then("user verify the booking {string} was deleted succesfully")
    public void userVerifyTheBookingWasDeletedSuccesfully(String deletedId) throws IOException {
        Assert.assertFalse(UsableMethods.getIdList().contains(BeforeTheDelete));
    }



}
