/*
 * 
 */
package com.testng_reporter.demo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.testng_reporter.demo.constant.Constant;

/**
 * <b>Collection of all the Generic Selenium methods.</b><br>
 * To reduce coding effort and reuse the methods</b>
 * 
 * @author Chandrashekhar Gouda
 * @version 1.0
 * @since 2019-12-04
 */
public class Utility {
    
    /** The Web Driver. */
    public static WebDriver driver = null;
    
    /**
     * Open app.
     *
     * @param BrowserName the browser name
     * @param url the url
     * @return the web driver
     */
    public static WebDriver OpenApp(String BrowserName, String url) {
        
        LaunchBrowser(BrowserName);
        OpenURL(url);
        report_genarator.Reporter.setWebDriver(driver);
        return driver;
    }
    
    /**
     * Open URL.
     *
     * @param url the url
     */
    public static void OpenURL(String url) {
        
        driver.get(url);
        driver.manage().window().maximize();
    }
    
    /**
     * Launch browser.
     *
     * @param browsername the browsername
     * @return the web driver
     */
    public static WebDriver LaunchBrowser(String browsername) {
        
        if (browsername.equals(Constant.CHROME)) {
            
            System.setProperty("webdriver.chrome.driver", Constant.BASE_DRIVER_PATH + "chromedriver.exe");
            driver = new ChromeDriver(getChromeOptions());
        } else if (browsername.equals(Constant.FIRE_FOX)) {
            // latest gecko driver path
            
            System.setProperty("webdriver.gecko.driver", Constant.BASE_DRIVER_PATH + "geckodriver64.exe");
            driver = new FirefoxDriver(getFireFoxOptions());
        } else if (browsername.equals(Constant.INTERNET_EXPLORER)) {
            
            System.setProperty("webdriver.ie.driver", Constant.BASE_DRIVER_PATH + "IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        System.err.append(browsername + " Browser Invoked");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }
    
    /**
     * Wait Until element found.
     *
     * @param path path of the element
     */
    public static void Wait(By path) {
        
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }
    
    /**
     * Wait Until element found.
     *
     * @param path path of the element
     */
    public static void Wait(By path, int sec) {
        
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }
    
    /**
     * Click on the element.
     *
     * @param path path of the element
     */
    public static void Click(By path) {
        
        driver.findElement(path).click();
    }
    
    /**
     * Click parent element.
     *
     * @param path the path
     */
    public static void ClickParentElement(By path) {
        
        driver.findElement(path).findElement(By.xpath("./..")).click();
        
    }
    
    /**
     * Send Keys to input box.
     *
     * @param path path of the element
     * @param inputValue the input value
     */
    public static void SendKeys(By path, String inputValue) {
        
        driver.findElement(path).clear();
        driver.findElement(path).sendKeys(inputValue);
    }
    
    /**
     * Send Keys to input box using Action.
     *
     * @param path path of the element
     * @param inputValue the input value
     */
    public static void SendKeysUsingAction(By path, String inputValue) {
        
        Actions actions = new Actions(driver);
        actions.moveToElement(GetElement(path));
        actions.click();
        actions.sendKeys(inputValue);
        actions.build().perform();
    }
    
    /**
     * Gets the web driver.
     *
     * @return the web driver.
     */
    public static WebDriver getDriver() {
        
        return driver;
    }
    
    /**
     * Switch to child window.
     */
    public static void SwitchToChildWindow() {
        
        String handle = driver.getWindowHandle();
        for (String handle1 : driver.getWindowHandles()) {
            if (!handle.equals(handle1)) {
                driver.switchTo().window(handle1);
                driver.manage().window().maximize();
                
            }
            
        }
    }
    
    /**
     * Mouse over on the element.
     *
     * @param path path of the element
     */
    public static void MouseOver(By path) {
        
        Actions actObj = new Actions(driver);
        actObj.moveToElement(driver.findElement(path)).build().perform();
    }
    
    /**
     * Drop down select by text.
     *
     * @param path path of the element
     * @param VisibleText the visible text
     */
    public static void DropdownSelectByText(By path, String VisibleText) {
        
        Select selObj = new Select(driver.findElement(path));
        selObj.selectByVisibleText(VisibleText);
    }
    
    /**
     * Multi select by text.
     *
     * @param path path of element
     * @param VisibleTexts the visible options text
     */
    public static void MultiSelectByText(By path, String[] VisibleTexts) {
        
        Select selObj = new Select(driver.findElement(path));
        for (int i = 0; i < VisibleTexts.length; i++) {
            selObj.selectByVisibleText(VisibleTexts[i]);
        }
    }
    
    /**
     * Drop down select by index.
     *
     * @param path path of the element
     * @param IndexValue the index value
     */
    public static void DropdownSelectByIndex(By path, int IndexValue) {
        
        Select selObj = new Select(driver.findElement(path));
        selObj.selectByIndex(IndexValue);
    }
    
    /**
     * Multi select by index.
     *
     * @param path path of element
     * @param IndexValues the index values of options
     */
    public static void MultiSelectByIndex(By path, int[] IndexValues) {
        
        Select selObj = new Select(driver.findElement(path));
        selObj.deselectAll();
        for (int i = 0; i < IndexValues.length; i++) {
            selObj.selectByIndex(IndexValues[i]);
        }
    }
    
    /**
     * Drop down select by value.
     *
     * @param path path of the element
     * @param Value the value
     */
    public static void DropdownSelectByValue(By path, String Value) {
        
        Select selObj = new Select(driver.findElement(path));
        selObj.deselectAll();
        selObj.selectByValue(Value);
    }
    
    /**
     * Multi select by values.
     *
     * @param path path of the element
     * @param Values the options value
     */
    public static void MultiSelectByValues(By path, String Values) {
        
        Select selObj = new Select(driver.findElement(path));
        selObj.deselectAll();
        for (int i = 0; i < Values.length(); i++) {
            selObj.selectByValue(Values);
        }
        
    }
    
    /**
     * Deselect all options .
     *
     * @param path path of element
     */
    public static void DeselectOptions(By path) {
        
        Select selObj = new Select(driver.findElement(path));
        selObj.deselectAll();
    }
    
    /**
     * Multi select all.
     *
     * @param path the path
     */
    public static void MultiSelectAll(By path) {
        
        Select selObj = new Select(driver.findElement(path));
        selObj.deselectAll();
        for (int i = 0; i < selObj.getOptions().size(); i++) {
            selObj.selectByIndex(i);
        }
    }
    
    /**
     * Gets the text from the element.
     *
     * @param path path of the element
     * @return the Text
     */
    public static String GetText(By path) {
        
        String txt = driver.findElement(path).getText().trim();
        System.out.println(txt);
        return txt;
    }
    
    public static String alertBoxHandler(WebDriver driver) throws Exception {
        
        Alert alertOkButton = driver.switchTo().alert();
        String okAccept = alertOkButton.getText();
        alertOkButton.accept();
        return okAccept;
    }
    
    public static void alertPopup(String expectedtxt) {
        
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popup_content_alert")));
        String actualTxt = driver.findElement(By.id("popup_content_alert")).getText();
        Assert.assertEquals(actualTxt.trim(), expectedtxt.trim());
        driver.findElement(By.id("popup_close_alert")).click();
    }
    
    /**
     * Confirm popup/Alert of IBO*ARM.
     *
     * @param status the status
     * @param expectedtxt the expectedtxt
     * @throws InterruptedException the interrupted exception
     */
    public static void confirmPopup(String status, String expectedtxt) throws InterruptedException {
        
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popup_content_confirm")));
        String actualTxt = driver.findElement(By.id("popup_content_confirm")).getText();
        Assert.assertEquals(actualTxt, expectedtxt);
        if (status == "OK") {
            Thread.sleep(1000);
            driver.findElement(By.id("popup_ok_confirm")).click();
        } else {
            Thread.sleep(1000);
            driver.findElement(By.id("popup_cancel_confirm")).click();
        }
        Thread.sleep(1000);
        
    }
    
    /**
     * Checks is element present.
     *
     * @param path path of the element
     * @return true, if is element present
     */
    public static boolean isElementPresent(By path) {
        
        try {
            driver.findElement(path);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Element Counter.
     *
     * @param path path of the element
     * @return size the elements size
     */
    public static int ElementCounter(By path) {
        getSessionId();
        List<WebElement> countList = driver.findElements(path);
        return countList.size();
        
    }
    
    public static WebElement GetElement(By path) {
        
        return driver.findElement(path);
        
    }
    
    /**
     * Gets the color of text.
     *
     * @param path path of element of element
     * @return the color
     */
    public static String getColor(By path) {
        
        return Color.fromString(driver.findElement(path).getCssValue("color")).asRgb();
    }
    
    /**
     * Gets the class element.
     *
     * @param path path of element of element of element
     * @return the class
     */
    public static String getClass(By path) {
        
        return driver.findElement(path).getAttribute("class");
    }
    
    /**
     * Checks if is displayed.
     *
     * @param path path of element of element
     * @return true, if is displayed
     */
    public static boolean isDisplayed(By path) {
        
        return driver.findElement(path).isDisplayed();
    }
    
    /**
     * Checks if is enabled.
     *
     * @param path path of element of element
     * @return true, if is enabled
     */
    public static boolean isEnabled(By path) {
        
        return driver.findElement(path).isEnabled();
    }
    
    /**
     * Checks if is selected.
     *
     * @param path path of element of element
     * @return true, if is selected
     */
    public static boolean isSelected(By path) {
        
        return driver.findElement(path).isSelected();
    }
    
    /**
     * Submit the form.
     *
     * @param path path of element
     */
    public static void submit(By path) {
        
        driver.findElement(path).submit();;
    }
    
    /**
     * Gets the page title.
     *
     * @param path path of element
     * @return the page title
     */
    public static String getPageTitle(By path) {
        
        return driver.getTitle();
    }
    
    /**
     * Gets the current url.
     *
     * @param path path of element
     * @return the current url
     */
    public static String getCurrentUrl(By path) {
        
        return driver.getCurrentUrl();
    }
    
    /**
     * Refresh the current page.
     */
    public static void refreshPage() {
        
        driver.navigate().refresh();
    }
    
    /**
     * Gets the css value.
     *
     * @param path path of element
     * @param cssProperty the css property
     * @return the css value
     */
    public static String getCssValue(By path, String cssProperty) {
        
        return driver.findElement(path).getCssValue(cssProperty);
    }
    
    /**
     * Gets the attribute.
     *
     * @param path path of element
     * @param attribute the attribute
     * @return the attribute value
     */
    public static String getAttribute(By path, String attribute) {
        
        return driver.findElement(path).getCssValue(attribute);
    }
    
    public static SessionId getSessionId() {
        return ((RemoteWebDriver) driver).getSessionId();
    }
    
    /**
     * Closes the driver.
     */
    public static void quitDriver() {
        if (((RemoteWebDriver) driver).getSessionId() != null) {
            driver.quit();
        }
        try {
            Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
            Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
            Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
            Thread.sleep(10000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void closeDriver() {
        
        driver.close();
    }
    
    /**
     * Get value by Attribute .
     */
    public static String getValue(By path) {
        
        return driver.findElement(path).getAttribute("value");
    }
    
    /**
     * Clear Field value .
     */
    public static void ClearField(By path) {
        
        driver.findElement(path).clear();
    }
    
    /**
     * Clear Field value .
     */
    public static void ClearField2(By path) {
        
        driver.findElement(path).sendKeys("");
    }
    
    /**
     * Wait until disappear.
     *
     * @param path the path
     * @param second the second
     */
    public static void WaitUntilDisappear(By path, int second) {
        
        new WebDriverWait(driver, second).until(ExpectedConditions.invisibilityOfElementLocated(path));
    }
    
    /**
     * Appends text to input box .
     *
     * @param path path of the element
     * @param inputValue the input value
     */
    public static void insertText(By path, String inputValue) {
        
        driver.findElement(path).sendKeys(inputValue);
    }
    
    /**
     * Dropdown select lenght.
     *
     * @param path the path
     */
    public static int DropdownSelectLenght(By path) {
        
        Select selObj = new Select(driver.findElement(path));
        List<WebElement> l = selObj.getOptions();
        return l.size();
    }
    
    /**
     * Click hidden element.
     *
     * @param element the element
     * @throws InterruptedException the interrupted exception
     */
    public static void ClickHiddenElement(By element) throws InterruptedException {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(element));
    }
    
    /**
     * Uploadfile.
     *
     * @param path the path
     */
    public static void uploadfile(By path, String pathOfFile) throws InterruptedException {
        
        String workingDir = System.getProperty("user.dir");
        String filepath = workingDir + pathOfFile;
        
        Thread.sleep(1000);
        driver.findElement(path).sendKeys(filepath);
        
    }
    
    /**
     * Gets the all options of dropdown.
     *
     * @param by the by
     * @return the all options of dropdown
     */
    public static List<String> getAllOptionsOfDropdown(By by) {
        
        List<String> options = new ArrayList<String>();
        for (WebElement option : new Select(driver.findElement(by)).getOptions()) {
            String txt = option.getText();
            if (option.getAttribute("value") != "")
                options.add(option.getText());
        }
        return options;
    }
    
    /**
     * Gets the chrome options.
     *
     * @return the chrome options
     */
    public static DesiredCapabilities getChromeOptions() {
        
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\" + Constant.DEFULT_DOWNLOAD_PATH_IE);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        return cap;
    }
    
    /**
     * Gets the fire fox options.
     *
     * @return the fire fox options
     */
    public static FirefoxOptions getFireFoxOptions() {
        
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", System.getProperty("user.dir") + "\\" + Constant.DEFULT_DOWNLOAD_PATH_IE);
        // Skipping Save As dialog box for types of files with their MIME
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
        
        // Creating FirefoxOptions to set profile
        FirefoxOptions option = new FirefoxOptions();
        option.setProfile(profile);
        return option;
    }
    
    /**
     * Gets the count of child files.
     *
     * @param filePath the file path
     * @return the count of child files
     */
    public static int getCountOfChildFiles(String filePath) {
        
        return new File(filePath).list().length;
    }
    
    /**
     * Gets the browser name.
     *
     * @return the browser name
     */
    public static String getBrowserName() {
        
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        return cap.getBrowserName();
    }
    
    /**
     * Close other windows.
     */
    public static void closeOtherWindows() {
        
        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(originalHandle);
    }
    
    /**
     * Wait for ajax.
     */
    public static void waitForAjax() {
        
        new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
            
            /*
             * (non-Javadoc)
             * @see com.google.common.base.Function#apply(java.lang.Object)
             */
            public Boolean apply(WebDriver driver) {
                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }
    
    public static void HoverAndClick(By path) throws InterruptedException {
        
        Actions actions = new Actions(driver);
        WebElement subMenu = driver.findElement(path);
        actions.moveToElement(subMenu);
        Thread.sleep(1000);
        actions.click().build().perform();
    }
    
    public static void uploadfile(By path) throws InterruptedException {
        WebElement fileInput = driver.findElement(path);
        fileInput.sendKeys("C:/upload/environment ip.docx");
    }
}
