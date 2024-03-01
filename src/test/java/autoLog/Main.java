package autoLog;

import java.util.Scanner;
import autoLog.funcoesLerEscrever.LerEscreverOperacao;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\lucas\\Documents\\Projetos\\drive\\msedgedriver.exe");

        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha a funcionalidade:");
        System.out.println("1. Funcionalidades da App");
        System.out.println("2. Funcionalidades da Automação");
        int opc = sc.nextInt();

        // Opcoes opcoes = new Opcoes(opc);
        // Funcoes funcao = new Funcoes();

        LerEscreverOperacao lerEscrever = new LerEscreverOperacao();
        // AutomaticaOperacao automatica = new AutomaticaOperacao();

        // Funcoes operacao = new LerEscreverOperacao();
        switch (opc) {
            case 1:
                lerEscrever.funcaoLerEscrever();
                break;
            case 2:
                lerEscrever.funcaoAutomatica();
                break;
            default:
                System.out.println("Opção inválida. Escolha 1 ou 2.");
                break;
        }

        sc.close();
    }
}
