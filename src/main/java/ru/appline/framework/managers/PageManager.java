package ru.appline.framework.managers;


import ru.appline.framework.pages.HomePage;
import ru.appline.framework.pages.MortgageSecondaryHousingPage;

public class PageManager {
    private PageManager() {
    }

    private static PageManager pageManager;

    private HomePage homePage;

    private MortgageSecondaryHousingPage mortgageSecondaryHousingPage;


    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
    public MortgageSecondaryHousingPage getMortgageSecondaryHousingPage() {
        if (mortgageSecondaryHousingPage == null) {
            mortgageSecondaryHousingPage = new MortgageSecondaryHousingPage();
        }
        return mortgageSecondaryHousingPage;
    }



}
