package Lerner.Mark;

public class Hand {
    private Card[]cards;
    private int combination;
    private int highCard;

    public Hand(Deck deck1) {

        cards = new Card[5];
        for(int i = 0; i < 5; i++)
            cards[i] = deck1.drawFromDeck();

 //       sort();
    }

//    private void sort() {
//        for(int i = 0; i < cards.length; i++) {
//            int indexOfMin = i, min = getValue(i);
//            for(int j = i +1; j < cards.length; j++){
//                if(getValue(j) < min){
//                    min = getValue(j);
//                    indexOfMin = j;
//                }
//            }
//            Card temp = getCard(i);
//            cards.set(i,getCard(indexOfMin));
//            cards.set(indexOfMin,temp);
//        }
//    }

    public void printHand(){
        for(int i =0; i < cards.length; i++)
            System.out.print(Integer.toString(getValue(i))+ getSuit(i));
    }

    public int getValue(int i) {
        return cards.get(i).getRank();
    }

    public int getSuit(int i) {
        return cards.get(i).getSuit();
    }

    public int getCombination() {
        return combination;
    }

    public int getHighCard() {
        return highCard;
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public void setCombination(int combination) {
        this.combination = combination;
    }

    public void setHighCard(int i) {
        highCard = i;
    }
}
