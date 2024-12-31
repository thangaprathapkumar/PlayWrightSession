import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Pattern;

public class FramesHandles
{

    @Test
    public void testcases() {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));

        Page page = browser.newPage();

        page.navigate("https://www.redbus.in/");

        page.locator("//span[text()='Account']").click();

        page.locator("//span[text()='Login/ Sign Up']").click();

        List<Frame> frames = page.frames();
        System.out.println("Total Frames :"+frames.size());

        // below line will work
//        FrameLocator frameLocator = page.frameLocator("//iframe[@class='modalIframe']");
//        frameLocator.locator("//input[@id='mobileNoInp']").fill("9807658432");
//          or

    //    page.frameLocator("//iframe[@class='modalIframe']").locator("//input[@id='mobileNoInp']").fill("9600825990");

      //  or

       Frame frame = page.frameByUrl(Pattern.compile(".*login.*"));
       frame.locator("//input[@id='mobileNoInp']").fill("7397665990");


    }
}
