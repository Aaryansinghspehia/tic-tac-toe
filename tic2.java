package tic;
import java.util.*;
public class tic2 {
	static char[][] a  = {{'1' , '2','3'},{'4','5','6'},{'7','8','9'}};
	static char turn='X';
	static int row, column;
	static boolean draw = false; 
	static void display_board() {
		System.out.println("\t \t Tick Tac Toe");
		System.out.println("Player1 [X]");
		System.out.println("Player2 [O] \n");
		System.out.println("Player1 [X] turn:");
		System.out.println("\t\t     |     |     ");
		System.out.println("\t\t  " +a[0][0] +"  | "+a[0][1]+"   |  "+a[0][2]+"  ");
		System.out.println("\t\t_____|_____|_____");
		System.out.println("\t\t     |     |     ");
		System.out.println("\t\t  " +a[1][0] +"  | "+a[1][1]+"   |  "+a[1][2]+"  ");
		System.out.println("\t\t_____|_____|_____");
		System.out.println("\t\t     |     |     ");
		System.out.println("\t\t  " +a[2][0] +"  | "+a[2][1]+"   |  "+a[2][2]+"  ");
		System.out.println("\t\t     |     |     ");
	}
	
	public static void player_turn() {
		Scanner sc = new Scanner(System.in);
		
		
		if(turn=='X') {
			System.out.println(" Player1 [X] turn:");
		}
		else if(turn=='O') {
			System.out.println(" Player2 [O] turn:");
		}
		int n = sc.nextInt();
		switch(n) {
		case 1:
			row = 0;column=0;
			break;
		case 2:
			row = 0;column=1;
			break;
		case 3:
			row = 0;column=2;
			break;
		case 4:
			row = 1;column=0;
			break;
		case 5:
			row = 1;column=1;
			break;
		case 6:
			row = 1;column=2;
			break;
		case 7:
			row = 2;column=0;
			break;
		case 8:
			row = 2;column=1;
			break;
		case 9:
			row = 2;column=2;;
			break;
		default:
			System.out.println("invalid entry");
		}
		if(turn=='X' && a[row][column]!='X'&& a[row][column]!='O') {
			a[row][column] = 'X';
			turn='O';
		}
		else if(turn=='O' && a[row][column]!='X'&& a[row][column]!='O') {
			a[row][column] = 'O';
			turn='X';
		}
		else {
			System.out.println("Box already filled");
		}
		
	}
	public static boolean gameover() {
        //check win  row-wise and column-wise
		for(int i=0;i<3;i++) 
		{
			if(a[i][0]==a[i][1] && a[i][0]==a[i][2] || a[0][i]==a[1][i] && a[0][i]==a[2][i] )
			{
				return false;
			}
		}
		
		//diagonally check
		if(a[0][0] == a[1][1] && a[0][0] == a[2][2] || a[0][2]==a[1][1] && a[0][2]==a[2][0] )
		{
			return false;
		}
		
		
		
		
		//all boxes are fill or not
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				 if(a[i][j]!='X' && a[i][j]!='O')
				 {
					 return true;
				 }
			}
		}
		
		
		
		//draw
	    draw = true;
		return false;
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		while(gameover() == true) {
		
		display_board();
		player_turn();
		gameover();
		}
		if(turn =='X' && draw == false) {
			System.out.println("Player2 wins");
		}
		else if(turn =='O' && draw == false)
			System.out.println("Player1 wins");
		else
			System.out.println("Game draw");
	}

}
