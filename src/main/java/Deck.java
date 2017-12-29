import java.util.Random;

public class Deck {

    private static Random random = new Random();
    private Card[] cards;

    public Deck(int n) {
        this.cards = new Card[n];
    }

    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    public void printDeck() {
        for (int i = 0; i < this.cards.length; i++) {
            System.out.println(this.cards[i]);
        }
    }

    public int randomInt(int low, int high) {
        int range = (high - low) + 1;
        return low + random.nextInt(range);
    }

    public void swapCards(int i, int j) {
        Card temp = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = temp;
    }

    public void shuffle() {
        for(int i = 0; i < this.cards.length - 1; i++) {
            int j = this.randomInt(i, this.cards.length - 1);
            swapCards(i,j);
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.printDeck();
        System.out.println("Shuffling   -   Shuffling");
        deck.shuffle();
        deck.printDeck();

        /// check
    }




}
