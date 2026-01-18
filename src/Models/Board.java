package Models;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
	
	public Cell[][] cells;
	
	public Board(int size, int snake, int ladder) {
		initialzeBoard(size);
		addSnakeAndLadder(cells,snake,ladder);
	}
	
	
	private void initialzeBoard(int size) {
		
		cells = new Cell[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cells[i][j] = new Cell();
			}
		}
		
	}
	
	private void addSnakeAndLadder(Cell[][] cells, int snake, int ladder) {
		
		int snakeCnt = 0;
		int ladderCnt = 0;
		
		while(snakeCnt < snake) {
			int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
			int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
			
			if(snakeHead <= snakeTail) {
				continue;
				
			}
			
			Jump jump = new Jump();
			jump.setStart(snakeHead);
			jump.setStop(snakeTail);
			
			Cell cell = getCell(snakeHead);
			cell.setJump(jump);
			
			snakeCnt++;
			
			
		}
		
		while(ladderCnt < ladder) {
			int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
			int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
			
			if(ladderHead >= ladderTail) {
				continue;
				
			}
			
			Jump jump = new Jump();
			jump.setStart(ladderHead);
			jump.setStop(ladderTail);
			
			Cell cell = getCell(ladderHead);
			cell.setJump(jump);
			
			ladderCnt++;
			
			
		}
		
	}
	
	public Cell getCell(int position) {
		int row = position / cells.length;
		int col = position % cells.length;
		
		return cells[row][col];
	}

}
