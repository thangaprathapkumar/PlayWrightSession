import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegisterPage {

    Browser browser;
    Page page;
    String hobbies[] = {
            "Playing",
            "Swimming"
            };
    private Faker faker = new Faker();

@Test
public void regPageValidate() {

    browser =  Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));

    page = browser.newPage();

    page.navigate("https://freelance-learn-automation.vercel.app/");

    PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");

    page.locator("//*[@class='navbar-menu-links']/img").click();

    page.locator("//button[text()='Log in']").click();

    page.getByText("New user? Signup").click();

    page.pause();

    page.getByPlaceholder("Name").fill(faker.name().firstName());

    page.locator("#email").fill(faker.name().firstName()+"@gmail.com");

    page.getByPlaceholder("Password").fill(faker.name().fullName());

    page.locator("//label[text()='Selenium']/preceding::input[1]").click();

    PlaywrightAssertions.assertThat(page.locator("//label[text()='Selenium']/preceding::input[1]")).isChecked();

    page.locator("//label[text()='Cypress']/preceding::input[1]").click();

    PlaywrightAssertions.assertThat(page.locator("//label[text()='Cypress']/preceding::input[1]")).isChecked();

    page.locator("//label[text()='Female']/preceding::input[1]").click();

    page.locator("#state").selectOption("Tamil Nadu");

    page.locator("#hobbies").selectOption(hobbies);

    PlaywrightAssertions.assertThat(page.locator("//button[@type='submit']")).isEnabled();

    page.locator("//button[@type='submit']").click();

}

@AfterMethod
public void closeAllSetup() {

    page.close();

    browser.close();

}

}
