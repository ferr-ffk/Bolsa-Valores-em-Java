package main;

import modelo.Corretora;
import modelo.Empresa;
import modelo.Investidor;

public class Main {

    public static void main (String[] args) {

    	Investidor investidor = new Investidor(1935839, "Ugo Henrique", 13_000);

    	Corretora corretora = new Corretora("Forex", 1935042);

    	Corretora.setCaminhoArquivo("C:\\Program Files\\Notas\\Fernando");
    	
    	Empresa.setCaminhoArquivo("C:\\Program Files\\Notas\\Fernando");
    	
    	System.out.println(Empresa.obterEmpresa(3));
    	
    	Empresa.exibirEmpresas();
    	
    }
}