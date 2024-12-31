import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class MultipleWindow
{

    @Test
    public void multiWindowHandles() {

       Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));

      BrowserContext context = browser.newContext();

      Page page = context.newPage();

      page.navigate("https://freelance-learn-automation.vercel.app/login");

      Page newPage = context.waitForPage(()-> {

          page.locator("//a[contains(@href,'facebook')]").first().click();

      });
    newPage.locator("//input[@type='text']").fill("toshila@gmail.com");

    page.bringToFront();

    page.locator("//input[@name='email1']").fill("admin@email.com");

    newPage.bringToFront();

    newPage.locator("//input[@type='password']").last().fill("Toshila@12345");
    newPage.close();
    page.bringToFront();

    page.locator("//input[@type='password']").fill("admin@123");

    page.locator("//button[@type='submit']").click();

    page.close();
    browser.close();


    }

}
