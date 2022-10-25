import java.util.Scanner;

public class guessMyNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int user=0,ran=0;
		ran= (int) (Math.random()*(999-100+1)+100);
		System.out.println(ran);
		int count = 0, count2 = 0;
		int y[] = {0,0,0};
		int x[] = {0,0,0};
		int ran1 = ran;
		for(int i = 0; i <3; i++) {
			y[i] = ran%10;
			ran = ran/10;
		}

		int tries = 8;
		int tr = 0;
		while(tr == 0) 
		{


			System.out.print(tries+" tries remaining. What is the code? ");
			user = sc.nextInt();
			if(user<100 || user>999) 
			{
				System.out.print("\nPlease enter 3 digit code\n");
				tries--;
			} 
			else 
			{
				if(ran1 == user)
				{
					System.out.print("\nYou opened the vault!");
					tr = 1;
				} else 
				{
					int user1 = user;
					for(int i = 0; i <3; i++) 
					{
						x[i] = user%10;
						user = user/10;

					}

					for(int i = 0; i <3; i++)
					{
						if(y[i]==x[i])
						{
							count++;
						}
					}

					for(int i=0; i<3;i++)
					{
						for(int j=0;j<3;j++)
						{
							if((i==0 && j==0) || (i==1 && j==1) || (i==2 && j==2)) 
							{
								continue;
							} else 
							{
								if(y[i]==x[j])
								{
									count2++; 
								}

							}
						}
					}

					if(user1> ran1) {
						System.out.print("Too high, "+count+" digits are correct and in the right place, "+ count2 +" digits are correct and in the wrong place.\n");
					}
					else if(user1<ran1) {
						System.out.print("Too low, "+count+" digits are correct and in the right place, "+count2+" digits are correct and in the wrong place.\n");
					}
					count =0;
					count2 = 0;
				}
				tries--;
				if (tries == 0) {
					System.out.print("The vault shuts down permanently due to too many incorrect attempts. You failed to open the vault! \nThe secret code was "+ran1);
					tr = 1;
				}
			} 
		}
		sc.close();
	}

}

