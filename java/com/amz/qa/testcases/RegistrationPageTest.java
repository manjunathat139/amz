package com.amz.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amz.qa.util.TestUtil;
import com.anahat.qa.base.TestBase;
import com.anahat.qa.pages.RegistrationPage;

public class RegistrationPageTest extends TestBase {
	RegistrationPage registration;
	String sheetName = "Sheet2";
	int dataimportcount = 1;

	@DataProvider
	public Object[][] regidata() throws IOException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	public RegistrationPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		registration = new RegistrationPage();

	}

	@Test(priority = 1, dataProvider = "regidata")
	public void registrationtest(String sl, String month, String year, String date, String beneficiaryname,
			String gender, String contactnum, String idcardtype, String idcardnum, String beneficiarytype,
			String Status) throws InterruptedException, IOException {

		try {
			if (Status.equalsIgnoreCase("passed")) {
				return;
			}
			System.out.println(month + "====================before");
			System.out.println(year + "====================before");
			System.out.println(date + "====================before");
			System.out.println(beneficiaryname + "====================before");
			System.out.println(gender + "====================before");
			System.out.println(contactnum + "====================before");
			System.out.println(idcardtype + "====================before");
			System.out.println(idcardnum + "====================before");
			System.out.println(beneficiarytype + "====================before");
			month = month.trim();
			year = year.trim();
			date = date.trim();
			contactnum = contactnum.trim();
			beneficiaryname = beneficiaryname.trim();
			idcardnum = idcardnum.trim();
			gender = gender.trim();
			idcardtype = idcardtype.trim();
			beneficiarytype = beneficiarytype.trim();
			if (TestUtil.validateMonth(month) == false) {
				month = "Jun";
			}
			if (TestUtil.isValidYear(year) == false) {
				year = "2021";
			}
			if (TestUtil.isValidDate(date) == false) {
				date = "30";
			}
			if (beneficiaryname == null || beneficiaryname.isEmpty()) {
				beneficiaryname = "NaaN";
			}
			if (TestUtil.isValidGender(gender) == false) {
				gender = "Female";
			}
			if (TestUtil.isValidPhoneNumber(contactnum) == false) {
				contactnum = "9901199011";
			}
			if (TestUtil.isValidCardType(idcardtype) == false) {
				idcardtype = "others";
			}
			if (idcardnum == null || idcardnum.isEmpty()) {
				idcardnum = "00";
			}
			if (TestUtil.isValidBeneficiarytype(beneficiarytype) == false) {
				beneficiarytype = "others";
			}

			System.out.println(month + "====================after");
			System.out.println(year + "====================after");
			System.out.println(date + "====================after");
			System.out.println(beneficiaryname + "====================after");
			System.out.println(gender + "====================after");
			System.out.println(contactnum + "====================after");
			System.out.println(idcardtype + "====================after");
			System.out.println(idcardnum + "====================after");
			System.out.println(beneficiarytype + "====================after");
			registration.register(month, (int) Float.parseFloat(year), (int) Float.parseFloat(date), beneficiaryname,
					gender, contactnum, idcardtype, idcardnum, beneficiarytype);

			WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));

			// submit.click();
			Thread.sleep(3000);
			String unsucessUrl = "https://survey.zohopublic.in/zs/QFDwHs";
			String currenturl = driver.getCurrentUrl();
			System.out.println(currenturl + "============================");
			if (currenturl.equalsIgnoreCase(unsucessUrl)) {
				System.out.println("000000000===============00000000000");
				TestUtil.setTestData(sheetName, "failed", sl);
				Assert.assertEquals(false, true,
						"failed to import ====>>>>>" + beneficiaryname + "has adhar number" + idcardnum);

			} else {
				System.out.println("3===============3");
				TestUtil.setTestData(sheetName, "passed", sl);
				Assert.assertEquals(true, true,
						"imported successfully ====>>>>>" + beneficiaryname + "has adhar number" + idcardnum);
			}

		} catch (WebDriverException driverexception) {
			System.out.println("webdriverexception occured");
			driverexception.printStackTrace();
			driver.quit();
		} catch (Exception e) {
			System.out.println("4===============4");
			e.printStackTrace();
			TestUtil.setTestData(sheetName, "passed", sl);
			Assert.assertEquals(true, false,
					"OOPs..failed to import ====>>>>>" + beneficiaryname + "has adhar number" + idcardnum);
			driver.quit();

		}
	}

	@AfterMethod
	public void driverClose() {
		// driver.close();
		driver.quit();

	}

}
