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

    public static RequestSpecification createUserRequestSpec = with()
            .basePath("/users")
            .log().uri()
            .log().body()
            .contentType(JSON);

    public static ResponseSpecification createUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("userName", notNullValue())
            .expectBody("userJob", notNullValue())
            .expectBody("id", notNullValue())
            .expectBody("createdAt", notNullValue())
            .build();

    public static RequestSpecification updateUserRequestSpec = with()
            .basePath("/users")
            .log().uri()
            .log().body()
            .contentType(JSON);

    public static ResponseSpecification updateUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("userName", notNullValue())
            .expectBody("userJob", notNullValue())
            .expectBody("updatedAt", notNullValue())
            .build();

    public static RequestSpecification registerUserRequestSpec = with()
            .basePath("register")
            .log().uri()
            .contentType(JSON);

    public static ResponseSpecification registerKnownUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("id", notNullValue())
            .expectBody("token", notNullValue())
            .build();

    public static ResponseSpecification registerUnknownUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("error", notNullValue())
            .build();
}
