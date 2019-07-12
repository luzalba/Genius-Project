package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	static WebDriver driver;
	
	protected static void arrancarBrowser(String url) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		
	}

	protected static void buscarCancion(String cancion) {
		WebElement searchBox = driver.findElement(By.name("q"));
		WebElement escribirCancion = null;
		escribirCancion.sendKeys(cancion);
		
	}

	protected static void seleccionarCancion(String string) {
		// TODO Auto-generated method stub
		
	}

	protected static void cerrarNavegador() {
		driver.close();
		
	}

}
