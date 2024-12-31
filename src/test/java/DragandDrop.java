import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class DragandDrop {

    @Test
    public void sliderHandleFunction() {

       Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));

       Page page = browser.newPage();

       page.navigate("https://jqueryui.com/droppable/");

       FrameLocator framelocator = page.frameLocator(".demo-frame");

     //  framelocator.locator("#draggable").dragTo(framelocator.locator("#droppable"));

       // or

      framelocator.locator("#draggable").hover();

      page.mouse().down();

      framelocator.locator("#droppable").hover();

      page.mouse().up();

    }

}
