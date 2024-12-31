import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class VideoRecording {


    @Test
    public void recordingVideos() {

       Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoSize(1000,800).setRecordVideoDir(Paths.get("screenshot/")));

       Page page = context.newPage();

       page.navigate("https://freelance-learn-automation.vercel.app/");
       page.waitForTimeout(2000);
       page.locator("//div[@class='navbar-menu-links']/img").click();
       page.waitForTimeout(2000);
       page.locator("//button[text()='Log in']").click();
       page.waitForTimeout(2000);

       String path =page.video().path().toString();
        System.out.println("The Path of String :"+path);


       page.close();
        context.close();
       browser.close();



    }

}
