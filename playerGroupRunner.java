import java.util.ArrayList;
import java.util.Scanner;
public class playerGroupRunner
{
	static ArrayList<player> listOfPlayers = new ArrayList<player>();
	static Scanner kb = new Scanner(System.in);
	
	public static void main(String[]args)
	{
		System.out.println("How many players will you be statting?");
		int numP = kb.nextInt();
		
		int i = 0;
		while (i < numP)
		{
			System.out.println("Enter a letter or single digit # to represent one of the players: ");
			String name = kb.next();
			boolean exec = true;
			for (int j = 0; j < i; j++)
			{
				if (listOfPlayers.get(j).getName().equals(name))
				{
					System.out.println("Use unique letters or numbers for each player");
					exec = false;
				}
			}
			if (exec == true)
			{
				listOfPlayers.add(new player(name));
				i++;
			}
		}
		statPlayers();
	}
	
	public static void statPlayers()
	{
		String stat = "";
		while (!(stat.equals("done")))
		{
			System.out.println("Enter stat: ");
			stat = kb.next();
			{
				if (!(stat.equals("done")))
				{
					String[] stats = stat.split("");
					String p = null;
					String n = null;
					String h = null;
					String t = null;
					if (stats.length >= 1)
					{
						p = stats[0];
					}
					if (stats.length >= 2)
					{
						n = stats[1];
					}
					if (stats.length >= 3)
					{
						h = stats[2];
					}
					if (stats.length >= 4)
					{
						t = stats[3];
					}
	
					for (int i = 0; i < listOfPlayers.size(); i++)
					{
						if (listOfPlayers.get(i).getName().equals(n))
						{
							listOfPlayers.get(i).addStats(p, h, t);
						}
					}
				}
			}
		}

		int totalServeHits = 0;
		int totalServeAtt = 0;
		int totalTransHits = 0;
		int totalTransAtt = 0;

		for (player p : listOfPlayers)
		{
			totalServeHits += p.getServeHits();
			totalServeAtt += p.getServeAtt();
			totalTransHits += p.getTransHits();
			totalTransAtt += p.getTransAtt();
		}

		System.out.println();
		System.out.println();
		System.out.println("Team Hitting %: " + (int)(1000*((totalServeHits+totalTransHits)/(double)(totalServeAtt + totalTransAtt)))/(double)1000);
		System.out.println("Team Hitting % S/R: " + (int)(1000*(totalServeHits/(double)totalServeAtt))/(double)1000);
		System.out.println("Hitting % Trans: " + (int)(1000*(totalTransHits/(double)totalTransAtt))/(double)1000);
		System.out.println();
	
		for (player p : listOfPlayers)
		{
			System.out.println(p);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Continue statting? 'y' or 'n'");
		String cont = kb.next();
		if (cont.equals("y"))
		{
			System.out.println("Would you like to reset the data? 'y' or 'n'");
			String reset = kb.next();
			if (reset.equals('n'))
			{
				statPlayers();
			}
			if (reset.equals("y"))
			{
				for (player p : listOfPlayers)
				{
					p.resetStats();
				}
				statPlayers();
			}
		}
		else
		{
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
}