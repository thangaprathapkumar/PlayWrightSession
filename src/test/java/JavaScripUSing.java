import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScripUSing
{

    @Test
    public void dynamicelementChecking() {

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
        Page page = browser.newPage();
        page.navigate("https://login.yahoo.com/");
        page.evaluate("document.getElementById('persistent').click()");
        page.waitForTimeout(2000);
        page.close();
        browser.close();

    }
}
