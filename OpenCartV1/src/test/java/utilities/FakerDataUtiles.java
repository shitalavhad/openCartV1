package utilities;

import java.util.Random;

import com.github.javafaker.Faker;

public class FakerDataUtiles {
	private static final Faker faker=new Faker();
	private static final Random random=new Random();
	
	public static String getFirstName()
	{
		return faker.name().firstName();
	}
	
	public static String getLastName()
	{
		return faker.name().lastName();
	}
	public static String getFullName()
	{
		return faker.name().fullName();
	}
	public static String getEmail()
	{
		return faker.internet().emailAddress();
	}
	//custom Email Format :name+randomNumber+domain
	public static String getCustomEmail(String baseName,String domain)
	{
		return baseName.toLowerCase()+random.nextInt(1000)+"@"+domain.toLowerCase();
	}
	public static String getPhoneNumber()
	{
		return faker.phoneNumber().cellPhone();
	}
 public static String getPassword()
 {
	return faker.internet().password(8,16,true,true);
 }
  public static String getCity()
 {
	return faker.address().city();
 }
 public static String getCountry()
 {
	return faker.address().country();
}
public static String getFullAddress()
{
	return faker.address().fullAddress();
}
public static String getZipCode()
{
	return faker.address().zipCode();
}
public static String getCompanyName()
{
	return faker.company().name();
}
public static String getJobTitle()
{
	return faker.job().title();
}
public static String getUsername()
{
	return faker.name().username();
	
}
public static String getRandomNumber(int digits)
{
	return faker.number().digits(digits);
}
public static String getRandomAlphaNumeric(int length)
{
	String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	StringBuilder sb=new StringBuilder(length);
	for(int i=0;i<length;i++)
	{
		sb.append(chars.charAt(random.nextInt(chars.length())));
	}
	return sb.toString();
}
//Return tab-separated data(for excel)
public static String getTabDelimitedUser()
{
	return getFirstName()+"\t"+
                 getLastName()+"\t"+
			      getCustomEmail("user","mailinator.com")+"\t"+
                  getPhoneNumber()+"\t"+
			      getCity();
}

}
