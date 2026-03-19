package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ShoppingStesp;
import net.serenitybdd.annotations.Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartShoppingDefSteps {

    @Steps
    ShoppingStesp shoppingStesp;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        shoppingStesp.estoyEnLaAplicaciónDeSauceLabs();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        shoppingStesp.validoQueCarguenCorrectamenteLosProductosEnLaGaleria();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoUNIDADESDelSiguienteProducto(int unidades, String producto) {
        shoppingStesp.agregoUNIDADESDelSiguienteProducto(unidades, producto);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        shoppingStesp.validoElCarritoDeCompraActualiceCorrectamente();
    }
}