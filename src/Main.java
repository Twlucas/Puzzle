import Heuristica.A_Search;

public class Main{
	public static void main(String[] args){
		A_Search a = new A_Search();
		//int[][] mi = {{2,3,1},{0, 5, 6},{4, 7, 8}};
		int[][] mi = {{0,1,2},{3, 4, 5},{6, 7, 8}};
		int[][] mf = {{1, 2, 3},{4, 5, 6},{7, 8, 0}};
		System.out.println("\nIteracoes:"+a.busca(mi, mf, 0));
	}
}
