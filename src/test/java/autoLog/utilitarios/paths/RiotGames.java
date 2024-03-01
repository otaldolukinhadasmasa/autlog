package autoLog.utilitarios.paths;

import org.openqa.selenium.WebDriver;

import autoLog.utilitarios.WebSite;

public class RiotGames extends WebSite {
    //private final WebDriver navegador;

    public RiotGames(WebDriver navegador) {
        super("riotgames", navegador);
        //this.navegador = navegador;
    }
    
    public String urlString(){
        return "https://authenticate.riotgames.com/?client_id=prod-xsso-riotgames&code_challenge=A84WFsurlV6U2F0q8L8G6fR7wzPf2-o81PJ0b_sv5fw&method=riot_identity&platform=web&redirect_uri=https%3A%2F%2Fauth.riotgames.com%2Fauthorize%3Fclient_id%3Dprod-xsso-riotgames%26code_challenge%3DA84WFsurlV6U2F0q8L8G6fR7wzPf2-o81PJ0b_sv5fw%26code_challenge_method%3DS256%26redirect_uri%3Dhttps%253A%252F%252Fxsso.riotgames.com%252Fredirect%26response_type%3Dcode%26scope%3Dopenid%2520account%2520email%26state%3Da087a86734cefd868de1c8cff9&security_profile=low";
    }

    @Override
    public String getXPath1(){
        return "//input[@name='username' and @type='text']";
    }

    @Override
    public String getXPath2(){
        return "//input[@name='password' and @type='password']";
    }

    public String getXPathG(){
        return ""; 
    }
}

