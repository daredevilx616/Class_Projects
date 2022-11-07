/* came from fcopy.c (Chapter 22, page 568) */
/* checks arguments and impelments relevant infromation */

#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h> 
#define DEBUG true
int main(int argc,char *argv[]) {
	FILE *source_fp,*dest_fp; 
	int ch; 
	char argu[2]; //argument to check which tast to perform
	bool help = false; //boolean type for help
	bool uppercase = false; //boolean type to convert to uppercase
	bool lowercase = false; //boolean type to convert to lowercase

	source_fp = fopen(argv[1], "rb"); 
	dest_fp = fopen(argv[3], "wb"); 
	strcpy(argu,argv[2]); 

	if(argc!=4) {
		fprintf(stderr,"usage: fcopy source dest\n");
		exit(EXIT_FAILURE);
	}
	if ((strcmp(argu,"-h")) == 0) //checking if the argument is true or not
		help = true;
	if ((strcmp(argu,"-u")) == 0) //checking if the argument is true or not
		uppercase = true;
	if ((strcmp(argu,"-l")) == 0) //checking if the argument is true or not
		lowercase = true;
	if( help == false && uppercase == false && lowercase == false) { //checking if not argument is passed, it just copies the file
		printf("\nNo command passed!!!\nThe file 1 is copied to file 2.\n\n");
		while ((ch = getc(source_fp)) != EOF)
			putc(ch, dest_fp);
		exit(EXIT_FAILURE);
	}
	if( uppercase == true && lowercase == true) { //if both arguments are passes, prints error message
		printf("\nError!!!\nPass only one command -u or -l\n\n");
		exit(EXIT_FAILURE);
	}
	if(help == true) { //if asks for help prints relvant information
		printf("\nHelp Information: This program will take two files, one for reading and other for writing.\nPass the argument '-u' to convert all the character to upper-case.\nPass the argument '-l' to convert all the character to lower-case.\n\n");
		exit(EXIT_FAILURE);
	}
	if(source_fp==NULL) { //if null, prints can't open file
		fprintf(stderr,"\nCan't open %s\n",argv[1]);
		exit(EXIT_FAILURE);
	}
	else if(dest_fp==NULL) { //if null, prints can't open file
		fprintf(stderr,"\nCan't open %s\n",argv[2]);
		fclose(source_fp);
		exit(EXIT_FAILURE);
	}
	else {

		if(uppercase == true) { // converting all characters to upper-case and putting them in the dest file
			while((ch=getc(source_fp))!=EOF) {
				if((ch>='a') && (ch<='z')) {
					ch = ch - 'a' + 'A'; 
					putc(ch,dest_fp); 
				}
				else
					putc(ch,dest_fp); 
			}
		}
		if(lowercase == true) { // converting all characters to lower-case and putting them in the dest file
			while((ch=getc(source_fp))!=EOF) {
				if((ch>='A') && (ch<='Z')) {
					ch = ch - 'A' + 'a'; 
					putc(ch,dest_fp); 
				}
				else
					putc(ch,dest_fp); 
			}
		}
		if (DEBUG == true){ //DEBUG flag to print the task that happened in the program
			if( help == true && uppercase == false && lowercase == false) 
				printf("\nTask Successful.\nhelp: true\nlowercase: false\nuppercase: false\ninputfile: source.txt\noutputfile: dest.txt\n\n");
			if( help == false && uppercase == true && lowercase == false) 
				printf("\nTask Successful.\nhelp: false\nlowercase: false\nuppercase: true\ninputfile: source.txt\noutputfile: dest.txt\n\n");
			if( help == false && uppercase == false && lowercase == true) 
				printf("\nTask Successful.\nhelp: false\nlowercase: true\nuppercase: false\ninputfile: source.txt\noutputfile: dest.txt\n\n");
		}
	}


	fclose(source_fp); 
	fclose(dest_fp); 
	return 0;


}
