import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebsignupTest {
    //import the seleniumWebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chrome/chromedriver_win32 (1)/chromedriver.exe");
        //1. open chrome browser
        driver = new ChromeDriver();
    }

    @Test(priority = 0)
    public void getUrl() throws InterruptedException {
        //2. Input your selenium Demo Page URL (https://selenium-blog.herokuapp.com) and add little pause timer
        driver.get("https://selenium-blog.herokuapp.com");
        // Test 1: Verify the user input the right url and he/she is on the right page
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("correct web page");
        else
            //fail
            start();
        System.out.println("wrong web page");
        Thread.sleep((500));

        //3. Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void openSignUpPage() throws InterruptedException {
        //4. click on signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        // Test 2:Verify that when user click on the signup button the user is directed to the signup page
        String expectedSignupUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualSignupUrl = driver.getCurrentUrl();
        if (actualSignupUrl.contains(expectedSignupUrl))
            //pass
            System.out.println("correct signup page");
        else
            //fail
            System.out.println("wrong signup page");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void positiveSignUp() throws InterruptedException {
          //Test 3
        //5. Locate your username field and Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("lamb67dg888ap10");

        //6. Locate your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("lambaz4kj56774@mailinator.com");

        //7. Locate your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("lamba");

        //8. Click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(500);
    }

    @Test(priority = 3)
    public void clickUser1Item() throws InterruptedException {
        //9.Click on User1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test4:Verify that user1 item is present on the item list page
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users.11318";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("correct User1page");
        else
            //fail
            System.out.println("wrong User1page");

        Thread.sleep(5000);

    }

    @Test(priority = 4)
    public void verifyItem() throws InterruptedException {
        //10. Search for an element(using python with selenium) and confirm if it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[35]/div/div/div[1]/a")).click();
        //Test5:Verify that the item searched for on the user1page is present.
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/user/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("correct User1page");
        else
            //fail
            System.out.println("wrong User1page");
        Thread.sleep(500);
    }

    @Test(priority = 5)
    public void logoutsuccessfully() throws InterruptedException {
        // Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test6:Verify that when user logout, he/she is directed back to the homepage
        String expectedTittle = "AlphaBlog";
        String actualTittle = driver.getTitle();
        if (actualTittle.contains(expectedTittle))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
    }

    @Test(priority = 6)
    public void negativeSignUpInvalidUsername() throws InterruptedException {
        // click on signup button to open signup page driver.
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        // Test 7: Verify that user cannot signup with username less than 3  characters*
        //locate the username field and input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("zi");
        //locate the email field and input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("arami@mailinator.com");
        // locate the password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        // click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void negativeSignUpInvalidEmailAddress() throws InterruptedException {
        // click on signup button in the navbar to open signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(3000);
        // Test 8: Verify that user cannot signup with invalid email address
        // locate the username field and input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("tluwa");
        // locate the email field and input invalid email on the email field
        driver.findElement(By.id("user_email")).sendKeys("fade092");
        //locate the password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
      @Test(priority = 8) public void negativeSignUpInvalidPassword() throws InterruptedException {
          // click on signup button in the navbar to open signup page
          driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
          Thread.sleep(3000);
          // Test 9: Verify user cannot login with password less than or equal to one character
          // locate the username field and input your username on the username field
          driver.findElement(By.id("user_username")).sendKeys("fajiifi3");
          //locate the email field and input your email on the email field
          driver.findElement(By.id("user_email")).sendKeys("dagunji45677@gmail.com");
          // locate the password field and input invalid password on the  password field
          driver.findElement(By.id("user_password")).sendKeys(" admin");
          // click on signup button
          driver.findElement(By.id("submit")).click();
          Thread.sleep(5000);

      }
        @Test (priority = 9) public void negativeSignUpBlankFields() throws InterruptedException {
        // click on signup button in the navbar to open signup page
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
            Thread.sleep(5000);
            // Test 10: Verify user cannot signup with either/all of the fields blank
            // locate the username field and input your username on the username field
            driver.findElement(By.id("user_username")).sendKeys(" ");
        // locate the email field and input your email on the email field
            driver.findElement(By.id("user_email")).sendKeys("fifigress4@gmail.com");
        // locate the password field and input invalid password on the password field
            driver.findElement(By.id("user_password")).sendKeys("admin");
          // click on signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
}
          @AfterTest
         public void closeBrowser(){
          //quit browser
              driver.quit();
    }
}