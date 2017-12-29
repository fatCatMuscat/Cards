public class Card {

    public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    private final int rank;
    private final int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        String cardName = RANKS[this.rank] + " of " + SUITS[this.suit];
        return cardName;
    }

    public boolean equals(Card that) {
        return this.suit == that.suit && this.rank == that.rank;
    }

    public int compareTo(Card that) {
        if (this.suit < that.suit) return -1;
        if (this.suit > that.suit) return 1;
        if (this.rank < that.rank && this.rank != 1) return -1;
        if (this.rank > that.rank && that.rank != 1) return 1;
        if (this.rank < that.rank && this.rank == 1) return 1;
        if (this.rank > that.rank && that.rank == 1) return -1;
        return 0;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int i = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank ++) {
                cards[i] = new Card(rank, suit);
                i++;
            }
        }
        return cards;
    }

    public static void printDeck (Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);
        }
    }

    public static int search(Card[] cards, Card target) {
        int index = 0;
        for (int i = 0; i <= cards.length; i++) {
            if (cards[i].equals(target)) return i;
        }
        return -1;
    }

    public static int binarySearch(Card[] cards, Card target) {
         int low, high;
         low = 0;
         high = cards.length-1;

          while (low <= high) {
              System.out.println(low + " , " + high);
              int mid = (high + low) / 2;
              int comp = cards[mid].compareTo(target);

              if (comp == 0) return mid;
              else if (comp < 0) {
                  low = mid + 1;
              }
              else {
                  high = mid - 1;
              }
          }
          return -1;
    }

    public int recursiveBinarySearch (Card[] cards, Card target, int low, int high) {
        if (high < low) return -1;

        int mid = (low + high) / 2;
        int comp = cards[mid].compareTo(target);

        if (comp == 0) return mid;
        else if (comp < 0) recursiveBinarySearch(cards, target, mid + 1, high);
        else recursiveBinarySearch(cards, target, low, mid - 1);
        return -1;
    }

    public static int[] suitHist(Card[] hand) {
        int[] suits = new int[4];
        for (Card card : hand) {
            suits[card.suit]++;
        }
        return suits;
    }

    public static boolean hasFlush(Card[] hand) {
        for (int suit: suitHist(hand)) {
            return suit >= 5;
        }
        return false;
    }

    public static void main(String[] args) {



    }


}
