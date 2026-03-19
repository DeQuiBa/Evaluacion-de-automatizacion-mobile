package com.nttdata.steps;


import com.nttdata.screens.MainPageShoppingScreen;
import com.nttdata.screens.PageOfProductoScreen;
import net.serenitybdd.annotations.Steps;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.core.Serenity.getDriver;


public class ShoppingStesp {
    @Steps
    MainPageShoppingScreen mainpage;
    @Steps
    PageOfProductoScreen pageOfProductoScreen;

    private int unidades;

    // En tu AppiumConfig o BaseTest

    public void estoyEnLaAplicaciónDeSauceLabs() {
        //Espera implicita
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        boolean isOnInitialScreen = wait.until(driver -> mainpage.validarPantallaInicial());
        if (!isOnInitialScreen)
            throw new AssertionError("No se encuentra en la pantalla inicial de SauceDemo");
        System.out.println("Ingreso a la pagina de manera exitos");
    }

    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        //Vemos si se encontro el catalogo
        boolean isCatalogScreen = wait.until(driver -> mainpage.CatalogoDeProductos());
        //Vemos si aparecen las imagenes de los productos
        boolean isImageOfProduct = wait.until(driver -> mainpage.ImagenesDeProductos());

        if(isCatalogScreen && isImageOfProduct) {
            System.out.println("Productos detectados en el Catalogo");
        } else {
            throw new AssertionError("No se encontraron los productos");
        }
    }

    public void agregoUNIDADESDelSiguienteProducto(int unidades, String producto) {
        this.unidades = unidades;
        List<String> productos = mainpage.obtenerTodosLosProductos();
        if (!productos.contains(producto))
            throw new AssertionError("Producto no encontrado: " + producto);
        //Seleccionamos la imagen del producto encontrado
        mainpage.seleccionarImagenDelProducto(producto);
        //Loop para añadir las unidade
        pageOfProductoScreen.clickMenos();
        for (int i = 0; i < unidades; i++) {
            pageOfProductoScreen.clickMas();
        }
        //hacemos clic al carrito
        pageOfProductoScreen.clickCarrito();
    }

    public void validoElCarritoDeCompraActualiceCorrectamente() {
        int ValoCarrito= pageOfProductoScreen.obtenerUnidadesCarrito();
        if(unidades == ValoCarrito){
            System.out.println("Se valida que el carrito tiene la misma cantidad que las unidades");
        }else {
            throw new  AssertionError("Valores diferentes");
        }
        pageOfProductoScreen.ClickIconoCarrito();
    }
}
