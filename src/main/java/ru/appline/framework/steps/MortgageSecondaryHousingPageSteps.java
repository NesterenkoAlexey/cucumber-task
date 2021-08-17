package ru.appline.framework.steps;


import io.cucumber.java.ru.И;
import org.junit.jupiter.api.Assertions;
import ru.appline.framework.managers.PageManager;

public class MortgageSecondaryHousingPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @И("^Заполняем поле (.+) ([0-9]+)$")
    public void fillField(String nameField, String value){
        pageManager.getMortgageSecondaryHousingPage().fillField(nameField , value);
    }

    @И("^Убираем галочку страхование жизни$")
    //Убрать галку страхование жизни
    public void lifeAndHealthInsuranceOFF(){
        PageManager.getPageManager().getMortgageSecondaryHousingPage().lifeAndHealthInsuranceOFF();
    }

    @И("^Ставим галочку молодая семья$")
    //Поставить галку молодая семья
    public void youngFamilyON(){
        PageManager.getPageManager().getMortgageSecondaryHousingPage().youngFamilyON();
    }


    @И("^Проверяем значение поля Ежемесячный платеж ([0-9]+)$")
    //Проверка ежемесячного платежа
    public  void checkMonthlyPayment(String monthlyPayment){
        PageManager.getPageManager().getMortgageSecondaryHousingPage().checkMonthlyPayment(monthlyPayment);
    }
    @И("^Проверяем значение поля Сумма кредита ([0-9]+)$")
    //Проверка суммы кредита
    public  void checkCreditAmount(String creditAmount){
        PageManager.getPageManager().getMortgageSecondaryHousingPage().checkCreditAmount(creditAmount);

    }
    @И("^Проверяем значение поля Необходимый доход ([0-9]+)$")
    //Проверка необходимого дохода
    public  void checkNecessaryIncome(String necessaryIncome){
        PageManager.getPageManager().getMortgageSecondaryHousingPage().checkNecessaryIncome(necessaryIncome);
    }
    @И("^Проверяем значение поля Процентная ставка ([0-9 ,]+)$")
    //Проверка процентной ставки
    public  void checkInterestRate(String interestRate){
        PageManager.getPageManager().getMortgageSecondaryHousingPage().checkInterestRate(interestRate);
    }
}
