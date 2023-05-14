package Gameplay.TrumpCard;
import Gameplay.Card.CardPOJO;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
public class TrumpCardController {

    private static HashMap<String, TrumpCardPOJO> CARDS = new HashMap<>(), iconStatus;

    private ArrayList<TrumpCardPOJO> cards = new ArrayList<>();

    public TrumpCardController() {
//        The chip that Hit a card
        CARDS.put("ace", new TrumpCardPOJO("Hit A", "Draw Ace card from the deck.", "ace", "DRAW", new ImageIcon("resources/HitA.PNG")));
        CARDS.put("three", new TrumpCardPOJO("Hit 3", "Draw Three card from the deck. ", "three", "DRAW", new ImageIcon("resources/Hit3.PNG")));
        CARDS.put("five", new TrumpCardPOJO("Hit 5", "Draw Five card from the deck. ", "five", "DRAW", new ImageIcon("resources/Hit5.PNG")));
        CARDS.put("seven", new TrumpCardPOJO("Hit 7", "Draw Seven card from the deck. ", "seven", "DRAW", new ImageIcon("resources/Hit7.PNG")));
        CARDS.put("tens", new TrumpCardPOJO("Hit 10", "Draw any cards that its value equals to 10 left in the deck. ", "tens", "DRAW", new ImageIcon("resources/Hit10.PNG")));
//        The attack chip
        CARDS.put("removeLastCard", new TrumpCardPOJO("Remove opponent's last card", "Remove opponent's last card.", "removeLastCard", "ATTACK", new ImageIcon("resources/RemoveLastCard.PNG")));
        CARDS.put("blind", new TrumpCardPOJO("Enemy can't see their next hit card", "Enemy can't see their next hit card.", "blind", "ATTACK", new ImageIcon("resources/BlindDraw.PNG")));
        CARDS.put("denyHit", new TrumpCardPOJO("Opponent cannot hit in this round", "Opponent cannot hit in this round.", "denyHit", "ATTACK", new ImageIcon("resources/DenyHit.PNG")));
        CARDS.put("denyUseTrumpCard", new TrumpCardPOJO("Opponent cannot use their trump cards", "Opponent cannot use their trump cards.", "denyUseTrumpCard", "ATTACK", new ImageIcon("resources/DenyUseTrumpChip.PNG")));
        CARDS.put("maxCardOpponent", new TrumpCardPOJO("Give the most value card left in deck to enemy", "Give the most value card left in deck to enemy.", "maxCardOpponent", "ATTACK", new ImageIcon("resources/MaxCardOpponent.PNG")));
//        The utility chip
        CARDS.put("seeNextHit", new TrumpCardPOJO("See next 2 cards from the deck", "Player will be notified what the next 2 cards in the deck are.", "seeNextHit", "UTILITY", new ImageIcon("resources/SeeNextHit.PNG")));
        CARDS.put("changePointsLimit25", new TrumpCardPOJO("Change limit to 25", "Change game win condition to 25 instead of 21.", "changePointsLimit25", "UTILITY", new ImageIcon("resources/ChangePointLimit25.PNG")));
        CARDS.put("undoHit", new TrumpCardPOJO("Remove my last card", "Remove your latest card drawn.", "undoHit", "UTILITY", new ImageIcon("resources/UndoHit.PNG")));
        CARDS.put("invincibility", new TrumpCardPOJO("Protect from opponent's ATTACK trump cards", "Protect you from being attack by opponent's ATTACK trump cards in this round.", "invincibility", "UTILITY", new ImageIcon("resources/Invincibility.PNG")));
    }

    public void iconStatusImage() {
//      Invincible
        iconStatus.put("invincibility", new TrumpCardPOJO("Protect from opponent's ATTACK trump cards", "Protect you from being attack by opponent's ATTACK trump cards in this round.", "invincibility", "UTILITY", new ImageIcon("resources/Invincible_Status.PNG")));
//      Blind
        iconStatus.put("blind", new TrumpCardPOJO("Enemy can't see their next hit card", "Enemy can't see their next hit card.", "blind", "ATTACK", new ImageIcon("resources/Blind_Status.PNG")));
//      Deny hit
        iconStatus.put("denyHit", new TrumpCardPOJO("Opponent cannot hit in this round", "Opponent cannot hit in this round.", "denyHit", "ATTACK", new ImageIcon("resources/Deny_hit_Status.PNG")));
//      Deny trump use
        iconStatus.put("denyUserTrumpCard", new TrumpCardPOJO("Opponent cannot use their trump cards", "Opponent cannot use their trump cards.", "denyUseTrumpCard", "ATTACK", new ImageIcon("resources/Deny_Trump_Use_Status.PNG")));
    }

    public void setCards(ArrayList<TrumpCardPOJO> cards) {
        this.cards = cards;
    }

    public static HashMap<String, TrumpCardPOJO> getCARDS() {
        return CARDS;
    }

    public ArrayList<TrumpCardPOJO> getCards() {
        return this.cards;
    }

    public HashMap<String, TrumpCardPOJO> getIconStatus() {
        return iconStatus;
    }
}
