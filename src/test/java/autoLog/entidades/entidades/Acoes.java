package autoLog.entidades.entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Acoes {
    private String paramentro;
    private List<Atributos> file;
    private String caminhoOrigin;
    private String caminhoDestino;

    public Acoes() {

    }

    public Acoes(String paramentro, List<Atributos> file, String caminhoOrigin, String caminhoDestino) {
        this.paramentro = paramentro;
        this.file = file;
        this.caminhoOrigin = caminhoOrigin;
        this.caminhoDestino = caminhoDestino;
    }

    public void ler() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoOrigin))) {

            /*
             * String line = br.readLine();
             * while (line != null) {
             * if (line.contains(paramentro)) {
             * String[] logins = line.split(":");
             * // @SuppressWarnings("unused")
             * String descarte = logins[0];
             * String descart1 = logins[1];
             * // System.out.println("Linha antes da divisão: " + line);
             * String login = logins[2];
             * String senha = logins[3];
             * 
             * file.add(new Atributos(login, senha));
             * 
             * line = br.readLine();
             * } else {
             * line = br.readLine();
             * }
             * }
             */
            int fail = 0;
            int valid = 0;

            String line = br.readLine();

            while (line != null) {
                try {
                    if (line.contains(paramentro)) {
                        String[] parts = line.split(":");
                        if (parts.length >= 4) {
                            String login = parts[2];
                            String senha = parts[3];

                            // Exibir para debug
                            System.out.println(line);
                            System.out.println("login: " + login);
                            System.out.println("senha: " + senha);

                            valid++;

                            file.add(new Atributos(login, senha));
                        } else {
                            System.out.println("Erro: Não foi possível dividir a linha corretamente - " + line);
                            fail++;
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("Erro: Linha nula");
                }
                line = br.readLine();
            }

            System.out.println("Linhas nao lidas: " + fail);
            System.out.println("Linhas lidas com sucesso: " + valid);

        } catch (IOException e) {
            System.out.println();
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
            throw new RuntimeException("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void escrever(List<Atributos> lista) {
        System.out.println(caminhoDestino);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoDestino))) {
            for (Atributos login : lista) {
                bw.write(login.getLogin() + ":" + login.getSenha());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
            throw new RuntimeException("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
}
