import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameCreation 
{
	Player player;
	InputChecker inputChecker;
	ArrayList<Spells> characterSpells = new ArrayList<Spells>();
	GameCreation(Player playerToEdit, InputChecker inputChecker) 
	{
		player = playerToEdit;
		this.inputChecker = inputChecker;
	}
	
	public void Spells(String fileName) 
	{
		//text file input
		Spells spellToAdd = new Spells();
		FileReader fileReader;
		BufferedReader bufferReader;
		String fileInput ="";
		fileName = fileName +".txt";
		int counter = 1;
		//trys to read the file of the character class selected
		try 
		{
			fileReader = new FileReader(fileName);
			bufferReader = new BufferedReader(fileReader);
			fileInput = bufferReader.readLine();
			while(fileInput!=null)
			{
				spellToAdd = structureSpells(counter,fileInput,spellToAdd);				
				fileInput = bufferReader.readLine();
				if(counter!=4)
				{
					counter++;
				}
				else
				{
					counter = 1;
					characterSpells.add(spellToAdd);
					spellToAdd = new Spells();
				}
				
			}								
				if(fileReader!=null)
				{
					fileReader.close();
				}
				if(bufferReader!=null)
				{
					bufferReader.close();
				}
		}
		catch(Exception e)
		{
			System.out.println("spell file is missing or error with reading file");
		}
		player.setSpells(characterSpells);
	}
	public Spells structureSpells(int counter,String message ,Spells spellToEdit)
	{
		switch(counter)
		{
			case 1: 
				spellToEdit.setName(message);
				break;
			case 2:	
				spellToEdit.setManaCost(Integer.parseInt(message));
				break;
			case 3:
				spellToEdit.setDamage(Integer.parseInt(message)); 
				break;
			case 4:
				spellToEdit.setLevelRequired(Integer.parseInt(message));
				break;
		}
		return spellToEdit;
	}
		
	
	public Player creationStarted()
	{
		buildingCharacter();
		return finishedCreation();
	}
	private void buildingCharacter()
	{
		System.out.println("Welcome to the world, before you begin your adventure we will need to know what type of person you are.");
		System.out.println("The characters you can be are below:");
		System.out.println("1 = Mage , 2 = Warrior 3 = Town Drunk");
		int input = inputChecker.getIntegerInput(0, 4, "The characters you can be are below:" + "\n" + "1 = Mage , 2 = Warrior 3 = Town Drunk" );
		characterClassSetup(input);	
		NameInput(input);
	}
	private void characterClassSetup(int input)
	{
		switch(input)
		{
			case 1: System.out.println("Mage was selected.");
				player.setHp(4);
				player.setDefaultHp(4);
				player.setMana(7);
				player.setDefaultMana(1);
				player.setAttack(1);
				player.setClass("Mage");
			break;
			case 2: System.out.println("Warrior was selected.");
				player.setHp(9);
				player.setDefaultHp(9);
				player.setMana(2);
				player.setDefaultMana(2);
				player.setAttack(5);
				player.setClass("Warrior");
			break;
			case 3: System.out.println("Town Drunk, a noble beginning for every character.");
				player.setHp(7);
				player.setDefaultHp(7);
				player.setMana(2);
				player.setDefaultMana(2);
				player.setAttack(4);
				player.setClass("Town Drunk");
			break;
		}	
		Spells(player.getCharacterClass());
	}
	private void NameInput(int input)
	{
		String name = "Joe"; //default value unless you select a name ( so if you were the mage or warrior) 
		if(input!=3)
		{
			System.out.println("what is your name:");
			name = inputChecker.getString();
		}
		player.setName(name);
		System.out.println("Ok, and with that your adventure begins " + name);
		inputChecker.breakLineConv();
	}
	
	private Player finishedCreation()
	{
		return player;
	}
}
