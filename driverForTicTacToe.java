import java.util.*;

public class driverForTicTacToe {

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		
		ticTacToe game = new ticTacToe();
		int row;
		int col;
		int tookTurn = 1; //variable used to keep track whose turn it is. 
		int player; //Keeps track of the player whose playing.
		
		//From ticTacToe.java
		game.player1Name();
		game.player2Name();
		System.out.println();
		game.chooseMark();
		game.buildBoard();
		boolean quit = false;
		
		while(!quit)
		{
			if(tookTurn == 1)
			{
				System.out.println(game.player1 + " : " + "Enter your choice of row and column");
				player = 1;
				tookTurn = 2;
			}
			else
			{
				System.out.println(game.player2 + " : " + "Enter your choice of row and column");
				player = 2;
				tookTurn = 1;
			}
			
			//This is to avoid game from crashing when a letter is inputed instead of an int 
			while(true)
			{
				try
				{
					System.out.print("Row: " );
					row = new Scanner(System.in).nextInt();
					System.out.print("Column: ");
					col = new Scanner(System.in).nextInt();
					game.placeChoice(row,col,player);
					System.out.println();
					game.buildBoard();
					System.out.println();
					break;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Please enter valid entries.");
					System.out.println(e);
				}
			}
			
			//if someone one or it is a draw
			if(game.checkWin())
			{
				if(game.checkWin())
				{
					//if player won
					if(player == 1)
					{
						System.out.println("Congratualations, " + game.player1 + " you won!");
						System.out.println();
					}
					
					else
					{
						System.out.println("Congratulations, " + game.player2 + " you won!");
						System.out.println();
					}
				}
			
				if(game.isItADraw())
				{
					System.out.println("It's a draw!");
				}
				
				// To start a new game. Asks if the new game will be with same players or with different players. If 
				//player do not wish to continue, then the game will end.
				System.out.print("Play again? (Enter Yes or No): ");
				String quits = new Scanner(System.in).nextLine().toLowerCase();
				System.out.println();
				switch(quits)
				{
					case "no" : System.out.println("Thanks for playing, goodbye!");
							quit = true;
							break;
					case "yes" :System.out.print("New players? ");
								String newChoice = new Scanner(System.in).nextLine().toLowerCase();
								if(newChoice.equals("no"))
								{
									System.out.println("Starting up new board...");
									System.out.println();
									game.initializeBoard();
									quit = false;
								}
								else
								{
									System.out.println("Starting up new board...");
									System.out.println();
									main(args);
									quit = true;
								}
					default:
						System.out.println("Please enter yes or no. ");
				}
			}
		}	
		System.exit(0);
	}
}
