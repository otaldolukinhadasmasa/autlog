package autoLog.funcoesLerEscrever;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import autoLog.entidades.entidades.Acoes;
import autoLog.entidades.entidades.Atributos;
import autoLog.entidades.entidades.Caminhos;
import autoLog.utilitarios.Preencher2;
import autoLog.utilitarios.WebSite;

public class LerEscreverOperacao extends Funcoes {
    @Override
    public void funcaoLerEscrever() {
        Scanner sc = new Scanner(System.in);

        List<Atributos> file = new ArrayList<>();
        boolean valorValido = false;

        do {
            try {
                System.out.println("Informe o nome do arquivo: ");
                String nomeArq = sc.nextLine();

                System.out.println("Informe o paramentro de busca: ");
                String paramentro = sc.nextLine();

                Caminhos caminho = new Caminhos(nomeArq, paramentro);

                String caminhoOrigin = caminho.caminhoOrigin();
                String caminhoDestino = caminho.caminhoDestino();

                Acoes acoes = new Acoes(paramentro, file, caminhoOrigin, caminhoDestino);

                acoes.ler();

                acoes.escrever();

                valorValido = true;

                System.out.println("Sucesso!");

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Tente novamente.");
                valorValido = false;
            }
        } while (!valorValido);

        sc.close();
    }

    @Override
    public void funcaoAutomatica() {
        Scanner sc = new Scanner(System.in);

        List<Atributos> file = new ArrayList<>();
        boolean valorValido = false;

        do {
            try {
                System.out.println("Informe o nome do arquivo: ");
                String nomeArq = sc.nextLine();

                System.out.println("Informe o paramentro de busca: ");
                String paramentro = sc.nextLine();

                Caminhos caminho = new Caminhos(nomeArq, paramentro);

                String caminhoOrigin = caminho.caminhoOrigin();
                String caminhoDestino = caminho.caminhoDestino();

                Acoes acoes = new Acoes(paramentro, file, caminhoOrigin, caminhoDestino);

                acoes.ler();

                valorValido = true;

                System.out.println("Lido com sucesso!");

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Tente novamente.");
                valorValido = false;
            }
        } while (!valorValido);

        System.out.println("Informe o site:");
        String webSite = sc.nextLine();

        System.out.println("------------------------------------------------");
        System.out.println("Carregando site...");

        // Create Edge driver
        WebDriver navegador = new EdgeDriver();
        WebSite site = WebSite.createWebsite(webSite, navegador);

        if (site != null) {
            site.getUrl();
        } else {
            System.out.println("Website não encontrado.");
        }

        Preencher2 preencher = new Preencher2(navegador, file, site, webSite);
        preencher.preencher();

        sc.close();
    }
}
