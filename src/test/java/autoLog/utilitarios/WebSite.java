package autoLog.utilitarios;

import org.openqa.selenium.WebDriver;

import autoLog.utilitarios.paths.Facebook;
import autoLog.utilitarios.paths.Google;
import autoLog.utilitarios.paths.Instagram;
import autoLog.utilitarios.paths.RiotGames;

public abstract class WebSite {
    private WebDriver navegador;
    @SuppressWarnings("unused")
    private String site;

    public WebSite(String site, WebDriver navegador) {
        this.navegador = navegador;
        this.site = site;
    }

    public WebSite() {
    }

    public static WebSite createWebsite(String webSite, WebDriver navegador) {
        switch (webSite.toLowerCase()) {
            case "facebook":
                return new Facebook(navegador);
            case "instagram":
                return new Instagram(navegador);
            case "google":
                return new Google(navegador);
            case "riot":
                return new RiotGames(navegador);
            default:
                return null;
        }
    }

    public void getUrl() {
        navegador.get(urlString());
    }

    public abstract String urlString();

    public abstract String getXPath1();

    public abstract String getXPathG();

    public abstract String getXPath2();

    public String getXpathG() {
        return "";
    }
}
