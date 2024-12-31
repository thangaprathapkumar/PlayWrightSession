import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadFiles {

    @Test
    public void sliderHandleFunction() throws IOException {

       Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
       Page page = browser.newPage();
       page.navigate("https://the-internet.herokuapp.com/download");
       Download download = page.waitForDownload(()->
       {
          page.locator("//a[text()='random_data.txt']").click();
       });

       String downloadPath = System.getProperty("user.dir")+"/DownloadFiles/"+download.suggestedFilename() ;
       download.saveAs(Paths.get(downloadPath));
        System.out.println("download file path is :" + downloadPath);
        if (downloadPath.endsWith(".txt")) {
            System.out.println("The File Extention is Text File & Verified:");
        }
        else {
            System.out.println("Not Text File ");
        }
        if (Files.size(Path.of(downloadPath)) > 0) {
            System.out.println("File size verified");
        }
        else {
            System.out.println("File size Not verified");
            browser.close();
            return;
        }

       String dataFromfile = Files.readString(Path.of(downloadPath));

        if (dataFromfile.contains("what is lorem Ipsum")) {
            System.out.println("Text verified successfully");
        }
        else {
            System.out.println("File content Not Verified");
            browser.close();
            return;
        }
    browser.close();

    }

}
