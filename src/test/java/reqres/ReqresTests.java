package reqres;

import io.qameta.allure.Owner;
import models.lombok.BodyUserLombokModel;
import models.lombok.ResponseUserLombokModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static specs.UserSpec.*;


public class ReqresTests extends TestBase{

    @Test
    @Tag("regres_api")
    @Owner("malyginms")
    @DisplayName("Getting user list test")
    public void getListUsersTests() {
        given()
                .spec(getUsersRequestSpec)
                .when()
                .get("?page=1")
                .then()
                .spec(getUsersResponseSpec)
                .body("data.id", hasItems(3))
                .body("data.email", hasItems("emma.wong@reqres.in"))
                .body("support.url", is("https://reqres.in/#support-heading"))
                .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }

    @Test
    @Tag("regres_api")
    @Owner("malyginms")
    @DisplayName("Creation a new user test")
    public void createUserTests() {

        BodyUserLombokModel bodyUserLombokModel = new BodyUserLombokModel();
        bodyUserLombokModel.setUserName("George");
        bodyUserLombokModel.setUserJob("QA engineer");

        ResponseUserLombokModel responseUserLombokModel =  given()
                .spec(createUserRequestSpec)
                .body(bodyUserLombokModel)
                .when()
                .post()
                .then()
                .spec(createUserResponseSpec)
                .extract()
                .as(ResponseUserLombokModel.class);

        assertThat(responseUserLombokModel.getUserName()).isEqualTo("George");
        assertThat(responseUserLombokModel.getUserJob()).isEqualTo("QA engineer");
    }

    @Test
    @Tag("regres_api")
    @Owner("malyginms")
    @DisplayName("Updating user data test")
    public void updateUserTests() {

        BodyUserLombokModel bodyUserLombokModel = new BodyUserLombokModel();
        bodyUserLombokModel.setUserName("George");
        bodyUserLombokModel.setUserJob("Automation Java QA engineer");

        ResponseUserLombokModel responseUserLombokModel = given()
                .spec(updateUserRequestSpec)
                .body(bodyUserLombokModel)
                .when()
                .put("/153")
                .then()
                .spec(updateUserResponseSpec)
                .extract()
                .as(ResponseUserLombokModel.class);

        assertThat(responseUserLombokModel.getUserName()).isEqualTo("George");
        assertThat(responseUserLombokModel.getUserJob()).isEqualTo("Automation Java QA engineer");

    }

    @Test
    @Tag("regres_api")
    @Owner("malyginms")
    @DisplayName("Registration a known user test")
    public void registerKnownUserTests() {

        BodyUserLombokModel bodyUserLombokModel = new BodyUserLombokModel();
        bodyUserLombokModel.setEmail("eve.holt@reqres.in");
        bodyUserLombokModel.setPassword("pistol");

        given()
                .spec(registerUserRequestSpec)
                .body(bodyUserLombokModel)
                .when()
                .post()
                .then()
                .spec(registerKnownUserResponseSpec)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @Tag("regres_api")
    @Owner("malyginms")
    @DisplayName("Registration of an unknown user test")
    public void registerUnknownUserTests() {

        BodyUserLombokModel bodyUserLombokModel = new BodyUserLombokModel();
        bodyUserLombokModel.setEmail("testGulio@reqres.in");
        bodyUserLombokModel.setPassword("regres123");

        given()
                .spec(registerUserRequestSpec)
                .body(bodyUserLombokModel)
                .when()
                .post()
                .then()
                .spec(registerUnknownUserResponseSpec)
                .body("error", is("Note: Only defined users succeed registration"));
    }
}
