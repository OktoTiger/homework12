import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Annotation {
    private static final String REPOSITORY  = "OktoTiger/selenium_python_OOP";
    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Кликаем на поисковую строку")
    public void clickSearchBar(){
        $(".search-input").click();
    }
    @Step("Поиск репозитория " + REPOSITORY)
    public void searchForRepository(){
        $("#query-builder-test").setValue(REPOSITORY).pressEnter();
    }
    @Step("Кликаем на ссылку" + REPOSITORY)
    public void clickOnRepository(){
        $("[href='/OktoTiger/selenium_python_OOP']").click();
    }
    @Step("Кликаем на Issues в навигационной панели")
    public void clickOnIssue(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue")
    public void checkIssue(){
        $("#issue_1").shouldHave(text("Issue"));
    }
    @Test
    public void checkIssuesOnNavigationBar(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        openMainPage();
        clickSearchBar();
        searchForRepository();
        clickOnRepository();
        clickOnIssue();
        checkIssue();
    }

}
