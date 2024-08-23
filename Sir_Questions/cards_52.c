#include <stdio.h>
#include <stdbool.h>
#define CLUBS    0
#define DIAMONDS 1
#define HEARTS   2
#define SPADES   3

char create_card(char suit, char value) {
    return (suit << 4) | value;
}

char get_card_value(char card) {
    return card & 0x0F;
}

char get_card_suit(char card) {
    return (card >> 4) & 0x03;
}

int higher_value_card( char card1,  char card2) {
     char value1 = get_card_value(card1);
     char value2 = get_card_value(card2);
    
    if (value1 > value2) return 1;
    if (value2 > value1) return 2;
    return 0;
}

bool same_suit( char card1,  char card2) {
    return get_card_suit(card1) == get_card_suit(card2);
}

void test_cards() {
     char ace_of_spades = create_card(SPADES, 14);
     char king_of_hearts = create_card(HEARTS, 13);
     char queen_of_spades = create_card(SPADES, 12);

    printf("Higher value card (Ace of Spades vs King of Hearts): %d\n", 
           higher_value_card(ace_of_spades, king_of_hearts));
    
    printf("Same suit (Ace of Spades vs Queen of Spades): %s\n", 
           same_suit(ace_of_spades, queen_of_spades) ? "Yes" : "No");
    
    printf("Same suit (Ace of Spades vs King of Hearts): %s\n", 
           same_suit(ace_of_spades, king_of_hearts) ? "Yes" : "No");
}

int main() {
    test_cards();
    return 0;
}