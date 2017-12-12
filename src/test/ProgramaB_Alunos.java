package test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import comparators.SearchByAgeAndCity;
import comparators.SearchByEmail;
import comparators.SearchByName;
import datastructures.ListaEncadeada;
import model.Aluno;
import predicates.NamePredicate;

public class ProgramaB_Alunos {

	private static final String name = "Sherrie Rojas";
	private static final String email = "sherrierojas@menbrain.com";
	private static final int idade = 36 ;
	private static final String cidade = "Cloverdale";
	
	public static void main(String[] args) {
		Aluno procura = new Aluno(name, email, idade, cidade);
		
		FileReader arquivo = null;
		try {
			arquivo = new FileReader("data/alunos.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(arquivo);
		
		System.out.println(lista.search(procura,new SearchByName()));
		lista.removeIf(new NamePredicate(name));
		if (lista.search(procura, new SearchByName()) != null)
			System.out.println(name + " nao deveria estar na lista.");

		System.out.println(lista.search(procura, new SearchByEmail()));
		System.out.println(lista.search(procura,new SearchByAgeAndCity()));
	}

}
