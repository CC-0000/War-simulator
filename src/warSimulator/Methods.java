package warSimulator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Methods 
{
	public static NumberFormat formatter = new DecimalFormat("#,###.00");

	public static int getInt(String message) 
	{
		int result = 0;
		boolean error = false;
		do 
		{
			try 
			{
				result = Integer.parseInt(JOptionPane.showInputDialog(message));
				if(result < 0) 
				{
					JOptionPane.showMessageDialog(null, "Please enter a positive value");
					error = true;
				}
				else 
				{
					error = false;
				}
			}
			catch(Exception e) 
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid integer");
				error = true;
			}
		}while(error);
		
		return result;
	}	
	
	public static boolean isStringOnlyAlphabet(String name) 
	{ 
		return ((!name.equals("")) && (name != null) && (name.matches("^[a-zA-Z' ']*$"))); 
	} 
	
	public static String generateValidName() 
	{
		
		String name = "";
		boolean isAlphabet = true;
		boolean error = false;
		do {
			name = JOptionPane.showInputDialog("What is the name of the new military branch:");
			
			isAlphabet = isStringOnlyAlphabet(name);
			
			if(!isAlphabet) {
				JOptionPane.showMessageDialog(null, "Please enter a name that contains only letters and a space");
				error = true;
			}
			else if(name.charAt(0) == ' ') {
				JOptionPane.showMessageDialog(null, "The first letter cannot be a space");
				error = true;
			}
			else {
				error = false;
			}
		}while(error);
		
		return name;
	}

	public static int smallestValue(ArrayList<Integer> numbersArray)
	{
		int smallestValue = numbersArray.get(0);
		for(int i = 0; i < numbersArray.size(); i++)
		{
			if(numbersArray.get(i) < smallestValue)
			{
				smallestValue = numbersArray.get(i);
			}
		}
		return smallestValue;
	}// end of smallestValue()
	
	public static String displayBranchPower (Military military) {
		
		String result = "";
		double strongestBranchPower = 0;
		int strongestBranchIndex = 0;

		ArrayList <Branch> branches = new ArrayList<>();
			
			
		branches.add(military.getAirforce());
		branches.add(military.getNavy());
		branches.add(military.getArmy());
		branches.add(military.getMarines());
			
		strongestBranchPower = branches.get(0).calculatePower();
		
		
		for(int j = 0; j < branches.size(); j++) 
		{
			if(branches.get(j).calculatePower() > strongestBranchPower)
			{
				strongestBranchPower = branches.get(j).calculatePower();
				strongestBranchIndex = j;
			}
		}
		
		switch(strongestBranchIndex)
		{
			case 0:
				result = "The strongest branch is the Air Force with a total power of: " + formatter.format(strongestBranchPower);
				break;
			case 1:
				result = "The strongest branch is the Navy with a total power of: " + formatter.format(strongestBranchPower);
				break;
			case 2:
				result = "The strongest branch is the Army with a total power of: " + formatter.format(strongestBranchPower);
				break;
			case 3:
				result = "The strongest branch is the Marines with a total power of: " + formatter.format(strongestBranchPower);
				break;
			default:
				System.out.println("Please enter a valid branch index");
		}
				
		return result;
	}
}
