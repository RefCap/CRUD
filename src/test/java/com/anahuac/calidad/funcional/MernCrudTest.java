package com.anahuac.calidad.funcional;

import static org.junit.Assert.*;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import java.io.File;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MernCrudTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

 
  @Test
  public void Test_1Add() throws Exception {
    driver.get("https://mern-crud.herokuapp.com/");
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("H");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("correo@a.com");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("44");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Male'])[2]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
    pause(4000);
    //Verify(assert)
    WebElement  etiquetaEsperada = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/div"));
    String textoResultado = etiquetaEsperada.getText();
    assertThat("Nice one!",is(textoResultado));
  }
  
  @Test
  public void Test_2Buscar() throws Exception {
		  
		  driver.get("https://mern-crud.herokuapp.com/");
		  
		  pause(3000);
		    
		  WebElement etiquetaEsperada = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[1]"));
		    
		  String text = etiquetaEsperada.getText();
		    
		    
		  assertThat("H", is(text));
  		}
  @Test
  public void Test_3Update() throws Exception {
	  driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[5]/button[1]")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    pause(1000);
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).sendKeys("Update");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
	    pause(5000);
	    //Verify(assert)
	WebElement  updateEsperado = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p"));
	String texto = updateEsperado.getText();
	assertThat("Successfully updated!",is(texto));	    
  }

  @Test
  public void Test_4Eliminar() throws Exception {
	driver.get("https://mern-crud.herokuapp.com/");
	driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete User'])[1]/following::p[1]")).click();
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hupdate'])[2]/following::button[1]")).click();
	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
	driver.findElement(By.xpath("//body")).click();
	    pause(5000);
	//Verificar(assert)
	WebElement  etiquetaEsperada = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody"));
	String textoResultado = etiquetaEsperada.getText();
	assertThat("null",is(not(textoResultado)));
	    }
  
	 
  
  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
  
  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  
  private void pause(long mils) {
	  try {
		  Thread.sleep(mils);
	  }catch(Exception e){
		  e.printStackTrace();
	  }
  }


  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

