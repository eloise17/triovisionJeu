package org.triovision.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.triovision.model.Game;
import org.triovision.model.Player;

@Component
public class Lobby {
	
	private static Logger log = LoggerFactory.getLogger(Lobby.class);
	
	Map<UUID, Player> players = new HashMap<>();
	
	public Player makePlayerAndAddToLobby() {
		Player p = new Player();
		players.put(p.getPlayerId(), p);
		
		return p;
	}
	
	public Game tryNewGame() {
		List<Player> playersForNewGame = players.values()
												.stream()
												.limit(Game.MAX_PLAYERS_IN_SINGLE_GAME)
												.collect(Collectors.toList());
		
		if (playersForNewGame.size() >= Game.MIN_PLAYERS_IN_SINGLE_GAME) {
			removePlayersFromLobby(playersForNewGame);
			return GameFactory.newGame(playersForNewGame);
		}
		
		throw new IllegalStateException("There aren't enough players to start a new game!");
	}
	
	private void removePlayersFromLobby(List<Player> playersToRemove) {
		playersToRemove.forEach(player -> players.remove(player.getPlayerId()));
	}
	
	public List<Player> players() {
		return new ArrayList<>(players.values());
	}

	@Override
	public String toString() {
		return "Lobby [players=" + players.values() + "]";
	}

}
