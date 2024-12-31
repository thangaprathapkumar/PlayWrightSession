import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert

{

    @Test
    public static void alertHandle() {

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.onceDialog( dialog -> {
            String mesg = dialog.message();
            System.out.println("The alert Message is :"+mesg);
            Assert.assertTrue(mesg.contains("I am a JS Alert"));
            dialog.accept();
        });

        page.locator("//button[text()='Click for JS Alert']").click();




    }

    }
