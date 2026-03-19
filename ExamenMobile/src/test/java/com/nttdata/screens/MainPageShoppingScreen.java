package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPageShoppingScreen extends PageObject {

        //Ingresamos a la aplicación
        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
        private WebElement paginaPrincipal;
        public boolean validarPantallaInicial() {
                return paginaPrincipal.isDisplayed();
        }

        //Vamos a comparar la carga del catalo como de las iamgenes de los productos
        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV")
        private WebElement catalogoDeProductos;
        public boolean CatalogoDeProductos(){return catalogoDeProductos.isDisplayed();}
        @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc]")
        private WebElement imagenesDeProductos;
        public boolean ImagenesDeProductos(){return imagenesDeProductos.isDisplayed();}

        //Obtenemos el Texto de los productos
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]")
        private List<WebElement> listaProductos;
        public List<String> obtenerTodosLosProductos() {
                List<String> todosLosProductos = new ArrayList<>();
                String ultimoProducto = "";
                //Hacemos un scroll hasta poder obtener el texto de todos los productos
                do {
                        for (WebElement p : listaProductos)
                                if (!todosLosProductos.contains(p.getText()))
                                        todosLosProductos.add(p.getText());

                        if (todosLosProductos.get(todosLosProductos.size()-1).equals(ultimoProducto)) break;

                        ultimoProducto = todosLosProductos.get(todosLosProductos.size()-1);

                        getDriver().findElement(AppiumBy.androidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
                } while (true);
                return todosLosProductos;
        }

        public void seleccionarImagenDelProducto(String producto) {

                // Scroll hasta que el producto sea visible en pantalla
                getDriver().findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"" + producto + "\"))"
                ));

                // Construimos el XPath que va del título como base al padre
                String xpath = "//android.widget.TextView[@resource-id=" +
                        "\"com.saucelabs.mydemoapp.android:id/titleTV\"" +
                        " and @text=\"" + producto + "\"]" +
                        "/parent::android.view.ViewGroup" +
                        "/android.widget.ImageView[@resource-id=" +
                        "\"com.saucelabs.mydemoapp.android:id/productIV\"]";

                // Hacemos clic en la imagen
                getDriver().findElement(By.xpath(xpath)).click();
        }
}