package br.com.tradetechnology.testeqa.context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.tradetechnology.testeqa.dto.Product;
import br.com.tradetechnology.testeqa.dto.ProductStatus;

public class ScenarioContext {

    public WebDriver driver;
    public WebDriverWait wait;
    public int galacticCredits;
    public Product product;
    public String searchedProductName;
    public ProductStatus searchedProductStatus;
    
}
