package authentication
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

import internal.GlobalVariable

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



class LoginQasir {

	@Given("Saya membuka browser dan menuju halaman Website Qasir.id")
	def redirectWeb() {
		TestObject qasirLogo = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'div-block-43'))]/img[(contains(@src,'svg'))]")

		WebUI.openBrowser(GlobalVariable.qasir_web_url)
		WebUI.maximizeWindow()
		WebUI.delay(4)
		WebUI.waitForElementPresent(qasirLogo, 3, FailureHandling.OPTIONAL)
		WebUI.verifyElementVisible(qasirLogo, FailureHandling.OPTIONAL)
		WebUI.delay(4)
		WebUI.takeScreenshot()
	}

	@When("Saya menggunakan login via (.*) dengan area id (.*) melakukan input (.*)")
	def chooseMethodLogin(String via,String areaid,String userid) {
		TestObject methodLogin = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(text(),'$via'))]")
		TestObject blockMethod = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'div-block-56'))]")
		TestObject modalKodeShow = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@data-qa,'modal-selectcountry'))]")
		TestObject selectKode = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(contains(text(),'$areaid'))]")
		TestObject inputMethod = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(contains(@class,'tabs-content w-tab-content'))]")

		WebUI.delay(2)
		WebUI.click(methodLogin)
		WebUI.delay(2)
		WebUI.takeElementScreenshot(blockMethod)
		WebUI.delay(4)
		WebUI.takeElementScreenshot(inputMethod)
		if (via == "No. Handphone") {
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/01-Dashboard-Qasir-Login/Web-dropDownModal-areaid'))
			WebUI.delay(4)
			WebUI.takeElementScreenshot(modalKodeShow)
			WebUI.delay(2)
			WebUI.click(selectKode)
			WebUI.delay(2)
			WebUI.setText(findTestObject('Object Repository/01-Dashboard-Qasir-Login/Web-editText-nohp'), userid)
		}else {
			WebUI.delay(2)
			WebUI.setText(findTestObject('Object Repository/01-Dashboard-Qasir-Login/Web-editText-email'), userid)
		}
		WebUI.delay(4)
		WebUI.takeElementScreenshot(inputMethod)
	}

	@And("Saya memasukkan nomor pin (.*)")
	def inputPin(String pin) {
		TestObject pinMethod = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/div[(contains(@class,'div-block-56'))]/div[(contains(@class,'field-control'))]")

		WebUI.delay(4)
		WebUI.takeElementScreenshot(pinMethod)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/01-Dashboard-Qasir-Login/Web-editText-nopin'), pin)
		for (int a=0 ; a < 2 ;a++) {
			WebUI.delay(4)
			WebUI.takeElementScreenshot(pinMethod)
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/01-Dashboard-Qasir-Login/Web-button-fieldEye'))
		}
	}

	@Then("Saya menekan button login dan menuju ke halaman Qasir.id")
	def loginButton() {
		WebUI.delay(2)
		WebUI.takeScreenshot()
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/01-Dashboard-Qasir-Login/Web-button-masuk'))
	}
}