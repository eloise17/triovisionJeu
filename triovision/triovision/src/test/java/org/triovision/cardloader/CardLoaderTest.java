package org.triovision.cardloader;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import org.triovision.exceptions.MalformedCardException;
import org.triovision.model.Card;
import org.triovision.model.Pawn;


public class CardLoaderTest {
	
	@Test(expected = MalformedCardException.class)
	public void testCardLoadedFromEmptyStringThrowsException() {
		CardLoader.fromString("");
	}
	
	@Test(expected = MalformedCardException.class)
	public void testCardLoadedFromAlmostCorrectStringThrowsException() {
		CardLoader.fromString("B, R -, - B");
	}
	
	@Test
	public void testCardLoadedfromValidStringIsNotNull() {
		Card card = CardLoader.fromString("- B, G -, Y -");
		
		assertThat(card, is(notNullValue()));
	}
	
	@Test
	public void testCardLoadedfromValidStringIsCorrect() {
		Card card = CardLoader.fromString("- B, Y -, R -");
		
		assertThat(card, is(notNullValue()));
		
		Pawn[][] cardInfo = card.getCardInfo();
		Pawn[][] expected = {
					{Pawn.EMPTY, Pawn.BLUE}, 
					{Pawn.YELLOW, Pawn.EMPTY},
					{Pawn.RED, Pawn.EMPTY}};
		
		assertTrue(Arrays.deepEquals(cardInfo, expected));
	}

}
