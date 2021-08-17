package ru.appline.framework.steps;

import io.cucumber.java.ru.И;
import ru.appline.framework.managers.PageManager;


public class HomePageSteps {

    PageManager pageManager = PageManager.getPageManager();


    @И("^Закрытие сообщения cookies$")
    public void closeCookies() {
        pageManager.getHomePage().closeCookiesDialog();
    }

    @И("^Выбираем \"(.+)\" в главном меню$")
    public void selectBaseMenu(String nameBaseMenu) {
        pageManager.getHomePage().selectBaseMenu(nameBaseMenu);
    }

    @И("^Выбираем (.+) в подменю$")
    public void selectSubMenu(String nameSubMenu) {
        pageManager.getHomePage().selectSubMenu(nameSubMenu);
    }
}
