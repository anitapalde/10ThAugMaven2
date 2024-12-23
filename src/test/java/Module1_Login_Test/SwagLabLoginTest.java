package Module1_Login_Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabsHomePage;
import Module1_Login.SwagLabsLoginPage;
import Module1_Login.SwagLabsOpenMenuPage;


public class SwagLabLoginTest extends BaseClass
{
	SwagLabsLoginPage login;
	SwagLabsHomePage home;
	SwagLabsOpenMenuPage openMenu;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException 
	{
		initializeBrowser();
		
		login=new SwagLabsLoginPage(driver);
		home=new SwagLabsHomePage(driver);
		openMenu=new SwagLabsOpenMenuPage(driver);
	}
	
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.inpSwagLabsLoginPageUsername(UtilityClass.getPFData("UN"));
		login.inpSwagLabsLoginPagePaswword(UtilityClass.getPFData("PWD"));
		login.clickSwagLabsLoginPageLoginBtn();
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyLogoText() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		TCID=101;
		String actLogoText = home.getSwagLabsHomePageLogoText();
		String expLoloText = UtilityClass.getTD(0, 2);
		
		Assert.assertEquals(actLogoText, expLoloText,"Failed-both results are diff");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException
	{
		if (s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		} 
		
		home.clickSwagLabsHomePageOpenMenuBtn();
		Thread.sleep(2000);
		openMenu.clickSwagLabsOpenMenuPageLogout();
		Thread.sleep(2000);
	}
		
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();
	}
}
