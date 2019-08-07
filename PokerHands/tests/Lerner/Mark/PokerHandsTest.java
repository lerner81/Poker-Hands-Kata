package Lerner.Mark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class PokerHandsTest {
    String inputFile;

    @BeforeEach
    void setUp() {
        inputFile = "test.txt";
    }

    @Test
     void createCard (){
        String input = "KD";
        Card card = new Card(input);
        assertEquals(13, card.getRank());
        assertEquals('D',card.getSuit());
    }

    @Test
     void createHand() {
        String [] input = {"2D","3D","4D","5D","6D"};
        Hand hand = new Hand(input);
        assertEquals(2,hand.getValue(0));
        assertEquals('D', hand.getSuit(0));
        assertEquals(3,hand.getValue(1));
        assertEquals('D', hand.getSuit(1));
        assertEquals(4,hand.getValue(2));
        assertEquals('D', hand.getSuit(2));
        assertEquals(5,hand.getValue(3));
        assertEquals('D', hand.getSuit(3));
        assertEquals(6,hand.getValue(4));
        assertEquals('D', hand.getSuit(4));

    }

    @Test
    void isPair() {
        String content = "Black: 2H 5D 6S KC KD White: 2C 3H 4S 8C AH";
        writeToFile(content);
        PokerHands poker = new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(1, poker.player1.getCombination());
        assertEquals(13,poker.player1.getHighCard());
    }
    @Test
    void isTwoPair() {
        String content = "Black: 6H 5D 6S KC KD White: 2C 3H 4S 8C AH";
        writeToFile(content);
        PokerHands poker = new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(2, poker.player1.getCombination());
        assertEquals(13,poker.player1.getHighCard());
    }
    @Test
    void isThreeOfAKind() {
        String content = "Black: 2H 5D KS KC KD White: 2C 3H 4S 8C AH";
        writeToFile(content);
        PokerHands poker = new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(3, poker.player1.getCombination());
        assertEquals(13,poker.player1.getHighCard());
    }
    @Test
    void isStraight() {
        String content = "Black: 2H 3D 4S 5C AD White: 2C 3H 4S 8C AH";
        writeToFile(content);
        PokerHands poker = new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(4, poker.player1.getCombination());
        assertEquals(5,poker.player1.getHighCard());
    }
    @Test
    void isFlush(){
        String content = "Black: 2D 3D 4D 6D AD White: 2C 3H 4S 8C AH";
        writeToFile(content);
        PokerHands poker = new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(5, poker.player1.getCombination());
        assertEquals(14,poker.player1.getHighCard());
    }
    @Test
    void isFullHouse(){
        String content = "Black: 3D 3D AC AS AD White: 2C 3H 4S 8C AH";
        writeToFile(content);
        PokerHands poker = new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(6, poker.player1.getCombination());
        assertEquals(14,poker.player1.getHighCard());
    }

    @Test
    void isFourOfAKind() {
        String content = "Black: 3D AD AC AS AD White: 2C 3H 4S 8C AH";
        writeToFile(content);
        PokerHands poker = new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(7, poker.player1.getCombination());
        assertEquals(14,poker.player1.getHighCard());
    }

    @Test
    void isStraightFlush() {
        String content = "Black: 2D 3D 4D 5D 6D White: 2C 3H 4S 8C AH";
        writeToFile(content);
        PokerHands poker = new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(8, poker.player1.getCombination());
        assertEquals(6,poker.player1.getHighCard());
    }
    @Test
    void getWinner (){
        String content = "Black: 2D 3D 4D 5D 6D White: 2C 3H 4S 8C AH";
        writeToFile(content);
        PokerHands poker = new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals("Black",poker.getWinner());
    }

    @Test
    void getTie() {
        String content = "Black: 2D 3D 4D 5D 6D White: 2H 3H 4H 5H 6H";
        writeToFile(content);
        PokerHands poker = new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals("Tie",poker.getWinner());
    }

    private void writeToFile(String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(inputFile));
            writer.write(content);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}