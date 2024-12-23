package Module1_Login;
import org.openqa.selenium.WebDriver;
//pom class 1
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SwagLabsLoginPage
{
	//Step1: declaration
	@FindBy(xpath="//input[@name='user-name']") private WebElement UN;  //private WebElement UN=driver.finElement(By.xpath(""))
	@FindBy(xpath="//input[@name='password']") private WebElement PWD;	//private WebElement PWD=driver.finElement(By.xpath(""))
	@FindBy(xpath="//input[@name='login-button']") private WebElement LoginBtn;	//private WebElement LoginBtn=driver.finElement(By.xpath(""))
	@FindBy(xpath="//div[@class='error-message-container error']") private WebElement errorMsg;
	
	//initialization
	public SwagLabsLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);      //className.methodName(WebdriverObject, thisKeyword);
	}
	
	public void inpSwagLabsLoginPageUsername(String username) 
	{
		UN.sendKeys(username);
	}
	
	public void inpSwagLabsLoginPagePaswword(String password)
	{
		PWD.sendKeys(password);
	}
	
	public void clickSwagLabsLoginPageLoginBtn()
	{
		LoginBtn.click();
	}
	
	
	public void verifySwagLabsLoginPageErrorMsg(String expErrorMsg) 
	{
		String actErrorMsg = errorMsg.getText();
		if (actErrorMsg.contains(expErrorMsg)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	
}
