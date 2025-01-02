import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicWait
{

    @Test
    public void dynamicelementChecking() {

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
        Page page = browser.newPage();
        page.navigate("https://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html",new Page.NavigateOptions().setTimeout(60000));
        page.locator("//button[text()='Click me to start timer']").click();
        page.locator("//p[text()='WebDriver']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(20000));
        Assert.assertTrue(page.locator("//p[text()='WebDriver']").isVisible());
        page.close();
        browser.close();

    }
}
