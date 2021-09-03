package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class CreateNewAccount {

    @Test
    public void openBrowser() throws InterruptedException{
        String browserType = "chrome";
        WebDriver driver;

//        if(browserType.equals("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "D:\\Test Automation\\drivers\\geckodriver.exe");
//            driver = new FirefoxDriver();
//            System.out.println("Using Firefox");
//        } else {
        System.setProperty("webdriver.chrome.driver", "D://Test Automation//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Using Chrome");
//        }

        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.id("at-cv-lightbox-close")).click();

//  Input Forms -> Simple Form demo
        driver.findElement(By.partialLinkText("Input Forms")).click();
        driver.findElement(By.partialLinkText("Simple Form Demo")).click();
        driver.findElement(By.id("user-message")).sendKeys("This is Sparta!");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/form/button")).click();
        String message1 = driver.findElement(By.id("display")).getText();
        System.out.println("Inputted text: " + message1);

        driver.findElement(By.id("sum1")).sendKeys("15");
        driver.findElement(By.id("sum2")).sendKeys("35");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/form/button")).click();
        String total1 = driver.findElement(By.id("displayvalue")).getText();
        System.out.println("Total value is: " + total1);

        String defaultTotal = "50";
        if (total1.equals(defaultTotal)) {
            System.out.println("Total value is correct");
        } else {
            System.out.println("Total value is NOT correct");
        }

//  Input Forms -> Checkbox demo
        driver.findElement(By.partialLinkText("Input Forms")).click();
        driver.findElement(By.partialLinkText("Checkbox Demo")).click();
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"isAgeSelected\"]"));
        boolean result;
        result = checkbox.isSelected();
        System.out.println("Is checkbox selected?: " + result);
        checkbox.click();
        result = checkbox.isSelected();
        System.out.println("Is checkbox selected?: " + result);

        driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input")).click();
        driver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(4) > label > input")).click();
        driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input")).click();
        driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input")).click();
//??????????????
        String btnMsg = driver.findElement(By.id("check1")).getText();
        String buttonMessage = "Check All";

        if (buttonMessage.equals(btnMsg)) {
            System.out.println("Checkboxes are checked in");
        } else {
            driver.findElement(By.xpath("//*[@id=\"check1\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"check1\"]")).click();
            WebElement checkboxes = driver.findElement(By.xpath("//*[@id=\"isChkd\"]"));
            boolean result2;
            result2 = checkboxes.isSelected();
            System.out.println("Are checkboxes selected?: " + result2);
        }

//  Input Forms -> Radio Buttons demo
        driver.findElement(By.partialLinkText("Input Forms")).click();
        driver.findElement(By.partialLinkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input")).click();
        driver.findElement(By.id("buttoncheck")).click();
        String getChecked = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]")).getText();
        System.out.println("Your sex: " + getChecked);
        if(getChecked.equals("Radio button 'Male' is checked")) {
            System.out.println("Hello boy");
        } else {
            System.out.println("Hey girl");
        }
        driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[2]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[1]/input")).click();
//        String age = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[1]/input")).getText();
//        String ageLegal = "15 to 50";
//        if (age.equals(ageLegal)) {
//            System.out.println("Age: " + age);
//        } else {
//            System.out.println("No enter, you are too young");
//        }
        driver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > button")).click();
        String getValues = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")).getText();
        System.out.printf("Details: %n[" + getValues + "]%n");

//  Input Forms -> Select Dropdown List
        driver.findElement(By.partialLinkText("Input Forms")).click();
        driver.findElement(By.partialLinkText("Select Dropdown List")).click();
        new Select(driver.findElement(By.id("select-demo"))).selectByVisibleText("Friday");
        String weekDay = driver.findElement(By.className("selected-value")).getText();
        System.out.println("Selected week day: " + weekDay);

        driver.findElement(By.xpath("//*[@id=\"printMe\"]")).click();
        String selected1 = driver.findElement(By.className("getall-selected")).getText();
        String properSelected = "First selected option is : undefined";
        //???? something went wrong!!!!!! - for review!
        if(selected1.equals(properSelected)) {
            new Select(driver.findElement(By.id("multi-select"))).selectByVisibleText("New York");
            driver.findElement(By.xpath("//*[@id=\"printMe\"]")).click();
            String multiSelect = driver.findElement(By.className("getall-selected")).getText();
            System.out.println(multiSelect);
        } else {
            System.out.println("Firstly selected: " + selected1);
        }

//  Input Forms -> Select Dropdown List
        driver.findElement(By.partialLinkText("Input Forms")).click();
        driver.findElement(By.partialLinkText("Input Form Submit")).click();
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]/div/div/input")).sendKeys("Janusz");
        driver.findElement(By.name("last_name")).sendKeys("Kowalski");
        driver.findElement(By.cssSelector("#contact_form > fieldset > div:nth-child(4) > div > div > input")).sendKeys("janusz.kowalski@mail.com");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[4]/div/div/input")).sendKeys("(845)543-22-11");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[5]/div/div/input")).sendKeys("Drwalska 29");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[6]/div/div/input")).sendKeys("Drwalowo");
        new Select(driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select"))).selectByVisibleText("Kentucky");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[8]/div/div/input")).sendKeys("40003");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[9]/div/div/input")).sendKeys("www.kowaslkijanuszcorp.com");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[10]/div/div[1]/label/input")).click();
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[11]/div/div/textarea")).sendKeys("Very small not existing project");








        Thread.sleep(2000);
        driver.close();
        System.out.println("Browser has been closed.");
    }
}
