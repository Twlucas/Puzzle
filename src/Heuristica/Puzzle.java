package Heuristica;
import java.util.LinkedList;

public class Puzzle {
	public int [][] puzzle;
	public Puzzle anterior;
	public int f = 0;

	public void showPuzz(){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(this.puzzle[i][j]+", ");
			}
			System.out.println();
		}
	}
	
	public boolean compareTo(int[][] at, int[][] dest){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(at[i][j] != dest[i][j])
					return false;
			}
		}
		return true;
	}
	
	public LinkedList<Puzzle> filhos(Puzzle p){
		int[] indice = getIndex(0, p.puzzle);
		int x = indice[0];
		int y = indice[1];
		int[][] up = new int[3][3];
		int[][] down = new int[3][3];
		int[][] right = new int[3][3];
		int[][] left = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				up[i][j] = p.puzzle[i][j];
				down[i][j] = p.puzzle[i][j];
				right[i][j] = p.puzzle[i][j];
				left[i][j] = p.puzzle[i][j];
			}
		}
		LinkedList<Puzzle> filhos = new LinkedList<Puzzle>();
		if(y <= 1){
			right[x][y] = right[x][y + 1];
			right[x][y + 1] = 0;
			Puzzle pi = new Puzzle();
			pi.puzzle = right;
			pi.anterior = p;
			filhos.add(pi);			
		}
		if(y >= 1){
			left[x][y] = left[x][y - 1];
			left[x][y - 1] = 0;
			Puzzle pi = new Puzzle();
			pi.puzzle = left;
			pi.anterior = p;
			filhos.add(pi);			
		}
		if(x <= 1){
			down[x][y] = down[x + 1][y];
			down[x + 1][y] = 0;
			Puzzle pi = new Puzzle();
			pi.puzzle = down;
			pi.anterior = p;
			filhos.add(pi);			
		}
		if(x >= 1){
			up[x][y] = up[x - 1][y];
			up[x - 1][y] = 0;
			Puzzle pi = new Puzzle();
			pi.puzzle = up;
			pi.anterior = p;
			filhos.add(pi);			
		}
		return filhos;
	}
	
	public static int[] getIndex(int num, int[][] p){
		int[] indice = new int[2];
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if(p[i][j] == num){
					indice[0] = i;
					indice[1] = j;
					return indice;
				}
			}
		}
		return null;		
	}
}
