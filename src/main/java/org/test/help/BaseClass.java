package org.test.help;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver ;
	
	// 1.Browser Launch
	public static void browserLaunch () {
		WebDriverManager.edgedriver().setup();
		 driver =new EdgeDriver ();
	}
	
	// 2.Url Launch
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
	// 3. Time Management
	public static void impWait (int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	// 4.SendKeys
	public static void sendKey (WebElement a,String input) {
		a.sendKeys(input);
	}
	
	// 5.Click
	public static void click (WebElement a) {
	a.click();
	}
	
	// 6. Get Url
	public static String getCurrentUrl () {
		String currentUrl=driver.getCurrentUrl();
		return currentUrl;
	}
	
	// 7.Get Title
	public static String getTitle () {
	String title = driver.getTitle();
	return title;
	}
	
	// 8.Get Text
	public static String getText (WebElement a) {
		String text = a.getText();
		return text;
		
	}
	
	// 9.Get Attribute (Inner Text)
	public static String getAttributeText (WebElement a) {
		String atttext = a.getAttribute("innerText");
		return atttext;
	}
	
	// 10. Get Attribute (Value)
	public static String getAttribute (WebElement a) {
		String attvalue = a.getAttribute("value");
		return attvalue;
	}
	
	// 11.Quit
	public static void quit () {
		driver.quit();
	}
	
	// 12.Navigate To
	public static void navigateto (String url) {
		driver.navigate().to(url);
	}
	
	// 13.Forward
	public static void forward () {
		driver.navigate().forward();
	}
	
	// 14.Backward
	public static void backward () {
		driver.navigate().back();
	}
	
	//15.Refresh
	public static void refresh () {
		driver.navigate().refresh();
	}
	
	// 16.clear
	public static void clear (WebElement a) {
		a.clear();
	}
	
	// 17.is Enabled
	public static boolean isEnabled (WebElement a) {
		boolean enabled = a.isEnabled();
		return enabled;
	}
	
	// 18.is Diplayed
	public static boolean isDiplayed (WebElement a) {
		boolean displayed = a.isDisplayed();
		return displayed;
	}
	
	// 19.is Selected
	public static boolean isSelected (WebElement a) {
		boolean selected = a.isSelected();
		return selected;
	}
	
	// 20.FindElement
	public static WebElement findElement (String locator,String value) {
		WebElement e=null;
		if (locator.equals("id")) {
			WebElement el = driver.findElement(By.id(value));
			
		}
		else if (locator.equals("name")) {
			WebElement el = driver.findElement(By.name(value));
		}
		else if(locator.equals("xpath")) {
			WebElement el = driver.findElement(By.xpath(value));
		}
		else if (locator.equals("tagname")) {
			WebElement el = driver.findElement(By.tagName(value));
		}
		else if (locator.equals("classname")) {
			WebElement el = driver.findElement(By.className(value));
		}
		else if (locator.equals("text")) {
			WebElement el = driver.findElement(By.linkText(value));
		}
		else if (locator.equals("contain")) {
			WebElement el = driver.findElement(By.partialLinkText(value));
		}
		else if (locator.equals("select")) {
			WebElement el = driver.findElement(By.cssSelector(value));
		}
		return e;
		
	}
	
	// 21.Move to Element
	public static void movetoElement(WebElement a) {
		Actions act=new Actions (driver);
		act.moveToElement(a).perform();
	}
	
	// 22.Drag and Drop
	public static void dragAndDrop (WebElement from, WebElement To) {
		Actions act=new Actions (driver);
		act.dragAndDrop(from, To).perform();
	}
	
	// 23.Action Click
	public static void actionClick (WebElement a) {
		Actions act=new Actions (driver);
		act.click().perform();
	}
	
	// 24.Click and Hold------Moveto-------Release
	public static void clickMoveRelease (WebElement from,WebElement to) {
		Actions act=new Actions (driver);
		act.clickAndHold(from).moveToElement(to).release();
	}
	
	// 25.ClickHold-------------Release
	public static void clickRelease (WebElement from,WebElement to) {
		Actions act=new Actions (driver);
		act.clickAndHold(from).release(to).perform();
	}
	
	// 26.Double Click
	public static void doubleClick(WebElement a) {
		Actions act=new Actions (driver);
		act.doubleClick().perform();
	}
	
	// 27.Triple Click
	public static void tripleClick (WebElement a) {
		Actions act=new Actions (driver);
		act.doubleClick().click().perform();
	}
	
	// 28.Context Click
	public static void contextClick (WebElement a) {
		Actions act=new Actions (driver);
		act.contextClick().perform();
	}
	
	// 29.Alert-----------Accept
	public static void accept () {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	
	// 30.Alert--------Dismiss
	public static void dismiss () {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	
	// 31.Alert-----------Promt Alert Accept
	public static void promtAlertAccept (String input) {
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(input);
		alt.accept();
	}
	
	// 32.Alert------------ Promt Alert Dismiss
	public static void promtDismiss () {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	
	// 33.select By Index
	public static void selectByIndex (WebElement a,int index) {
		Select sel=new Select (a);
		sel.selectByIndex(index);
	}
	
	// 34.Select By Value
	public static void selectByValue (WebElement a,String value) {
		Select sel=new Select (a);
		sel.selectByValue(value);
	}
	
	// 35.Select By Visibletext
	public static void selectByVisibleText (WebElement a,String text) {
		Select sel=new Select (a);
		sel.selectByVisibleText(text);
	}
	
	// 36.Deselected By Index
	public static void deselectedByIndex (WebElement a,int index) {
		Select sel=new Select (a);
		sel.deselectByIndex(index);
	}
	
	// 37.Deselected By Value
	public static void deselectedByValue (WebElement a,String value) {
		Select sel=new Select (a);
		sel.deselectByValue(value);
	}
	
	// 38.Deselected By Text
	public static void deselectedByVisibleText (WebElement a,String text) {
		Select sel=new Select (a);
		sel.deselectByVisibleText(text);
	}
	
	// 39.Deselect All
	public static void deselectAll (WebElement a) {
		Select sel=new Select (a);
		sel.deselectAll();
	}
	
	// 40.Get All Option in Drop Down
	public static void getOption (WebElement a) {
		Select sel=new Select (a);
		List<WebElement> options = sel.getOptions();
		for (WebElement x:options) {
			String text = x.getText();
			System.out.println(text);
		}
	}
	// 41.is Possible To Select Mutiple action
	public static boolean isMultiple(WebElement a) {
		Select sel=new Select (a);
		boolean multiple = sel.isMultiple();
		return multiple;
		
	}
	// 42.Get First Select Option 
	public static String getFirstSelectedOption(WebElement a) {
		Select sel=new Select (a);
		WebElement firstSelectedOption = sel.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}
	// 43.Get All Selected Option
	public static void getAllSelectedOption(WebElement a) {
		Select sel=new Select (a);
		List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
		
		for (int i=0; i<allSelectedOptions.size();i++) {
			WebElement we = allSelectedOptions.get(i);
			String text = we.getText();
			System.out.println(text);
		}
	}
	
	// 44.Frame By Index
	public static void frameByIndex (int index) {
		driver.switchTo().frame(index);
	}
	
	//  45.Frame By Id
	public static void frameById (String id) {
		driver.switchTo().frame(id);
	}
	
	// 46.frame By WebElement
	public static void frameByWebElement(WebElement a) {
		driver.switchTo().frame(a);
	}
	
	//  47.Default Content
	public static void defaultContent () {
		driver.switchTo().defaultContent();
	}
	
	// 48. Parent Frame
	public static void parentFrame () {
		driver.switchTo().parentFrame();
	}
	
	// 49.JavaScript----------------Set
	public static void setExecuteScript(String text,WebElement a) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value',' "+text+ "')", a);
	}
	
	// 50.JavaScript-------------Get
	public static String getexecutorScript (WebElement a) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		Object es = js.executeScript("return arguments[0],getAttribute('value')", a);
		String data=(String) es;
		return data;
		
	}
	
	// 51.Scroll Down
	public static void scrollDown (WebElement a) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView('true')", a);
	
}
	
	// 52.Scroll up
		public static void scrollUp (WebElement a) {
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView('false')", a);
		}
		
	//  53.WindowsHandles
		public static void windowsHandles (int index) {
			Set<String> allwindows = driver.getWindowHandles();
			List<String> li=new ArrayList<String>();
			li.addAll(allwindows);
			driver.switchTo().window(li.get(index));
			
		}
		
	// 54.Screenshot
		public static void screenshot (String filename) throws IOException {
			String str= System.getProperty("User.dir");
			TakesScreenshot tk=(TakesScreenshot) driver;
			File srcfile = tk.getScreenshotAs(OutputType.FILE);
			File destfile=new File (str+"\\src\\test\\resource\\"+filename+".png");
			FileUtils.copyDirectory(srcfile, destfile);
			
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
