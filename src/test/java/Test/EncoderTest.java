//package Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//import org.testng.annotations.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//
//public class encoderTest {	
//	@Test
//	public void test_01(){
////		System.out.println("Hi");
////		Response response=RestAssured.get("https://preprod.1stbet.com/prism/v1/video/videoEncoders");
////		System.out.println(response.getStatusCode());
//		RestAssured.baseURI = "https://preprod.1stbet.com";
//		
//		RestAssured.useRelaxedHTTPSValidation();
//		
//		
//	given().log().all().auth("Authorization"," Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IkYxRTM0MENCNjZCNEFENTgyQTYwNjcyMTRDN0M2MTM0IiwidHlwIjoiYXQrand0In0.eyJpc3MiOiJodHRwczovL3ByZXByb2QuMXN0YmV0LmNvbS9wcmlzbS9hdXRoIiwibmJmIjoxNzIxOTIyMDIxLCJpYXQiOjE3MjE5MjIwMjEsImV4cCI6MTcyMTkzMjgyMSwiYXVkIjoiaHR0cHM6Ly9wcmlzbS4xc3QuY29tIiwic2NvcGUiOlsib3BlbmFwaSIsIm9wZW5pZCIsInByb2ZpbGUiLCJwcmlzbSJdLCJhbXIiOlsicHdkIl0sImNsaWVudF9pZCI6Im9yZy8xU1QvYXV0aG9yaXplZENsaWVudHMvMTExMTExMTEtMTExMS0xMTExLTExMTEtMTExMTExMTExMTExIiwic3ViIjoib3JnLzFTVC91c2Vycy8xMTExMTExMS0xMTExLTExMTEtMTExMS0xMTExMTExMTExMTEiLCJhdXRoX3RpbWUiOjE3MjE5MjIwMjAsImlkcCI6ImxvY2FsIiwic2lkIjoiM0UzQTQxNjk4Qjk4REZGRTMzNUEwQzdCMjEyQTk2NjIiLCJqdGkiOiI4RDc3NjM3MzlBODg1RUYyMDNGMDA1RTExREREREY1NCJ9.QLn6OTQ3fK6ghGlxHRh9ks7hSne9rQ1Cs49N5KhBohA0qpIAXalemMyFS001ad4UZx8pDQqY1a0L8ggrk5A4rZpr4VFivtdHXKCf1hnfGuwThRGz0p7Ociv-0bnY30CbSmt7MK8oEx2sWNk_LYWexk7Q8fq8eZWp4Sf10r3Xr66tDNSdZ8GaG5OVHItLYasdHYsRHwI_ETX96hjwGmUQ0dU0LmdOWyHLrM1s-l4qbk8fJxtbVBxvm1T1r571rkcnWrABC4ESW9LCIgQKlNlXpEUmtYo_32ByJkH460xNQMuSVHQtK0txiSfeWbYRflzAws-RnPc-a9gpUamJklHvgQ")
//				.header("Content-Type","application/json")
//				.body("{}").when().post("/prism/v1/video/videoEncoders")
//				.then().log().all().assertThat().statusCode(200)	;
//		
//		
//		
//	}
//	
//
//}

package Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class EncoderTest {
    @Test
    public void test_01() {
        RestAssured.baseURI = "https://preprod.1stbet.com";
        RestAssured.useRelaxedHTTPSValidation();
        String EncoderName = "Encoder-007";
        String EncoderIDName = "EncoderID-007";

        // Define the JSON body as a String with a placeholder
        String body = "{\r\n"
            + "    \"parent\": \"org/Auto_test/orgUnits/Auto_Unit\",\r\n"
            + "    \"display_name\": {\r\n"
            + "        \"value\": \"" + EncoderName + "\"\r\n"
            + "    },\r\n"
            + "    \"vendor\": \"VENDOR_LTN\",\r\n"
            + "    \"vendor_encoder_identifier\": \""+EncoderIDName+"\",\r\n"
            + "    \"state\": \"STATE_UNSPECIFIED\"\r\n"
            + "}";

        given()
            .log().all()
            .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IkYxRTM0MENCNjZCNEFENTgyQTYwNjcyMTRDN0M2MTM0IiwidHlwIjoiYXQrand0In0.eyJpc3MiOiJodHRwczovL3ByZXByb2QuMXN0YmV0LmNvbS9wcmlzbS9hdXRoIiwibmJmIjoxNzIxOTY5NTM1LCJpYXQiOjE3MjE5Njk1MzUsImV4cCI6MTcyMTk4MDMzNSwiYXVkIjoiaHR0cHM6Ly9wcmlzbS4xc3QuY29tIiwic2NvcGUiOlsib3BlbmFwaSIsIm9wZW5pZCIsInByb2ZpbGUiLCJwcmlzbSJdLCJhbXIiOlsicHdkIl0sImNsaWVudF9pZCI6Im9yZy8xU1QvYXV0aG9yaXplZENsaWVudHMvMTExMTExMTEtMTExMS0xMTExLTExMTEtMTExMTExMTExMTExIiwic3ViIjoib3JnLzFTVC91c2Vycy8xMTExMTExMS0xMTExLTExMTEtMTExMS0xMTExMTExMTExMTEiLCJhdXRoX3RpbWUiOjE3MjE5Njk1MzQsImlkcCI6ImxvY2FsIiwic2lkIjoiNUI0RTM4MDM0MkNDMjBDM0E4MjE0NUNEQTFDOTJDQjkiLCJqdGkiOiJGMkY5MEZDMzYzMzg2QzQ4OEI0QjhBODczMDUzODRBOCJ9.KB2_vChh1PBK4oNGfqmiLx0qh0CDjXBw26f9g7OyBMAm00q9uNf_BvB4glETuznfYQtk1akza2en_zPk_ah2PeGqdns2PyLI81trVcbddVqYLjgTkLQMtsNWJCkVegIgNDMJLwcjNvnLP8D1eDRLS81OPJLFgW4qyGcKu-W5my-b1urT62tTOh-Cas0QVgRTxEoaArwosT451oKEBLdupLJYrih1WWYA5y_1c4f_874ls5P-T3ftsAkhx4YUmAjgKdN3xtX9ZOGfi1LQ5tdH4-AbqikyRjSEm2b9g9-mqBT_oWY2Bg7PE1IgTDwwGp4h7h4fIBSmJpvj4eD8GhWwEw")
            .header("Content-Type", "application/json")
            .body(body)
        .when()
            .post("/prism/v1/video/videoEncoder")
        .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .body("display_name.value", equalTo(EncoderName))
            .body("vendor_encoder_identifier", equalTo(EncoderIDName));
    }
}
