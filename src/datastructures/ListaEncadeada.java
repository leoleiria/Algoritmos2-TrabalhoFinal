package datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;

import interfaces.Predicado;
import model.Aluno;
import predicates.NamePredicate;


public class ListaEncadeada<T> {
	private ListNode<T> head;
	private ListNode<T> tail;
	
	private static class ListNode<T>{
		private T dados;
		private ListNode<T> proximo;
		private ListNode<T> anterior;
		public ListNode(T dados){
			this.dados = dados;
			this.proximo = null;
			this.anterior = null;
		}
		public void remove() {
			if(this.anterior.proximo != null){
				this.anterior.proximo = this.proximo;
			}
			if(this.proximo.anterior != null){
				this.proximo.anterior = this.anterior;
			}
			
		}
	}
	public void append(T dado){
		ListNode<T> novo = new ListNode<>(dado);
		if (tail != null){
			novo.anterior = tail;
			tail.proximo = novo;
		}else{
			head = novo;
		}
		tail = novo;
	}
	public void addFirst(T dado){
		ListNode<T> novo = new ListNode<>(dado);
		if (head != null){
			novo.proximo = head;
			head.anterior = novo;
		}else{
			tail = novo;
		}
		head = novo;
	}
	public T search(T procura, Comparator<T> cmp){
		ListNode<T> i = head;
		while(i != null){
			if(cmp.compare(procura, i.dados) == 0) {
				return i.dados;
			}
            i = i.proximo;
}
		return null;
	}
	public void printObjects(){
		int contador = 0;
		ListNode<T> i = head;
		while(i!=null){
			System.out.println(contador+". "+i.dados);
			contador++;
			i = i.proximo;
		}
	}
	
	public static  ListaEncadeada<Aluno> loadFromFile(FileReader arquivo){
		ListaEncadeada<Aluno> lista = new ListaEncadeada<>();
		Scanner sc;
		try {
			sc = new Scanner(new File("data/alunos.csv"));
			// Altera o delimitador do scanner para
			// vírgula ou "nova linha" (\n).
			sc.useDelimiter("[,\n]");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
			return null;
		}
		
		while (sc.hasNext()) {
			Aluno p = new Aluno(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.next().charAt(0),sc.next(),sc.next());
			lista.append(p);
		}
		
sc.close();
		
		
		return lista;
	}
	
	public T select(int selected){
		int contador = 0;
		ListNode<T> i = head;
		while(i!=null){
			if (contador==selected){
			return i.dados;
			}
			contador++;
			i = i.proximo;
		}
		return null;
}
	public void removeIf(Predicado<T> namePredicate) {
		ListNode<T> i = head;
		while(i != null){
			if(namePredicate.teste(i.dados)==true) {
				i.remove();
				if(i == head){
					i.proximo = head;
				}
				if(i == tail){
					i.anterior = tail;
				}
			}
            
}
	}
}