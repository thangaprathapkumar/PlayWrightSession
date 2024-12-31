import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class ScreenShot
{

    @Test
    public void screenshots() {

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

        Page page =browser.newPage();

        page.navigate("https://www.naukri.com/");

        page.locator("//a[@title='Jobseeker Login']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("elementscreen1.png")));

        Utility.captureScreenshot(page);

        page.close();

        browser.close();



    }

}
