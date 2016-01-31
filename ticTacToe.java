import java.util.*;
public class ticTacToe {

	private char[][] board;
	char player1Choice;
	char player2Choice;
	private static Scanner input;
	private static Scanner input2;
	private static Scanner input3;
	String player1 = null;;
	String player2 = null;
	
	public ticTacToe()
	{
		board = new char[3][3];
	    player1Choice = '-';
		player2Choice = '-';
		initializeBoard();
	}
	
	public void setPlayer1 (char p1) 
	{
		player1Choice = p1;
	}
	
	public char getPlayer1()
	{
		return player1Choice;
	}
	
	public void setPlayer2 (char p2)
	{
		player2Choice = p2;
	}
	
	public char getPlayer2()
	{
		return player2Choice;
	}
	
	public void initializeBoard()
	{
		for(int rows = 0; rows < 3; rows++)
		{
			for(int cols = 0; cols < 3; cols++ )
			{
				board[rows][cols] = '-';
			}
		}
	}
	
	public void buildBoard()
	{
		System.out.println("-------------");
		for(int rows = 0; rows < 3; rows++)
		{
			System.out.print("| ");
			
			for(int cols = 0; cols < 3; cols++)
			{
				System.out.print(board[rows][cols] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	public boolean isItADraw()
	{
		boolean draw = true;
		
		for(int row = 0; row < 3; row++)
		{
			for(int cols = 0; cols < 3; cols++)
			{
				if(board[row][cols] == '-')
				{
					draw = false;
				}
			}
		}
		
		return draw; 
	}
	
	//if it's not empty and it's the same
	private boolean checkRowCol(char c1, char c2, char c3)
	{
		boolean check = false;
		
		if((c1 != '-') && (c1 == c2) && (c2 == c3))
		{
			check = true;
		}
		
		else
		{
			check = false;
		}
		
		return check;
	}
	
	public boolean checkRowForWin()
	{
		boolean rowWin = false;
		for(int row = 0; row < 3; row++)
		{
			if(checkRowCol(board[row][0], board[row][1], board[row][2]) == true)
			{
				rowWin = true;
				break;
			}
			
			else
			{
				rowWin = false;
			}
			
		}
		
		return rowWin;
	}
	
	public boolean checkColForWin()
	{
		boolean colWin = false;
		
		for(int col = 0; col < 3; col++)
		{
			if(checkRowCol(board[0][col],board[1][col], board[2][col]) == true)
			{
				colWin = true;
				break;
			}
			
			else
			{
				colWin = false;
			}
		}
		
		return colWin;
	}
	
	public boolean checkDiagForWin()
	{
		boolean diagWin = false;
		
		if(checkRowCol(board[0][0], board[1][1], board[2][2]) == true)
		{
			diagWin = true;
		}
		
		else if(checkRowCol(board[0][2], board[1][1], board[2][0]) == true)
		{
			diagWin = true;
		}
		
		else
		{
			diagWin = false;
		}
		return diagWin;
	}
	
	public boolean checkWin()
	{
		boolean win = false;
		if(checkRowForWin() || checkColForWin() || checkDiagForWin() == true)
		{
			win = true;
		}
		
		else
		{
			win = false;
		}
		
		return win;
	}
	
	public void chooseMark()
	{
		input = new Scanner(System.in);
		System.out.print(player1 + " : " + "choose your mark, X or O : ");
		setPlayer1(input.nextLine().charAt(0));
		System.out.print(player2 + " : " + "choose your mark, X or O : ");
		setPlayer2(input.nextLine().charAt(0));
	}
	
	public void player1Name()
	{
		input2 = new Scanner(System.in);
		String player1 = null;
		System.out.print("Player 1, Enter your name: ");
		player1 = input2.nextLine().toUpperCase();
		this.player1 = player1;
	}
	
	public void player2Name()
	{
		input3 = new Scanner(System.in);
		String player2 = null;
		System.out.print("Player 2, Enter your name: ");
		player2 = input3.nextLine().toUpperCase();
		this.player2 = player2;
	}
	
	@SuppressWarnings("resource")
	public void placeChoice(int row, int col, int player) 
	{
		boolean isValid = false;
		//first must make sure it is within the board
		if((row <0) || (row>3))
		{
			System.out.println("Row entry is out of bounds, please choose a number from 0 to 2");
			System.out.println();
			isValid = false;
		}
		
		else if((col < 0) || (col > 3))
		{
			System.out.println("Column entry is out of bounds, please choose a number from 0 to 2");
			System.out.println();
			isValid = false;
		}
		
		//now we'll take the player's choice to place his mark.
		else if((row >=0) && (row < 3))
		{
			if((col >= 0) && (col < 3))
			{
				if(board[row][col] == '-')
				{
					//if its player 1
					if(player == 1)
					{
						board[row][col] = getPlayer1();
						isValid = true;
					}
					
					if(player == 2)
					{
						board[row][col] = getPlayer2();
						isValid = true;
					}
				}
				else
				{
					System.out.println("This spot is taken");
					System.out.println();
					isValid = false;
				}
			}
		}
		
		if(!isValid)
		{
			System.out.println("Please enter a new row and column: ");
			System.out.print("Row: ");
			int newRow = new Scanner(System.in).nextInt();
			System.out.print("Column: ");
			int newColumn = new Scanner(System.in).nextInt();
			placeChoice(newRow, newColumn, player);
		}
	}
}
