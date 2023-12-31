package org.triovision.model;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;

	@Before
	public void setup() {
		game = new Game(2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGameIsNotInstantiableWithMoreThanMaxAllowedPlayers() {
		new Game(Game.MAX_PLAYERS_IN_SINGLE_GAME + 1);
	}
	
	@Test
	public void testGameIsInstantiableWithMaxAllowedPlayers() {
		new Game(Game.MAX_PLAYERS_IN_SINGLE_GAME);
	}
	
	@Test
	public void testGameIsIntantiableWithThreePlayers() {
		new Game(3);
	}
	
	@Test
	public void testGameIsIntantiableWithTwoPlayers() {
		new Game(2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGameIsNotInstantiableWithOnePlayer() {
		new Game(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGameIsNotInstantiableWithLessThanMinRequiredPlayers() {
		new Game(Game.MIN_PLAYERS_IN_SINGLE_GAME - 1);
	}
	
	@Test
	public void testGameIsInstantiableWithMinRequiredPlayers() {
		new Game(Game.MIN_PLAYERS_IN_SINGLE_GAME);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGameIsNotInstantiableWithNegativePlayers() {
		new Game(-1);
	}

	@Test
	public void testEveryGameHasANonNullBoard() {
		Board b = game.getBoard();

		assertThat(b, is(notNullValue()));
	}

	@Test
	public void testGameMaintainsASingleBoard() {
		Board b1 = game.getBoard();
		Board b2 = game.getBoard();

		assertThat(b1, is(sameInstance(b2)));
	}

	@Test
	public void testGameHasNonNullDeck() {
		Deck d = game.getDeck();

		assertThat(d, is(notNullValue()));
	}

	@Test
	public void testGameMaintainsSingleDeck() {
		Deck d1 = game.getDeck();
		Deck d2 = game.getDeck();

		assertThat(d1, is(sameInstance(d2)));
	}

	@Test
	public void testOpenCardsAreZeroBeforeStart() {
		List<Card> openCards = game.getOpenCards();

		assertThat(openCards.size(), is(0));
	}

	@Test
	public void testThereAreTwelveOpenCardsAfterStart() {
		game.start();

		List<Card> openCards = game.getOpenCards();

		assertThat(openCards.size(), is(12));
	}

	@Test
	public void testCallingStartTwiceHasNoEffect() {
		game.start();
		game.start();

		List<Card> openCards = game.getOpenCards();

		assertThat(openCards.size(), is(12));
	}

}
