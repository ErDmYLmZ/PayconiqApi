package Payconiq.Pojo.GetBookingIdPojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetBookingPojo {

	@SerializedName("ResponseJava")
	private List<BookingIdPojo> responseJava;

	public void setResponse(List<BookingIdPojo> responseList){
		this.responseJava = responseList;
	}

	public List<BookingIdPojo> getResponse(){
		return responseJava;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"response = '" + responseJava + '\'' +
			"}";
		}
}