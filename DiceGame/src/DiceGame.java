import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	private static String[][] language;
	private static int lang = -1;

	public static void main(String[] args) {
		int die1;
		int die2;
		String[] playerChoices;
		language = langInit();
		String langChoice = getInput("Selecet a language:\n[0] English \n[1] Hawaiian Pidgin　\n[2] Japanese");
		lang = Integer.parseInt(langChoice);
		die1 = roll();
		die2 = roll();
		String choice;
		choice = getInput(language[lang][0]);
		choice = choice.toLowerCase();
		int count = 0;
		String playerCount = getInput(language[lang][1]);
		count = Integer.parseInt(playerCount);
		playerChoices = new String[count];
		while(choice.equals(language[lang][2])) {
			
			for(int c= 0; c < count; c++) {
			playerChoices[c] = getInput(language[lang][3]+(c+1)+language[lang][4]);
			
			}
			System.out.println(language[lang][5]+die1+language[lang][6]+die2);
			//Start a new loop here.
			for(int c=0; c<count;c++) {
				if(didIWin(die1,die2,playerChoices[c]))
				{
					System.out.println(language[lang][3]+(c+1)+language[lang][7]);
				}else
				{
					System.out.println(language[lang][3]+(c+1)+language[lang][8]);
				}
			}
			
			choice = getInput(language[lang][9]);
			choice = choice.toLowerCase();
			die1 = roll();
			die2 = roll();
		}
	}
	private static boolean didIWin(int die1, int die2, String choice)
	{
		if ((die1 + die2)% 2 == 0 && choice.equals(language[lang][10])) {
			return true;
		}
		if ((die1 + die2)% 2 == 0 && choice.equals(language[lang][11])) {
			return false;
		}
		return false;
	}
	
	private static String[][] langInit() {
		String[][] temp = new String[][] {
			//English floor 0
			{
				"Do you want to play?\nYes\nNo","How many players are there?","yes",
				"Player ",": [0] Even\n[1] Odd","Die 1: ",
				"\nDie 2: "," wins!"," loses!",
				"Do you want to play?\nYes\nNo","even","odd"
			},
			//Hawaiian Pidgin 1
			{
				"Like try?\nYessah\nNo need","How many guys get?","yessah",
				"Brahda ",": [0] Even\n[1] Odd","Dice 1: ",
				"\nDice 2: "," winnah!"," nevah win!",
				"Like try again?\nYessah\nNo need","even","odd"
			},
			//Japanese floor 2
			{
				"ゲームをしたいですか。\nはい\nいいえ","何人ですか。","はい",
				"プレイヤー ",": [0] 偶数\n[1] 奇数","サイコロ 1: ",
				"\nサイコロ 2: ","の勝利","の負け",
				"もう一同\nはい\nいいえ","偶数","奇数"
			}
		};
		return temp;
	}
	
	private static int roll()
	{
		return roll(6,1);
	}
	private static int roll(int sides,int start) {
		Random roller = new Random();
		return roller.nextInt(sides)+start;
	}
	private static String getInput(String text) {
		Scanner input = new Scanner(System.in);
		String choice = "";
		try 
		{
			System.out.println(text);
			choice = input.nextLine();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return choice;
	}
	
	private static boolean isInputInteger(String input) {
		boolean isAnInteger = true;
		for(int c = 0; c < input.length();c++) {
			char letter = input.charAt(c);
			//'-' is 45 '0 - 9' 48 - 57
			if(c!=0 &&!(letter >= 48 && letter<= 57))
			{
				isAnInteger = false;
			}else if(letter != 45 && !(letter >= 48 && letter <= 57))
			{
				isAnInteger = false;
			}
		}
		return isAnInteger;
	}
}
