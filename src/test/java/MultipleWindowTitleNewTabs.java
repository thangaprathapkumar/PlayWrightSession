import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.List;

public class MultipleWindowTitleNewTabs
{

    @Test
    public void multiWindowHandlesNewTabs() {

       Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));

      BrowserContext context = browser.newContext();

      Page page = context.newPage();

      page.navigate("https://freelance-learn-automation.vercel.app/login");

      Locator allLinks = page.locator("//div[1][@class='social-btns']//a");

      for (int i=0; i<allLinks.count(); i++) {

          allLinks.nth(i).click();
      }

      List<Page> allPage = context.pages();

      for (Page p:allPage) {


          String pageTitle = p.title();

          System.out.println("The title is :" + pageTitle);

            if (pageTitle.contains("Selenium Webdriver")) {
                p.bringToFront();
                p.locator("//span[text()='Email address or phone number']").fill("toshila@gmail.com");
                p.locator("//span[text()='Password']").fill("Toshi@12345");

            }

            if (pageTitle.contains("Log in to X / X")) {
                p.bringToFront();
                p.locator("//div[@class='css-175oi2r r-18u37iz r-1pi2tsx r-1wtj0ep r-u8s1d r-13qz1uu']/div").fill("tpkumar@gmail.com");

            }
            if (pageTitle.contains("Mukesh otwani - YouTube")) {
                p.bringToFront();
                p.locator("//input[@name='search_query']").first().fill("Playwright");

            }
      }

    page.bringToFront();
    page.getByPlaceholder("Enter Email").fill("admin@email.com");
    page.getByPlaceholder("Enter Password").fill("admin@123");
    page.close();
    browser.close();


    }

}
