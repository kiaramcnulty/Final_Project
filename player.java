public class player
{
	private String name;
	private int hits;
	private int attempts;
	
	public player()
	{
		this.name = "";
		this.hits = 0;
		this.attempts = 0;
	}
	public player(String n)
	{
		this.name = n;
		this.hits = 0;
		this.attempts = 0;
	}
	
	public String getName()
	{
		return name;
	}
	public int getHits()
	{
		return hits;
	}
	public int getAttempts()
	{
		return attempts;
	}
	
	public void addStats(String kOrE)
	{
		if (kOrE.equals("k"));
		{
			hits += 1;
			attempts += 1;
		}
		if (kOrE.equals("e"));
		{
			hits -= 1;
			attempts += 1;
		}
		if (kOrE.equals("w"));
		{
			attempts += 1;
		}
	}
	
	public String toString()
	{
		return name + ": " + hits/(double)attempts; // need to round off to 3 decimals places
	}
	
	
}