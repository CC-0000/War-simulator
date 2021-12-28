package warSimulator;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Marines extends Branch implements Pi, RecommendedAmount
{
	private int numLightArmoredVehicles = 0;//smaller tanks basically - $2,000,000
	private int numTroopTrucks = 0;//Humvee - $220,000
	private int numHeavyCargoTrucks = 0;//MTVR MK23? - $200,000
	private int numGrenadeLauncher = 0;//switched from the M203 to the M320 - $3,500
	private int numSnipers = 0;//currently switching over from the M40 to the MK13 - $12,000
	private int numAR = 0;//number of assault rifles; M4 carbines - $1,300
	private int numLiutenants = 0;
	private int numCaptains = 0;
	private int numMajors = 0;
	private int numColonels = 0;
	private int numMajorGenerals = 0;
	private int numGenerals = 0;
	
	public Marines() 
	{
		super();
	}
	
	public Marines(String hardCode) 
	{
		if(hardCode.equals("US Marines")) 
		{
			setNumTroopTrucks(19598);
			setNumLightArmoredVehicles(401);
			setNumHeavyCargoTrucks(11400);
			setNumAR(10000);
			setNumGrenadeLauncher(2000);
			setNumSnipers(1200);
			
			setNumGenerals(4);
			setNumMajorGenerals(29);
			setNumColonels(648);
			setNumMajors(3905);
			setNumCaptains(6015);
			setNumLieutenants(6729);
			
			/*
			 * according to https://en.wikipedia.org/wiki/List_of_vehicles_of_the_United_States_Marine_Corps
			 * according to https://download.militaryonesource.mil/12038/MOS/Reports/2019-demographics-report.pdf
			 */
		}
		else if(hardCode.equals("Chinese Marines"))
		{
			setNumTroopTrucks(14090);
			setNumLightArmoredVehicles(321);
			setNumHeavyCargoTrucks(10000);
			setNumAR(8000);
			setNumGrenadeLauncher(1000);
			setNumSnipers(800);
			
			setNumGenerals(3);
			setNumMajorGenerals(22);
			setNumColonels(539);
			setNumMajors(3000);
			setNumCaptains(5000);
			setNumLieutenants(6000);
		}
		else if(hardCode.equals("Russian Marines"))
		{
			setNumTroopTrucks(10598);
			setNumLightArmoredVehicles(201);
			setNumHeavyCargoTrucks(6400);
			setNumAR(5000);
			setNumGrenadeLauncher(1000);
			setNumSnipers(600);
			
			setNumGenerals(2);
			setNumMajorGenerals(19);
			setNumColonels(348);
			setNumMajors(1905);
			setNumCaptains(3015);
			setNumLieutenants(3729);
		}
	}

	public Marines(int numLightArmoredVehicles, int numTroopTrucks, int numHeavyCargoTrucks, int numGranadeLaucher,
			int numSnipers, int numAR, int numLiutenants, int numCaptains, int numMajors, int numColonels,
			int numMajorGenerals, int numGenerals) 
	{
		super();
		this.numLightArmoredVehicles = numLightArmoredVehicles;
		this.numTroopTrucks = numTroopTrucks;
		this.numHeavyCargoTrucks = numHeavyCargoTrucks;
		this.numGrenadeLauncher = numGranadeLaucher;
		this.numSnipers = numSnipers;
		this.numAR = numAR;
		this.numLiutenants = numLiutenants;
		this.numCaptains = numCaptains;
		this.numMajors = numMajors;
		this.numColonels = numColonels;
		this.numMajorGenerals = numMajorGenerals;
		this.numGenerals = numGenerals;
	}

	public int getNumLightArmoredVehicles() 
	{
		return numLightArmoredVehicles;
	}

	public void setNumLightArmoredVehicles(int numLightArmoredVehicles) 
	{
		this.numLightArmoredVehicles = numLightArmoredVehicles;
	}

	public int getNumTroopTrucks() 
	{
		return numTroopTrucks;
	}

	public void setNumTroopTrucks(int numTroopTrucks) 
	{
		this.numTroopTrucks = numTroopTrucks;
	}

	public int getNumHeavyCargoTrucks() 
	{
		return numHeavyCargoTrucks;
	}

	public void setNumHeavyCargoTrucks(int numHeavyCargoTrucks) 
	{
		this.numHeavyCargoTrucks = numHeavyCargoTrucks;
	}

	public int getNumGrenadeLauncher() 
	{
		return numGrenadeLauncher;
	}

	public void setNumGrenadeLauncher(int numGrenadeLauncher) 
	{
		this.numGrenadeLauncher = numGrenadeLauncher;
	}

	public int getNumSnipers() 
	{
		return numSnipers;
	}

	public void setNumSnipers(int numSnipers) 
	{
		this.numSnipers = numSnipers;
	}

	public int getNumAR() 
	{
		return numAR;
	}

	public void setNumAR(int numAR) 
	{
		this.numAR = numAR;
	}

	public int getNumLieutenants() 
	{
		return numLiutenants;
	}

	public void setNumLieutenants(int numLiutenants) 
	{
		this.numLiutenants = numLiutenants;
	}

	public int getNumCaptains() 
	{
		return numCaptains;
	}

	public void setNumCaptains(int numCaptains) 
	{
		this.numCaptains = numCaptains;
	}

	public int getNumMajors() 
	{
		return numMajors;
	}

	public void setNumMajors(int numMajors) 
	{
		this.numMajors = numMajors;
	}

	public int getNumColonels() 
	{
		return numColonels;
	}

	public void setNumColonels(int numColonels) 
	{
		this.numColonels = numColonels;
	}

	public int getNumMajorGenerals() 
	{
		return numMajorGenerals;
	}

	public void setNumMajorGenerals(int numMajorGenerals) 
	{
		this.numMajorGenerals = numMajorGenerals;
	}

	public int getNumGenerals() 
	{
		return numGenerals;
	}

	public void setNumGenerals(int numGenerals) 
	{
		this.numGenerals = numGenerals;
	}

	@Override
	public String toString() {
		
		String message = " ***** US Marine Corps *****\n\n";
		
		return message;
	}
	
	public void purchaseOrHireSomething(Military military, int setterChoice, double price, String nameOfItem) 
	{
		
		UIManager.put("OptionPane.minimumSize",new Dimension(400,100));
		int numberOfThingsToBuy = Methods.getInt("How many "+nameOfItem+" would you like to purchase: ");
		
		if(military.getBalance() < (numberOfThingsToBuy * price))//more efficient?
		{
			JOptionPane.showMessageDialog(null, "You do not have enough money to buy " + numberOfThingsToBuy + " " + nameOfItem);
		}
		else 
		{
			military.setBalance(military.getBalance() - (numberOfThingsToBuy * price));
			selectRightSetter(setterChoice, numberOfThingsToBuy);
		}
	}//end of purchaseOrHireSomething
	
	public void removeOrFireSomething(Military military, int setterChoice, double price, String nameOfItem) 
	{
		UIManager.put("OptionPane.minimumSize", new Dimension(400, 100));
		int	numberOfThingsToSell = Methods.getInt("How many " + nameOfItem + " would you like to remove: ");
		
		switch(setterChoice)
	
		{
			case 1: //Aircraft Carriers
				if(getNumTroopTrucks() < numberOfThingsToSell)
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
				if(getNumLightArmoredVehicles() < numberOfThingsToSell)
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
				if(getNumHeavyCargoTrucks() < numberOfThingsToSell)
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
				if(getNumAR() < numberOfThingsToSell)
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
				if(getNumGrenadeLauncher() < numberOfThingsToSell)
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
				if(getNumSnipers() < numberOfThingsToSell)
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
			case 8: //Commanders
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
			case 9: //Lieutenants
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
			case 10: //Ensigns
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
			case 11: //Seamen
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
			case 12:
				if(getNumLieutenants() < numberOfThingsToSell)
				{
					JOptionPane.showMessageDialog(null, "You do not have " + numberOfThingsToSell + " " + nameOfItem);
				}
				else 
				{
					military.setBalance(military.getBalance() + (numberOfThingsToSell * price));
					selectRightSetter(setterChoice, -numberOfThingsToSell);
				}
			default:
				System.out.println("Invalid Setter");
		}//end of switch
	}//end of removeOrFireSomething


	public void selectRightSetter(int setter, int userInput) 
	{
		switch(setter) 
		{
			case 1:
				setNumTroopTrucks(getNumTroopTrucks() + userInput);
				break;
			case 2:
				setNumLightArmoredVehicles(getNumLightArmoredVehicles() + userInput);
				break;
			case 3:
				setNumHeavyCargoTrucks(getNumHeavyCargoTrucks() + userInput);
				break;
			case 4:
				setNumAR(getNumAR() + userInput);
				break;
			case 5:
				setNumGrenadeLauncher(getNumGrenadeLauncher() + userInput);
				break;
			case 6:
				setNumSnipers(getNumSnipers() + userInput);
				break;
			case 7:
				setNumGenerals(getNumGenerals() + userInput);
				break;
			case 8:
				setNumMajorGenerals(getNumMajorGenerals() + userInput);
				break;
			case 9:
				setNumColonels(getNumColonels() + userInput);
				break;
			case 10:
				setNumMajors(getNumMajors() + userInput);
				break;
			case 11:
				setNumCaptains(getNumCaptains() + userInput);
				break;
			case 12:
				setNumLieutenants(getNumLieutenants() + userInput);
				break;	
			default:
				System.out.println("Invalid Setter");
		}//end of switch
	}//end of selectRightSetter()
	
	private int getNumGranadeLaucher() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculatePower() 
	{
		double totalNumberOfSoldiersYouHave = getNumGenerals() + getNumMajorGenerals() + getNumColonels() + getNumMajors() + getNumCaptains() + getNumLieutenants()
			+ 0.000000000001;

		//calculate the theoretical number of crew that a certain rank can efficiently support based on known US proportions (Western Bias?)
		double generalProportion = getNumGenerals() / totalNumberOfSoldiersYouHave;
		double generalDeviation = (generalProportion - 0.000231) / 0.000231;
		if(generalDeviation > 0)
		{
			generalDeviation = 0;//too many generals will not hurt your score
		}
		double majorGeneralProportion = getNumMajorGenerals() / totalNumberOfSoldiersYouHave;
		double majorGeneralDeviation = (majorGeneralProportion - 0.001673) / 0.001673;
		if(majorGeneralDeviation > 0)
		{
			majorGeneralDeviation = 0;//too many major generals will not hurt your score
		}
		double colonelProportion = getNumColonels() / totalNumberOfSoldiersYouHave;
		double colonelDeviation = (colonelProportion - 0.037392) / 0.037392;
		if(colonelDeviation > 0)
		{
			colonelDeviation = 0;//too many colonels will not hurt your score
		}
		double majorProportion = getNumMajors() / totalNumberOfSoldiersYouHave;
		double majorDeviation = (majorProportion - 0.225332) / 0.225332;
		if(majorDeviation > 0)
		{
			majorDeviation = 0;//too many majors will not hurt your score
		}
		double captainProportion = getNumCaptains() / totalNumberOfSoldiersYouHave;
		double captainDeviation = (captainProportion - 0.347086) / 0.347086;
		if(captainDeviation > 0)
		{
			captainDeviation = 0;//too many captains will not hurt your score
		}
		double lieutenantProportion = getNumLieutenants() / totalNumberOfSoldiersYouHave;
		double lieutenantDeviation = (lieutenantProportion - 0.388286) / 0.388286;
		if(lieutenantDeviation > 0)
		{
			lieutenantDeviation = 0;//too many lieutenants will not hurt your score
		}
		
		double averageDeviation = (generalDeviation + majorGeneralDeviation + colonelDeviation + majorDeviation + captainDeviation + lieutenantDeviation)/6;
		double averageDeviationWeighted = Math.pow((averageDeviation), 2);
		double crewProportionEfficiency = 1 - ((2/pi) * Math.atan(averageDeviationWeighted));
		
		//calculate the power of the equipment?
		
		//assign soldiers to individual equipments
		int effectiveTroopTrucks = 0;
		int effectiveLightArmoredVehicles = 0;
		int effectiveHeavyCargoTrucks = 0;
		int effectiveARs = 0;
		int effectiveGrenadeLaunchers = 0;
		int effectiveSnipers = 0;
		double numberOfSoldiersLeft = totalNumberOfSoldiersYouHave;
		boolean exit = false;
		while(exit == false)
		{
			if(numberOfSoldiersLeft >= 4 && effectiveLightArmoredVehicles < getNumLightArmoredVehicles())
			{
				effectiveLightArmoredVehicles++;
				numberOfSoldiersLeft -= 4;
			}
			if(numberOfSoldiersLeft >= 3 && effectiveTroopTrucks < getNumTroopTrucks())
			{
				effectiveTroopTrucks++;
				numberOfSoldiersLeft -= 3;
			}
			if(numberOfSoldiersLeft >= 2 && effectiveHeavyCargoTrucks < getNumHeavyCargoTrucks())
			{
				effectiveHeavyCargoTrucks++;
				numberOfSoldiersLeft -= 2;
			}
			if(numberOfSoldiersLeft >= 1 && effectiveSnipers < getNumSnipers())
			{
				effectiveSnipers++;
				numberOfSoldiersLeft -= 1;
			}
			if(numberOfSoldiersLeft >= 1 && effectiveGrenadeLaunchers < getNumGranadeLaucher())
			{
				effectiveGrenadeLaunchers++;
				numberOfSoldiersLeft -= 1;
			}
			if(numberOfSoldiersLeft >= 1 && effectiveARs < getNumAR())
			{
				effectiveARs++;
				numberOfSoldiersLeft -= 1;
			}
			else
			{
				exit = true;
			}
		}
		
		/********************************/
		
		//apply the balanced square root algorithm
		double lightArmoredVehiclePower = (1 + Math.pow(effectiveLightArmoredVehicles, ((double)1/11)) + 0.00002 * effectiveLightArmoredVehicles);
		double troopTruckPower = (1 + Math.pow(effectiveTroopTrucks, ((double)1/14)) + 0.0000022/*cost of equipment in hundreds of billions*/ * effectiveTroopTrucks);
		double heavyCargoTruckPower= (1 + Math.pow(effectiveHeavyCargoTrucks, ((double)1/14)) + 0.000002 * effectiveHeavyCargoTrucks);
		double assaultRiflePower = (1 + Math.pow(effectiveARs, ((double)1/24)) + 0.000000013 * effectiveARs);
		double grenadeLauncherPower = (1 + Math.pow(effectiveGrenadeLaunchers, ((double)1/21)) + 0.000000035 * effectiveGrenadeLaunchers);
		double sniperPower = (1 + Math.pow(effectiveSnipers, ((double)1/18)) + 0.00000012 * effectiveSnipers);
		double marinePower = troopTruckPower * lightArmoredVehiclePower * heavyCargoTruckPower * assaultRiflePower * grenadeLauncherPower * sniperPower;
		
		//apply the raw power money multiplier algorithm
		marinePower += Math.pow((effectiveTroopTrucks * 0.0011/*cost of equipment in hundreds of millions/2*/ + effectiveLightArmoredVehicles * 0.01 + effectiveHeavyCargoTrucks * 0.001
				+ effectiveARs * 0.0000065 + effectiveGrenadeLaunchers * 0.0000175 + effectiveSnipers * 0.00006), (double)4/5);
		
		//apply the crew proportion efficiency
		marinePower *= crewProportionEfficiency;
		
		//this is to account for branch-specific equipment variability
		marinePower /= 5;//default minus one bonus
		
		return marinePower;
	}
	
	public int recommendedAmount(String rank)
	{
		int recommendedAmount = 0;
		int totalNumberOfSoldiersNeededToOperateEquipment = getNumHeavyCargoTrucks() * 2 + getNumLightArmoredVehicles() * 4
				+ getNumTroopTrucks() * 3 + getNumAR() + getNumGranadeLaucher() + getNumSnipers();
		
		if(rank.equals("General"))
		{
			recommendedAmount = (int)(0.000231 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Major General"))
		{
			recommendedAmount = (int)(0.001673 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Colonel"))
		{
			recommendedAmount = (int)(0.037392 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Major"))
		{
			recommendedAmount = (int)(0.225332 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Captain"))
		{
			recommendedAmount = (int)(0.347086 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else if(rank.equals("Lieutenant"))
		{
			recommendedAmount = (int)(0.388286 * totalNumberOfSoldiersNeededToOperateEquipment) + 1;
		}
		else
		{
			recommendedAmount = -1;
			System.out.println("Given rank is not recognizable... returning -1");
		}
		return recommendedAmount;
	}//end of recommendedAmount
	

	@Override
	public boolean equals(Object obj) 
	{
		if(((Marines)obj).getNumLightArmoredVehicles() == this.getNumLightArmoredVehicles() &&
			((Marines)obj).getNumTroopTrucks() == this.getNumTroopTrucks() && 
			((Marines)obj).getNumHeavyCargoTrucks() == this.getNumHeavyCargoTrucks() &&
			((Marines)obj).getNumAR() == this.getNumAR() && 
			((Marines)obj).getNumSnipers() == this.getNumSnipers() && 
			((Marines)obj).getNumGrenadeLauncher() == this.getNumGrenadeLauncher() && 
			((Marines)obj).getNumGenerals() == this.getNumGenerals() && 
			((Marines)obj).getNumMajorGenerals() == this.getNumMajorGenerals() && 
			((Marines)obj).getNumCaptains() == this.getNumCaptains() && 
			((Marines)obj).getNumMajors() == this.getNumMajors() && 
			((Marines)obj).getNumColonels()	== this.getNumColonels() &&
			((Marines)obj).getNumLieutenants() == this.getNumLieutenants()) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}//end of equals method

}//end of marines class