package june_14;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < m; i++) {
			for(int j = 0 ; j < n; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		
		spiralc(arr);
		System.out.println("END");
		
	}

	private static void spiralc(int[][] arr) {

		int rmin = 0;
		int rmax = arr.length - 1;
		int cmin = 0;
		int cmax = arr[0].length - 1;
		
		while(rmin <= rmax && cmin <= cmax) {
			for(int c = cmin; c<= cmax; c++) {
				System.out.print(arr[rmin][c] + "," + " ");
			}
			rmin++;
			
			for(int r = rmin; r<= rmax && rmin <= rmax && cmin <= cmax; r++) {
				System.out.print(arr[r][cmax] + "," + " ");
			}
			cmax--;
			for(int c = cmax; c >= cmin ; c--) {
				System.out.print(arr[rmax][c] + "," + " ");
			}
			rmax--;
			for(int r = rmax; r >= rmin; r--) {
				System.out.print(arr[r][cmin] + "," + " ");
			}
			cmin++;
		}
	}

}
