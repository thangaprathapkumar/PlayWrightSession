import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandleAutoSuggestion
{

    @Test
    public static void autoSuggestion() {

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        page.navigate("https://www.amazon.in/ref=nav_logo");
        page.locator("//input[@id='twotabsearchtextbox']").fill("iphone ");
        Locator locator = page.locator("//div[@class='left-pane-results-container']/div");
        System.out.println(locator.count());
        for (int i = 0; i <= locator.count(); i++) {
            String inText = locator.nth(i).innerText();
            System.out.println(inText);

            if (inText.contains("iphone 16pro max")) {
                locator.nth(i).click();
                break;
            }

        }

        page.close();
        browser.close();


    }
}
