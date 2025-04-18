package tasks;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.nio.file.*;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Task03_DhakaStockExchangeTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void testScrapeTableData() {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table[contains(@class, 'table-bordered')]")));

        //process data
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[contains(@class, 'table-bordered')]/tbody/tr"));
        StringBuilder data = new StringBuilder();

        String[] headers = {
                "#", "TRD CODE", "LTP*", "HIGH", "LOW", "CLOSEP*", "YCP*", "CHANGE", "TRADE", "VALUE (mn)", "VOLUME"
        };

        for (String headerCell : headers) {
            String strPadding = headerCell.length() < 4 ? "\t\t\t|\t" : (headerCell.length() < 8 ? "\t\t|\t" : "\t|\t");
            System.out.print(headerCell + strPadding);
            data.append(headerCell).append(strPadding);
        }
        System.out.println();
        data.append(System.lineSeparator());

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (WebElement column : columns) {
                String cellData = column.getText().trim();
                String strPadding = cellData.length() < 4 ? "\t\t\t|\t" : (cellData.length() < 8 ? "\t\t|\t" : "\t|\t");
                System.out.print(cellData + (strPadding));
                data.append(cellData).append(strPadding);
            }
            System.out.println();
            data.append(System.lineSeparator());
        }

        //Save data
        Path filePath = Paths.get("src/test/resources/stock_data.txt");

        try {
            Files.createDirectories(filePath.getParent()); // Ensure directory exists
            Files.write(filePath, data.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            assertTrue(Files.size(filePath) > 0, "File created and data written successfully.");
        } catch (IOException e) {
            throw new AssertionError("Failed to write data to file: " + e.getMessage(), e);
        }
    }

    @AfterAll
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
