import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PingTest {
    @BeforeMethod
    public void BeforePing() {
        BookingTests book = new BookingTests();
        book.Before();
    }

    @Test
    public void pingTest() {
        String ping = given().log().all().contentType(ContentType.JSON).
                when().get("/ping").then().statusCode(201).extract().response().prettyPrint();
        System.out.println(ping);
    }

    @Test
    public void getBookId() {
        String getBookId = given().log().all().contentType(ContentType.JSON).
                when().
                get(Helpers.BOOKING_RESOURCE)
                .then().statusCode(200).extract().response().prettyPrint();

        System.out.println(getBookId);

        JsonPath js = new JsonPath(getBookId);

    }
}