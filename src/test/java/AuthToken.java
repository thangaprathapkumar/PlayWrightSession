import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class AuthToken {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setStorageStatePath(Paths.get("login.json")));
            Page page = context.newPage();
            page.navigate("https://freelance-learn-automation.vercel.app/");
            page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("menu")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
            page.getByPlaceholder("Enter Email").click();
            page.getByPlaceholder("Enter Email").fill("admin@email.com");
            page.getByPlaceholder("Enter Email").press("Tab");
            page.getByPlaceholder("Enter Password").fill("admin@123");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
            page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("menu")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign out")).click();
        }
    }
}
