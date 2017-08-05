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
			String eingabestring = eingabe.next();
			
			if (eingabestring.equals("end"))
				System.exit(0);
			
			Random rand = new Random();
		
			int wollende = 0;
			int alledrinne = 0;
			for (int x=Integer.parseInt(eingabestring); x >0; x--)
			{
				durchlaufe++;
				
				wollende = 0;
				for(int i=1; i <= 160; i++)
				{
					if(rand.nextInt(101) <= 92)
						wollende++;
				}
				System.out.println(wollende);
				if (wollende > 150)
					alledrinne++;
			}
			float wahrscheinlichkeit = ((float)alledrinne)/((float)durchlaufe);
			System.out.println("-------------------------------------------------" + "\n" +
							   " Durchläufe: " + durchlaufe + "\n" +
							   " Absolut alle drin: " + alledrinne + "\n" +
							   " warscheinlichkeit, dass alle drin:" + wahrscheinlichkeit * 100 + "\n" +
							   "-------------------------------------------------");
		}
	}
}