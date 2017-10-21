package Heuristica;

public class Heuristica {
	
	private static int op;
	
	public Heuristica(int op) {
		this.op = op;
	}

	public static int heristica(int[][] atual, int[][] destino){
		int sum = 0;
		if(getOp() == 0){
			sum = manhattan(atual, destino);
		}else{
			sum = fora_do_lugar(atual, destino);
		}
		return sum;
	}
	
	public static int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

	public static int manhattan(int[][] atual, int[][] destino){
		int sum = 0;
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				int[] iDest = Puzzle.getIndex(atual[i][j], atual);
				sum += Math.abs(i - iDest[0]) + Math.abs(j - iDest[1]);
			}
		}
		return sum;
	}
	
	public static int fora_do_lugar(int[][] atual, int[][] destino){
		int sum = 0;
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				if(atual[i][j] != destino[i][j])
					sum++;
			}
		}
		return sum;
	}
}
