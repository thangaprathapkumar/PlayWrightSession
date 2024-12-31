import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility
{

    public static byte[] captureScreenshot(Page page) {


        SimpleDateFormat customFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");

        Date date = new Date();

        String newDates = customFormat.format(date);

        byte[] arr =  page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("screenshot/"+newDates+".png")));

        return arr;

    }

}
