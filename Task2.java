package b2w_Projeto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Task2 {


	public static void main(String[] args) {
		
		
		
		int valor = Integer.parseInt(args[0]);
		
		
		String numeroChar =  String.valueOf(valor);
		
		char[] status = numeroChar.toCharArray(); //aqui pode ser qualquer objeto que implemente Comparable
		List<SortedSet<Comparable>> allCombList = new ArrayList<SortedSet<Comparable>>(); //aqui vai ficar a resposta
		for (char nstatus : status) {
			allCombList.add(new TreeSet<Comparable>(Arrays.asList(nstatus))); //insiro a combinação "1 a 1" de cada item
		}
		
		for (int nivel = 1; nivel < status.length; nivel++) { 
			List<SortedSet<Comparable>> statusAntes = new ArrayList<SortedSet<Comparable>>(allCombList); //crio uma cópia para poder não iterar sobre o que já foi
			for (Set<Comparable> antes : statusAntes) {
				SortedSet<Comparable> novo = new TreeSet<Comparable>(antes); //para manter ordenado os objetos dentro do set
				novo.add(status[nivel]);
				if (!allCombList.contains(novo)) { //testo para ver se não está repetido
					allCombList.add(novo);
				}
			}
		}
		
		Collections.sort(allCombList, new Comparator<SortedSet<Comparable>>() { //aqui só para organizar a saída de modo "bonitinho"
			@Override
			public int compare(SortedSet<Comparable> o1, SortedSet<Comparable> o2) {
				int sizeComp = o1.size() - o2.size();
				
				System.out.println("Ver SizeComp: "+sizeComp);
				if (sizeComp == 0) {
					Iterator<Comparable> o1iIterator = o1.iterator();
					Iterator<Comparable> o2iIterator = o2.iterator();
					while (sizeComp == 0 && o1iIterator.hasNext() ) {
						sizeComp = o1iIterator.next().compareTo(o2iIterator.next());
					}
				}
				return sizeComp;
			}
		});
		System.out.println(allCombList);
	
	}
		
}
