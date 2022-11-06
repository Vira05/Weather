import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Vira05OnGitHubTest {

    //TC_11_01
    //1.  Открыть базовую ссылку
    //2.  Нажать на пункт меню Guide
    //3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide
    // и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testOpenAndClickToGuida() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String buttonGuide = "Guide";
        String expectedResult = "https://openweathermap.org/guide";
        String expectedResult1 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(5000);

        WebElement ButtonGuide = driver.findElement(
                By.xpath("//a[@href='/guide']")
        );
        ButtonGuide.click();

        String guideButton = driver.getCurrentUrl();

        String actualResult = guideButton;
        Assert.assertEquals(actualResult,expectedResult);

        String actualResult1 = driver.getTitle();
        Assert.assertEquals(actualResult1, expectedResult1);
        driver.quit();
    }

    //TC_11_02
    //1.  Открыть базовую ссылку
    //2.  Нажать на единицы измерения Imperial: °F, mph
    //
    //3.  Подтвердить, что температура для города показана в Фарингейтах



}
