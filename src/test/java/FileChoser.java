import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChoser
{

    @Test
    public static void singleFileupload() {

      Browser browser =  Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
      Page page = browser.newPage();
      page.navigate("https://the-internet.herokuapp.com/upload");

        Path path[] = {

                Paths.get(System.getProperty("user.dir")+"/fileUploads/landscape.jpg"),
                Paths.get(System.getProperty("user.dir")+"/fileUploads/lake-mountains.avif"),
                Paths.get(System.getProperty("user.dir")+"/fileUploads/beautiful.webp"),
        };

        FileChooser fileChoser = page.waitForFileChooser(() -> page.locator("#drag-drop-upload").click());

      //  fileChoser.setFiles(Paths.get(System.getProperty("user.dir")+"/fileUploads/landscape.jpg"));

        fileChoser.setFiles(path);

       // page.locator("#drag-drop-upload").setInputFiles(path);

    }

}
