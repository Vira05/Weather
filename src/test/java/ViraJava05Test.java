import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViraJava05Test {
    //TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchCityFild = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder='Search city']")
        );
        searchCityFild.click();
        searchCityFild.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//button[@type ='submit']")
        );
                searchButton.click();
        Thread.sleep(1000);

        WebElement parisFRChoiceInDropDownMenu  = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropDownMenu.click();
        Thread.sleep(1000);



        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id ='weather-widget']//h2")
        );
        Thread.sleep(2000);
        

        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
}
 //  @Test
 //  public void testH2TagText_WhenSearchingCityCountry(){
 //      System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");

 //      WebDriver driver = new ChromeDriver();

 //       driver.close();


//}