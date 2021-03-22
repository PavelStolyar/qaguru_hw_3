package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Hw3 {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void findJUnitExapmleOnWikiPage() {
        //open githup page
        open("https://github.com/");
        //open selenide page
        $("[name=q]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        //go to wiki page
        $(byText("Wiki")).click();
        //check SoftAssertions page existing == open SoftAssertions page
        $(byText("SoftAssertions")).click();
        // check JUnit5 code existing
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class")).shouldBe(Condition.visible);

    }

    @Test
    void dragAndDropTest() {
        //open page
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //execute DragAndDrop operation
        $("#column-a").dragAndDropTo($("#column-b"));
        //check results
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
}
