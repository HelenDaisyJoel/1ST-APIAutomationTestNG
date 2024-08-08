package utils;
import static io.restassured.RestAssured.given;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import pojo.EncoderResponse;
import pojo.DecoderResponse;

//public class BaseApiService<T> {
//    private final RequestSpecification reqSpec;
//    private final ObjectMapper objectMapper;
//    private final Class<T> responseType;
//
//    public BaseApiService(ConfigUtility config, Class<T> responseType) {
//        this.reqSpec = new RequestSpecBuilder()
//                .setBaseUri(config.getProperty("baseUri"))
//                .setContentType(ContentType.JSON)
//                .addHeader("Authorization", config.getProperty("authToken"))
//                .addHeader("accept", "application/json")
//                .build();
//        this.objectMapper = new ObjectMapper();
//        this.responseType = responseType;
//    }

public abstract class BaseApiService<T> {
    protected RequestSpecification reqSpec;
    protected ObjectMapper objectMapper;
    protected Class<T> responseType;

    public BaseApiService(ConfigUtility config, Class<T> responseType) {
        this.reqSpec = new RequestSpecBuilder()
                .setBaseUri(config.getProperty("baseUri"))
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", config.getProperty("authToken"))
                .addHeader("accept", "application/json")
                .build();
        this.objectMapper = new ObjectMapper();
        this.responseType = responseType;
    }

    public T create(String endpoint, Object request) {
        Response response = given()
                .spec(reqSpec)
                .body(request)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();

        // Log the raw response
        String rawResponse = response.getBody().asString();
        System.out.println("Raw API Response: " + rawResponse);

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to create booking: " + response.getStatusLine() + " " + rawResponse);
        }

        try {
            return objectMapper.readValue(rawResponse, responseType);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize response: " + e.getMessage(), e);
        }
    }

    public T get(String endpoint) {
        return given()
                .spec(reqSpec)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response()
                .as(responseType);
    }

    public T delete(String endpoint) {
        return given()
                .spec(reqSpec)
                .when()
                .body("{}")
                .delete(endpoint)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response()
                .as(responseType);
    }

    public T list(String endpoint) {
        return given()
                .spec(reqSpec)
                .body("{}")
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response()
                .as(responseType);
    }
    
    public T update(String endpoint, Object updatedObject, String... fields) {
        return given()
                .spec(reqSpec)
                .queryParam("field_mask", String.join(",", fields))
                .body(updatedObject)
                .when()
                .patch(endpoint)
                .then()
                .log().all()
//                .statusCode(200)
                .extract()
                .response()
                .as(responseType);
    }
    public T reenable(String endpoint) {
        return given()
                .spec(reqSpec)
                .body("{}")
                .when()
                .post(endpoint)
                .then()
                .log().all()
//                .statusCode(200)
                .extract()
                .response()
                .as(responseType);
    }
   
    public T disable(String endpoint) {
        System.out.println("Disable Endpoint: " + endpoint);
        return given()
                .spec(reqSpec)
                .body("{}")
                .when()
                .post(endpoint)
                .then()
                .log().all()
//                .statusCode(200)
                .extract()
                .response()
                .as(responseType);
    
//		return response;
        
//        // Log response details
//        System.out.println("HTTP/1.1 " + ((ResponseOptions<Response>) response).getStatusCode() + " " + ((ResponseOptions<Response>) response).getStatusLine());
//        ((ResponseOptions<Response>) response).getHeaders().forEach(header -> System.out.println(header.getName() + ": " + header.getValue()));
//        System.out.println(((ResponseBodyData) response).asPrettyString());
//		return response;
    }
    
}
