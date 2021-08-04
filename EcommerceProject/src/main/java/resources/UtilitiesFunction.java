package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import objectRespository.CreateAccountPageObjects;

public class UtilitiesFunction {
	public static WebDriver driverObject = null;
	Select selectObject = null;
	String mainWindowHandle = null;
	Properties propertiesObject = null;
	ExtentReports extentObj =null;

	public Properties propertiesFileLoad() throws IOException {
		Properties propertiesObject = new Properties();
		FileInputStream fileObj = new FileInputStream(
				"C:\\Users\\sakgupta1\\EcommerceProject\\src\\main\\java\\resources\\DataDriven.properties");
		propertiesObject.load(fileObj);
		return propertiesObject;
	}

	public Actions ActionClass(WebDriver driverObject) {
		Actions actionObject = new Actions(driverObject);
		return actionObject;
	}

	public static WebDriver browserinitialization() throws IOException {
//		DesiredCapabilities cap = DesiredCapabilities.chrome();
//		cap.setCapability("download.default_directory", "C:");
//		cap.setCapability("download.prompt_for_download", "false");
//		cap.setCapability("directory_upgrade", "true");
//		cap.setCapability("plugins.plugins_disabled", "Chrome PDF Viewer");
		Properties propertiesObject = new Properties();
		FileInputStream fileObj = new FileInputStream(
				"C:\\Users\\sakgupta1\\EcommerceProject\\src\\main\\java\\resources\\DataDriven.properties");
		propertiesObject.load(fileObj);
		if (propertiesObject.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", propertiesObject.getProperty("ChromeExeFilePath"));
			driverObject = new ChromeDriver();
		} else if (propertiesObject.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", propertiesObject.getProperty("FireFoxExeFilePath"));
			driverObject = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver", propertiesObject.getProperty("IEExeFilePath"));
			driverObject = new InternetExplorerDriver();
		}

		driverObject.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driverObject;
	}

	public Select selectObject(WebElement element) {
		selectObject = new Select(element);
		return selectObject;

	}

	public String handlingMultipleWindows(WebDriver driverObj) {
		String mainWindowHandle = driverObject.getWindowHandle();
		Set<String> ids = driverObj.getWindowHandles();
		Iterator<String> iteratorObject = ids.iterator();
		while (iteratorObject.hasNext()) {
			driverObj.switchTo().window(iteratorObject.next());
			driverObj.manage().window().maximize();
			System.out.println(driverObj.getTitle());
		}
		return mainWindowHandle;

	}

	public void browserClose() {
		driverObject.close();
	}

	public void formFillingDetails(CreateAccountPageObjects createAccountPageObject, Properties propertiesObject) {

		createAccountPageObject.sendObjectFirstName().sendKeys(propertiesObject.getProperty("firstName"));
		createAccountPageObject.sendObjectFirstName().sendKeys(Keys.TAB);
		createAccountPageObject.sendObjectMiddleName().sendKeys(propertiesObject.getProperty("middleName"));
		createAccountPageObject.sendObjectMiddleName().sendKeys(Keys.TAB);
		createAccountPageObject.sendObjectLastName().sendKeys(propertiesObject.getProperty("lastName"));
		createAccountPageObject.sendObjectLastName().sendKeys(Keys.TAB);
		createAccountPageObject.sendObjectEmailAddress().sendKeys(propertiesObject.getProperty("emailAddress"));
		createAccountPageObject.sendObjectEmailAddress().sendKeys(Keys.TAB);
		createAccountPageObject.sendObjectpassword().sendKeys(propertiesObject.getProperty("password"));
		createAccountPageObject.sendObjectpassword().sendKeys(Keys.TAB);
		createAccountPageObject.sendObjectConfirmPassword().sendKeys(propertiesObject.getProperty("confirmPassword"));
		createAccountPageObject.sendObjectRegisterBtn().click();

	}

	public String takeScreenshot(String nameOfMethod, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + nameOfMethod + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

	public ExtentReports reportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentHtmlReporter ExtenSparkReporterObj = new ExtentHtmlReporter(path);
		ExtenSparkReporterObj.config().setReportName("Ecommerce Webiste Report");
		ExtenSparkReporterObj.config().setDocumentTitle("Automation Test Result");
		extentObj = new ExtentReports();
		extentObj.attachReporter(ExtenSparkReporterObj);
		extentObj.setSystemInfo("Tester", "Sakshar Gupta");
		return extentObj;

	}
	
	protected File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	    	System.out.println("FIle not downloaded");
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	    	   System.out.println("FIle downloaded");
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	
	protected File getLatestFilefromDire(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	    	System.out.println("FIle not downloaded");
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	    	   System.out.println("FIle downloaded");
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
}
