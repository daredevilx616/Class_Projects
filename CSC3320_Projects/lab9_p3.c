#include <stdio.h>
#include <string.h>

int main() {
	int i,j;
	char flower_array[5][7]; //2D array to store the flower names in
	char temp[10]; //temporary string variable to swap the elements

	
	char flower1[] = {"Rose"}; //declaring String variables
	char flower2[] = {"Daisy"};
	char flower3[] = {"Tulip"};
	char flower4[] = {"Poppy"};
	char flower5[] = {"Orchid"};

	
	strcpy(flower_array[0], flower1); //copying flower names in the 2D array
	strcpy(flower_array[1], flower2);
	strcpy(flower_array[2], flower3);
	strcpy(flower_array[3], flower4);
	strcpy(flower_array[4], flower5);

	printf("Flower names in random order: \n"); //printing the flower names before sorting
	for(i=0; i<5; i++) {
		printf("%s\t", flower_array[i]);//using tab sequence to make the list look good
	}
	printf("\n");

	for(i=0; i<5; i++){ //bubble sorting names in ascending order
		for(j=i+1 ;j<5; j++) {
			if(strcmp(flower_array[i],flower_array[j]) > 0) { //comparing the two names

				strcpy(temp,flower_array[i]); //copying and saving it in a temporary string
				strcpy(flower_array[i],flower_array[j]); //switching and swapping the names
				strcpy(flower_array[j],temp);

			}
		}
	}
	printf("\n");
	printf("Flower names in ascending order: \n"); //printing the flower names after sorting
	for(i=0; i<5; i++) {
		printf("%s\t", flower_array[i]);
	}
	printf("\n");
	
	for(i=0; i<5; i++) { //bubble sorting names in descending order
		for(j=i+1; j<5; j++) {
			if(strcmp(flower_array[i],flower_array[j]) < 0) {  //comparing the two names

				strcpy(temp,flower_array[i]); //copying and saving it in a temporary string
				strcpy(flower_array[i],flower_array[j]); //switching and swapping the names
				strcpy(flower_array[j],temp);

			}
		}
	}

	printf("\n");
	printf("Flower names in descending order: \n"); //printing the flower names after sorting
	for(i=0; i<5; i++) {
		printf("%s\t",flower_array[i]);
	}

	return 0;
}
