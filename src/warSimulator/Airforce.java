package warSimulator;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Airforce extends Branch implements Pi, RecommendedAmount
{
	private int numBomberPlane = 0;//B-1 Lancer $423 million
	private int numFighterJet = 0;//f-16 fighting falcon - $121.8 million
	private int numAttackHelicopter = 0;//sikorsky HH-60 - $40.1 million
	private int numCargoPlane = 0;//C-130 - $30.1 million
	
	private int numCaptains = 0;
	private int numColonels = 0;
	private int numGenerals = 0;
	private int numMajorGenerals = 0;
	private int numMajors = 0;
	private int numLieutenants = 0;
	
	public Airforce() { }//...can't...stand...must...not...
	
	public Airforce(String hardCode) 
	{
		if(hardCode.equals("US Airforce")) 
		{
			setNumBomberPlane(153);
			setNumCargoPlane(746);
			setNumAttackHelicopter(199);//too many? 199
			setNumFighterJet(2265);
			//my stats come from: https://en.wikipedia.org/wiki/List_of_active_United_States_Air_Force_aircraft
			
			setNumGenerals(12);
			setNumMajorGenerals(89);
			setNumColonels(3336);
			setNumMajors(14040);
			setNumCaptains(20666);
			setNumLieutenants(15796);
		} // end if to hardcode US Airforce
		else if(hardCode.equals("Chinese Airforce"))
		{
			setNumBomberPlane(120);
			setNumCargoPlane(335);
			setNumAttackHelicopter(5);
			setNumFighterJet(1596);
			
			setNumGenerals(51);
			setNumMajorGenerals(378);
			setNumColonels(11200);
			setNumMajors(39200);
			setNumCaptains(6400);
			setNumLieutenants(63600);
		}
		else if(hardCode.equals("Russian Airforce"))
		{
			setNumBomberPlane(181);
			setNumCargoPlane(195);
			setNumAttackHelicopter(626);
			setNumFighterJet(1319);
			
			setNumGenerals(8);
			setNumMajorGenerals(54);
			setNumColonels(2250);
			setNumMajors(7300);
			setNumCaptains(12000);
			setNumLieutenants(9000);
		}
	} // end Marines hardcoding
	
	public int getNumCargoPlane() {
		return numCargoPlane; }
	public void setNumCargoPlane(int numCargoPlane) {
		this.numCargoPlane = numCargoPlane; }
	public int getNumFighterJet() {
		return numFighterJet; }
	public void setNumFighterJet(int numFighterJet) {
		this.numFighterJet = numFighterJet; }
	public int getNumBomberPlane() {
		return numBomberPlane; }
	public void setNumBomberPlane(int numBomberPlane) {
		this.numBomberPlane = numBomberPlane; }
	public int getNumAttackHelicopter() {
		return numAttackHelicopter; }
	public void setNumAttackHelicopter(int numAttackHelicopter) {
		this.numAttackHelicopter = numAttackHelicopter; }
	public int getNumCaptains() {
		return numCaptains; }
	public void setNumCaptains(int numCaptains) {
		this.numCaptains = numCaptains; }
	public int getNumColonels() {
		return numColonels; }
	public void setNumColonels(int numColonels) {
		this.numColonels = numColonels; }
	public int getNumGenerals() {
		return numGenerals; }
	public void setNumGenerals(int numGenerals) {
		this.numGenerals = numGenerals; }
	public int getNumMajorGenerals() {
		return numMajorGenerals; }
	public void setNumMajorGenerals(int numMajorGenerals) {
		this.numMajorGenerals = numMajorGenerals; }
	public int getNumMajors() {
		return numMajors; }
	public void setNumMajors(int numMajors) {
		this.numMajors = numMajors; }
	public int getNumLieutenants() {
		return numLieutenants; }
	public void setNumLieutenants(int numLieutenants) {
		this.numLieutenants = numLieutenants; }
	
	
	public void purchaseOrHireSomething(Military military, int setterChoice, double price, String name) {
		UIManager.put("OptionPane.minimumSize",new Dimension(400,100));
		int userInput = Methods.getInt("How many " + name + " would you like to requisition: ");
		
		if(military.getBalance() < (userInput * price)) 
		{
			JOptionPane.showMessageDialog(null, "You do not have enough money to buy " + userInput + " " + name);
		} 
		else 
		{
			military.setBalance(military.getBalance() - (userInput * price));
			selectRightSetter(setterChoice, userInput);
		} // end if else
	} // end purchaseOrHireSomething
	
	public void removeOrFireSomething(Military military, int setterChoice, double price, String nameOfItem) 
	{
		UIManager.put("OptionPane.minimumSize", new Dimension(400, 100));
		int	numberOfThingsToSell = Methods.getInt("How many " + nameOfItem + " would you like to remove: ");
		
		switch(setterChoice)
	
		{
			case 1: //Aircraft Carriers
				if(getNumBomberPlane() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
				break;
			case 2: //Submarines
				if(getNumCargoPlane() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
				break;
			case 3: //Battleships
				if(getNumFighterJet() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
				break;
			case 4: //Destroyers
				if(getNumAttackHelicopter() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
				break;
			case 5: //Cargo Ships
				if(getNumGenerals() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
				break;
				
			case 6: //Admirals
				if(getNumMajorGenerals() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
				break;
			case 7: //Captains
				if(getNumColonels() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
				break;
			case 8: //Commanders
				if(getNumMajors() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
				break;
			case 9: //Lieutenants
				if(getNumCaptains() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
				break;
			case 10: //Ensigns
				if(getNumLieutenants() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
				break;
			default:
				System.out.println("Invalid Setter");
		}//end of switch
	}//end of removeOrFireSomething
	
	public void selectRightSetter(int setter, int userInput) {
		switch(setter) {
		case 1:
			setNumBomberPlane(getNumBomberPlane() + userInput);
			break;
		case 2:
			setNumCargoPlane(getNumCargoPlane() + userInput);
			break;
		case 3:
			setNumFighterJet(getNumFighterJet() + userInput);
			break;
		case 4:
			setNumAttackHelicopter(getNumAttackHelicopter() + userInput);
			break;
		case 5:
			setNumGenerals(getNumGenerals() + userInput);
			break;
		case 6:
			setNumMajorGenerals(getNumMajorGenerals() + userInput);
			break;
		case 7:
			setNumColonels(getNumColonels() + userInput);
			break;
		case 8:
			setNumMajors(getNumMajors() + userInput);
			break;
		case 9:
			setNumCaptains(getNumCaptains() + userInput);
			break;
		case 10:
			setNumLieutenants(getNumLieutenants() + userInput);
			break;
		default:
			System.out.println("Invalid Setter");
			break;
		} // end switch cases
	} // end selectRightSetter
	
	@Override
	public double calculatePower()
	{			
		/********************************************************************
		 	US Air Force Stats used to derive proportions
		  	setNumBomberPlane(153);
			setNumCargoPlane(746);
			setNumAttackHelicopter(1174);//too many? 199
			setNumFighterJet(2265);
			
			fighter jet crew size: 1
			helicopter crew size: 4
			bomber ship crew size: 3
			cargo plane crew size: 5
		********************************************************************/		
		//calculate total number of soldiers
		double totalNumberOfSoldiersYouHave = getNumGenerals() + getNumMajorGenerals() + getNumColonels() + getNumMajors() + getNumCaptains() + getNumLieutenants()
				+ 0.000000000001;
		
		//calculate the crew proportions of each individual rank and compare them to the most efficient value
		double generalProportion = getNumGenerals() / totalNumberOfSoldiersYouHave;
		double generalDeviation = (generalProportion - 0.00022247) / 0.00022247;
		if(generalDeviation > 0)
		{
			generalDeviation = 0;//too many generals will not hurt your score
		}
		double majorGeneralProportion = getNumMajorGenerals() / totalNumberOfSoldiersYouHave;
		double majorGeneralDeviation = (majorGeneralProportion - 0.00165) / 0.00165;
		if(majorGeneralDeviation > 0)
		{
			majorGeneralDeviation = 0;//too many major generals will not hurt your score
		}
		double colonelProportion = getNumColonels() / totalNumberOfSoldiersYouHave;
		double colonelDeviation = (colonelProportion - 0.06184764) / 0.06184764;
		if(colonelDeviation > 0)
		{
			colonelDeviation = 0;//too many colonels will not hurt your score
		}
		double majorProportion = getNumMajors() / totalNumberOfSoldiersYouHave;
		double majorDeviation = (majorProportion - 0.260294) / 0.260294;
		if(majorDeviation > 0)
		{
			majorDeviation = 0;//too many majors will not hurt your score
		}
		double captainProportion = getNumCaptains() / totalNumberOfSoldiersYouHave;
		double captainDeviation = (captainProportion - 0.3831365) / 0.3831365;
		if(captainDeviation > 0)
		{
			captainDeviation = 0;//too many captains will not hurt your score
		}
		double lieutenantProportion = getNumLieutenants() / totalNumberOfSoldiersYouHave;
		double lieutenantDeviation = (lieutenantProportion - 0.29285) / 0.29285;
		if(lieutenantDeviation > 0)
		{
			lieutenantDeviation = 0;//too many lieutenants will not hurt your score
		}
		
		double averageDeviation = (generalDeviation + majorGeneralDeviation + colonelDeviation + majorDeviation + captainDeviation + lieutenantDeviation)/6;
		double averageDeviationWeighted = Math.pow((averageDeviation), 2);
		double crewProportionEfficiency = 1 - ((2/pi) * Math.atan(averageDeviationWeighted));
		
		//calculate the power of the equipment?
		int effectiveBombers = 0;
		int effectiveJets = 0;
		int effectiveHelicopters = 0;
		int effectiveCargoPlanes = 0;
		double numberOfSoldiersLeft = totalNumberOfSoldiersYouHave;
		boolean exit = false;
		while(exit == false)
		{
			if(numberOfSoldiersLeft >= 5 && effectiveCargoPlanes < getNumCargoPlane())
			{
				effectiveCargoPlanes++;
				numberOfSoldiersLeft -= 5;
			}
			if(numberOfSoldiersLeft >= 4 && effectiveHelicopters < getNumAttackHelicopter())
			{
				effectiveHelicopters++;
				numberOfSoldiersLeft -= 3;
			}
			if(numberOfSoldiersLeft >= 3 && effectiveBombers < getNumBomberPlane())
			{
				effectiveBombers++;
				numberOfSoldiersLeft -= 2;
			}
			if(numberOfSoldiersLeft >= 1 && effectiveJets < getNumFighterJet())
			{
				effectiveJets++;
				numberOfSoldiersLeft -= 1;
			}
			else
			{
				exit = true;
			}
		}
		
		/******************************************************************************/
		
		
		//apply the balanced square root algorithm
		double bomberPower = (1 + Math.pow(effectiveBombers, ((double)1/6)) + 0.00423/*cost of equipment in hundreds of billions*/ * effectiveBombers);
		double jetPower = (1 + Math.pow(effectiveJets, ((double)1/7)) + 0.001218 * effectiveJets);
		double helicopterPower= (1 + Math.pow(effectiveHelicopters, ((double)1/8)) + 0.000401 * effectiveHelicopters);
		double cargoPlanePower = (1 + Math.pow(effectiveCargoPlanes, ((double)1/8)) + 0.000301 * effectiveCargoPlanes);
		double airforcePower = bomberPower * jetPower * helicopterPower * cargoPlanePower;
						
		//apply the raw power money multiplier algorithm
		airforcePower += Math.pow((effectiveBombers * 2.115/*cost of equipment in hundreds of millions/2*/ + effectiveJets * 0.609 + effectiveHelicopters * .2005
				+ effectiveCargoPlanes * 0.1505), (double)4/5);
						
		//apply the crew proportion efficiency
		airforcePower *= crewProportionEfficiency;
		
		//this is to account for branch-specific equipment variability
		airforcePower /= 3;//default minus one bonus
		
		return airforcePower;
	}//end of calculatePower()
	
	public int recommendedAmount(String rank)
	{
		int recommendedAmount = 0;
		int totalNumberOfSoldiersNeededToOperateEquipment = getNumFighterJet() * 1 + getNumAttackHelicopter() * 4
				+ getNumBomberPlane() * 3 + getNumCargoPlane() * 5;
		
		if(rank.equals("General"))
		{
			recommendedAmount = (int)(0.00022247 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Major General"))
		{
			recommendedAmount = (int)(0.00165 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Colonel"))
		{
			recommendedAmount = (int)(0.06184764 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Major"))
		{
			recommendedAmount = (int)(0.260294 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Captain"))
		{
			recommendedAmount = (int)(0.3831365 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Lieutenant"))
		{
			recommendedAmount = (int)(0.29285 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else
		{
			recommendedAmount = -1;
			System.out.println("Given rank is not recognizable... returning -1");
		}
		return recommendedAmount;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if(!(obj instanceof Airforce))
		{
			return false;
		}
		else
		{
			int otherNumBomberPlanes = ((Airforce)obj).getNumBomberPlane();
			int otherNumFighterJet = ((Airforce)obj).getNumFighterJet();
			int otherNumAttackHelicopter = ((Airforce)obj).getNumAttackHelicopter();
			int otherNumCargoPlane = ((Airforce)obj).getNumCargoPlane();
			int otherNumGenerals = ((Airforce)obj).getNumGenerals();
			int otherNumMajorGenerals = ((Airforce)obj).getNumMajorGenerals();
			int otherNumColonels = ((Airforce)obj).getNumColonels();
			int otherNumMajors = ((Airforce)obj).getNumMajors();
			int otherNumCaptains = ((Airforce)obj).getNumCaptains();
			int otherNumLieutenants = ((Airforce)obj).getNumLieutenants();

			
			if(this.getNumBomberPlane() == otherNumBomberPlanes && this.getNumFighterJet() == otherNumFighterJet 
					&& this.getNumAttackHelicopter() == otherNumAttackHelicopter && this.getNumCargoPlane() == otherNumCargoPlane
					&& this.getNumGenerals() == otherNumGenerals && this.getNumMajorGenerals() == otherNumMajorGenerals 
					&& this.getNumColonels() == otherNumColonels && this.getNumMajors() == otherNumMajors
					&& this.getNumCaptains() == otherNumCaptains && this.getNumLieutenants() == otherNumLieutenants)
			{
				return true;
			}//end of if
			else
			{
				return false;
			}//end of else
		}//end of else
	}//end of equals method
	
} // end Airforce class
