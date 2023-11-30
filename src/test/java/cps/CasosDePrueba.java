package cps;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CasosDePrueba {

    WebDriver driver; //null
    JavascriptExecutor js; //null

    String rutaProyecto = System.getProperty("user.dir"); //no es de la prueba

    String rutaDriver = rutaProyecto + "\\src\\test\\resources\\drivers\\chromedriver.exe";

    @BeforeEach
    public void preCondiciones(){
        System.setProperty("webdriver.chrome.driver", rutaDriver); //enlace al browser
        driver = new ChromeDriver(); //se instancia el navegador

        js = (JavascriptExecutor) driver; //instancia el ejecutor JS

        driver.get("http://opencart.abstracta.us/"); //carga la pagina

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @AfterEach

    public void posCondiciones(){
        driver.quit();
    }



    @Disabled
    @Test
    @Order(1)
    public void CP001_validar_creacion_cuenta_nueva() throws InterruptedException {

        By localizadorMiCuenta = By.xpath(" //span[@class='caret']");
        Thread.sleep(2000);
        WebElement btnMiCuenta = driver.findElement(localizadorMiCuenta);
        Thread.sleep(2000);
        btnMiCuenta.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        Thread.sleep(2000);


        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Cristian");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Moraga");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("correo001@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9977695476");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(2000);

        String resultadoEsperado = "Congratulations! Your new account has been successfully created!";
        Thread.sleep(2000);
        String resultadoActual = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")).getText();
        System.out.println("Esperado: "+ resultadoEsperado);
        System.out.println("Actual: "+ resultadoActual);
        Assertions.assertEquals(resultadoEsperado, resultadoActual);



    }

    @Disabled
    @Test
    @Order(2)
    public void CP002_validar_creacion_cuenta_antigua() throws InterruptedException {

        By localizadorMiCuenta = By.xpath(" //span[@class='caret']");
        Thread.sleep(2000);
        WebElement btnMiCuenta = driver.findElement(localizadorMiCuenta);
        Thread.sleep(2000);
        btnMiCuenta.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        Thread.sleep(2000);


        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Cristian");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Moraga");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("cmoraga.ochoa@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9977695476");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(2000);

        String resultadoEsperado = "Warning: E-Mail Address is already registered!";
        String resultadoActual = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        System.out.println("Esperado: "+ resultadoEsperado);
        System.out.println("Actual: "+ resultadoActual);
        Assertions.assertEquals(resultadoEsperado, resultadoActual);

        //p[contains(text(),'Congratulations! Your new account has been success')]


    }

    @Disabled
    @Test
    @Order(3)
    public void CP003_validar_login_correcto() throws InterruptedException {

        By localizadorMiCuenta = By.xpath(" //span[@class='caret']");
        Thread.sleep(2000);
        WebElement btnMiCuenta = driver.findElement(localizadorMiCuenta);
        Thread.sleep(2000);
        btnMiCuenta.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("cmoraga.ochoa@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(2000);

        String resultadoEsperado = "My Account";
        Thread.sleep(2000);
        String resultadoActual = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).getText();
        Thread.sleep(1000);
        System.out.println("Esperado: "+ resultadoEsperado);
        System.out.println("Actual: "+ resultadoActual);
        Assertions.assertEquals(resultadoEsperado, resultadoActual);

    }

    @Test
    @Order(4)
    public void CP004_agregar_producto_carro() throws InterruptedException {

        By localizadorMiCuenta = By.xpath(" //span[@class='caret']");
        Thread.sleep(2000);
        WebElement btnMiCuenta = driver.findElement(localizadorMiCuenta);
        Thread.sleep(2000);
        btnMiCuenta.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("cmoraga.ochoa@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='image']//img[@title='MacBook']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='button-cart']")).click();
        Thread.sleep(2000);


        String resultadoEsperado = "Success: You have added MacBook to your shopping cart!";
        Thread.sleep(2000);
        String resultadoActual = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        Thread.sleep(1000);
        System.out.println("Esperado: "+ resultadoEsperado);
        System.out.println("Actual: "+ resultadoActual);
        Assertions.assertEquals(resultadoEsperado, resultadoActual.substring(0,54));


    }

    @Test
    @Order(5)
    public void CP005_comprar_producto_carro() throws InterruptedException {

        By localizadorMiCuenta = By.xpath(" //span[@class='caret']");
        Thread.sleep(2000);
        WebElement btnMiCuenta = driver.findElement(localizadorMiCuenta);
        Thread.sleep(2000);
        btnMiCuenta.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("cmoraga.ochoa@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='image']//img[@title='MacBook']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='button-cart']")).click();
        Thread.sleep(2000);


        String resultadoEsperado = "Success: You have added MacBook to your shopping cart!";
        Thread.sleep(2000);
        String resultadoActual = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        Thread.sleep(1000);
        System.out.println("Esperado: "+ resultadoEsperado);
        System.out.println("Actual: "+ resultadoActual);
        Assertions.assertEquals(resultadoEsperado, resultadoActual.substring(0,54));


    }
}


/*
        driver.findElement(By.id("login-username")).sendKeys("emailTest123456789@algo.com");

        Thread.sleep(1000);

        driver.findElement(By.id("login-password")).sendKeys("Frre3232");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-testid='login-button']")).click();
        Thread.sleep(2000);
        String username = driver.findElement(By.xpath("//button[@data-testid='user-widget-link']")).getAttribute("aria-label");

        Assertions.assertEquals("Curso Falabella Selenium",username); */