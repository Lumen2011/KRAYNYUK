package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

//работа в редакторе + явные ожидания

public class App4 {
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

        driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li/a[@href=\"/editor/fx\"]")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("/editor"));
        driver.findElement(By.id("editor_textarea")).click();
        driver.findElement(By.id("editor_textarea")).sendKeys("geek");
        driver.findElement(By.id("em-save")).click();

        driver.quit();

    }
}
