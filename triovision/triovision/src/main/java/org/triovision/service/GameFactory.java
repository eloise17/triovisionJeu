package org.triovision.service;

import java.util.Collections;
import java.util.List;

import org.triovision.model.Board;
import org.triovision.model.Card;
import org.triovision.model.Deck;
import org.triovision.model.Game;
import org.triovision.model.Player;

public class GameFactory {
	
	private GameFactory() {
		
	}
	
	public static Game newGame(List<Player> players) {
		return new Game(new Board(), new Deck(), Collections.<Card>emptyList(), players);
	}
}
