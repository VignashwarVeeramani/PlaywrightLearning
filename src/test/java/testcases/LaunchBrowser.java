package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {

        //create playwright - websocket session
        Playwright playwright = Playwright.create(); //launch websocket session

        //Test case 1 - Headless mode
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("https://staging-www.forevernew.com.au/georgia-petite-high-waist-pants-257760?colour=black");
        System.out.println(page.title());
        page.close();

        //Test case 2 - With head mode
        Browser browser1 = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page1 = browser1.newPage();
        page1.navigate("https://staging-www.forevernew.com.au/georgia-petite-high-waist-pants-257760?colour=black");
        Thread.sleep(2000); //never use - learning purpose only
        System.out.println(page1.title());
        page1.close();

        playwright.close(); //close websocket session
    }
}
