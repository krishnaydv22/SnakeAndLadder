package Models;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
	
	private Board board;
	private Player player;
	private Dice dice;
	
	Player winner = null;
	Deque<Player> players;
	
	public Game(int size, int snake , int ladder) {
		
		board = new Board(size, snake, ladder);
		
		dice = new Dice(1);
		addPlayers();
		
		
	}
	
	private void addPlayers(){
		players = new LinkedList<Player>();
		players.add(new Player("Player - 1", 0 ));
		players.add(new Player("Player - 2", 0 ));

	}
	
	
	
	public void startGame() {
		while(winner == null) {
			Player currentPlayer = getPlayer();
			int currentPosition =    currentPlayer.getCurrentPosition();
			int diceNumber =  dice.rollDice();
			
			System.out.println("player turn " +  currentPlayer.getPlayerName() +" and current position is " + currentPlayer.getCurrentPosition() + " and got " + diceNumber);
			
			int playerNewPosition = diceNumber + currentPosition;
			playerNewPosition = jumpCheck(playerNewPosition,currentPlayer);
			
			currentPlayer.setCurrentPosition(playerNewPosition );
			
			
			System.out.println("player turn "+ currentPlayer.getPlayerName() + " and now current position is "+ playerNewPosition);
			
			if(currentPosition >= board.cells.length * board.cells.length - 1) {
				winner = currentPlayer;
				
				System.out.println("winner is "+ currentPlayer.getPlayerName());
			}
			
			
			
		}
	}
	
	public Player getPlayer() {
		Player player = players.pollFirst();
		players.addLast(player);
		
		return player;
	}
	
	public int jumpCheck(int newPostion,Player player) {
		
		if(newPostion >= board.cells.length * board.cells.length - 1) {
			return newPostion;
		}
		Cell cell = board.getCell(newPostion);
		
		if(cell.getJump() != null && cell.getJump().getStart() == newPostion ) {
			
			String jampTkn = cell.getJump().getStart() <= cell.getJump().getStop() ? "Ladder" : "Snake";
			
			System.out.println("jamp take by player "+ player.getPlayerName() + jampTkn );
			
			return cell.getJump().getStop();
		}
		
		return newPostion;
		
		
		
	}
	
	
	
	
	

}
