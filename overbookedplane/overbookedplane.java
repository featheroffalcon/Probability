import java.io.*;
import java.util.*;
//import java.Math.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class overbookedplane
{
	public static void main(String[] args)
	{
		Scanner eingabe = new Scanner(System.in);
		int durchlaufe = 0;
		
		//String eingabestring = eingabe.next();
		
		while (true)
		{
			System.out.println("Type 'simulate', 'reset' or 'end'");
			
			String eingabestring = eingabe.next();
			
			if (eingabestring.equals("end"))
				System.exit(0);
			if (eingabestring.equals("reset"))
				durchlaufe = 0;
			if (eingabestring.equals("simulate"))
			{
				System.out.println("Percentage that a person wants to take the plane:");
				int arriveprobability = eingabe.nextInt();
				System.out.println("Available seats:");
				int seats = eingabe.nextInt();
				System.out.println("Overbooked by that many seats:");
				int overbooked = seats + eingabe.nextInt();
				System.out.println("How often the simulation is run:");
				int runs = eingabe.nextInt();
				
				Random rand = new Random();
			
				int wollende = 0;
				int alledrinne = 0;
				for (int x=runs; x >0; x--)
				{
					durchlaufe++;
				
					wollende = 0;
					for(int i=1; i <= overbooked; i++)
					{
						if(rand.nextInt(101) <= arriveprobability)
							wollende++;
					}
					System.out.println(wollende);
					if (wollende > seats)
						alledrinne++;
				}
				float wahrscheinlichkeit = ((float)alledrinne)/((float)durchlaufe);
				System.out.println("---------------------------------------------------------------" + "\n" +
						   " Runs: " + durchlaufe + "\n" +
						   " Number of runs, everybody had a seat: " + alledrinne + "\n" +
						   " Probability, that everybody will have a seat:" + wahrscheinlichkeit * 100 + "\n" +
					           "---------------------------------------------------------------");
			}
		}
	}
}
