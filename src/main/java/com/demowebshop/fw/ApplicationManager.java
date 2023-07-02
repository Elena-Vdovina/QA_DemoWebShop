package com.demowebshop.fw;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

  String browser;

  public WebDriver driver;

  UserHelper user;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public UserHelper getUser(){
    return user;
  }

  public void init() {
    System.err.close();
    if (browser.equalsIgnoreCase("chrome")){
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")){
      // FirefoxOptions options = new FirefoxOptions();
      //options.addArguments("--remote-allow-origins=*");
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")){
      // EdgeOptions options = new EdgeOptions();
      //options.addArguments("--remote-allow-origins=*");
      //driver=new EdgeDriver(options);
      driver=new EdgeDriver();
    }

    driver.get("https://demowebshop.tricentis.com/");
    driver.manage().window().maximize();
    // wait for all elements on the site to load before starting test
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    user = new UserHelper(driver);
  }

  public void stop() {
    driver.quit();
  }

}
