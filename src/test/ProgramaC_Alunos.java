package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import comparators.SearchByAgeAndCity;
import comparators.SearchByEmail;
import comparators.SearchByName;
import datastructures.ListaEncadeada;
import model.Aluno;

public class ProgramaC_Alunos {

	private static final String name = "Sherrie Rojas";
	private static final String email = "sherrierojas@menbrain.com";
	private static final int idade = 36 ;
	private static final String cidade = "Cloverdale";
	
	public static void main(String[] args) {
		FileReader arquivo = null;
		try {
			arquivo = new FileReader("data/alunos.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(arquivo);
		
		Aluno procura = new Aluno(name, email, idade, cidade);
		
		System.out.println(lista.search(procura, new SearchByName()));
		System.out.println(lista.search(procura, new SearchByEmail()));
		System.out.println(lista.search(procura, new SearchByAgeAndCity()));
	}

}
