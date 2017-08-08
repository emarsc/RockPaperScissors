import java.util.*;
import java.io.File;
import java.io.*;

public class Robot
{

	int throwValue;
	int rock;
	int paper;
	int scissors;
	int userWins;
	int robotWins;
	int ties;
	int count=0;
	int count2=0;
	LinkedList<Throw> userPattern=new LinkedList<Throw>();

	public Robot()
	{
		userWins=0;
		robotWins=0;
		ties=0;
	}

	public void addFile(String fLocation, boolean append)
	{
		int u=0; int r;
		if(!append)
			userPattern.clear();
		try {
		File playFile=new File(fLocation);
		if(!playFile.exists())
			playFile.createNewFile();
		else {
		Scanner fileReader=new Scanner(playFile);
		while(fileReader.hasNextInt()) {
			 r=fileReader.nextInt();
			if(fileReader.hasNextInt())
				 u=fileReader.nextInt();
			userPattern.add(new Throw(r, u));
			count++; count2++; }
		fileReader.close(); }
	}
		catch (IOException e) {
			e.printStackTrace();
	}
	}

	public void writeFile(String fLocation, boolean append)
	{
		try {
					File file=new File(fLocation);
					if(!file.exists())
					file.createNewFile();
					BufferedWriter results=new BufferedWriter(new FileWriter(file, append));
					for(int i=count2; i<userPattern.size(); i++) {
					results.write(Integer.toString(userPattern.get(i).getUserThrow()));
					results.write(Integer.toString(userPattern.get(i).getRobotThrow()));
					results.write(" ");
					results.flush();
				}
					results.close();
					count2=userPattern.size();

				}

				catch (IOException e) {
					e.printStackTrace();
	}
	}
	public void printFile()
	{
		for(int i=0; i<userPattern.size(); i++)
			System.out.print(userPattern.get(i)+" ");

	}

	public void clear(String fLocation)
	{
		try {
		File file=new File(fLocation);
		BufferedWriter clear=new BufferedWriter(new FileWriter(file));
		clear.write("");
		clear.close();
		userPattern.clear();
		}
	catch(IOException e) { e.printStackTrace(); }
	}

	public void add(Throw newThrow)
	{
		if(newThrow.whoWon().equals("robot"))
			robotWins++;
		else if(newThrow.whoWon().equals("user"))
			userWins++;
		else if(newThrow.whoWon().equals("tie"))
			ties++;
		userPattern.add(newThrow);
	}

	public boolean isPatternEqual(LinkedList<Integer> lt, LinkedList<Integer> p)
	{
		for(int i=0; i<p.size(); i++)
		{
			if(!(lt.get(i).equals(p.get(i))))
				return false;
		}

		return true;
	}
	public void assess()
	{
	boolean rThrow=false;
	if(userPattern.size()>50)
		rThrow=true;
	int rob=0;
	if(rThrow)
		rob=1;
	rock=0;
	paper=0;
	scissors=0;
	int rrock=0;
	int rpaper=0;
	int rscissors=0;
	int priority=0;

		LinkedList<Integer> lastThrows=new LinkedList<Integer>();
		for(int x=0; x<4; x++) {
			if (userPattern.size()-x>=1)
			lastThrows.push(userPattern.get(userPattern.size()-1-x).getUserThrow());
			else break;
		}
		if(rThrow)
			lastThrows.push(userPattern.get(userPattern.size()-1).getRobotThrow());
		LinkedList<Integer> patterns=new LinkedList<Integer>();
		boolean pattern=false;
		boolean tempbool=false;
		int index;
		int j=0;
		while(lastThrows.size()>1 && pattern==false) {
			for(int i=0; i<userPattern.size()-2; i++) {
				patterns.add(userPattern.get(i).getUserThrow());

				if(patterns.size()==lastThrows.size()-rob) { if(rThrow) patterns.push(userPattern.get(i).getRobotThrow());

				tempbool=this.isPatternEqual(lastThrows, patterns);
				patterns.pop();
				if(rThrow)
					patterns.pop();
			}
				if( tempbool) {
					pattern=true;
					if(count!=0)
							priority=(i%count);
					switch(userPattern.get(i+1).getUserThrow()) {

						case 0: rock=rock+1;
								break;
						case 1: paper=paper+1;
								break;
						case 2: scissors=scissors+1;
								break;
						default: break;
							}
				}
		} lastThrows.pop(); patterns.clear();
	}
			if(pattern) {
			if(rock>scissors && rock>paper)
				throwValue=1;
			else if(paper>scissors && paper>rock)
				throwValue=2;
			else if(scissors>rock && scissors>paper)
				throwValue=0;

		}
			else
				throwValue=(int) Math.floor(Math.random()*3-.001);

	}

	public int throwMove()
				{
					return throwValue;
				}

	public String toString()
	{
		return "User Wins: "+this.userWins+" Robot Wins: " +this.robotWins+" Ties: "+this.ties+"\n";
	}


}