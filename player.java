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
			else if (kOrE.equals("w"))
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
						"\n\tHitting %: " + (int)(1000*((serveHits+transHits)/(double)(serveAtt + transAtt)))/(double)1000 +
						"\n\tHitting % S/R: " + (int)(1000*(serveHits/(double)serveAtt))/(double)1000 + 
						"\n\tHitting % Trans: " + (int)(1000*(transHits/(double)transAtt))/(double)1000 +
						"\n\t% of Errors by block: " + (int)(1000*(blockErr/(double)(blockErr + hitErr)))/(double)1000 +
						"\n\t% of Errors by hit: " + (int)(1000*(hitErr/(double)(blockErr + hitErr)))/(double)1000 + 
						"\n\tWash %: "+ (int)(1000*(washPoints/(double)washTotal))/(double)1000;
	}
}