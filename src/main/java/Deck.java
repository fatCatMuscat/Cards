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

    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
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

    public void merge(Deck d1, Deck d2) {
        Deck result = new Deck(d1.cards.length + d2.cards.length);
        int i = 0;
        int j = 0;
        for (int k = 0; k < result.cards.length; k++) {
            

        }


    }

    public int indexLowest(int lowIndex, int highIndex) {
        int indexLowest = lowIndex;
        for(int i = lowIndex; i < highIndex; i++) {
            int j = i + 1;
            if (this.cards[j].compareTo(this.cards[indexLowest]) < 0) {
                indexLowest = j;
            }
        }
        return indexLowest;
    }

    public Deck selectionSort() {
        for (int i = 0; i < this.cards.length - 1; i++) {
            swapCards(i, indexLowest(i, this.cards.length - 1));
        }
        return this;
    }





    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.printDeck();
        System.out.println();
        deck.subdeck(10, 20).printDeck();


    }




}
