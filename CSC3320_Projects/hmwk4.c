/*
new game

Muhammad Abdullah Nasir
CSC 3320 Homework #4
Account: mnasir3
Due Date: 6th November, 10:59 PM

Description: This Program checks for the player coordinates and compare it to enemy's coordinates and return the enemy position who is nearest to the player.

Input: Input is the player's coordinates.

Output: The enemy's coordinates who is nearest to the player.
*/

#include <stdio.h>
#include <math.h>
#include "new_game.h"


double getDistance(int px, int py, int ex, int ey) {
	double Al, A2, D;
	/*calculating the distance to find the shortest path between player and enemy*/
	Al = (px - ex) * (px - ex);
	A2 = (py - ey) * (py - ey);
	D = sqrt(Al + A2);
	return D;
}

int main(int argc, char *argv[]) {
	if (DEBUG) { //if debug is true
		int player_x = 6; // we initialized the players as integers
		int player_y = 20;
		double D;
		printf("Please enter the X and Y coordinates for the player: ");
		scanf("%d %d", &player_x, &player_y); //taking input from user
		printf("\n"); 
		double close_enemy = 100000;
		int close_eneme_num = 0;
		for (int i = 0; i < MAX_ENEMY; i++) { //for loop to pass each enemy coordinates's
			D = getDistance(player_x, player_y, Enemy_X[i], Enemy_Y[i]); //chechking distance
			printf("Enemy %d is at %d,%d and the distance to the player is %.2f\n", i, Enemy_X[i], Enemy_Y[i], D); //printing data
			if (D < close_enemy) { //checking for smallest
				close_enemy = D;
				close_eneme_num = i;
			}
		}
		/*printing the data for the closest enemy*/
		printf("\nThe player is at %d,%d and the closest enemy is enemy %d at %d,%d\n", player_x, player_y, close_eneme_num, Enemy_X[close_eneme_num], Enemy_Y[close_eneme_num]);

	} else { // if debug is false
		int player_x = 6; // we initialized the players as integers
		int player_y = 20;
		double close_enemy = 10000;
		int close_enemy_num = 0;
		for (int i = 0; i < MAX_ENEMY; i++) { //for loop to pass each enemy coordinates's
			double D = getDistance(0, 0, Enemy_X[i], Enemy_Y[i]); //chechking distance
			if (D < close_enemy) { //checking for smallest
				close_enemy = D;
				close_enemy_num = i;
			}
		}
		/*printing the data for the closest enemy*/
		printf("The player is at %d,%d and the closest enemy is enemy %d at %d,%d\n", player_x, player_y, close_enemy_num, Enemy_X[close_enemy_num], Enemy_Y[close_enemy_num]);
	}
	return 0;
}
