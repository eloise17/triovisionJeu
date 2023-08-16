package org.triovision.notifier;

import org.springframework.stereotype.Component;

import org.triovision.model.Game;

@Component
public interface PlayerNotifier {

	void notifyPlayers(Game game);

}