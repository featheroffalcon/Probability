import java.io.*;
import java.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class birthdayproblem
{
	public static void main (String[] args)
	{
		Random rand = new Random();
		Scanner eingabe = new Scanner(System.in);
		
		System.out.println("Number of People:");
		int numberpeople = eingabe.nextInt();
		int[] birthdays = new int[numberpeople];
		boolean sameday = false;
		int samebirthday = 0;
		
		System.out.println("Number of runs:");
		int runs = eingabe.nextInt();
		
		int numbersamedays = 0;
		long starttime = System.currentTimeMillis();
		for (int run =0; run<runs; run++)
		{
		
		for (int i=0;i<numberpeople-1;i++)
		{
			birthdays[i] = rand.nextInt(366)+1;
			//System.out.println(birthdays[i]);
		}
		for (int j = 0; j<numberpeople-1;j++)
		{
			for(int k=0; k<numberpeople-1;k++)
			{
				if (k!=j)
				{
					if (birthdays[k] == birthdays[j])
					{
						sameday=true;
					}
				}
			}
			if (sameday)
			{
				samebirthday++;
				sameday = false;
			}
		}
		//System.out.println("-------");
		//System.out.println(samebirthday);
		if (samebirthday != 0)
			numbersamedays++;
		
		samebirthday = 0;
		}
		long endtime = System.currentTimeMillis();
		long time = endtime - starttime;
		System.out.println("----------------");
		System.out.println(numbersamedays);
		System.out.println("Chance that two or more of them share the same birthday:");
		System.out.println((double)numbersamedays / (double) runs * 100 + "%");
		System.out.println("Took " + time + " milliseconds");
	}
}
