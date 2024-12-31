import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RecordPlayBack
{
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://freelance-learn-automation.vercel.app/");
            assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Learn Automation Courses"))).isVisible();
            page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("menu")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
            page.getByPlaceholder("Enter Email").click();
            page.getByPlaceholder("Enter Email").fill("admin@email.com");
            page.getByPlaceholder("Enter Password").click();
            page.getByPlaceholder("Enter Password").fill("admin@123");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Welcome Admin Manager to")).click();
            page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("menu")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign out")).click();

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
