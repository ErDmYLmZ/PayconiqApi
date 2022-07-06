package payconiq.pojo.getBookingIdPojo;

import com.google.gson.annotations.SerializedName;

public class BookingIdPojo {

	@SerializedName("bookingid")
	private String bookingid;

	public void setBookingid(String bookingid){
		this.bookingid = bookingid;
	}

	public String getBookingid(){
		return bookingid;
	}

	@Override
 	public String toString(){
		return 
			"ResponseItem{" + 
			"bookingid = '" + bookingid + '\'' + 
			"}";
		}
}