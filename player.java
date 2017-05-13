import jdk.management.resource.internal.inst.WindowsAsynchronousFileChannelImplRMHooks;

public class player
{
	private String name;
	private int serveAtt, transAtt, serveHits, transHits, blockErr, hitErr, intType, washPoints, washTotal;
	
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
	
	public void addStats(String sOrT, String kOrE, String type)
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
				if (type != null && type.equals("b"))
				{
					blockErr +=1;
				}
				else if (type != null && type.equals("h"))
				{
					hitErr +=1;
				}
			}
			else if (type != null && kOrE.equals("w"))
			{
				intType = Integer.parseInt(type);
				washPoints += intType;
				washTotal += 3;
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
				if (type != null && type.equals("b"))
				{
					blockErr +=1;
				}
				else if (type != null && type.equals("h"))
				{
					hitErr +=1;
				}
			}
			else if (type != null && kOrE.equals("w"))
			{
				intType = Integer.parseInt(type);
				washPoints += intType;
				washTotal += 3;
			}
		}

	}
	
	
	public String toString()
	{
		return name + ": " +
						"\n\tHitting %: " + (serveHits+transHits)/(double)(serveAtt + transAtt) +
						"\n\tHitting % S/R: " + serveHits/(double)serveAtt + 
						"\n\tHitting % Trans: " + transHits/(double)transAtt +
						"\n\t% of Errors by block: " + blockErr/(double)(blockErr + hitErr) +
						"\n\t% of Errors by hit: " + hitErr/(double)(blockErr + hitErr) + 
						"\n\tWash %: "+washPoints/(double)washTotal; // need to round off to 3 decimals places
	}
}