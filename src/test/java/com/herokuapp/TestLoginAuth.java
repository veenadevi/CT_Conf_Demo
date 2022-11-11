package com.herokuapp;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLoginAuth {

    WebDriver driver;
    @Test
    public void testInvalidAuth(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/login");

        driver.findElement(By.cssSelector("#username")).sendKeys("Veena");
        driver.findElement(By.cssSelector("#password")).sendKeys("mypassword");
        driver.findElement(By.cssSelector(".fa-sign-in")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".error")).isDisplayed());
    }

    @Test
    public void testValidAuth(){



        driver.get("http://the-internet.herokuapp.com/login");

        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".fa-sign-in")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".success")).isDisplayed());
    }

    @Test
    public void checkGitWorkFlow(){
        System.out.println("add new statements");

    }

    @Test
    public void checkGitnewWorkFlow(){
        System.out.println("add new statements");

    }

    @Test
    public void checkGitnewWorkFlow_new(){
        System.out.println("add new statements");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
