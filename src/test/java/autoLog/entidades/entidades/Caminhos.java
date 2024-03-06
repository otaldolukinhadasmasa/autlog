package autoLog.entidades.entidades;

import java.io.File;

public class Caminhos {
    private String nomeArq;
    private String paramentro;

    public Caminhos(String nomeArq, String paramentro) {
        this.nomeArq = nomeArq;
        this.paramentro = paramentro;
    }

    public String caminhoOrigin() {
        return "C:\\Users\\lucas\\Documents\\" + nomeArq + ".txt";
    }

    public String novoArq() {
        File novoArq = new File(caminhoOrigin());

        String diretorioPai = novoArq.getParent();

        return diretorioPai;
    }

    public String caminhoDestino() {
        String caminhoDestino = novoArq() + "\\" + paramentro;

        return caminhoDestino;
    }

}
