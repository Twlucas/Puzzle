package Heuristica;

import java.util.LinkedList;
import Heuristica.Heuristica;
import java.util.concurrent.TimeUnit;

public class A_Search {
	
	public int busca(int[][] atual, int[][] dest, int op){
		int cont = 0;
		long itemp = System.nanoTime();
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
			//System.out.println("ma");
            //at.showPuzz();
			//System.out.println();
			if(at.compareTo(at.puzzle, dest)){
				long ftemp = System.nanoTime();
				long time = ftemp - itemp;
				System.out.printf("Tempo total: "+ String.format("%d min, %d sec",TimeUnit.NANOSECONDS.toHours(time),
						TimeUnit.NANOSECONDS.toSeconds(time) -
								TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(time))));
				return cont;
			}
			LinkedList<Puzzle> filhos = at.filhos(at);
			cont++;
			//System.out.println(cont);
			Puzzle menor = null;
			for(Puzzle f : filhos){
				if(f.compareTo(f.puzzle, dest)){
					long ftemp = System.nanoTime();
					long time = ftemp - itemp;
					System.out.printf("Tempo total: "+ String.format("%d min, %d sec",TimeUnit.NANOSECONDS.toHours(time),
							TimeUnit.NANOSECONDS.toSeconds(time) -
									TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(time))));
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
				long ftemp = System.nanoTime();
				long time = ftemp - itemp;
				System.out.printf("Tempo total: "+ String.format("%d min, %d sec",TimeUnit.NANOSECONDS.toHours(time),
						TimeUnit.NANOSECONDS.toSeconds(time) -
								TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(time))));
				return cont;
			}
			at = menor;
			if(!inList){
                visitados.add(at);
            }
		}

	}
}
