package autoLog.utilitarios.paths;

import org.openqa.selenium.WebDriver;

import autoLog.utilitarios.WebSite;

public class Instagram extends WebSite {
    //private final WebDriver navegador;

    public Instagram(WebDriver navegador) {
        super("instagram", navegador);
        //this.navegador = navegador;
    }

    public String urlString() {
        return "https://www.instagram.com/accounts/login/?next=%2Fexplore%2F&source=desktop_nav";
    }

    @Override
    public String getXPath1() {
        return "//input[@name='username' and @type='text']";
    }

    @Override
    public String getXPath2() {
        return "//input[@name='password' and @type='password']";
    }

    public String getXPathG(){
        return "";
    }
}
