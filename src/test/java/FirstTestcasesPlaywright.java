import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FirstTestcasesPlaywright
{

    @Test
    public void firstTestcases() {

      Playwright pw =  Playwright.create();
      BrowserType browserType = pw.chromium();
      Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
      Page page = browser.newPage();
      page.navigate("https://freelance-learn-automation.vercel.app/");
      String title = page.title();
      System.out.println("Playwright Session : "+title);
      assertThat(page).hasTitle(Pattern.compile("Learn Automation Courses")); // playwright assertion
      browser.close();
      pw.close();
    }
}
