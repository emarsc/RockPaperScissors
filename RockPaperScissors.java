import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import java.io.*;
public class RockPaperScissors
{
	public static void main(String[] args)
	{
	int userWins=0;
	int robotWins=0;
	int ties=0;
	int userThrow=0;
	String play="y";
	String fLocation="/Users/emars/Desktop/CS/Rock Paper Scissors/NetResults.txt";
	Robot franklin=new Robot();
	Scanner user=new Scanner(System.in);
	System.out.println("Enter 'n' for novice robot. Enter 'm' for master robot. (Then press enter)");
	if(user.nextLine().equals("m"))
		franklin.addFile(fLocation, true);

	boolean invalid;
	boolean iterate=true;
	while(iterate==true)
	{
	invalid=true;
	userThrow=-1;
	switch (user.nextLine()) {
		case "r": userThrow=0;
					System.out.println("You throw rock. ");
					break;
		case "p": userThrow=1;
					System.out.println("You throw paper. ");
					break;
		case "s": userThrow=2;
					System.out.println("You throw scissors. ");
					break;
		case "save": franklin.writeFile(fLocation, true);
					break;

		case "string": franklin.assess();
					System.out.println(franklin.toString());
					invalid=false;
					break;
		case "clear": 	franklin.clear(fLocation);
						invalid=false;
						break;
		case "printFile":  franklin.printFile();
							invalid=false;
								break;


		case "exit": iterate=false; invalid=false; break;
		default: System.out.println("Invalid Input");
				invalid=false;

				}
		if(invalid==true) {
		franklin.assess();
		franklin.add(new Throw(franklin.throwMove(), userThrow));
		int robotThrow=franklin.throwMove();
		if(robotThrow==0)
			System.out.print("Robot throws Rock. ");
		else if(robotThrow==1)
			System.out.print("Robot throws Paper. ");
		else
			System.out.print("Robot throws Scissors. ");
		System.out.println(franklin.toString());

	}




	}

		System.exit(1);






}


}
