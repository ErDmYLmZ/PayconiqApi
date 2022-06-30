package Payconiq.utilities;

import Payconiq.Pojo.GetBookingIdPojo.BookingIdPojo;
import Payconiq.TestBase.Base;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UsableMethods extends Base {

    public static List<String> getIdList() throws IOException {
        Response response;
        BookingIdPojo[] getBookingPojo;
        List<String>idlistPojo=new ArrayList<>();
        ObjectMapper obj = new ObjectMapper();
        response=given().accept(ContentType.JSON).when().get(baseUrl + "booking");
        getBookingPojo =obj.readValue(response.asString(), BookingIdPojo[].class);

        for(int i = 0; i<getBookingPojo.length; i++){
            idlistPojo.add(getBookingPojo[i].getBookingid());
        }

        //System.out.println(idlistPojo);

        return idlistPojo;
    }
    public static String getId() throws IOException {
        Response response;
        BookingIdPojo[] bookingPojo;
        List<String>idlistPojo=new ArrayList<>();
        ObjectMapper obj = new ObjectMapper();
        response=given().accept(ContentType.JSON).when().get(baseUrl + "booking");
        bookingPojo =obj.readValue(response.asString(), BookingIdPojo[].class);

        for(int i = 0; i<bookingPojo.length; i++){
            idlistPojo.add(bookingPojo[i].getBookingid());
        }
        String singleId= idlistPojo.get(0).toString();

//        System.out.println(singleId);
        return singleId;
    }

    public static String createToken(){

        Map<String,String> tokenBody = new HashMap<String,String>();
        tokenBody.put("username", ConfigurationReader.get("tokenUserName"));
        tokenBody.put("password", ConfigurationReader.get("tokenPassword"));
        Response response=given().
                contentType(ContentType.JSON).
                body(tokenBody).
                when().
                post(baseUrl + "auth");
        //response.prettyPrint();
        JsonPath token = response.jsonPath();
        String readyToken="token="+token.getString("token");
        //System.out.println(readyToken);
        return readyToken;

    }


    public static void main(String[] args) throws IOException {
//        getId();
//        createToken();
//        getIdList();

    }

}
