package Heuristica;

import java.util.Iterator;
import java.util.LinkedList;
import Heuristica.Heuristica;

public class A_Search {
	
	public int busca(int[][] atual, int[][] dest, int op){
		int cont = 0;
		long itemp;
		long ftemp;
		Puzzle at = new Puzzle();
		Heuristica nh = new Heuristica(op);
		at.puzzle = atual;
		int g;
		int h;
		
		g = 0;
		h = nh.heristica(atual, dest);
		at.f = h + g;
		LinkedList<Puzzle> visitados = new LinkedList<>();
        visitados.add(at);
		while(true){
			System.out.println("ma");
            at.showPuzz();
			System.out.println();
			if(at.compareTo(at.puzzle, dest)){
				return cont;
			}
			LinkedList<Puzzle> filhos = at.filhos(at);
			cont++;
			System.out.println(cont);
			Puzzle menor = null;
			for(Puzzle f : filhos){
				if(f.compareTo(f.puzzle, dest)){
					at = f;
					return cont;
				}
				boolean pass = false;
				for(Puzzle p : visitados){
					if(p.compareTo(f.puzzle, p.puzzle)){
						pass = true;
						break;
					}
				}
				if(pass)
					continue;
				g = nh.heristica(at.puzzle, f.puzzle);
				h = nh.heristica(f.puzzle, dest);
				f.f = g + h;
				if(menor == null){
					menor = f;
				}else
					if(menor.f > f.f){
						menor = f;
					}
			}
			boolean inList = false;
			if(menor == null){
			    inList = true;
			    for (int i = 0; i < visitados.size(); i++){
			        if(at.equals(visitados.get(i))){
                        if(i >= 2)
                            menor = visitados.get(i - 1);
                        break;
                    }
                }
			}
			if(menor.compareTo(menor.puzzle, dest)){
				return cont;
			}
			at = menor;
			if(!inList){
                visitados.add(at);
            }
		}
	}
}
