package scenarioPlan
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.openqa.selenium.JavascriptExecutor


class outletAndProfil {

	@Given("Saya berada pada pemilihan outlet sebelum masuk Halaman utama dan memilih outlet (.*)")
	def chooseOutlet(String outlet) {
		TestObject showOutlet = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'div-block-42'))]")
		TestObject pilihOutlet = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/h4[(contains(text(),'$outlet'))]")

		WebUI.delay(4)
		WebUI.takeScreenshot()
		WebUI.delay(4)
		WebUI.takeElementScreenshot(showOutlet)
		WebUI.delay(2)
		WebUI.click(pilihOutlet)
	}

	@When("Saya berada di Halaman utama dan memastikan pemilihan dropdown outlet (.*)")
	def checkOutletInMainMenu(String outlet) {
		TestObject listOutlet = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/li/div/span[(contains(@dir,'ltr'))]/span/span/span[(contains(text(),'$outlet'))]")
		TestObject captOutlet = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/li/div/span[(contains(@dir,'ltr'))]/span/span")

		WebUI.delay(4)
		WebUI.takeScreenshot()
		WebUI.delay(4)
		WebUI.takeElementScreenshot(captOutlet)
		WebUI.delay(4)
		WebUI.verifyElementPresent(listOutlet, 3, FailureHandling.OPTIONAL)
	}

	@And("Saya melakukan klik gambar profil dan memilih sub-menu Profil Pengguna")
	def navigateToProfile() {
		TestObject dropDownProfil = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'topmenu-outer'))]/div/ul[1]/li")
		TestObject hoverProfil = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'topmenu-outer'))]/div/ul[1]/li/ul")

		WebUI.delay(4)
		WebUI.click(dropDownProfil)
		WebUI.delay(4)
		WebUI.takeElementScreenshot(hoverProfil)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-menu-profil'))
	}

	@And("Saya merubah foto profil dengan gambar (.*) dan menerapkan foto")
	def changePhoto(String gambar) {
		String picture = gambar
		String dirPath = RunConfiguration.getProjectDir()
		String assetDir = dirPath+'/Include/assets/'+picture+'.jpg'

		TestObject photoBox = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'row'))]/div[(contains(@class,'col-xs-6 col-md-3'))]")

		WebUI.delay(4)
		WebUI.takeScreenshot()
		WebUI.delay(3)
		WebUI.uploadFile(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-button-UploadFoto'), assetDir, FailureHandling.OPTIONAL)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-button-terapkanfoto'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-button-terapkanfoto'))
		WebUI.delay(3)
		WebUI.takeScreenshot()
	}

	@And("Saya merubah Nama Depan dengan (.*) dan Nama Belakang dengan (.*) dan menyimpan perubahan tersebut")
	def changeName(String nama, String namablkg) {
		TestObject dataDiri = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'row'))][2]/div[(contains(@class,'col-xs-12 col-md-8'))]")

		WebUI.delay(4)
		WebUI.takeScreenshot()
		WebUI.delay(2)
		WebUI.scrollToPosition(0, 60)
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-EditText-FirstName'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-EditText-FirstName'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-EditText-FirstName'), Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-EditText-FirstName'), nama)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-EditText-LastName'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-EditText-LastName'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-EditText-LastName'), Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-EditText-LastName'), namablkg)
		for (int a=0 ; a < 2 ;a++) {
			WebUI.delay(4)
			WebUI.scrollToElement(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-button-simpan'), 3)
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-button-simpan'))
		}
	}

	@And("Saya melakukan pengecekan perubahan dari nama depan (.*) dan Nama Belakang (.*)")
	def checkChange(String nama, String namablkg) {
		TestObject dataDiri = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'row'))][2]/div[(contains(@class,'col-xs-12 col-md-8'))]")
		TestObject firstName = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/input[(contains(@name,'first') and contains(@value,'$nama'))]")
		TestObject lastName = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/input[(contains(@name,'last') and contains(@value,'$namablkg'))]")

		WebUI.delay(4)
		WebUI.takeScreenshot()
		WebUI.delay(4)
		WebUI.takeElementScreenshot(dataDiri)
		WebUI.delay(2)
		WebUI.verifyElementPresent(firstName, 3, FailureHandling.OPTIONAL)
		WebUI.delay(2)
		WebUI.verifyElementPresent(lastName, 3, FailureHandling.OPTIONAL)
	}

	@Then("Kemudian saya logout dari web Qasir.id")
	def navigateLogout() {
		TestObject dropDownProfil = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'topmenu-outer'))]/div/ul[1]/li")
		TestObject hoverProfil = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'topmenu-outer'))]/div/ul[1]/li/ul")

		WebUI.delay(4)
		WebUI.click(dropDownProfil)
		WebUI.delay(4)
		WebUI.takeElementScreenshot(hoverProfil)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/02-Dashboard-Qasir-Home/01-Profil/Web-menu-logout'))
		WebUI.delay(4)
		WebUI.takeScreenshot()
		WebUI.delay(2)
		WebUI.closeBrowser()
	}
}