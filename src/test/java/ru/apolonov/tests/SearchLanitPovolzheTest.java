package ru.apolonov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.apolonov.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SearchLanitPovolzheTest extends TestBase {
    private final String urlSite = "https://lanit.ru";

    @DisplayName("Поиск дочерней компании Ланит-Поволжье")
    @Tag("SearchAffiliatedCompany")
    @Test
    void SearchAffiliatedCompany() {
        step("открыть главную страницу сайта www.lanit.ru", () ->
                open(urlSite));
        step("Найти в меню пункт \"О нас\"", () -> {
            $$(".menu__list .menu__item").get(0).hover();
        });
        step("Выбрать пункт \"Подразделения\"", () ->
                $$(".submenu__list .submenu__item").get(1).click());
        step("Выбрать дочернюю компанию Нижний Новгород", () -> {
            $(".tab-14882").shouldHave(text("Нижний Новгород")).click();
            $(linkText("ЛАНИТ-ПОВОЛЖЬЕ")).click();
        });
        step("Найти адрес офиса в Нижнем Новгороде", () -> {
            $(".department__info__coord").shouldHave(text("603093, г.Нижний Новгород ул.Родионова, 23, офис 410"));
        });
    }
}
