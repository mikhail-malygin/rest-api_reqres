package reqres;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static specs.UserSpec.getUsersRequestSpec;
import static specs.UserSpec.getUsersResponseSpec;


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


}
