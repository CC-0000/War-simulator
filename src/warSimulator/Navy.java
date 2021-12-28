package warSimulator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.JOptionPane;

public class Navy extends Branch implements Pi, RecommendedAmount
{
	public static NumberFormat formatter = new DecimalFormat("#,###.00");
	private int numberOfAircraftCarriers;
	private int numberOfSubmarines;
	private int numberOfBattleships;
	private int numberOfDestroyers;
	private int numberOfCargoShips;
	private int numberOfAdmirals;
	private int numberOfCaptains;
	private int numberOfCommanders;
	private int numberOfLieutenants;
	private int numberOfEnsigns;
	private int numberOfSeamen;
	private double navalPower;
	
	public Navy()
	{
		super();
	}
	
	public Navy(String hardCodeCountry)
	{
		if(hardCodeCountry.equals("US Navy"))
		{	
			setNumberOfAircraftCarriers(11);
			setNumberOfSubmarines(71);
			setNumberOfBattleships(0);
			setNumberOfDestroyers(70);
			setNumberOfCargoShips(79);
			
			setNumberOfAdmirals(212);//.00216
			setNumberOfCaptains(3127); //14 captains for every admiral .03
			setNumberOfCommanders(6694);//2 commanders for every captain .06
			setNumberOfLieutenants(18520);//3 lieutenants for every commander .18
			setNumberOfEnsigns(24564);//partially mixed with junior lieutenants
			setNumberOfSeamen(71174);//11 seamen for every ensign .6652
			
			/*
			 * according to: https://en.wikipedia.org/wiki/List_of_current_ships_of_the_United_States_Navy
			 */
		}
		else if(hardCodeCountry.equals("Chinese Navy"))
		{
			setNumberOfAircraftCarriers(2);
			setNumberOfSubmarines(76);
			setNumberOfBattleships(0);
			setNumberOfDestroyers(34);
			setNumberOfCargoShips(57);
			
			setNumberOfAdmirals(40);//.00216
			setNumberOfCaptains(400); //14 captains for every admiral .03
			setNumberOfCommanders(4300);//2 commanders for every captain .06
			setNumberOfLieutenants(8500);//3 lieutenants for every commander .18
			setNumberOfEnsigns(21000);//equal to commanders? .06
			setNumberOfSeamen(43000);//11 seamen for every ensign .6652
			
			/*
			 * according to: https://en.wikipedia.org/wiki/List_of_active_People%27s_Liberation_Army_Navy_ships
			 */
		}
		else if(hardCodeCountry.equals("Russian Navy"))
		{
			setNumberOfAircraftCarriers(1);
			setNumberOfSubmarines(64);
			setNumberOfBattleships(2);
			setNumberOfDestroyers(13);
			setNumberOfCargoShips(48);
			
			setNumberOfAdmirals(6);
			setNumberOfCaptains(60);
			setNumberOfCommanders(600);
			setNumberOfLieutenants(1200);
			setNumberOfEnsigns(3000);
			setNumberOfSeamen(6000);
			
			/*
			 * according to: https://en.wikipedia.org/wiki/List_of_active_Russian_Navy_ships
			 */
		}
	}

	public int getNumberOfAircraftCarriers() 
	{
		return numberOfAircraftCarriers;
	}

	public void setNumberOfAircraftCarriers(int numberOfAircraftCarriers) 
	{
		this.numberOfAircraftCarriers = numberOfAircraftCarriers;
	}

	public int getNumberOfSubmarines() 
	{
		return numberOfSubmarines;
	}

	public void setNumberOfSubmarines(int numberOfSubmarines) 
	{
		this.numberOfSubmarines = numberOfSubmarines;
	}

	public int getNumberOfBattleships() 
	{
		return numberOfBattleships;
	}

	public void setNumberOfBattleships(int numberOfBattleships) 
	{
		this.numberOfBattleships = numberOfBattleships;
	}

	public int getNumberOfDestroyers() 
	{
		return numberOfDestroyers;
	}

	public void setNumberOfDestroyers(int numberOfDestroyers) 
	{
		this.numberOfDestroyers = numberOfDestroyers;
	}

	public int getNumberOfCargoShips() 
	{
		return numberOfCargoShips;
	}

	public void setNumberOfCargoShips(int numberOfCargoShips) 
	{
		this.numberOfCargoShips = numberOfCargoShips;
	}

	public int getNumberOfAdmirals() 
	{
		return numberOfAdmirals;
	}

