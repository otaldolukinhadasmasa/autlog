package autoLog.entidades.entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Acoes {
    private String paramentro;
    private List<Atributos> file;
    private String caminhoOrigin;
    private String caminhoDestino;

    public Acoes(String paramentro, List<Atributos> file, String caminhoOrigin, String caminhoDestino) {
        this.paramentro = paramentro;
        this.file = file;
        this.caminhoOrigin = caminhoOrigin;
        this.caminhoDestino = caminhoDestino;
    }

    public void ler() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoOrigin))) {

            String line = br.readLine();
            while (line != null) {
                if (line.contains(paramentro)) {
                    String[] logins = line.split(":");
                    @SuppressWarnings("unused")
                    String descarte = logins[0];
                    String login = logins[1];
                    String senha = logins[2];

                    file.add(new Atributos(login, senha));

                    line = br.readLine();
                } else {
                    line = br.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println();
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
            throw new RuntimeException("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void escrever() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoDestino))) {
            for (Atributos login : file) {
                bw.write(login.getLogin() + ":" + login.getSenha());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
            throw new RuntimeException("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
}
