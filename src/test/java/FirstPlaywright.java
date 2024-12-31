import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class FirstPlaywright
{
    Browser browser;

    @Test
    public void testcases() {
      browser =  Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
      Page page = browser.newPage();
      page.navigate("https://freelance-learn-automation.vercel.app/");
      PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
      page.locator("//*[@class='navbar-menu-links']/img").click();
      page.getByText("Log in").click();
      page.locator("#email1").fill("admin@email.com");
      page.getByPlaceholder("Enter Password").fill("admin@123");
      page.locator("//button[@type='submit']").click();
      PlaywrightAssertions.assertThat(page.locator("//button[text()='Cart']")).containsText("Cart");
        page.locator("//*[@class='navbar-menu-links']/img").click();
      page.locator("//button[text()='Sign out']").click();
      PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
      page.close();
      browser.close();

    }
}
