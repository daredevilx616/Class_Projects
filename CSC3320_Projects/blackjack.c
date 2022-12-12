/*
  Extra_credit_mnasir3.c
  Name: Muhammad Abdullah Nasir
  Account: mnasir3
  CSc 3320
  Due date: 11th December, 2022 11:59 PM
  
  Description:
  This is a Blackjack game, checks if the dealer and player has scores less than 21 and greater than 17, if yes
  it compares which has higher score, the one with high score wins. I also asks the user to hit or stay, if the
  dealer or player score goes over 21, they lose the game the other person wins.
  Input:
  User entry if the player wants to hit or stay at the origional score.
  Output:
  Displays what was the final score of each player is, and prints who wins and lose the game.
*/


#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main() {
	srandom(time(0)); //srandom to generate random numbers
	int pTotalScore = 0, dTotalScore = 0; //initializing all the variables
	int pCard1, pCard2, pHit, dCard1, dCard2, dHit;
	char input;

	printf("Welcome to Blackjack!\n");
	pCard1 = random() % 10 + 2; //determining the first 2 cards of the player
	pCard2 = random() % 10 + 2;
	pTotalScore = pCard1 + pCard2; //calculating the total score
	printf("Player card 1 = %d.\nPlayer card 2 = %d.\n", pCard1, pCard2);
	printf("Player total score = %d.\n", pTotalScore);
	dCard1 = random() % 10 + 2; //determining the first 2 cards of the dealer
	dCard2 = random() % 10 + 2;
	dTotalScore = dCard1 + dCard2; //calculating the total score
	printf("\nDealer's one card = %d.\n", dCard1); 
	printf("Dealer's second card = (Unknown).\n"); 
	printf("\nPress (h) for Hit or (s) for Stay? "); //checking if the player wants to hit or stay
	scanf("%c", &input);

	if(input == 'h') { //if 'h' do the this:
		pHit = random() % 10 + 2; //calculating the player's hit 
		pTotalScore = pTotalScore + pHit; //adding the scores together
		printf("\nPlayer's new hit = %d.\n", pHit);
		printf("Player's new total score = %d.\n", pTotalScore);
		if(pTotalScore > 21) { //if score jumps over 21, player disqualifies and dealer win.
			printf("\nPlayer's score went over 21.\nPlayer lost! Dealer won!\n");
			return 0;
		}
	} 
	if(dTotalScore <= 16) { //now checking if dealer score is less than 17
		while(dTotalScore <= 16) { //keeping adding random numbers between 2 and 11 till it jumps over 16
			dHit = random() % 10 + 2;
			dTotalScore = dTotalScore + dHit;
			printf("\nDealer's new hit = %d.\n", dHit);
			printf("Dealer's new total score = %d.\n", dTotalScore);
		} 
		if(dTotalScore > 21) { //checking if the dealer score jumped over 21, player wins and dealer disqualifies
			printf("\nDealer's score went over 21. \nPlayer won! Dealer lost!\n");
			return 0;
		}
	}
	if(pTotalScore <= 21 && dTotalScore <= 21) { //if both player and dealer total score is less than 21, compare which has high score.
		if(pTotalScore > dTotalScore) { //if player's score is higher, player win.
			printf("\nPlayer got a higher score than the Dealer.\nPlayer won! Dealer lost!\n");
			return 0;
		}
		else if(dTotalScore > pTotalScore) { //if Dealer score is higher, Dealer win.
			printf("\nDealer got a higher score than the Player.\nDealer win! Player lost!\n");
			return 0;
		}
		else { //if both got the same score
			printf("\nBoth the Player and the Dealer have the same score.\nIt's a push.\n");
			return 0;
		}
	}
	printf("\nBlackjack Terminated.\n");
	return 0;
}
