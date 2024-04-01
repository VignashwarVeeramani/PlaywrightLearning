package testcases;

import com.microsoft.playwright.*;

import java.awt.*;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {

        //create playwright - websocket session
        Playwright playwright = Playwright.create(); //launch websocket session

        //Test case 1 - Headless mode
        System.out.println("----------Test case 1 - Headless mode-------------- ");
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("https://staging-www.forevernew.com.au/georgia-petite-high-waist-pants-257760?colour=black");
        System.out.println(page.title());
        page.close();

        //Test case 2 - With head mode
        System.out.println("----------Test case 2 - With head mode-------------- ");
        Browser browser1 = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page1 = browser1.newPage();
        page1.navigate("https://staging-www.forevernew.com.au/georgia-petite-high-waist-pants-257760?colour=black");
        Thread.sleep(2000); //never use - learning purpose only
        System.out.println(page1.title());
        page1.close();

        //Test case 3 - Maximise the window
        System.out.println("----------Test case 3 - Maximise the window-------------- ");

        //To dynamically pick the size of the working screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        System.out.println(width+"---"+height);

        Browser browser2 = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext =  browser2.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int)height));
        Page page2 = browserContext.newPage();
        page2.navigate("https://staging-www.forevernew.com.au/georgia-petite-high-waist-pants-257760?colour=black");
        Thread.sleep(2000); //never use - learning purpose only
        System.out.println(page2.title());
        page2.close();

        playwright.close(); //close websocket session
    }
}
