package reqres;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
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
    @Tag("reqres_api")
    @Owner("malyginms")
    @DisplayName("Getting a user list test")
    @Description("Getting a user list.\nUsing a request GET: https://reqres.in/api/users/?page=1")
    @Feature("userList")
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
    @Tag("reqres_api")
    @Owner("malyginms")
    @DisplayName("Creation a new user test")
    @Description("Creation a new user.\nUsing a request POST: https://reqres.in/api/users\n" +
            "and BODY \n{\n" +
            "    \"userName\": \"George\",\n" +
            "    \"userJob\": \"QA engineer\"\n" +
            "}")
    @Feature("user")
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
    @Tag("reqres_api")
    @Owner("malyginms")
    @DisplayName("Updating user data test")
    @Description("Updating user data\nUsing a request PUT: https://reqres.in/api/users/153\n" +
    "with BODY\n{\n" +
            "    \"userName\": \"George\",\n" +
            "    \"userJob\": \"Automation Java QA engineer\"\n" +
            "}")
    @Feature("user")
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
    @Tag("reqres_api")
    @Owner("malyginms")
    @DisplayName("Registration a known user test")
    @Description("Registration a known user.\nUsing a request POST: https://reqres.in/api/register\n" +
    "and BODY\n{\n" +
            "    \"email\": \"eve.holt@reqres.in\",\n" +
            "    \"password\": \"pistol\"\n" +
            "}")
    @Feature("registerUser")
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
    @Tag("reqres_api")
    @Owner("malyginms")
    @DisplayName("Registration an unknown user test")
    @Description("Trying to register an unknown user.\nUsing a request POST: https://reqres.in/api/register\n" +
    "and BODY\n{\n" +
            "    \"email\": \"testGulio@reqres.in\",\n" +
            "    \"password\": \"regres123\"\n" +
            "}")
    @Feature("registerUser")
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
