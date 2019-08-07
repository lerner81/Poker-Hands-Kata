package Lerner.Mark;

public class Card {
    private int rank, suit;
   // private char suit;
    private String name;
    private static String[] suits = { "H", "S", "D", "C" };
    private static String[] ranks  = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" ,"A"};


    public Card(String input) {
        name = input;
        suit = input.charAt(input.length()-1);

        String temp = input.substring(0, input.length()- 1);

        if(Character.isDigit(temp.charAt(0)))
            rank = Integer.parseInt(temp);
        else{
            switch (temp.charAt(0)){
                case 'J':
                    rank = 11;
                    break;
                case 'Q':
                    rank = 12;
                    break;
                case 'K':
                    rank = 13;
                    break;
                case 'A':
                    rank = 14;
                    break;
            }
        }
    }

    public static String stringRank(int intRank ) {
        return ranks[intRank];
    }

    //Card constructor sets the rank and suit
    Card(int suit, int rank)
    {
        this.rank = rank;
        this.suit = suit;
    }

//    public String newCard(){
//        Random random = new Random();
//        int i = random.nextInt(13);
//        int j = random.nextInt(4);
//        String randomCard = ranks[i]+suits[j];
//        return randomCard;
//    }

    public int getRank(){
        return rank;
    }

    public int getSuit(){
        return suit;
    }
    public String toString(){
        return ranks[rank]+suits[suit];
    }
}
