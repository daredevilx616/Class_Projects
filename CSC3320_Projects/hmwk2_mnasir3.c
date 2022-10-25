
/*
 *
 * Description:
 * 	A game that produces a random number, and the user has to figure that number out given the hints as he plays the game.
 * Input:
 *				Player guesses a random number.
 * Output:
 *				The game gives hints if the number enterd is large, or small and tells which number is in right place.
 *              
 */

#include<stdio.h>
#include<stdlib.h>
#include <time.h>

int main() {


	srandom(time(0)); 
	int user = 0, ran = 0;
	ran = random() % 1000 + 100; //generates a random number from 100-999
	int i = 0, j = 0, k = 0;
	int count = 0, count2 = 0; //two counters for counting any similar numbers
	int y[2]; //arrays to store the number generated and entered by the user
	int x[2];
	int ran_num = ran;
	while(ran > 0){

		y[i] = ran%10; //adding the random number in the array
		ran = ran/10;

		i++;
	}
	for(j = 0; j<3;j++){ 	//nested for loop to compare the two arrays content and increment the counter if a similar or non similar element is found
		for(k = 0; k<3; k++){

			if(x[j] == y[k]){
				if(j == k){
					count++;
				}
				else{
					count2++;
				}
			}
		}
	}
	int tries= 8;
	int tr = 0;;
	while(tr==0){ // one while loop to go through the program to guess the number

		int guess;

		printf("%d tries remaining. What is the code? ",tries);
		scanf("%d",&user);
		if(user<100 || user>999) { //checks if the user did not enter the number out of range
			printf("\nPlease enter 3 digit code");
			tries--;
		}
		if (tries==1){ //checks if the user used all of its tries and then breaks the loop
			printf("%s\n","The vault shuts down permanently due to too many incorrect attempts. You failed to open the vault!");
			printf("The secret code was %d\n",ran_num);
			tr= 1;
		}
		else if (tries>0){ //for all the tries the program continues here
			guess = user;
			tries--;
			i=0;
			while(user >= 1) { //adding the user entered number in the array
				x[i] = user%10;
				user = user/10;
				i++;
			}
			if(guess==ran_num){ //if the number entered matches the random number the loop breaks 
				printf("\nYou opened the vault!\n");
				tr=1;
			} else { // else the program keep finding the similar numbers comparing all the new guesses

				int count = 0, count2 = 0; //two counters for counting any similar numbers
				for(int j = 0; j<3;j++){
					for(int k = 0; k<3; k++){
						if(x[j] == y[k]){
							if(j == k){
								count++;
							}
							else{
								count2++;
							}
						}
					}
				}
				if(guess>ran_num){ //if the number guessed is greater than the random number
					printf("Too high, %d digits are correct and in the right place, %d digits are correct and in the wrong place.\n",count,count2);
				}
				else if(guess<ran_num) //if the number guessed is lesser than the random number
					printf("Too low, %d digits are correct and in the right place, %d digits are correct and in the wrong place.\n",count,count2);
			}
		}
	}
}


