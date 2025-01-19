import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class LCWAutomationProject {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.lcw.com/");
    }

    @Test(priority = 1)
    public void loginTest() {
        driver.findElement(By.cssSelector("button.login-button"))
                .click();
        driver.findElement(By.id("LoginEmail"))
                .sendKeys("valid_email@example.com");
        driver.findElement(By.cssSelector("button[form='loginForm']"))
                .click();
        driver.findElement(By.id("Password"))
                .sendKeys("validPassword123");
        driver.findElement(By.cssSelector("button[type='submit']"))
                .click();
    }

    @Test(priority = 2)
    public void navigateToCategory() {
        driver.findElement(By.linkText("Çocuk & Bebek"))
                .click();
        driver.findElement(By.partialLinkText("Kız Çocuk (6-14 YAŞ)"))
                .click();
        driver.findElement(By.partialLinkText("Mont ve Kaban"))
                .click();
    }

    @Test(priority = 3)
    public void applyFilters() {
        driver.findElement(By.xpath("//label[contains(text(),'5-6')]"))
                .click();
        driver.findElement(By.xpath("//label[contains(text(),'6')]"))
                .click();
        driver.findElement(By.xpath("//label[contains(text(),'6-7')]"))
                .click();
        driver.findElement(By.xpath("//label[contains(text(),'Bej')]"))
                .click();
    }

    @Test(priority = 4)
    public void sortAndSelectProduct() {
        Select sortDropdown = new Select(driver.findElement(By.id("sort-dropdown")));
        sortDropdown.selectByVisibleText("En çok satanlar");
        WebElement fourthProduct = driver.findElements(By.cssSelector(".product-item")).get(3);
        fourthProduct.click();
    }

    @Test(priority = 5)
    public void addToCart() {
        Select sizeDropdown = new Select(driver.findElement(By.id("size-selector")));
        sizeDropdown.selectByIndex(1); // Assuming index 1 is available
        driver.findElement(By.id("add-to-cart-button"))
                .click();
        driver.findElement(By.cssSelector("a[href='/sepetim']"))
                .click();

        WebElement productName = driver.findElement(By.cssSelector(".cart-item-name"));
        WebElement productColor = driver.findElement(By.cssSelector(".cart-item-color"));
        WebElement productQuantity = driver.findElement(By.cssSelector(".cart-item-quantity"));
        WebElement productPrice = driver.findElement(By.cssSelector(".cart-item-price"));

        WebElement totalPrice = driver.findElement(By.cssSelector(".total-price"));

        Assert.assertEquals(productPrice.getText(), totalPrice.getText(), "Price mismatch in cart.");
    }

    @Test(priority = 6)
    public void addToFavoritesAndProceedToCheckout() {
        driver.findElement(By.cssSelector("button.favorite-button"))
                .click();
        driver.findElement(By.cssSelector("button.checkout-button"))
                .click();
        driver.findElement(By.id("delivery-option-home"))
                .click();
        driver.findElement(By.id("delivery-address"))
                .click();
        driver.findElement(By.id("payment-method-creditcard"))
                .click();

        driver.findElement(By.cssSelector("a[href='/favorilerim']"))
                .click();

        WebElement favoriteItemName = driver.findElement(By.cssSelector(".favorite-item-name"));
        Assert.assertTrue(favoriteItemName.getText().contains("Expected Product"), "Favorite item not found.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
