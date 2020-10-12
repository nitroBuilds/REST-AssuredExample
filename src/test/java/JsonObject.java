import org.json.JSONObject;

public class JsonObject {

    public static String JsonBook() {
        JSONObject book1 = new JSONObject();
        book1.put("firstname","jim");
        book1.put("lastname","jim");
        book1.put("totalprice","jim");
        book1.put("depositpaid","jim");
        book1.put("bookingdates.checkin","2020-08-02");
        book1.put("bookingdates.checkout","2030-08-02");
      String bookstring=  book1.toString();


return bookstring;

    }


}
