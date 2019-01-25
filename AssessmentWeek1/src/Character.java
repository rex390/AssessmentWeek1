
public abstract class Character 
{
	String name;
	int level;
	int hp;
	int mana;
	int attack;
	int defence; //work in progress defence calculator
	boolean isDead = false;
	int damageReduction = 1;
	public int getDamageReduction() 
	{
		return damageReduction;
	}
	public void setDamageReduction(int damageReduction)
	{
		this.damageReduction = damageReduction;
	}
	public int getHp()
	{
		return hp;
	}
	public void setIsDead(boolean isDeadPassed)
	{
		isDead = isDeadPassed;
	}
	public boolean getIsDead()
	{
		return isDead;
	}
	public String getName() 
	{
		return name;
	}
	public int getLevel() 
	{
		return level;
	}
	public void setLevel(int level) 
	{
		this.level = level;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setHp(int hp) 
	{	
		this.hp = hp;
		if(hp<=0) //letting it go negatives because it looks nice to overkill
		{
			setIsDead(true);
		}
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana)
	{
		this.mana = mana;
	}
	public int getAttack() 
	{
		return attack;
	}
	public void setAttack(int attack) 
	{
		this.attack = attack;
	}
	public int getDefence() 
	{
		return defence;
	}
	public void setDefence(int defence) 
	{
		
		this.defence = defence;
	}	
	
	public void showStats()
	{
		System.out.println("---------------------------------");
		System.out.println("Stats of \"" + getName() +  "\"");
		System.out.println("---------------------------------");
		System.out.println("Level : " + getLevel() + "\n" + "hp : " + getHp() + "\n" + "mana : " + getMana());
		System.out.println("---------------------------------");
	}
}
