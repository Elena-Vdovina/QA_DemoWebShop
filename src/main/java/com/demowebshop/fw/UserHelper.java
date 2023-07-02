package com.demowebshop.fw;

import com.demowebshop.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

  public UserHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnRegisterLink() {
    click(By.xpath("//a[.='Register']"));
  }

  public boolean isRegisterSuccessPresent() {
    return isElementPresent(By.xpath("//div[contains(text(),'Your registration completed')]"));
  }

  public void clickOnLogoutLink() {
    click(By.xpath("//a[contains(text(),'Log out')]"));
  }

  public void fillRegisterForm(User user) {
    if (user.getGender()) {
      click(By.xpath("//input[@id='gender-male']"));
    } else {
      click(By.xpath("//input[@id='gender-female']"));
    }
    type(By.cssSelector("#FirstName"), user.getFirstName());
    type(By.cssSelector("#LastName"), user.getLastName());
    type(By.cssSelector("#Email"), user.getEmail());
    type(By.cssSelector("#Password"), user.getPassword());
    type(By.cssSelector("#ConfirmPassword"), user.getConfirmPassword());
  }

  public void clickOnRegisterButton() {
    click(By.cssSelector("#register-button"));
  }

  public boolean isRegisterLinkPresent() {
    return isElementPresent(By.xpath("//a[.='Register']"));
  }
}