	public void setNumberOfAdmirals(int numberOfAdmirals) 
	{
		this.numberOfAdmirals = numberOfAdmirals;
	}

	public int getNumberOfCaptains() 
	{
		return numberOfCaptains;
	}

	public void setNumberOfCaptains(int numberOfCaptains) 
	{
		this.numberOfCaptains = numberOfCaptains;
	}

	public int getNumberOfCommanders() 
	{
		return numberOfCommanders;
	}

	public void setNumberOfCommanders(int numberOfCommanders) 
	{
		this.numberOfCommanders = numberOfCommanders;
	}

	public int getNumberOfLieutenants() 
	{
		return numberOfLieutenants;
	}

	public void setNumberOfLieutenants(int numberOfLieutenants) 
	{
		this.numberOfLieutenants = numberOfLieutenants;
	}

	public int getNumberOfEnsigns() 
	{
		return numberOfEnsigns;
	}

	public void setNumberOfEnsigns(int numberOfEnsigns) 
	{
		this.numberOfEnsigns = numberOfEnsigns;
	}

	public int getNumberOfSeamen() 
	{
		return numberOfSeamen;
	}

	public void setNumberOfSeamen(int numberOfSeamen) 
	{
		this.numberOfSeamen = numberOfSeamen;
	}

	public double getNavalPower() 
	{
		return navalPower;
	}

	public void setNavalPower(double navalPower) 
	{
		this.navalPower = navalPower;
	}

