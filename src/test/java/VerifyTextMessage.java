import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTextMessage {

    @Test
    public void veriyTitle() {

       Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
       Page page = browser.newPage();
       page.navigate("https://freelance-learn-automation.vercel.app/");
       page.locator("//div[@class='navbar-menu-links']/img").click();
       page.locator("//button[text()='Log in']").click();
       page.locator("//button[text()='Sign in']").click();
       String expMessage = "Email and Password is required";
       String actualMessage = page.locator(".errorMessage").textContent();

        Assert.assertEquals(actualMessage,expMessage);
        System.out.println("The act mess 1 :" + actualMessage);
        Assert.assertTrue(actualMessage.contains("Password is required"));

        // Playwright assertion

        PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText("Email and Password is required");


       /*
       System.out.println("The act mess 1" + actualMessage);
       String expMessg1 = page.locator(".errorMessage").innerText();
       System.out.println("Exp Message 2 "+ expMessg1);
       String jsMessage = (String) page.evaluate("document.getElementsByClassName('errorMessage')[0].textContent");
       System.out.println("The JS Error Message :" + jsMessage);
        */

       page.close();
       browser.close();

    }
}
