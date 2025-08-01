package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class RegisterAccountPage  extends PageBase{

	public RegisterAccountPage(WebDriver driver) {
		super(driver);
}
  @FindBy(xpath="//input[@id='input-firstname']")	
  private WebElement txtFistName;
  
  @FindBy(xpath="//input[@id='input-lastname']")	
  private WebElement txtLastName;
  
  @FindBy(xpath="//input[@id='input-email']")
  private WebElement txtEmail;
  
  @FindBy(xpath="//input[@id='input-telephone']")
  private WebElement txtTelephone;
  
  @FindBy(xpath="//input[@id='input-password']")
  private WebElement txtPassword;
  
  @FindBy(xpath="//input[@id='input-confirm']")
  private WebElement txtConfirmPassword;
  
  @FindBy(xpath="//input[@name='agree']")
  private WebElement btnPrivacyPolicy;
  
  @FindBy(xpath="//input[@value='Continue']")
  private WebElement btnContinue;
  
  @FindBy(xpath="//label[normalize-space()='Yes']")
  private WebElement btnnewsLetterYes;
  
  @FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
  private WebElement ftnErrorMessage;
  
  @FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
  private WebElement ltnErrorMessage;
  
  @FindBy(xpath="//input[@id='input-email']/following-sibling::div")
  private WebElement emlErrorMessage;
  
  @FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
  private WebElement telePhoneErroeMessage;
  
  @FindBy(xpath="//input[@id='input-password']/following-sibling::div")
  private WebElement pwdErroeMessage;
  
  @FindBy(xpath="(//ul[@class='breadcrumb']/following-sibling::div)[1]")
  private WebElement privcyPolicyWaringMessage;
  
  public String retrivePrivcyPolicyWarningMessage()
  {
	  return privcyPolicyWaringMessage.getText();
  }
  
  public String retrivePasswordErrorMessage()
  {
	  return pwdErroeMessage.getText();
  }
  
  public String retriveTelePhoneErrorMessage()
  {
	  return telePhoneErroeMessage.getText();
  }
  
  public String retriveEmailErrorMessage()
  {
	  return emlErrorMessage.getText();
  }
  
  public String retriveLastNameErrorMessage()
  {
	  return ltnErrorMessage.getText();
  }
  
  public String retriveFirstNameErrorMessage()
  {
	  return ftnErrorMessage.getText();
  }
  
  public void clickOnNewsLetterYesButton()
  {
	 btnnewsLetterYes.click(); 
  }
  
  public void enterTextInFirstNameField(String fb) {
	  txtFistName.sendKeys(fb);
  }
  
  public void enterTextInLastNameField(String ln)
  {
	  txtLastName.sendKeys(ln);
  }
  public void enterTextInEmailField(String em)
  {
	  txtEmail.sendKeys(em);
  }
  public void enterTextInTelephoneField(String tp)
  {
	  txtTelephone.sendKeys(tp);
  }
  public void enterTextInPasswordField(String pw)
  {
	  txtPassword.sendKeys(pw);
  }
  public void enterTextInConfirmPasswordField(String cpw)
  {
	  txtConfirmPassword.sendKeys(cpw);
  }
  public void clickOnPrivacyPolicyButton()
  {
	  btnPrivacyPolicy.click();
  }
  public AccountSuccessPage clickOnContinueButton()
  {
	  btnContinue.click();
	  return new AccountSuccessPage(driver);
  }
  
  
  
  
  
}