package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import util.Pilha;

public class Corretora {

	private static final String HISTORICO_ORDENS_TXT = "HistoricoOrdens.txt";

	private BufferedReader reader;

	private Pilha<String> ordensEfetuadas = new Pilha<>();
	
	private static int idBase = 0;

	public Corretora() {
	}

	public void enviarOrdem(AbstratoAcao a, Investidor i) {
		i.adicionarPapel(a);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(HISTORICO_ORDENS_TXT), true));
			reader = new BufferedReader(new FileReader(HISTORICO_ORDENS_TXT));

			Character idChar = reader.readLine() == null ? null : reader.readLine().charAt(0);

			int id;

			if (idChar.equals(null)) {
				id = idBase++;
			} else {
				String linha;

				while ((linha = reader.readLine()) != null) {
					idChar = linha.charAt(0);
				}

				idBase = Integer.parseInt(idChar.toString());
				id = idBase++;
			}

			String ordem = id + ": Ordem " + ": " + a + " enviada para " + i;
			ordensEfetuadas.empilhar(ordem);

			writer.write("\n" + ordem);

			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removerUltimaOrdem() {
		String ultimaOrdem = ordensEfetuadas.desempilhar();
		System.out.println(ultimaOrdem + " removida com sucesso");
	}

	public void exibirOrdens() {
		System.out.println("Ordens efetuadas:");

		try {
			reader = new BufferedReader(new FileReader(HISTORICO_ORDENS_TXT));

			if (reader.readLine() == null) {
				System.out.println("Nenhuma ordem efetuada");
				return;
			}

			String linha;

			while ((linha = reader.readLine()) != null) {
				System.out.println(linha);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}
