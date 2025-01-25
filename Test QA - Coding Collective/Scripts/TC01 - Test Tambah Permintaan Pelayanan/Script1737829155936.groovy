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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.openBrowser('https://evoluz.farmagitechs.co.id/')

String input_judul = 'Permintaan Perbaikan Monitor'

WebUI.setText(findTestObject('Page_Login - Evoluz/input_Pengguna_nameOrEmail'), 'januari')

WebUI.setText(findTestObject('Page_Login - Evoluz/input_Kata Sandi_password'), 'januari')

WebUI.click(findTestObject('Page_Login - Evoluz/button_Masuk'))

WebUI.click(findTestObject('Page_Evoluz by Farmagitechs/span_Permintaan Pelayanan'))

WebUI.click(findTestObject('Page_Evoluz by Farmagitechs/button_Tambah Permintaan Pelayanan'))

WebUI.waitForElementPresent(findTestObject('Page_Evoluz by Farmagitechs/input_(max 100 karakter)_billing_requestService'), 
    15)

WebUI.setText(findTestObject('Page_Evoluz by Farmagitechs/input_(max 100 karakter)_billing_requestService'), input_judul)

// Dapatkan WebDriver dan eksekusi JavaScript untuk memanipulasi elemen
WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor js = ((driver) as JavascriptExecutor)

// Temukan elemen file dan tampilkan 
js.executeScript('document.querySelector(\'input[type="file"]\').style.display = \'block\';' // Tampilkan elemen jika disembunyikan
    )

//js.executeScript("document.getElementById('input-file-id').value = arguments[0];", filePath)
WebUI.uploadFile(findTestObject('Object Repository/Page_Evoluz by Farmagitechs/label_Upload2'), 'E:\\kerja\\gambar\\komputer.jpg')

// Tunggu file terupload atau melanjutkan proses lainnya
WebUI.delay(5)

//Verify upload berhasil
WebUI.verifyElementPresent(findTestObject('Page_Evoluz by Farmagitechs/img'), 0)

WebUI.setText(findTestObject('Page_Evoluz by Farmagitechs/p_Increase indent_ck-placeholder'), 'Permintaan perbaikan komputer rusak ')

WebUI.delay(10)

WebUI.click(findTestObject('Page_Evoluz by Farmagitechs/button_Kirim'))

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('Page_Evoluz by Farmagitechs/div_Service Tes permintaan perbaikan mesin kasirFarmagitechs  Januari26 Januari 2025 0314'), 
    0)

//Menyimpan judul
String judul = WebUI.getText(findTestObject('Object Repository/Page_Evoluz by Farmagitechs/h4_Tes permintaan perbaikan mesin kasir'))

WebUI.click(findTestObject('Page_Evoluz by Farmagitechs/i_Kembali_mdi mdi-arrow-left me-1'))

WebUI.delay(5)

//Mencari judul permintaan
WebUI.setText(findTestObject('Page_Evoluz by Farmagitechs/input_Permintaan Pelayanan_search'), judul)

//Verify judul berhasil masuk atau belum
List<WebElement> list = WebUI.findWebElements(findTestObject('Object Repository/Page_Evoluz by Farmagitechs/td_Melakukan check data tilaka username'), 
    10)

for (def data : list) {
    nama_judul = data.getText()

    if (!(nama_judul.equals(judul))) {
        KeywordUtil.markFailed('data belum ditambahkan')
    }
}

//Delay untuk memastikan data sudah ada
WebUI.delay(5)

// Tutup browser setelah selesai
WebUI.closeBrowser()

