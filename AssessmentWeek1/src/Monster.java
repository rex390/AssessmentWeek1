import java.util.Random;

public class Monster extends Character 
{
	int expOnDeath;
	Monster(int level,int hp,int mana,int attack,int defence)
	{
		this.name = setUpName();
		this.level = level;
		this.hp = hp;
		this.mana = mana;
		this.attack = attack;
		this.defence = defence;
		this.expOnDeath = 3*level;
		
	}
	public int getExpOnDeath() 
	{
		return expOnDeath;
	}

	public String setUpName()
	{
		String[][] monsterNameGenerator = new String[2][];
		monsterNameGenerator[0] = new String[]{"Fire","Water","Earth","Wind", "Raging" , "Ghastly"};
		monsterNameGenerator[1] = new String[]{"Orc","Human","Goblin","Slime", "Skeleton"};
		
		Random rand = new Random();
		int type = rand.nextInt(monsterNameGenerator[0].length);
		int species = rand.nextInt(monsterNameGenerator[1].length);
		String name = monsterNameGenerator[0][type] + " " + monsterNameGenerator[1][species];
		
		return name;
	}
}
