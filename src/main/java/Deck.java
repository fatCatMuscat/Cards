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

    public static Deck merge(Deck d1, Deck d2) {
        // create the new deck
        Deck result = new Deck (d1.cards.length + d2.cards.length);

        int choice;    // records the winner (1 means d1, 2 means d2)
        int i = 0;     // traverses the first input deck
        int j = 0;     // traverses the second input deck

        // k traverses the new (merged) deck
        for (int k = 0; k < result.cards.length; k++) {
            choice = 1;

            // if d1 is empty, d2 wins; if d2 is empty, d1 wins; otherwise,
            // compare the two cards
            if (i == d1.cards.length)
                choice = 2;
            else if (j == d2.cards.length)
                choice = 1;
            else if (d1.cards[i].compareTo(d2.cards[j]) > 0)
                choice = 2;

            // make the new deck refer to the winner card
            if (choice == 1) {
                result.cards[k] = d1.cards[i];  i++;
            } else {
                result.cards[k] = d2.cards[j];  j++;
            }
        }
        return result;
    }

    public Deck mergeSort() {
        if (cards.length < 2) {
            return this;
        }
        int mid = (cards.length-1) / 2;

        // divide the deck roughly in half
        Deck d1 = subdeck(0, mid);
        Deck d2 = subdeck(mid+1, cards.length-1);

        // sort the halves
        d1 = d1.mergeSort();
        d2 = d2.mergeSort();

        // merge the two halves and return the result
        // (d1 and d2 get garbage collected)
        return merge(d1, d2);
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

        deck.shuffle();
        deck.printDeck();

        System.out.println();

        Deck sortedDeck = deck.mergeSort();

        sortedDeck.printDeck();

    }




}
