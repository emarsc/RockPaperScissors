public class Throw
{
	String whoWon;
	int robotThrow;
	int userThrow;
	public Throw(int rThrow, int uThrow)
	{
		robotThrow=rThrow;
		userThrow=uThrow;

	}

	public String whoWon()
	{
		if(userThrow==robotThrow)
							whoWon="tie";
						else if((userThrow==0 && robotThrow==2) || (userThrow==1 && robotThrow==0) || (userThrow==2 && robotThrow==1))
							whoWon="user";
						else
			whoWon="robot";
		return whoWon;
	}

	public int getRobotThrow()
	{
		return robotThrow;
	}

	public int getUserThrow()
	{
		return userThrow;
	}







}