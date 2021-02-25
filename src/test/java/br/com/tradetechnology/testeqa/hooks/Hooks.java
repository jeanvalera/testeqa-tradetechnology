package br.com.tradetechnology.testeqa.hooks;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

    private ScenarioContext scenarioContext;

    public Hooks(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void beforeAll() {
        scenarioContext.driver = buildFirefoxDriver();

        scenarioContext.wait = new WebDriverWait(scenarioContext.driver, 10);
    }

    @After
    public void afterAll() {
        scenarioContext.driver.close();
    }

    private WebDriver buildFirefoxDriver() {

        WebDriverManager.firefoxdriver().setup();

        Path resourceDirectory = Paths.get("src", "test", "resources");

        FirefoxOptions options = new FirefoxOptions();

        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", resourceDirectory.toFile().getAbsolutePath());
        options.addPreference("browser.download.useDownloadDir", true);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        options.addPreference("pdfjs.disabled", true);

        return new FirefoxDriver(options);

    }

}