	public void purchaseOrHireSomething(Military military, int setterChoice, double price, String nameOfItem) 
	{
		UIManager.put("OptionPane.minimumSize", new Dimension(400, 100));
		int	numberOfThingsToBuy = Methods.getInt("How many " + nameOfItem + " would you like to requisition: ");
		
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
				if(getNumberOfAircraftCarriers() < numberOfThingsToSell)
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
				if(getNumberOfSubmarines() < numberOfThingsToSell)
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
				if(getNumberOfBattleships() < numberOfThingsToSell)
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
				if(getNumberOfDestroyers() < numberOfThingsToSell)
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
				if(getNumberOfCargoShips() < numberOfThingsToSell)
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
				if(getNumberOfAdmirals() < numberOfThingsToSell)
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
				if(getNumberOfCaptains() < numberOfThingsToSell)
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
				if(getNumberOfCommanders() < numberOfThingsToSell)
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
				if(getNumberOfLieutenants() < numberOfThingsToSell)
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
				if(getNumberOfEnsigns() < numberOfThingsToSell)
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
				if(getNumberOfSeamen() < numberOfThingsToSell)
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
		}
	}//end of removeOrFireSomething

	public void selectRightSetter(int setter, int userInput) 
	{
		switch(setter) 
		{
			case 1: //Aircraft Carriers
				setNumberOfAircraftCarriers(getNumberOfAircraftCarriers() + userInput);
				break;
			case 2: //Submarines
				setNumberOfSubmarines(getNumberOfSubmarines() + userInput);
				break;
			case 3: //Battleships
				setNumberOfBattleships(getNumberOfBattleships() + userInput);
				break;
			case 4: //Destroyers
				setNumberOfDestroyers(getNumberOfDestroyers() + userInput);
				break;
			case 5: //Cargo Ships
				setNumberOfCargoShips(getNumberOfCargoShips() + userInput);
				break;
			case 6: //Admirals
				setNumberOfAdmirals(getNumberOfAdmirals() + userInput);
				break;
			case 7: //Captains
				setNumberOfCaptains(getNumberOfCaptains() + userInput);
				break;
			case 8: //Commanders
				setNumberOfCommanders(getNumberOfCommanders() + userInput);
				break;
			case 9: //Lieutenants
				setNumberOfLieutenants(getNumberOfLieutenants() + userInput);
				break;
			case 10: //Ensigns
				setNumberOfEnsigns(getNumberOfEnsigns() + userInput);
				break;
			case 11: //Seamen
				setNumberOfSeamen(getNumberOfSeamen() + userInput);
				break;
			default:
				System.out.println("Invalid Setter");
		}//end of switch
	}//end of setterRightSetter
	
	@Override
	public double calculatePower()
	{			
		/********************************************************************
		 	US Navy Stats used to derive proportions
		  	setNumberOfAdmirals(218);//.00216
			setNumberOfCaptains(3125); //14 captains for every admiral .03
			setNumberOfCommanders(6679);//2 commanders for every captain .06
			setNumberOfLieutenants(22111);//3 lieutenants for every commander .18
			setNumberOfEnsigns(6605);//equal to commanders? .06
			setNumberOfSeamen(72267);
			
			aircraft carrier crew size: 6000
			submarine crew size: 140
			battleship crew size: 2700
			destroyer crew size: 300
			cargo ship crew size: 60
		********************************************************************/	
		//calculate total number of soldiers
		double totalNumberOfCrewYouHave = getNumberOfAdmirals() + getNumberOfCaptains() + getNumberOfCommanders() + getNumberOfLieutenants() + getNumberOfEnsigns() + getNumberOfSeamen()
				+ 0.000000000001;
		
		//calculate the theoretical number of crew that a certain rank can efficiently support based on known US proportions (Western Bias?)
		double admiralProportion = getNumberOfAdmirals() / totalNumberOfCrewYouHave;
		double admiralDeviation = (admiralProportion - 0.001077) / 0.001077;
		if(admiralDeviation > 0)
		{
			admiralDeviation = 0;//too many admirals will not hurt your score
		}
		double captainProportion = getNumberOfCaptains() / totalNumberOfCrewYouHave;
		double captainDeviation = (captainProportion - 0.013567) / 0.013567;
		if(captainDeviation > 0)
		{
			captainDeviation = 0;//too many captains will not hurt your score
		}
		double commanderProportion = getNumberOfCommanders() / totalNumberOfCrewYouHave;
		double commanderDeviation = (commanderProportion - 0.056963) / 0.056963;
		if(commanderDeviation > 0)
		{
			commanderDeviation = 0;//too many commanders will not hurt your score
		}
		double lieutenantProportion = getNumberOfLieutenants() / totalNumberOfCrewYouHave;
		double lieutenantDeviation = (lieutenantProportion - 0.133494) / 0.133494;
		if(lieutenantDeviation > 0)
		{
			lieutenantDeviation = 0;//too many lieutenants will not hurt your score
		}
		double ensignProportion = getNumberOfEnsigns() / totalNumberOfCrewYouHave;
		double ensignDeviation = (ensignProportion - 0.202657) / 0.202657;
		if(ensignDeviation > 0)
		{
			ensignDeviation = 0;//too many ensigns will not hurt your score
		}
		double seamenProportion = getNumberOfSeamen() / totalNumberOfCrewYouHave;
		double seamenDeviation = (seamenProportion - 0.591362) / 0.591362;
		if(seamenDeviation > 0)
		{
			seamenDeviation = 0;//too many seamen will not hurt your score
		}
		
		double averageDeviation = (admiralDeviation + captainDeviation + commanderDeviation + lieutenantDeviation + ensignDeviation + seamenDeviation) / 6;
		double averageDeviationWeighted = Math.pow((averageDeviation), 2);
		double crewProportionEfficiency = 1 - ((2/pi) * Math.atan(averageDeviationWeighted));
		
		//calculate total power of ships
		//assign soldiers to individual ships
		int effectiveAircraftCarriers = 0;
		int effectiveBattleships = 0;
		int effectiveDestroyers = 0;
		int effectiveSubmarines = 0;
		int effectiveCargoShips = 0;
		double numberOfSoldiersLeft = totalNumberOfCrewYouHave;
		boolean exit = false;
		while(exit == false)
		{
			if(numberOfSoldiersLeft >= 4000 && effectiveAircraftCarriers < getNumberOfAircraftCarriers())
			{
				effectiveAircraftCarriers++;
				numberOfSoldiersLeft -= 4000;
			}
			if(numberOfSoldiersLeft >= 1000 && effectiveBattleships < getNumberOfBattleships())
			{
				effectiveBattleships++;
				numberOfSoldiersLeft -= 1000;
			}
			if(numberOfSoldiersLeft >= 300 && effectiveDestroyers < getNumberOfDestroyers())
			{
				effectiveDestroyers++;
				numberOfSoldiersLeft -= 300;
			}
			if(numberOfSoldiersLeft >= 140 && effectiveSubmarines < getNumberOfSubmarines())
			{
				effectiveSubmarines++;
				numberOfSoldiersLeft -= 140;
			}
			if(numberOfSoldiersLeft >= 60 && effectiveCargoShips < getNumberOfCargoShips())
			{
				effectiveCargoShips++;
				numberOfSoldiersLeft -= 60;
			}
			else
			{
				exit = true;
			}
		}
		
		//apply the balanced square root algorithm
		double aircraftCarrierPower = (1 + Math.pow(effectiveAircraftCarriers, ((double)1/2)) + 0.13 * effectiveAircraftCarriers);
		double submarinePower = (1 + Math.pow(effectiveSubmarines, ((double)1/3)) + 0.045 * effectiveSubmarines);
		double battleshipPower = (1 + Math.pow(effectiveBattleships, ((double)1/4)) + 0.026 * effectiveBattleships);
		double destroyerPower = (1 + Math.pow(effectiveDestroyers, ((double)1/5)) + 0.018 * effectiveDestroyers);
		double cargoShipPower = (1 + Math.pow(effectiveCargoShips, ((double)1/6)) + 0.012 * effectiveCargoShips);
		double navalPower = aircraftCarrierPower * submarinePower * battleshipPower * destroyerPower * cargoShipPower;
				
		//apply the raw power money multiplier algorithn
		navalPower += Math.pow((effectiveAircraftCarriers * 65/*cost of equipment in hundreds of millions/2*/ + effectiveSubmarines * 22.5 + effectiveBattleships * 13
				+ effectiveDestroyers * 9 + effectiveCargoShips * 6), (double)4/5);
				
		//apply the crew proportion efficiency
		navalPower *= crewProportionEfficiency;
		
		//this is to account for branch-specific equipment variability
		navalPower /= 5;//no bonus because the navy is toooo powerful... may change in the future.
		
		return navalPower;
	}
	
	public int recommendedAmount(String rank)
	{
		int recommendedAmount = 0;
		int totalNumberOfCrewRequired = getNumberOfAircraftCarriers() * 4000 + getNumberOfBattleships() * 1000
				+ getNumberOfDestroyers() * 300 + getNumberOfSubmarines() * 140 + getNumberOfCargoShips() * 60;
		
		if(rank.equals("Admiral"))
		{
			recommendedAmount = (int)(0.001077 * totalNumberOfCrewRequired) + 1;
		}
		else if(rank.equals("Captain"))
		{
			recommendedAmount = (int)(0.013567 * totalNumberOfCrewRequired) + 1;
		}
		else if(rank.equals("Commander"))
		{
			recommendedAmount = (int)(0.056963 * totalNumberOfCrewRequired) + 1;
		}
		else if(rank.equals("Lieutenant"))
		{
			recommendedAmount = (int)(0.133494 * totalNumberOfCrewRequired) + 1;
		}
		else if(rank.equals("Ensign"))
		{
			recommendedAmount = (int)(0.202657 * totalNumberOfCrewRequired) + 1;
		}
		else if(rank.equals("Seamen"))
		{
			recommendedAmount = (int)(0.591362 * totalNumberOfCrewRequired) + 1;
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
		if(!(obj instanceof Navy))
		{
			return false;
		}
		else
		{
			int otherAircraftCarriers = ((Navy)obj).getNumberOfAircraftCarriers();
			int otherSubmarines = ((Navy)obj).getNumberOfSubmarines();
			int otherBattleships = ((Navy)obj).getNumberOfBattleships();
			int otherDestroyers = ((Navy)obj).getNumberOfDestroyers();
			int otherCargoShips = ((Navy)obj).getNumberOfCargoShips();
			int otherAdmirals = ((Navy)obj).getNumberOfAdmirals();
			int otherCaptains = ((Navy)obj).getNumberOfCaptains();
			int otherCommanders = ((Navy)obj).getNumberOfCommanders();
			int otherLieutenants = ((Navy)obj).getNumberOfLieutenants();
			int otherEnsigns = ((Navy)obj).getNumberOfEnsigns();
			int otherSeamen = ((Navy)obj).getNumberOfSeamen();

			
			if(this.getNumberOfAircraftCarriers() == otherAircraftCarriers && this.getNumberOfSubmarines() == otherSubmarines 
					&& this.getNumberOfBattleships() == otherBattleships && this.getNumberOfDestroyers() == otherDestroyers
					&& this.getNumberOfDestroyers() == otherCargoShips && this.getNumberOfAdmirals() == otherAdmirals 
					&& this.getNumberOfCaptains() == otherCaptains && this.getNumberOfCommanders() == otherCommanders
					&& this.getNumberOfLieutenants() == otherLieutenants && this.getNumberOfEnsigns() == otherEnsigns
					&& this.getNumberOfSeamen() == otherSeamen)
			{
				return true;
			}//end of if
			else
			{
				return false;
			}//end of else
		}//end of else
	}//end of equals method
}
