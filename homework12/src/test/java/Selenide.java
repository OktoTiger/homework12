import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Selenide {
    private static final String REPOSITORY  = "OktoTiger/selenium_python_OOP";
    public void checkIssuesOnNavigationBar(){

            SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com/");
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").setValue(REPOSITORY);
            $("#query-builder-test").click();
            $(By.linkText(REPOSITORY)).click();
            $("#issues-tab").click();
            $("#issue_1").shouldHave(text("Issue"));

    }
}
