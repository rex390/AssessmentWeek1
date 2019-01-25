
public class Spells 
{
	private String name;
	private int manaCost;
	private int damage;
	private int levelRequired;
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getManaCost() 
	{
		return manaCost;
	}
	public void setManaCost(int manaCost) 
	{
		this.manaCost = manaCost;
	}
	public int getDamage() 
	{
		return damage;
	}
	public void setDamage(int damage) 
	{
		this.damage = damage;
	}
	public int getLevelRequired() 
	{
		return levelRequired;
	}
	public void setLevelRequired(int levelRequired) 
	{
		this.levelRequired = levelRequired;
	}
}
