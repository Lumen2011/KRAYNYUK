package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

//форма "Вход для зарегистрированных пользователей" + неявные ожидания

public class App3 {

        public static void main( String[] args )
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--incognito");
            options.addArguments("disable-popup-blocking");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://wooordhunt.ru/");

            WebElement element = driver.findElement(By.xpath("//*[@id=\"profile\"]/a[@href=\"/user/login\"]"));
            element.click();
            driver.findElement(By.id("LoginForm_email")).click();
            driver.findElement(By.id("LoginForm_email")).sendKeys("example@mail.com");
            driver.findElement(By.id("LoginForm_password")).click();
            driver.findElement(By.id("LoginForm_password")).sendKeys("qwerty");
            driver.findElement(By.id("LoginForm_password")).submit();

            driver.quit();

        }
    }

