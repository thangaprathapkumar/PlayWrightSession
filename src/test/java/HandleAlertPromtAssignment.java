import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class HandleAlertPromtAssignment

{

    @Test
    public static void alertHandle() {

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
        Page page = browser.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/");

        page.locator("//div[@class='navbar-menu-links']/img").click();

        page.locator("//button[text()='Log in']").click();

        page.locator("#email1").fill("admin@email.com");

        page.locator("#password1").fill("admin@123");

        page.locator("//button[@type='submit']").click();

        page.locator("//span[text()='Manage']").click();

        page.locator("//a[@class='nav-menu-item false'][2]").click();

        page.navigate("https://freelance-learn-automation.vercel.app/category/manage");

        PlaywrightAssertions.assertThat(page.locator("//table[@class='category-table table table-borderless']/thead/tr/th[1]")).containsText("Cateogry Name");

    //    page.locator("//button[text()='Add New Category ']").click();

        page.onceDialog( dialog -> {
            String mesg = dialog.message();
            System.out.println("The alert Message is :"+mesg);
            Assert.assertTrue(mesg.contains("Enter a Category Name"));
            dialog.accept("Toshila");
        });

        page.locator("//button[text()='Add New Category ']/img").click();

    }

    }
