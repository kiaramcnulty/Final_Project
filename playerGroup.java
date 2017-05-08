import java.util.ArrayList;
public class playerGroup
{
	ArrayList<player> playerList;
	
	public playerGroup()
	{
		playerList = new ArrayList<player>();
	}
	public playerGroup(String[] list)
	{
		loadPlayers(list);
	}
	
	public void loadPlayers(String[] pList)
	{
		for (int i = 0; i < pList.length; i++)
		{
			String name = pList[i];
			playerList.add(new player(name));
		}			
	}
}