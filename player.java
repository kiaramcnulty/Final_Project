public class player
{
	private String name;
	private int serveAtt;
	private int transAtt;
	private int serveHits;
	private int transHits;
	
	public player()
	{
		this.name = "";

	}
	public player(String n)
	{
		this.name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addStats(String sOrT, String kOrE)
	{
		if (sOrT.equals("s"))
		{
			serveAtt+=1;
			if (kOrE.equals("k"))
			{
				serveHits += 1;

			}
			else if (kOrE.equals("e"))
			{
				serveHits -= 1;
			}
		}
		else if (sOrT.equals("t"))
		{
			transAtt+=1;
			if (kOrE.equals("k"))
			{
				transHits += 1;

			}
			else if (kOrE.equals("e"))
			{
				transHits -= 1;
			}
		}

	}
	
	
	public String toString()
	{
		return name + ": " +
						"\nHitting %: " + (serveHits+transHits)/(double)(serveAtt + transAtt) +
						"\nHitting % S/R: " + serveHits/(double)serveAtt + 
						"\nHitting % Trans: " + transHits/(double)transAtt; // need to round off to 3 decimals places
	}
}