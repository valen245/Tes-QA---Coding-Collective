import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Go to url
WebUI.openBrowser('https://evoluz.farmagitechs.co.id/')

//Melakukan Login

WebUI.setText(findTestObject('Page_Login - Evoluz/input_Pengguna_nameOrEmail'), 'januari')

WebUI.setText(findTestObject('Page_Login - Evoluz/input_Kata Sandi_password'), 'januari')

WebUI.click(findTestObject('Page_Login - Evoluz/button_Masuk'))

//Delay membuka menu permintaan pelayanan

WebUI.delay(3)

WebUI.click(findTestObject('Page_Evoluz by Farmagitechs/span_Permintaan Pelayanan'))

WebUI.click(findTestObject('Page_Evoluz by Farmagitechs/button_Tambah Permintaan Pelayanan'))

//Delay membuka form tambah

WebUI.delay(3)

WebUI.click(findTestObject('Page_Evoluz by Farmagitechs/button_Kirim'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Evoluz by Farmagitechs/div_Judul usulan harus diisi'), 0)

String message = WebUI.getText(findTestObject('Object Repository/Page_Evoluz by Farmagitechs/div_Judul usulan harus diisi'))

if (!message.equals('Judul usulan harus diisi')) {
	KeywordUtil.markFailed("Message eror tidak sesuai")
}else {
	KeywordUtil.markPassed("Message eror sesuai")
}


