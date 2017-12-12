package comparators;

import java.util.Comparator;


import model.Aluno;

public class SearchByName implements Comparator<Aluno> {

	
	
	public int compare(Aluno o1, Aluno o2) {
		
		
			if(o1.getNome().equals(o2.getNome())) {
				return 0;
			}
		
		
		return -1;
	}

}