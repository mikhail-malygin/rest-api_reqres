package reqres;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    @BeforeAll
    static void setUp() {

        String login = config.login();
        String password = config.password();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        RestAssured.baseURI = "https://reqres.in/api/";
        Configuration.remote = format("https://%s:%s@%s", login, password, System.getProperty("selenoidStand"));
        Configuration.browserCapabilities = capabilities;
    }

}

