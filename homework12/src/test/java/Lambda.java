import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Lambda {
    private static final String REPOSITORY  = "OktoTiger/selenium_python_OOP";
    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void checkIssuesOnNavigationBar(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step ("Открываем главную страницу", () ->{
            open("https://github.com");
        });
        step("Кликаем на поисковую строку", () ->{
            $(".search-input").click();
        });
        step("Поиск репозитория " + REPOSITORY, () ->{
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем на ссылку" + REPOSITORY,()->{
            $("[href='/OktoTiger/selenium_python_OOP']").click();
        });
        step("Кликаем на Issues в навигационной панели", () ->{
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue", () ->{
            $("#issue_1").shouldHave(text("Issue"));
        });




    }

}
