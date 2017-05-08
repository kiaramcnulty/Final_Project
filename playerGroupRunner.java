import java.util.Scanner;
public class playerGroupRunner
{
	public static void main(String[]args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("How many players will you be statting?");
		int numP = kb.nextInt();
		String[] players = new String[numP];
		
		for (int i = 0; i < numP; i++)
		{
			System.out.println("Enter a letter to represent one of the players: "); //or #?
			players[i] = kb.next();
		}
		
		playerGroup listOfPlayers = new playerGroup(players);
		
		String stat = "";
		while (!(stat.equals("done")))
		{
			System.out.println("Enter stat: ");
			stat = kb.next();
			{
				while (!(stat.equals("done")))
				{
					String[] stats = stat.split("");
					String n = stats[0];
					String h = stats[1];
					n.addStats(h); // not allowed? Could do for loop checking each player in list for match
				}
			}
		}
	
		for (player p : listOfPlayers)
		{
			System.out.println(p);
		}
	}
}