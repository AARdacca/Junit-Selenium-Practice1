package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Utils;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Task01_DigitalUnitePracticeFormTest {
    WebDriver driver;
    Faker faker;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        faker = new Faker();
    }

    @Test
    @DisplayName("Check if form is submitting properly")
    public void practiceWebFrom() throws InterruptedException {

        //first name, email address, phone number
        String ranFirstName = faker.name().firstName();
        //String ranLastName = faker.name().lastName();
        String emailAddress = ranFirstName.toLowerCase()+"10@gmail.com";
        String phoneNumber = Utils.generateRandomPhoneNumber();

        driver.get("https://www.digitalunite.com/practice-webform-learners");

        //accept all cookies click
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        Utils.scroll(driver, 300);
        // name, number, date, email, tell us yourself elements
        List<WebElement> textbox = driver.findElements(By.className("form-control"));
        textbox.get(0).sendKeys(ranFirstName);
        textbox.get(1).sendKeys(phoneNumber);
        textbox.get(2).sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
        textbox.get(3).sendKeys(emailAddress);
        textbox.get(4).sendKeys("\n" + faker.lorem().sentence(15));

        //upload image
        WebElement imageUploadElement = driver.findElement(By.id("edit-uploadocument-upload"));
        imageUploadElement.sendKeys(System.getProperty("user.dir") + "/src/test/resources/demoImage.jpg");
        Thread.sleep(3000);
        Utils.pageZoom(driver, 80);
        Utils.scrollBottom(driver);
        //checkbox click
        WebElement clickCheckBoxElement = driver.findElement(By.id("edit-age"));
        clickCheckBoxElement.click();
        Thread.sleep(5000);

        //submit button
        WebElement submitButtonElement = driver.findElement(By.id("edit-submit"));
        submitButtonElement.click();
        Thread.sleep(2000);

        //After successful submission, assert the expected message as: Thank you for your submission!
        WebElement resultElement = driver.findElement(By.tagName("h1"));
        String actualResult = resultElement.getText();
        String expectedResult = "Thank you for your submission!";
        Assertions.assertTrue(actualResult.contains(expectedResult));
    }


    @AfterAll
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}