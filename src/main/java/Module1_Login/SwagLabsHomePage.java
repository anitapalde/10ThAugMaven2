package Module1_Login;
import org.openqa.selenium.WebDriver;
//pom class 2
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SwagLabsHomePage 
{
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement logoText;
	@FindBy(xpath = "//button[text()='Open Menu']") private WebElement openBtn;
	
	
	public SwagLabsHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String getSwagLabsHomePageLogoText() 
	{
		String text = logoText.getText();
		return text;
	}
	
//	public void verifySwagLabsHomePageLogo(String expLogoText) 
//	{
//		String actLogoText = logoText.getText();
//		if (actLogoText.equals(expLogoText))
//		{
//			System.out.println("Pass");
//		}
//		else 
//		{
//			System.out.println("Fail");
//		}
//	}
	
	public void clickSwagLabsHomePageOpenMenuBtn()
	{
		openBtn.click();
	}
	
}
