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
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
	}

	protected static void buscarCancion(String cancion) {
		WebElement searchBox = driver.findElement(By.name("q"));
		WebElement searchIcon= driver.findElement(By.xpath("//div[contains(@class, 'PageHeaderSearchdesktop__Icon')]"));
		searchBox.clear();
		searchBox.sendKeys(cancion);
		searchIcon.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement headerSongName = driver.findElement(By.xpath("//h2"));
		WebElement resultList = driver.findElement(By.xpath("//div[@class='mini_card-info']"));
		if(headerSongName.isDisplayed() && resultList.isDisplayed()) {
			System.out.print("El titulo es Everlong\n");
			
		} else {
			System.out.print("El titulo no es Everlong\n");
			cerrarNavegador();
		}
	}

	protected static void seleccionarCancion() {
		WebElement songLink = driver.findElement(By.xpath("//div[@class='mini_card-info']"));
		if(songLink.isDisplayed()) {
			songLink.click();
			System.out.print("Clic en Everlong de Top Result\n");
			
		} else {
			System.out.print("El titulo no es Everlong\n");
			cerrarNavegador();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement titleSong = driver.findElement(By.xpath("//div[@class='header_with_cover_art-primary_info']"));
		if(titleSong.isDisplayed()) {
			System.out.print("El titulo de la letra de la cancion es Everlong\n");
			
		} else {
			System.out.print("El titulo no es Everlong\n");
			cerrarNavegador();
		}
		WebElement artist = driver.findElement(By.xpath("//span[contains(@class, 'drop-target')]"));
		if(artist.isDisplayed()) {
			System.out.print("El artista de la cancion es Foo Fighters\n");
			
		} else {
			System.out.print("El artista no es Foo Fighters\n");
			cerrarNavegador();
		}
	}

	protected static void cerrarNavegador() {
		driver.close();
		
	}

}
