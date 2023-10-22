package main;

import modelo.Corretora;
import modelo.Empresa;
import modelo.Investidor;
import modelo.TipoAcaoEmpresa;

public class Main {

    public static void main (String[] args) {

    	Investidor investidor = new Investidor(1935839, "Ugo Henrique", 13_000);

    	Corretora corretora = new Corretora("Forex", 1935042);

    	Empresa empresa = new Empresa("COMPASS", "PASS5", 100, 120, TipoAcaoEmpresa.ACAO_FII);
    	
    	Corretora.setCaminhoArquivo("C:\\Program Files\\Notas\\Fernando");
    	
    	Empresa.setCaminhoArquivo("C:\\Program Files\\Notas\\Fernando");
    	
    	corretora.enviarOrdem(empresa.obterAcao(), investidor, empresa);
    	
    	Empresa.exibirEmpresas();
    }
}