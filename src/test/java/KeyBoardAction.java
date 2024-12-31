import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class KeyBoardAction {

    Browser browser;

    BrowserContext context;

    Page page;
    private Faker faker = new Faker();

@Test
public void regPageValidate() {

    try {

        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));

        context = browser.newContext();

        page = context.newPage();

        page.navigate("https://freelance-learn-automation.vercel.app/");

        PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");

        page.locator("//*[@class='navbar-menu-links']/img").click();

        page.locator("//button[text()='Log in']").click();

        page.getByPlaceholder("Enter Email").fill("admin@email.com");

        /*
        // Select ALL
        page.keyboard().down("Meta");
        page.keyboard().press("a");
        page.keyboard().up("Meta");

        // Copy the function
        page.keyboard().down("Meta");
        page.keyboard().press("c");
        page.keyboard().up("Meta");

        // Tab
        page.keyboard().press("Tab");

        // Paste the copied text
        page.keyboard().down("Meta");
        page.keyboard().press("v");
        page.keyboard().up("Meta");

         */


        page.keyboard().press("Meta+A");
        page.keyboard().press("Meta+C");
        page.keyboard().press("Tab");
        page.keyboard().press("Meta+V");



    }
    finally
    {
        page.close();
        browser.close();

    }

}

}
