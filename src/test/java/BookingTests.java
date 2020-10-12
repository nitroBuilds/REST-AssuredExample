import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

public class BookingTests extends PingTest {


    @BeforeMethod
    public void Before() {
        PingTest pingtest = new PingTest();
        RestAssured.baseURI = Helpers.URL;
        Helpers.getToken();
        pingtest.pingTest();


    }

    @Test
    public void getBook() {
        String getBook = given().log().all().contentType(ContentType.JSON).
                when()
                .get(Helpers.BOOKING_RESOURCE)
                .then().statusCode(200).extract().response().prettyPrint();

        System.out.println(getBook);
    }

    @Test
    public void getBookId() {
        String getBookId = given().log().all().contentType(ContentType.JSON).
                when().
                get(Helpers.BOOKING_RESOURCE)
                .then().statusCode(200).extract().response().prettyPrint();

        System.out.println(getBookId);

        JsonPath js = new JsonPath(getBookId);
        String firstName = js.getString(Helpers.BOOKING_firstname);
        String lastName = js.getString(Helpers.BOOKING_LASTNAME);

        System.out.println(firstName);
        System.out.println(lastName);




    }

    @Test
    public void postBook() {
        String getBook = given().log().all().contentType(ContentType.JSON)
                .body(Helpers.postBookBody())
                .when().post(Helpers.BOOKING_RESOURCE)
                .then().statusCode(200).extract().response().prettyPrint();

        System.out.println(getBook);
    }

    @Test
    public void UpdateBook() {
        String getBook = given().log().all().contentType(ContentType.JSON)
                .body(Helpers.putBookBody()).when().put(Helpers.BOOKING_RESOURCE_ID_1).then().statusCode(403).extract().response().prettyPrint();

        System.out.println(getBook);
    }

    @Test
    public void DeleteBook() {
        String getBook = given().log().all().contentType(ContentType.JSON)
                .when().delete(Helpers.BOOKING_RESOURCE_ID_1).then().statusCode(403).extract().response().prettyPrint();

        System.out.println(getBook);
    }

    @Test
    public void getBookId1() {
        String getBookId = given().log().all().contentType(ContentType.JSON).
                when().get(Helpers.BOOKING_RESOURCE_ID_1).then().assertThat().statusCode(200).body("firstname", equalTo("Susan")).extract().response().prettyPrint();

        System.out.println(getBookId);
    }

    @Test
    public void postBookSerialization() {
        String getBook = given().log().all().contentType(ContentType.JSON)
                .body(JsonObject.JsonBook()).when().post(Helpers.BOOKING_RESOURCE).then().statusCode(200).extract().response().prettyPrint();

        System.out.println(getBook);
        System.out.println(JsonObject.JsonBook());
    }
    @Test
    public void getBookWithSpecBuilder(){
        ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();

    }
}
