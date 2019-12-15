package Android.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import junit.framework.Assert;

public class Parametric {
	public static WebDriver driver;
	String fecha = "19";
	String texTitle = "ASO Conference";
	String leyenda = "Studio Arte is a 6,500 Sq. Ft. all-purpose white loft space located in the Garment District steps from Port Authority and Penn Station. The venue features hardwood floors and windows offering beautiful natural daylight with an elegant night view"; 
	String phone = "Teléfono: +1 646-558-5860";
	String VNombre = "Valentina Olivares";
	String element = "";
	
	public void login(WebDriver driver) {
		
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 driver.findElement(By.id("com.uharris.wedding:id/nameEditText")).sendKeys("User1");
		 driver.findElement(By.id("com.uharris.wedding:id/lastNameEditText")).sendKeys("Apllido1");
		 driver.findElement(By.id("com.uharris.wedding:id/codeEditText")).sendKeys("230219"); //230219 - 012345
		 driver.findElement(By.id("com.uharris.wedding:id/logInButton")).click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void primero(WebDriver driver) {
		
		 login(driver); //Ejecuta el Login
		 
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 String strText = driver.findElement(By.id("com.uharris.wedding:id/dayTextView")).getText();
		 Assert.assertEquals("19", strText);
		 System.out.println("Confirmación Faltan " + strText+" días para el evento....OK");
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
		 String strText2 = driver.findElement(By.id("com.uharris.wedding:id/toolbar_title")).getText();
		 Assert.assertEquals(texTitle, strText2);
		 System.out.println("Confirmación de pantalla " + strText2+ "....OK");
		 
		//cambio de pag.//
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 WebElement posicion = driver.findElement(By.id("com.uharris.wedding:id/navigation_sites"));
		 posicion.click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 	 
		 driver.findElement(By.id("com.uharris.wedding:id/siteImage")).click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
		 
		 String texto = driver.findElement(By.id("com.uharris.wedding:id/siteDescription")).getText();
		 Assert.assertEquals(leyenda, texto);
		 System.out.println("Confirmación de leyenda....OK");
		 System.out.println("Fin del Test 1: Exitoso !!");
		 
		
	}
	
	
	
	public void comentario (WebDriver driver) {
		login(driver);
		
		driver.findElement(By.id("com.uharris.wedding:id/navigation_wishes")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	
		System.out.println("Verificaré si en la lista exite el nombre de: "+VNombre);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement validaNombre = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.TextView[1]"));
		String valida = validaNombre.getText();
		Assert.assertEquals(VNombre, valida);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("El nombre: " +valida+ " Sí existe en la lista !!");
		
		//Crea Deseo
		driver.findElement(By.id("com.uharris.wedding:id/action_create_wish")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//Escribe
		driver.findElement(By.id("com.uharris.wedding:id/wishEditText")).sendKeys("Awesome !!");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 
		 
		driver.findElement(By.id("com.uharris.wedding:id/sendButton")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		System.out.println("Fin del Test 2: Exitoso !!");
		
		


		
	}
	
	
	    
	
	

}
