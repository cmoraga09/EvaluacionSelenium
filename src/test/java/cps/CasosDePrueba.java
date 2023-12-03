package cps;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
    public void CP001_crear_cuenta_nueva() throws InterruptedException {

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
    public void CP002_validar_mensaje_creacion_cuenta_existente() throws InterruptedException {

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
    //@Disabled
    @Test
    @Order(4)
    public void CP004_validar_mensaje_agregar_producto_carro() throws InterruptedException {

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

    //@Disabled
    @Test
    @Order(5)
    public void CP005_comprar_producto_carro() throws InterruptedException {

        By localizadorMiCuenta = By.xpath(" //span[@class='caret']");
        Thread.sleep(2000);
        WebElement btnMiCuenta = driver.findElement(localizadorMiCuenta);
        Thread.sleep(1000);
        btnMiCuenta.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("cmoraga.ochoa@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@id='cart-total']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//strong[normalize-space()='Checkout']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(" //input[@value='new']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='input-payment-firstname']")).sendKeys("Carolina");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='input-payment-lastname']")).sendKeys("Riquelme");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='input-payment-address-1']")).sendKeys("Los Alerces 123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='input-payment-city']")).sendKeys("Temuco");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='input-payment-postcode']")).sendKeys("156789");
        Thread.sleep(1000);

        Select dropdownPais = new Select (driver.findElement(By.xpath("//select[@id='input-payment-country']")));
        dropdownPais.selectByIndex(47);
        Thread.sleep(2000);

        Select dropdownRegion = new Select (driver.findElement(By.xpath("//select[@id='input-payment-zone']")));
        dropdownRegion.selectByIndex(3);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='button-payment-address']")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Pago mediante cuenta corriente BCI 156789");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='button-payment-method']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='button-confirm']")).click();
        Thread.sleep(2000);


        String resultadoEsperado = "Your order has been placed!";
        Thread.sleep(2000);
        String resultadoActual = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been placed!']")).getText();
        Thread.sleep(1000);
        System.out.println("Esperado: "+ resultadoEsperado);
        System.out.println("Actual: "+ resultadoActual);
        Assertions.assertEquals(resultadoEsperado, resultadoActual);


    }
}


