package com.demowebshop;

import com.demowebshop.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isRegisterLinkPresent()) {
      app.getUser().clickOnLogoutLink();
    }
  }

  @Test
  public void userRegisterPositiveTest() {
    app.getUser().clickOnRegisterLink();
    app.getUser().fillRegisterForm(new User()
        .setGender(false)
        .setFirstName("Olenka")
        .setLastName("Elenkova")
        .setEmail("o_e@gmail.com")
        .setPassword("777777")
        .setConfirmPassword("777777"));
    app.getUser().clickOnRegisterButton();
    Assert.assertTrue(app.getUser().isRegisterSuccessPresent());
  }

}
