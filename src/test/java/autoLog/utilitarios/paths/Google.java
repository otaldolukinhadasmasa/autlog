/*package autoLog.utilitarios.paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import autoLog.utilitarios.PreencherGoogle;
import autoLog.utilitarios.WebSite;
import java.time.Duration;

public class Google extends WebSite implements PreencherGoogle {
    private final WebDriver navegador;
    private WebSite site;

    public Google(WebDriver navegador, WebSite site) {
        super("google", navegador);
        this.navegador = navegador;
        this.site = site;
    }

    public String urlString() {
        return "https://accounts.google.com/v3/signin/identifier?authuser=0&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Fu%2F0%2F%3Fhl%3Dpt-BR&ec=GAlAMQ&hl=pt-BR&service=writely&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S-737501081%3A1708739467659189&theme=glif";
    }

    @Override
    public String getXPath1() {
        return "/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input";
    }

    @Override
    public String getXPath2() {
        return "/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input";
    }

    @Override
    public void preencherGoogle() {
        navegador.get(site.urlString());

        // primeira caixa
        WebElement primeiraCaixa = waitUntilElementVisible(By.xpath(site.getXPath1()));
        primeiraCaixa.click();
        primeiraCaixa.sendKeys("login");

        // segunda caixa
        WebElement segundaCaixa = waitUntilElementVisible(By.xpath(site.getXPath2()));
        segundaCaixa.click();
        segundaCaixa.sendKeys("senha");
    }

    private WebElement waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        return wait.until(driver -> driver.findElement(locator));
    }
} */

package autoLog.utilitarios.paths;

import org.openqa.selenium.WebDriver;

import autoLog.utilitarios.WebSite;

public class Google extends WebSite {

    public Google(WebDriver navegador) {
        super("google",navegador);
    }

    @Override
    public String urlString() {
        return "https://accounts.google.com/";
    }

    @Override
    public String getXPath1() {
        return "//input[@id='identifierId']";
    }

    @Override
    public String getXPathG() {
        return "//span[text()='Avançar']";
    }

    @Override
    public String getXPath2() {
        return "//input[@type='password']";
    }
}
