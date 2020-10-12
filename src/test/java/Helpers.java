import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Helpers {

    public final static String URL = "https://restful-booker.herokuapp.com/";
    public final static String BOOKING_RESOURCE = "/booking";
    public final static String BOOKING_RESOURCE_ID_1 = "/booking/1";
    public final static String BOOKING_LASTNAME = "lastname";
    public final static String BOOKING_firstname = "firstname";

    /**
     *  Запрос на получение токена гостя
     */
    public static ValidatableResponse getToken() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        ValidatableResponse getToken = given().log().all().header("Content-Type", "application/json").body("{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}")
                .when().post("/auth")
                .then().assertThat().statusCode(200);
        ValidatableResponse TOKEN = getToken;
        System.out.println(getToken);
        return TOKEN;


    }

    /**
     * Тело для отправки запроса на создание книги
     */
    public static String postBookBody() {
        String postBook = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        return postBook;
    }

    /**
     * Тело для отправки запроса на обновление книги
     */
    public static String putBookBody() {
        String putBook = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"White\",\n" +
                "    \"totalprice\" : 1111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2020-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        return putBook;
    }



}
