package ru.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MortgageSecondaryHousingPage extends BasePage {


    @FindBy(xpath = "//div[text()[contains(.,'Стоимость')]]/../input")
    private WebElement propertyValue;

    @FindBy(xpath = "//div[text()[contains(.,'Первоначальный взнос')]]/../input")
    private WebElement initialFee;

    @FindBy(xpath = "//div[text()[contains(.,'Срок кредита')]]/../input")
    private WebElement creditTerm;

    @FindBy(xpath = "//span[text() = 'Страхование жизни и здоровья']/../..//input")
    private WebElement lifeAndHealthInsuranceButton;

    @FindBy(xpath = "//span[text() = 'Молодая семья']/../..//input")
    private WebElement youngFamilyButton;



    @FindBy(xpath = "//div[@data-e2e-id = 'mland-calculator/result-block']//span[text() = 'Ежемесячный платеж']/..//span//span")
    private WebElement monthlyPaymentElement;

    @FindBy(xpath = "//div[@data-e2e-id = 'mland-calculator/result-block']//span[text() = 'Сумма кредита']//..//span//span")
    private WebElement creditAmountElement;

    @FindBy(xpath = "//div[@data-e2e-id = 'mland-calculator/result-block']//span[text() = 'Необходимый доход']//..//span//span")
    private WebElement necessaryIncomeElement;

    @FindBy(xpath = "//div[@data-e2e-id = 'mland-calculator/result-block']//span[text() = 'Процентная ставка']//..//span//span")
    private WebElement interestRateElement;




    public MortgageSecondaryHousingPage fillField(String nameField, String value){
        WebElement element = null;
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.id("iFrameResizer0")));
        String str = monthlyPaymentElement.getText();
        waitTime(300);
        switch (nameField){
            case "Стоимость недвижимости" :
                fillInputField(propertyValue , value);
                element = propertyValue;
                break;
            case "Первоначальный взнос" :
                fillInputField(initialFee , value);
                element = initialFee;
                break;
            case "Срок кредита" :
                fillInputField(creditTerm , value);
                element = creditTerm;
                break;
            default:
                Assertions.fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "'Оформления страхования путешественников'");
        }
        while (monthlyPaymentElement.getText().equals(str) != true) {
            str = monthlyPaymentElement.getText();
            waitTime(500);
        }
        String tempVar = element.getAttribute("value").replaceAll("[^0-9]", "");
        Assertions.assertEquals( tempVar ,
                value, "Поле '" + nameField + "' было заполнено некорректно");
        driverManager.getDriver().switchTo().defaultContent();
        return this;
    }
    //Убрать галку страхование жизни
    public MortgageSecondaryHousingPage lifeAndHealthInsuranceOFF(){
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.id("iFrameResizer0")));
        if (lifeAndHealthInsuranceButton.getAttribute("aria-checked").equals("true")) {
        driverManager.getDriver().findElement(By.xpath("//span[text() = 'Страхование жизни и здоровья']/../..//input/../..")).click();
        }
        driverManager.getDriver().switchTo().defaultContent();
        return this;
    }
    //Поставить галку молодая семья
    public MortgageSecondaryHousingPage youngFamilyON(){
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.id("iFrameResizer0")));
        if (youngFamilyButton.getAttribute("aria-checked").equals("false")) {
            driverManager.getDriver().findElement(By.xpath("//span[text() = 'Молодая семья']/../..//input/../..")).click();
        }
        driverManager.getDriver().switchTo().defaultContent();
        return this;
    }



    //Проверка ежемесячного платежа
    public  MortgageSecondaryHousingPage checkMonthlyPayment(String monthlyPayment){
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.id("iFrameResizer0")));
        String str = monthlyPaymentElement.getText();
        waitTime(300);
        while (monthlyPaymentElement.getText().equals(str) != true) {
            str = monthlyPaymentElement.getText();
            waitTime(1000);
        }
        str = str.replaceAll("[^0-9]", "");
        Assertions.assertEquals(monthlyPayment , str , "Mortgage Secondary Housing Page");
        driverManager.getDriver().switchTo().defaultContent();
        return this;
    }
    //Проверка суммы кредита
    public  MortgageSecondaryHousingPage checkCreditAmount(String creditAmount){
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.id("iFrameResizer0")));
        String str = creditAmountElement.getText();
        waitTime(200);
        while (creditAmountElement.getText().equals(str) != true) {
            str = creditAmountElement.getText();
            waitTime(1000);
        }
        str = str.replaceAll("[^0-9]", "");
        Assertions.assertEquals(creditAmount , str , "Mortgage Secondary Housing Page");
        driverManager.getDriver().switchTo().defaultContent();
        return this;
    }
    //Проверка необходимого дохода
    public  MortgageSecondaryHousingPage checkNecessaryIncome(String necessaryIncome){
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.id("iFrameResizer0")));
        String str = necessaryIncomeElement.getText();
        waitTime(200);
        while (necessaryIncomeElement.getText().equals(str) != true) {
            str = necessaryIncomeElement.getText();
            waitTime(1000);
        }
        str = str.replaceAll("[^0-9]", "");
        Assertions.assertEquals(necessaryIncome , str , "Mortgage Secondary Housing Page");
        driverManager.getDriver().switchTo().defaultContent();
        return this;
    }
    //Проверка процентной ставки
    public  MortgageSecondaryHousingPage checkInterestRate(String interestRate){
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.id("iFrameResizer0")));
        String str = interestRateElement.getText();
        waitTime(100);
        while (interestRateElement.getText().equals(str) != true) {
            str = interestRateElement.getText();
            waitTime(1000);
        }
        str = str.replaceAll("[^0-9 ,]", "");
        Assertions.assertEquals(interestRate , str , "Процентная ставка не совпала");
        driverManager.getDriver().switchTo().defaultContent();
        return this;
    }

}
