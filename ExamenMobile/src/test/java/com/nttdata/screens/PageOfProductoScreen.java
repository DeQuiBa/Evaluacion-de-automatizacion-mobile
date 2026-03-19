package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class PageOfProductoScreen extends PageObject {
    public void clickMenos() {

        WebElement botonMenos = getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector()" +
                        ".resourceId(\"com.saucelabs.mydemoapp.android:id/minusIV\"))"
        ));
        botonMenos.click();
    }

    public void clickMas() {
        WebElement botonMas = getDriver().findElement(AppiumBy.id(
                "com.saucelabs.mydemoapp.android:id/plusIV"
        ));
        botonMas.click();
    }

    public void clickCarrito() {
        WebElement botonCarrito = getDriver().findElement(AppiumBy.id(
                "com.saucelabs.mydemoapp.android:id/cartBt"
        ));
        botonCarrito.click();
    }

    public int obtenerUnidadesCarrito() {
        WebElement unidadesEnElCarrito = getDriver().findElement(
                AppiumBy.id("com.saucelabs.mydemoapp.android:id/noTV")
        );
        return Integer.parseInt(unidadesEnElCarrito.getText());
    }


    public void ClickIconoCarrito() {
        WebElement clickIcono = getDriver().findElement(AppiumBy.xpath(
                "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]"
        ));
        clickIcono.click();
    }

    public int ObtenerUnidadesAgregadas() {
        WebElement NumeroObtenido = getDriver().findElement(
                AppiumBy.id("com.saucelabs.mydemoapp.android:id/noTV"));
        return Integer.parseInt(NumeroObtenido.getText());
    }

}