package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.notNullValue;

public class UserSpec {

    public static RequestSpecification getUsersRequestSpec = with()
            .basePath("/users")
            .log().uri()
            .contentType(JSON);

    public static ResponseSpecification getUsersResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("data", notNullValue())
            .expectBody("support", notNullValue())
            .build();
}
