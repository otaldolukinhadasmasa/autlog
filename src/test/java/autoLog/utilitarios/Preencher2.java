package autoLog.utilitarios;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import autoLog.entidades.entidades.Acoes;
import autoLog.entidades.entidades.Atributos;
import autoLog.entidades.entidades.Caminhos;

import java.time.Duration;

public class Preencher2 {
    private String webSite;
    private WebSite site;
    private WebDriver navegador;
    private List<Atributos> file;
    private String caminhoDestino;

    List<Atributos> fileV = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public Preencher2() {

    }

    public Preencher2(WebDriver navegador, List<Atributos> file, WebSite site, String webSite, String caminhoDestino) {
        this.webSite = webSite;
        this.file = file;
        this.site = site;
        this.navegador = navegador;
        this.caminhoDestino = caminhoDestino;
    }

    public void preencher() {
        char valorValido = 's';
        if (webSite == "google") {
            // if (!"google".equalsIgnoreCase(webSite)) {
            do {
                for (Atributos login : file) {
                    navegador.get(site.urlString());

                    // primeira caixa
                    WebElement primeiraCaixa = waitUntilElementVisible(By.xpath(site.getXPath1()));
                    primeiraCaixa.click();
                    primeiraCaixa.sendKeys(login.getLogin());
                    primeiraCaixa.sendKeys(Keys.ENTER);

                    // caixa "avancar"
                    // WebElement avancarElement =
                    // waitUntilElementVisible(By.xpath(site.getXPathG()));
                    // avancarElement.click();

                    // segunda caixa
                    WebElement segundaCaixa = waitUntilElementVisible(By.xpath(site.getXPath2()));
                    segundaCaixa.click();
                    segundaCaixa.sendKeys(login.getSenha());
                }
            } while (valorValido != 's');
        } else {
            do {
                for (Atributos login : file) {
                    navegador.get(site.urlString());

                    if (valorValido == 's') {
                        System.out.println("Preenchido!!");
                    }

                    // primeira caixa
                    WebElement primeiraCaixa = waitUntilElementVisible(By.xpath(site.getXPath1()));
                    primeiraCaixa.click();
                    primeiraCaixa.sendKeys(login.getLogin());

                    // segunda caixa
                    WebElement segundaCaixa = waitUntilElementVisible(By.xpath(site.getXPath2()));
                    segundaCaixa.click();
                    segundaCaixa.sendKeys(login.getSenha());

                    System.out.println("Proximo login?");
                    System.out.println("s - Continuar sem salvar login.");
                    System.out.println("a - Salvar login e continuar.");
                    valorValido = sc.next().charAt(0);

                    if (valorValido == 'a') {
                        String loginV = login.getLogin();
                        String senhaV = login.getSenha();
                        fileV.add(new Atributos(loginV, senhaV));

                        valorValido = 's';
                    }
                }
            } while (valorValido != 's');
        }
        System.out.println("Acabou as linhas! Programa encerrado.");

        Acoes acoes = new Acoes(caminhoDestino, file, webSite, caminhoDestino);
        acoes.escrever(fileV);
    }

    private WebElement waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
