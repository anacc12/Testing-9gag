# Testing-9gag

## Overview
This repository contains a set of automated tests which were created for the purposes of a project assignment for the "Methods and 
Techniques of Software Testing" course at the Faculty of Electrical Engineering, Computer Science and Information Technology Osijek.
They were made in order to test the 9gag website.

## Getting started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
What you will need:
* [Chrome driver](https://chromedriver.chromium.org/downloads) or [Gecko driver](https://github.com/mozilla/geckodriver/releases)
* [Development Kit](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
* [IntelliJ IDE](https://www.jetbrains.com/idea/download/#section=windows)
* [TestNG](https://mvnrepository.com/artifact/org.testng/testng)
* Built with: [Maven](http://maven.apache.org/surefire/download.cgi)

### Installation
#### 1. Install JDK [(Java Development Kit)](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
#### 2. Install [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows)
#### 3. Download [Chrome driver](https://chromedriver.chromium.org/downloads) or [Gecko driver](https://github.com/mozilla/geckodriver/releases)
```
Extract it somewhere meaningful and write down the path (you will need it later on).
For example, on my computer the path to the chromedriver.exe is: C:\Users\Korisnik\chromedriver.exe
```
![chromeDriverPath](https://user-images.githubusercontent.com/57498725/75092457-f3531900-5577-11ea-9bef-0109ffbb341e.PNG)

#### 4. Download and open this repository
1. Clone the repository: https://github.com/anacc12/Testing-9gag.git
2. Create a new folder on your computer (e.g. on C:\Users\Korisnik\githubTesting9gag)
3. Open cmd in that folder
4. In cmd type:
```
git clone https://github.com/anacc12/Testing-9gag.git
```
5. You should see this in the command prompt:
![gitclone](https://user-images.githubusercontent.com/57498725/75094346-7da47880-558a-11ea-8ad4-255e86e42658.PNG)

6. Open IntelliJ
7. Navigate to: 
```
File -> Open -> C:\path-to-your-folder\Testing-9gag
(on my computer the path is C:\Users\Korisnik\githubTesting9gag\Testing-9gag)
```


## Running the tests
1. You should see the testng.xml file in the project structure
2. Right click on that file -> Run
* Now all of the tests should be started.

#### What you will need to enter manually:
```
When uploading the photo, the reCAPTCHA window will pop up. 
You will need to manually select the needed image squares (shown on the image below):
```
![capcap](https://user-images.githubusercontent.com/57498725/75093215-108be580-5580-11ea-82f1-cfa71ac61b79.PNG)

```
After you are done, click on the "Verify" button. 
The test will proceed normally after you pass the reCAPTCHA challenge.
```

#### Disclaimer:
```
That test will not execute fully, because 9gag will block the user who uploads that many posts.
It will stop just before uploading the image. 
```

# Project structure
## main
### com.test9gag.qa
* base - consists of TestBase class which all of the other classes inherit. Method Initialization sets the webdriver and
the necessary timeouts. 
```
public static void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Korisnik\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
  ```
* util - consists of TestUtil class which contains page load timeout and implicit wait constants in seconds.

* config - consists of test configuration file which contains properties (username, password, urls...)
 ```
url = https://9gag.com/
imgUrl = https://upload.wikimedia.org/wikipedia/commons/b/ba/Flower_jtca001.jpg
shopUrl = https://shop.9gag.com/
username = nonameuserx
password = A123456A
search = testing
postDescription = Some average description
browser = chrome
 ```

* pages - consists of pages on which the tests will be performed (login, home, search and shop pages) 

#### LoginPage
In the constructor uses the PageFactory for initialization.
Contains @FindBy annotations and WebElement elements found using the xpath of the element.
Contains methods:   
&#x1F539; exitPopup() - whenever the 9gag.com website is opened, the popup window appears - it should be closed in order to browse the page  
&#x1F539; validateTitle() - method which returns the title of the page  
&#x1F539; validateLogo() - method which returns boolean value true if the logo is displayed   
&#x1F539; login(String username, String password) - method which performs login using the username and password defined in the properties file and returns the HomePage object.  

#### HomePage
Uses the same annotations and constructor as the LoginPage.  
Contains methods:  
&#x1F539; changeAvatar() - changes the profile avatar in the profile settings.  
&#x1F539; uploadImage() - one of the main features of the 9gag  
* enters the iFrame in which the reCAPTCHA is located
* uses the WebDriverWait in order to wait for the user to manually complete reCAPTCHA
```
WebDriverWait wait = new WebDriverWait(driver,150);
wait.until(ExpectedConditions.attributeToBe(checkBoxSpan, "aria-checked", "true"));
```
* after the user completes the challenge, proceeds normally.  
&#x1F539; clickOnShop() - returns the ShopPage object  
&#x1F539; clickOnSearch() - returns the SearchPage object  

#### ShopPage
Contains methods:  
&#x1F539; switchTabs(int i) - used in the ShopPageTest in order for the driver to switch to the opened tab.  
```
ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(tabs.get(i));
```
&#x1F539; AddShirtToCart() - performs adding a shirt with the selected size to the cart  

#### SearchPage
Contains methods:  
&#x1F539; searchBarText(String text) - checks if the title is the same as expected  
&#x1F539; isSearchTagPresent() - returns boolean value true if the tag is displayed  



## test
### com.test9gag.qa.testcases
* LoginPageTest - contains tests for some basic functionalities, presence of logo on the page, login success, etc.
* HomePageTest - performs login and then executes tests for uploading the image, changing the profile avatar, etc.
* SearchPageTest - contains tests for the search page
* ShopPageTest - sets driver to the other tab and proceeds to test the functionalities - adding a specific shirt to the cart.

#### LoginPageTest
In the constructor calls the super(), which initiates the TestBase constructor.     
Contains the:  
&#x1F539; @BeforeMethod - method setUp() which performs initialization and exits the popUp every time the test is performed  
&#x1F539; @Test methods - loginPageTitleTest(), loginPageLogoTest(), loginPageLoginTest()  
* loginPageLoginTest() - returns the HomePage object with username and password properties defined in the properties file        
&#x1F539; @AfterMethod - method tearDown() quits the driver  

#### HomePageTest
Contains the:  
&#x1F539; @BeforeMethod - method setUp() which performs initialization and exits the popUp every time the test is performed, and logs in using the LoginPage login() method
```
@BeforeMethod
    public void setUp(){
        initialization();
        lPage = new LoginPage();
        lPage.exitPopUp();
        hPage = lPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
```  
&#x1F539; @Test methods - uploadImageTest(), changeAvatarTest(), clickOnShopButtonTest() and clickOnSearchButton()
* clickOnShopButtonTest() returns the ShopPage object
* clickOnSearchButtonTest() - returns the SearchPage object     
&#x1F539; @AfterMethod - method tearDown() quits the driver  


#### ShopPageTest
Contains the:  
&#x1F539; @BeforeMethod - similar to the previous ones, but also calls the ShopPage object using the HomePage clickOnShop() method.  
&#x1F539; @Test method - addToCartTest() - firstly switches to the opened tab using the switchTabs(int i) method. (i=1 in this case) and performs adding a shirt to the cart  
&#x1F539; @AfterMethod - the same as the previous ones  

#### SearchPageTest
Contains the:  
&#x1F539; @BeforeMethod - similar to the previous ones, but also calls the SearchPage object using the HomePage clickOnSearch() method.  
&#x1F539; @Test methods - searchBarTextTest() and isSearchTagPresentTest()
* searchBarTextTest() - calls the searchBarText(String text) method and accesses the "text" from the properties    
&#x1F539; @AfterMethod - the same as the previous ones.  




