package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args){
        // TODO prepare driver object

        WebDriver driver = getConfiguredDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        // login
        GeneralActions newCategory = new GeneralActions(driver);
        newCategory.login("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");

        // create category
        newCategory.createCategory("Category_Test");


        // check that new category appears in Categories table
        WebElement sortCategoryByName = driver.findElement(By.cssSelector("th:nth-child(3) > span > a:nth-child(2)"));
        sortCategoryByName.click();

        WebElement appearanceOfCreatedCategory = (new  WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), 'Category_Test')]")));

        // finish script
        driver.quit();
    }
}
