import java.io.IOException;
import java.util.Scanner;
public class InputChecker 
{
	private Scanner inputScanner;

	public InputChecker() 
	{
		inputScanner = new Scanner(System.in);
	}
	
	public String getDirectionStringInput()
	{
		System.out.println("which direction shall you move: north, east ,south, or west");
		boolean loopInput = true;
		String input = "";
		while(loopInput)
		{
			input =inputScanner.nextLine();
			loopInput = correctDirectionInput(input);
		}
		return input;
	}
	
	public String getString()
	{
		boolean loopInput = true;
		String input = "";
		while(loopInput)
		{
			input =inputScanner.nextLine();
			loopInput = (input !=""?false:true);
		}
		return input;
	}
	public boolean checkStringAgainstArgs(String input,String...strings)
	{
		String[] acceptableAnswers= strings;
		for(String  acceptableAnswer: acceptableAnswers)
		{
			if(acceptableAnswer.equals(input))
			{
				return true;
			}
		}
		System.out.println("please enter a valid keyword");
		return false;
	}
	public boolean correctDirectionInput(String testingInput)
	{
		testingInput = testingInput.toLowerCase();
		switch(testingInput)
		{
			case "east": return false;
			case "west": return false;
			case "north": return false;
			case "south": return false;
			default : System.out.println("please enter valid keyword input ( north east south west)");
				return true;
		}		
	}
	public int getIntegerInput(int minRange,int maxRange,String message)
	{
		boolean correctInput = false;
		String input = "";
		while(!correctInput)
		{		
			input =inputScanner.nextLine();
			correctInput = checkIntegerInput(input,minRange,maxRange);	
		}
		return Integer.parseInt(input);
	}
	//checks if it is a int and also if it is between the correct range
	public boolean checkIntegerInput(String input,int minRange,int maxRange)
	{
		boolean correctInput=false;
		try
		{
			int testInput = Integer.parseInt(input);
			if(testInput>minRange & testInput <maxRange)
			{
				correctInput = true;;
			}
			else
			{
				System.out.println("Not the correct value, please enter a number and be in the range.");
			}
		}
		catch(Exception e)
		{
			System.out.println("Not the correct value, please enter a number and be in the range.");
			breakLineConv();
		}
		return correctInput;				
	}
	public void breakLineConv()
	{
		System.out.println("----------------------------------------------------------");
	}
}
