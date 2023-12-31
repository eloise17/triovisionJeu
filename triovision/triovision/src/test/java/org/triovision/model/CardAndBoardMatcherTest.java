package org.triovision.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CardAndBoardMatcherTest {

	Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new Board();
	}

	@Test
	public void testCardMatchesInitialLeftSideConfiguration() {
		
		Card card = Card.builder()
				.topRight(Pawn.BLUE)
				.middleLeft(Pawn.YELLOW)
				.bottomLeft(Pawn.YELLOW)
				.build();
		
		assertTrue(board.matches(card));
	}
	
	@Test
	public void testCardMatchesInitialRightSideConfiguration() {
		
		Card card = Card.builder()
				.topLeft(Pawn.BLUE)
				.middleRight(Pawn.RED)
				.bottomRight(Pawn.RED)
				.build();
		
		assertTrue(board.matches(card));
	}
	
	@Test
	public void testCardDoesNotMatchInitalConfiguration() {
		Card card = Card.builder()
				.topLeft(Pawn.BLUE)
				.middleRight(Pawn.RED)
				.bottomRight(Pawn.YELLOW)
				.build();
		
		assertFalse(board.matches(card));
	}
	
	@Test
	public void testCardMatchesInitialConfigurationRotatedClockwiseOnce() {
		Card card = Card.builder()
				.topLeft(Pawn.YELLOW)
				.middleRight(Pawn.BLUE)
				.bottomRight(Pawn.BLUE)
				.build();
		
		assertTrue(board.matches(card));
	}
	
	@Test
	public void testCardMatchesInitialConfigurationRotatedClockwiseTwice() {
		Card card = Card.builder()
				.topRight(Pawn.YELLOW)
				.middleRight(Pawn.YELLOW)
				.bottomLeft(Pawn.BLUE)
				.build();
		
		assertTrue(board.matches(card));
	}
	
	@Test
	public void testCardMatchesInitialConfigurationRotatedClockwiseThrice() {
		Card card = Card.builder()
				.topLeft(Pawn.RED)
				.middleRight(Pawn.GREEN)
				.bottomRight(Pawn.GREEN)
				.build();
		
		assertTrue(board.matches(card));
	}

}
