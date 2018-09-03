package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        //throw new UnsupportedOperationException();

        String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
        driver.get(url);

        WebElement fieldEmail = driver.findElement(By.id("email"));
        fieldEmail.sendKeys(login);

        WebElement fieldPassword = driver.findElement(By.id("passwd"));
        fieldPassword.sendKeys(password);

        WebElement buttonSignIn = driver.findElement(By.className("ladda-label"));
        buttonSignIn.click();
    }

    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        // TODO implement logic for new category creation
        //throw new UnsupportedOperationException();

        WebElement itemCatalog = driver.findElement(By.cssSelector("#subtab-AdminCatalog>.title.has_submenu"));
        Actions actions = new Actions(driver);
        actions.moveToElement(itemCatalog).build().perform();

        WebElement itemCategory = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("категории")));
        itemCategory.click();
        WebElement addCategoryIcon = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("page-header-desc-category-new_category")));
        addCategoryIcon.click();

        WebElement fieldName = driver.findElement(By.id("name_1"));
        fieldName.sendKeys(categoryName);

        WebElement buttonSave = driver.findElement(By.cssSelector("button[name='submitAddcategoryAndBackToParent']"));
        buttonSave.click();

        WebElement successfulPostCategoryCreation = (new  WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"alert alert-success\"]")));
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded

        // wait.until
        // ...
    }

}
