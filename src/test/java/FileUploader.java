import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class FileUploader
{

    @Test
    public static void singleFileupload() {

      Browser browser =  Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
      Page page = browser.newPage();
      page.navigate("https://the-internet.herokuapp.com/upload");
//      page.locator("#file-upload").setInputFiles(Path.of(System.getProperty("user.dir")+"/fileUploads/landscape.jpg"));

        Path path[] = {
                Path.of(System.getProperty("user.dir")+"/fileUploads/landscape.jpg"),
//                Path.of(System.getProperty("user.dir")+"/fileUploads/landscape.jpg"),
//                Path.of(System.getProperty("user.dir")+"/fileUploads/landscape.jpg"),
        };

        page.locator("#file-upload").setInputFiles(path);

    }

}
