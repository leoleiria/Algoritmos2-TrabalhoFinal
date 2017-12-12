package comparators;

import java.util.Comparator;

import model.Aluno;

public class SearchByEmail implements Comparator<Aluno> {
	

public int compare(Aluno o1, Aluno o2) {
		
		if(o1.getIdade() == o2.getIdade()) {
			if(o1.getEmail().equals(o2.getEmail())) {
				return 0;
			}
		}
		
		return -1;
	}

}