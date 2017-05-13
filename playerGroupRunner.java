import java.util.ArrayList;
import java.util.Scanner;
public class playerGroupRunner
{
	public static void main(String[]args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("How many players will you be statting?");
		int numP = kb.nextInt();
		String[] players = new String[numP];
		
		ArrayList<player> listOfPlayers = new ArrayList<player>();
		
		for (int i = 0; i < numP; i++)
		{
			System.out.println("Enter a letter to represent one of the players: "); //or #?
			String name = kb.next();
			listOfPlayers.add(new player(name));
		}
		
		String stat = "";
		while (!(stat.equals("done")))
		{
			System.out.println("Enter stat: ");
			stat = kb.next();
			{
				if (!(stat.equals("done")))
				{
					String[] stats = stat.split("");
					String p = stats[0];
					String n = stats[1];
					String h = stats[2];
					String t = null;
					if (stats.length == 4)
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
	
		for (player p : listOfPlayers)
		{
			System.out.println(p);
		}
	}
}