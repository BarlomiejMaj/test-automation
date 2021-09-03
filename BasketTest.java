package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

class BasketTest {

    @Test
    public void checkBasket() throws InterruptedException{
        String browser = "chrome";
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "D://Test Automation//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Using Chrome");

        driver.get("https://www.morele.net/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[1]/div/div/div[2]/div/div[1]/form/div/input")).sendKeys("Wentylator Concept VS5100");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[1]/div/div/div[2]/div/div[1]/form/button/i")).click();

        driver.findElement(By.xpath("//*[@id=\"category\"]/div[2]/div[1]/div[6]/div[1]/div/div/div[2]/div[1]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"product\"]/div[1]/div[6]/aside/div[1]/div[3]/div[3]/div[1]/a")).click();

        Thread.sleep(2000);
        String basket = driver.findElement(By.className("icon-basket-count")).getText();
        String atLeastOne = "1";
        assertThat(basket).isEqualTo(atLeastOne);
        if(basket.equals(atLeastOne)) {
            System.out.println("Item has been added to the basket");
        } else {
            System.out.println("Your basket is still empty!");
        }


        Thread.sleep(2000);
        driver.close();
    }
}
