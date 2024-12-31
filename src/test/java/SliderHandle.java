import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class SliderHandle {

    @Test
    public void sliderHandleFunction() {

       Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));

       Page page = browser.newPage();

       page.navigate("https://jqueryui.com/slider/");

       FrameLocator locator = page.frameLocator(".demo-frame");
       Locator slider= locator.locator("//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')]");
       slider.focus();

        for (int i = 0; i <= 10; i++) {
            page.keyboard().press("ArrowRight");

        }



    }

}
