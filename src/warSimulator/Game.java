package warSimulator;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Game implements ActionListener
{
	public static NumberFormat formatter = new DecimalFormat("#,###.00");
	public static NumberFormat integers = new DecimalFormat("#,###,###,###");
	public static Random rand = new Random();

	private volatile int animationIndicator = 0;
	
	private ArrayList <Military> militaries = new ArrayList<Military>();
	private int militaryNumber;	
	private int defenseMilitaryNumber;
	
	//all of the JFrames
	JFrame primaryUserInterface;//this is the game loading screen
	JFrame loadingScreen2;//this is the pre-battle loading screen with versus animation
	JFrame battleScreen;//this is the battle animation screen
	JFrame navalInterface;
	JFrame marineInterface;
	JFrame airforceInterface;
	JFrame armyInterface;
	JFrame worldInterface;
	JFrame homeInterface;
	JFrame switchMilitaryInterface;
	JFrame battleInterface1;	
	JFrame strongestBranchInterface;
	
	//buttons on the world map
	JButton USFlag;
	JButton russianFlag;
	JButton chineseFlag;
	
	//JButtons for the naval purchase interface
	JButton purchaseAircraftCarrier;
	JButton purchaseSubmarine;
	JButton purchaseBattleship;
	JButton purchaseDestroyer;
	JButton purchaseCargoShip;
	JButton hireNavalAdmiral;
	JButton hireNavalCaptain;
	JButton hireNavalCommander;
	JButton hireNavalLieutenant;
	JButton hireNavalEnsign;
	JButton hireNavalSeamen;
	
	JButton removeAircraftCarrier;
	JButton removeSubmarine;
	JButton removeBattleship;
	JButton removeDestroyer;
	JButton removeCargoShip;
	JButton fireNavalAdmiral;
	JButton fireNavalCaptain;
	JButton fireNavalCommander;
	JButton fireNavalLieutenant;
	JButton fireNavalEnsign;
	JButton fireNavalSeamen;
		
	//JButtons for the marines purchase interface
	JButton purchaseTroopTrucks;
	JButton purchaseLightArmoredVehicle;
	JButton purchaseHeavyCargoTruck;
	JButton purchaseAssaultRifle;
	JButton purchaseGranadeLauncher;
	JButton purchaseSniper;
	JButton hireMarineGeneral;
	JButton hireMarineMajorGeneral;
	JButton hireMarineColonel;
	JButton hireMarineMajor;
	JButton hireMarineCaptain;
	JButton hireMarineLiutenant;
	
	JButton removeTroopTrucks;
	JButton removeLightArmoredVehicle;
	JButton removeHeavyCargoTruck;
	JButton removeAssaultRifle;
	JButton removeGranadeLauncher;
	JButton removeSniper;
	JButton fireMarineGeneral;
	JButton fireMarineMajorGeneral;
	JButton fireMarineColonel;
	JButton fireMarineMajor;
	JButton fireMarineCaptain;
	JButton fireMarineLiutenant;
	
	//JButtons for the airforce purchase interface
	JButton purchaseCargoPlane;
	JButton purchaseFighterJet;
	JButton purchaseBomberPlane;
	JButton purchaseAttackHelicopter;
	JButton hireAirforceGeneral;
	JButton hireAirforceMajorGeneral;
	JButton hireAirforceColonel;
	JButton hireAirforceMajor;
	JButton hireAirforceCaptain;
	JButton hireAirforceLieutenant;
	
	JButton removeCargoPlane;
	JButton removeFighterJet;
	JButton removeBomberPlane;
	JButton removeAttackHelicopter;
	JButton fireAirforceGeneral;
	JButton fireAirforceMajorGeneral;
	JButton fireAirforceColonel;
	JButton fireAirforceMajor;
	JButton fireAirforceCaptain;
	JButton fireAirforceLieutenant;

	//JButtons for the army purchase interface
	JButton purchaseTank;
    JButton purchaseHelicopter;
    JButton purchaseMRAP;
    JButton purchaseGrenadeLauncher;
    JButton purchaseSquadMG;
    JButton purchaseRifle;
    JButton hireArmyGeneral;
    JButton hireArmyColonel;
    JButton hireArmyMajor;
    JButton hireArmyCaptain;
    JButton hireArmyLieutenant;
    JButton hireArmyEnlisted;
    
    JButton removeTank;
    JButton removeHelicopter;
    JButton removeMRAP;
    JButton removeGrenadeLauncher;
    JButton removeSquadMG;
    JButton removeRifle;
    JButton fireArmyGeneral;
    JButton fireArmyColonel;
    JButton fireArmyMajor;
    JButton fireArmyCaptain;
    JButton fireArmyLieutenant;
    JButton fireArmyEnlisted;

    //return home buttons
    JButton returnHomeArmy;
	JButton returnHomeNavy;
	JButton returnHomeMarines;
	JButton returnHomeAirforce;
	JButton returnHomeWorldMap;
	JButton returnHomeSwitchMilitary;
	
	//buttons for the switch military interface
	JButton createMilitary;
	JButton chooseMilitaryAvailable;
	JLabel currentMilitary;//label to display the current military name

	//button to exit the battle animation 
	JButton okButton;
	
	//buttons in the home base screen
	JButton globeSpinning;
	JButton armyEmblem;
	JButton airforceEmblem;
	JButton navyEmblem;
	JButton marinesEmblem;
	JButton switchMilitary;
	JButton displayTheStrongestBranch;
	
	//buttons for the pre-battle do you want to battle screen
	JButton attackTheUS;
	JButton attackRussia;
	JButton attackChina;
	JButton noAttack;

/****************************************************************************************/
	/*CONTRUCTORS*/
/****************************************************************************************/
	
	public Game()//starts the game
	{
		militaries.add(new Military("US Military", 0.0, new Navy("US Navy"), new Airforce("US Airforce"), new Army("US Army"), new Marines("US Marines")));
		militaries.add(new Military("Russian Military", 0.0, new Navy("Russian Navy"), new Airforce("Russian Airforce"), new Army("Russian Army"), new Marines("Russian Marines")));
		militaries.add(new Military("Chinese Military", 0.0, new Navy("Chinese Navy"), new Airforce("Chinese Airforce"), new Army("Chinese Army"), new Marines("Chinese Marines")));
		militaries.add(new Military("Default Military", 1000000000000.0, new Navy(), new Airforce(), new Army(), new Marines()));//generates a new military obj
		militaryNumber = 3;
		loadingScreen();
		homeBase();
		while(true)
		{
			System.out.print("");
			if(animationIndicator == 1)
			{
				battleInterface1.dispose();
				secondLoadingScreen(new JLabel(new ImageIcon("images/theGeneral.png")), new JLabel(new ImageIcon("images/usaSilverWord.png")));
				battle(militaries.get(militaryNumber), militaries.get(0));//this battles the US
				animationIndicator = 0;
				defenseMilitaryNumber = 0;
			}
			else if(animationIndicator == 2)
			{
				battleInterface1.dispose();
				secondLoadingScreen(new JLabel(new ImageIcon("images/sunWukong.png")), new JLabel(new ImageIcon("images/chinaSilverWord.png")));
				battle(militaries.get(militaryNumber), militaries.get(2));//this battles China
				animationIndicator = 0;
				defenseMilitaryNumber = 2;
			}
			else if(animationIndicator == 3)
			{
				//russia					
				battleInterface1.dispose();
				secondLoadingScreen(new JLabel(new ImageIcon("images/vladmirPutin.png")), new JLabel(new ImageIcon("images/russiaSilverWord.png")));
				battle(militaries.get(militaryNumber), militaries.get(1));//this battles russia
				animationIndicator = 0;
				defenseMilitaryNumber = 1;
			}
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}//end of public() constructor
	
/****************************************************************************************/
	
	public Game(ArrayList <Military> militaries)//single arg constructor - takes a military arraylist object and sets it
	{
		this.militaries = militaries;
		militaryNumber = 0;
		loadingScreen();
		homeBase();
	}//end of GUIMenu(String)

/****************************************************************************************/
	/*OTHER METHODS FOR MENUS*/
/****************************************************************************************/
	
	public void loadingScreen()
	{
		//set the background label to an image icon 
		JLabel backgroundLabel = new JLabel(new ImageIcon("images/imageTest.png"));
		backgroundLabel.setBounds(0,0,1100,680);
		backgroundLabel.setVisible(true);
		
		//create a loading bar
		JProgressBar loadingBar = new JProgressBar();
		loadingBar.setValue(0);
		loadingBar.setBounds(90, 600, 900, 10);
		loadingBar.setStringPainted(true);
		loadingBar.setString("");

		//create loading text
		JLabel loadingText = new JLabel("Loading.");
		loadingText.setBounds(450, 565, 100, 30);
		loadingText.setFont(new Font("Calibri", Font.BOLD, 25));
		loadingText.setVisible(true);
		
		//create a new GUI interface frame
		primaryUserInterface = new JFrame("JSBC War Simulator");
		primaryUserInterface.setSize(new Dimension(1100, 680));
		primaryUserInterface.setLayout(null);
		primaryUserInterface.setContentPane(backgroundLabel);
		primaryUserInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add stuff to the primaryUserInterface
		primaryUserInterface.add(loadingBar);
		primaryUserInterface.add(loadingText);
		primaryUserInterface.setLocationRelativeTo(null);
		primaryUserInterface.setVisible(true);
		
		//create the animation for the loadingBar and the loadingText
		for(int i = 1; i <= 100; i++)
		{
			loadingBar.setValue(i);
			
			if(i%20 == 0)
			{
				primaryUserInterface.remove(loadingText);
				loadingText = new JLabel("Loading.");
				loadingText.setBounds(450, 565, 100, 30);
				loadingText.setFont(new Font("Calibri", Font.BOLD, 25));
				loadingText.setVisible(true);
				primaryUserInterface.setSize(new Dimension(1100, 680));
				primaryUserInterface.setLayout(null);
				primaryUserInterface.setContentPane(backgroundLabel);
				primaryUserInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				primaryUserInterface.add(loadingText);
				primaryUserInterface.setLocationRelativeTo(null);
				primaryUserInterface.setVisible(true);
			}
			else if((i%20)%16 == 0)
			{
				primaryUserInterface.remove(loadingText);
				loadingText = new JLabel("Loading.....");
				loadingText.setBounds(450, 565, 200, 30);
				loadingText.setFont(new Font("Calibri", Font.BOLD, 25));
				loadingText.setVisible(true);
				primaryUserInterface.setSize(new Dimension(1100, 680));
				primaryUserInterface.setLayout(null);
				primaryUserInterface.setContentPane(backgroundLabel);
				primaryUserInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				primaryUserInterface.add(loadingText);
				primaryUserInterface.setLocationRelativeTo(null);
				primaryUserInterface.setVisible(true);
			}
			else if((i%20)%12 == 0)
			{
				primaryUserInterface.remove(loadingText);
				loadingText = new JLabel("Loading....");
				loadingText.setBounds(450, 565, 180, 30);
				loadingText.setFont(new Font("Calibri", Font.BOLD, 25));
				loadingText.setVisible(true);
				primaryUserInterface.setSize(new Dimension(1100, 680));
				primaryUserInterface.setLayout(null);
				primaryUserInterface.setContentPane(backgroundLabel);
				primaryUserInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				primaryUserInterface.add(loadingText);
				primaryUserInterface.setLocationRelativeTo(null);
				primaryUserInterface.setVisible(true);
			}
			else if((i%20)%8 == 0)
			{
				primaryUserInterface.remove(loadingText);
				loadingText = new JLabel("Loading...");
				loadingText.setBounds(450, 565, 160, 30);
				loadingText.setFont(new Font("Calibri", Font.BOLD, 25));
				loadingText.setVisible(true);
				primaryUserInterface.setSize(new Dimension(1100, 680));
				primaryUserInterface.setLayout(null);
				primaryUserInterface.setContentPane(backgroundLabel);
				primaryUserInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				primaryUserInterface.add(loadingText);
				primaryUserInterface.setLocationRelativeTo(null);
				primaryUserInterface.setVisible(true);
			}
			else if ((i%20)%4 == 0)
			{
				loadingText = new JLabel("Loading..");
				loadingText.setBounds(450, 565, 140, 30);
				loadingText.setFont(new Font("Calibri", Font.BOLD, 25));
				loadingText.setVisible(true);
				primaryUserInterface.setSize(new Dimension(1100, 680));
				primaryUserInterface.setLayout(null);
				primaryUserInterface.setContentPane(backgroundLabel);
				primaryUserInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				primaryUserInterface.add(loadingText);
				primaryUserInterface.setLocationRelativeTo(null);
				primaryUserInterface.setVisible(true);
			}
			
			try 
			{
				Thread.sleep(18);//18?
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}//end of for 
		
		//throws away the loading screen frame in the hope that their will be a next frame
		primaryUserInterface.dispose();
	}//end of loadingScreen
	
/****************************************************************************************/

	public void secondLoadingScreen(JLabel enemy, JLabel enemyTag)
	{
		loadingScreen2 = new JFrame("JSBC War Simulator");
		loadingScreen2.setSize(new Dimension(1100, 680));
		loadingScreen2.setContentPane(new JLabel(new ImageIcon("images/fireBackground.gif")));
		loadingScreen2.setLayout(null);
		loadingScreen2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loadingScreen2.setLocationRelativeTo(null);
		loadingScreen2.setVisible(true);
		
		JLabel pacMan = new JLabel(new ImageIcon("images/pacMan.png"));
		pacMan.setBounds(0, 10, 500, 500);//final bounds
		pacMan.setVisible(true);
		
//		JLabel enemy = new JLabel(new ImageIcon("images/theGeneral.png"));//already passed in
		enemy.setBounds(490, 149, 600, 500);//final bounds
		enemy.setVisible(true);
		
		JLabel versus = new JLabel(new ImageIcon("images/versus3.png"));
		versus.setBounds(415, 260, 200, 200);
		versus.setVisible(true);
		
//		JLabel enemyTag = new JLabel(new ImageIcon("images/usaSilverWord.png"));//already passed in
		enemyTag.setBounds(618, 500, 350, 100);//final bounds
		enemyTag.setVisible(true);
		
		JLabel playerName = new JLabel(new ImageIcon("images/playerWord.png"));
		playerName.setBounds(50, 350, 350, 100);
		playerName.setVisible(true);
		
		//animation starts here:
		int count = 0;
		long startingTime = System.currentTimeMillis();
		while(count < 400)
		{
			if(count == 0)
			{//initial bounds
				versus.setBounds(415, 260, 0, 200);//200
				loadingScreen2.add(versus);
				playerName.setBounds(50, 350, 0, 100);//350
				loadingScreen2.add(playerName);
				pacMan.setBounds(-500, -490, 500, 500);
				loadingScreen2.add(pacMan);
				enemyTag.setBounds(618, 500, 0, 100);//350
				loadingScreen2.add(enemyTag);
				enemy.setBounds(1090, 649, 600, 500);
				loadingScreen2.add(enemy);
			}
			else if(count > 250)
			{
				versus.setBounds(415, 260, 0 + (int)((count-250) * 1.33333), 200);//200
				playerName.setBounds(50, 350, 0 + (int)((count-250) * 2.33333), 100);//350
				enemyTag.setBounds(618, 500, 0 + (int)((count-250) * 2.33333), 100);//350
			}
			else
			{
				pacMan.setBounds(-500 + count*2, -490 + count*2, 500, 500);//incremental bounds
				enemy.setBounds(1090 - (int)(count*2.4), 649 - count*2, 600, 500);//incremental bounds
			}
			count = (int)(System.currentTimeMillis()/2 - startingTime/2);
		}
		
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		//throws away the loading screen frame in the hope that their will be a next frame
		loadingScreen2.dispose();
		
	}//end of secondLoadingScreen
	
/****************************************************************************************/
	
	public void navyMenu()
	{		
		//set the navy ship yard image to a label
		JLabel backgroundLabelNavy = new JLabel(new ImageIcon("images/navyShipyard.png"));
		backgroundLabelNavy.setBounds(0, 0, 1100, 680);
		backgroundLabelNavy.setVisible(true);

		//create the naval interface
		navalInterface = new JFrame("Navy Shipyard");
		navalInterface.setSize(new Dimension(1100,680));
		navalInterface.setLayout(null);
		navalInterface.setContentPane(backgroundLabelNavy);
		navalInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a JLabel for the power
		String message = "Fire Power: " + formatter.format(militaries.get(militaryNumber).getNavy().calculatePower()) + " Nuketons";
		JLabel rawPower = new JLabel(message);
		rawPower.setFont(new Font("Calibri", Font.PLAIN, 25));
		rawPower.setBounds(40, 10, 400, 50);
		rawPower.setVisible(true);
		
		//create a JLabel for the current balance
		message = "Balance: $" + formatter.format(militaries.get(militaryNumber).getBalance());
		JLabel currentBalance = new JLabel(message);
		currentBalance.setFont(new Font("Calibri", Font.PLAIN, 25));
		currentBalance.setBounds(700, 10, 400, 50);
		currentBalance.setVisible(true);
		
		//create JLabels for each of the equipment types
		message = "Aircraft Carrier...$13B               QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfAircraftCarriers();
		JLabel aircraftCarrier = new JLabel(message);
		aircraftCarrier.setFont(new Font("Calibri", Font.PLAIN, 25));
		aircraftCarrier.setBounds(40, 60, 500, 50);
		aircraftCarrier.setVisible(true);
		
		message = "Submarine..........$4.5B              QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfSubmarines();
		JLabel submarine = new JLabel(message);
		submarine.setFont(new Font("Calibri", Font.PLAIN, 25));
		submarine.setBounds(40, 110, 500, 50);
		submarine.setVisible(true);
		
		message = "Battleship...........$2.6B              QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfBattleships();
		JLabel battleship = new JLabel(message);
		battleship.setFont(new Font("Calibri", Font.PLAIN, 25));
		battleship.setBounds(40, 160, 500, 50);
		battleship.setVisible(true);
		
		message = "Destroyer............$1.8B              QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfDestroyers();
		JLabel destroyer = new JLabel(message);
		destroyer.setFont(new Font("Calibri", Font.PLAIN, 25));
		destroyer.setBounds(40, 210, 500, 50);
		destroyer.setVisible(true);
		
		message = "Cargo Ship..........$1.2B              QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfCargoShips();
		JLabel cargoShip = new JLabel(message);
		cargoShip.setFont(new Font("Calibri", Font.PLAIN, 25));
		cargoShip.setBounds(40, 260, 500, 50);
		cargoShip.setVisible(true);
		
		//create JLabels for each of the soldier ranks
		message = "Admiral...............$220K             QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfAdmirals();
		JLabel admiral = new JLabel(message);
		admiral.setFont(new Font("Calibri", Font.PLAIN, 25));
		admiral.setBounds(40, 330, 500, 50);
		admiral.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getNavy().recommendedAmount("Admiral"));
		JLabel admiralRecommendedAmount = new JLabel(message);
		admiralRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		admiralRecommendedAmount.setBounds(500, 330, 400, 50);
		admiralRecommendedAmount.setVisible(true);
		
		message = "Captain...............$90K               QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfCaptains();
		JLabel captain = new JLabel(message);
		captain.setFont(new Font("Calibri", Font.PLAIN, 25));
		captain.setBounds(40, 380, 500, 50);
		captain.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getNavy().recommendedAmount("Captain"));
		JLabel captainRecommendedAmount = new JLabel(message);
		captainRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		captainRecommendedAmount.setBounds(500, 380, 400, 50);
		captainRecommendedAmount.setVisible(true);
		
		message = "Commander........$75K              QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfCommanders();
		JLabel commander = new JLabel(message);
		commander.setFont(new Font("Calibri", Font.PLAIN, 25));
		commander.setBounds(40, 430, 500, 50);
		commander.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getNavy().recommendedAmount("Commander"));
		JLabel commanderRecommendedAmount = new JLabel(message);
		commanderRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		commanderRecommendedAmount.setBounds(500, 430, 400, 50);
		commanderRecommendedAmount.setVisible(true);
		
		message = "Lieutenant...........$60K              QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfLieutenants();
		JLabel lieutenant = new JLabel(message);
		lieutenant.setFont(new Font("Calibri", Font.PLAIN, 25));
		lieutenant.setBounds(40, 480, 500, 50);
		lieutenant.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getNavy().recommendedAmount("Lieutenant"));
		JLabel lieutenantRecommendedAmount = new JLabel(message);
		lieutenantRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		lieutenantRecommendedAmount.setBounds(500, 480, 400, 50);
		lieutenantRecommendedAmount.setVisible(true);
		
		message = "Ensign..................$42K              QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfEnsigns();
		JLabel ensign = new JLabel(message);
		ensign.setFont(new Font("Calibri", Font.PLAIN, 25));
		ensign.setBounds(40, 530, 500, 50);
		ensign.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getNavy().recommendedAmount("Ensign"));
		JLabel ensignRecommendedAmount = new JLabel(message);
		ensignRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		ensignRecommendedAmount.setBounds(500, 530, 400, 50);
		ensignRecommendedAmount.setVisible(true);
		
		message = "Seamen...............$26K               QTY: " + militaries.get(militaryNumber).getNavy().getNumberOfSeamen();
		JLabel seamen = new JLabel(message);
		seamen.setFont(new Font("Calibri", Font.PLAIN, 25));
		seamen.setBounds(40, 580, 500, 50);
		seamen.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getNavy().recommendedAmount("Seamen"));
		JLabel seamenRecommendedAmount = new JLabel(message);
		seamenRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		seamenRecommendedAmount.setBounds(500, 580, 400, 50);
		seamenRecommendedAmount.setVisible(true);
		
		
		//create dividers
		JLabel dividerShort = new JLabel("_______________________________________");
		dividerShort.setFont(new Font("Calibri", Font.PLAIN, 25));
		dividerShort.setBounds(40, 285, 500, 50);
		dividerShort.setVisible(true);
		
		JLabel dividerLong = new JLabel("___________________________________________________________________________________");
		dividerLong.setFont(new Font("Calibri", Font.PLAIN, 25));
		dividerLong.setBounds(40, 30, 1020, 30);
		dividerLong.setVisible(true);
		
		//create the return home button
		returnHomeNavy = new JButton(new ImageIcon("images/homeIcon2.png"));
		returnHomeNavy.setBounds(980, 550, 80, 80);
		returnHomeNavy.setContentAreaFilled(false);
		returnHomeNavy.setBorderPainted(false);
		returnHomeNavy.setFocusPainted(false);
		returnHomeNavy.addActionListener(this);
		
		//create buttons for each of the equipment types
		purchaseAircraftCarrier = new JButton("Purchase");
		purchaseAircraftCarrier.setBounds(780, 65, 90, 30);//compare to 40, 60, 500, 50
		purchaseAircraftCarrier.setFocusable(false);
		purchaseAircraftCarrier.addActionListener(this);
		
		removeAircraftCarrier = new JButton("Remove");
		removeAircraftCarrier.setBounds(880, 65, 90, 30);//compare to 40, 60, 500, 50
		removeAircraftCarrier.setFocusable(false);
		removeAircraftCarrier.addActionListener(this);
		
		purchaseSubmarine = new JButton("Purchase");
		purchaseSubmarine.setBounds(780, 115, 90, 30);
		purchaseSubmarine.setFocusable(false);
		purchaseSubmarine.addActionListener(this);
		
		removeSubmarine = new JButton("Remove");
		removeSubmarine.setBounds(880, 115, 90, 30);
		removeSubmarine.setFocusable(false);
		removeSubmarine.addActionListener(this);
		
		purchaseBattleship = new JButton("Purchase");
		purchaseBattleship.setBounds(780, 165, 90, 30);
		purchaseBattleship.setFocusable(false);
		purchaseBattleship.addActionListener(this);
		
		removeBattleship = new JButton("Remove");
		removeBattleship.setBounds(880, 165, 90, 30);
		removeBattleship.setFocusable(false);
		removeBattleship.addActionListener(this);
		
		purchaseDestroyer = new JButton("Purchase");
		purchaseDestroyer.setBounds(780, 215, 90, 30);
		purchaseDestroyer.setFocusable(false);
		purchaseDestroyer.addActionListener(this);
		
		removeDestroyer = new JButton("Remove");
		removeDestroyer.setBounds(880, 215, 90, 30);
		removeDestroyer.setFocusable(false);
		removeDestroyer.addActionListener(this);
		
		purchaseCargoShip = new JButton("Purchase");
		purchaseCargoShip.setBounds(780, 265, 90, 30);
		purchaseCargoShip.setFocusable(false);
		purchaseCargoShip.addActionListener(this);
		
		removeCargoShip = new JButton("Remove");
		removeCargoShip.setBounds(880, 265, 90, 30);
		removeCargoShip.setFocusable(false);
		removeCargoShip.addActionListener(this);
		
		//create buttons for each of the ranks
		hireNavalAdmiral = new JButton("Hire");
		hireNavalAdmiral.setBounds(780, 335, 90, 30);
		hireNavalAdmiral.setFocusable(false);
		hireNavalAdmiral.addActionListener(this);
		
		fireNavalAdmiral = new JButton("Fire");
		fireNavalAdmiral.setBounds(880, 335, 90, 30);
		fireNavalAdmiral.setFocusable(false);
		fireNavalAdmiral.addActionListener(this);
		
		hireNavalCaptain = new JButton("Hire");
		hireNavalCaptain.setBounds(780, 385, 90, 30);
		hireNavalCaptain.setFocusable(false);
		hireNavalCaptain.addActionListener(this);
		
		fireNavalCaptain = new JButton("Fire");
		fireNavalCaptain.setBounds(880, 385, 90, 30);
		fireNavalCaptain.setFocusable(false);
		fireNavalCaptain.addActionListener(this);
		
		hireNavalCommander = new JButton("Hire");
		hireNavalCommander.setBounds(780, 435, 90, 30);
		hireNavalCommander.setFocusable(false);
		hireNavalCommander.addActionListener(this);
		
		fireNavalCommander = new JButton("Fire");
		fireNavalCommander.setBounds(880, 435, 90, 30);
		fireNavalCommander.setFocusable(false);
		fireNavalCommander.addActionListener(this);
		
		hireNavalLieutenant = new JButton("Hire");
		hireNavalLieutenant.setBounds(780, 485, 90, 30);
		hireNavalLieutenant.setFocusable(false);
		hireNavalLieutenant.addActionListener(this);
		
		fireNavalLieutenant = new JButton("Fire");
		fireNavalLieutenant.setBounds(880, 485, 90, 30);
		fireNavalLieutenant.setFocusable(false);
		fireNavalLieutenant.addActionListener(this);
		
		hireNavalEnsign = new JButton("Hire");
		hireNavalEnsign.setBounds(780, 535, 90, 30);
		hireNavalEnsign.setFocusable(false);
		hireNavalEnsign.addActionListener(this);
		
		fireNavalEnsign = new JButton("Fire");
		fireNavalEnsign.setBounds(880, 535, 90, 30);
		fireNavalEnsign.setFocusable(false);
		fireNavalEnsign.addActionListener(this);
		
		hireNavalSeamen = new JButton("Hire");
		hireNavalSeamen.setBounds(780, 585, 90, 30);
		hireNavalSeamen.setFocusable(false);
		hireNavalSeamen.addActionListener(this);
		
		fireNavalSeamen = new JButton("Fire");
		fireNavalSeamen.setBounds(880, 585, 90, 30);
		fireNavalSeamen.setFocusable(false);
		fireNavalSeamen.addActionListener(this);
		
		//add all of the JLabels and JButtons to the naval interface
		navalInterface.add(rawPower);
		navalInterface.add(currentBalance);
		navalInterface.add(dividerLong);
		navalInterface.add(aircraftCarrier);
		navalInterface.add(purchaseAircraftCarrier);
		navalInterface.add(removeAircraftCarrier);
		navalInterface.add(submarine);
		navalInterface.add(purchaseSubmarine);
		navalInterface.add(removeSubmarine);
		navalInterface.add(battleship);
		navalInterface.add(purchaseBattleship);
		navalInterface.add(removeBattleship);
		navalInterface.add(destroyer);
		navalInterface.add(purchaseDestroyer);
		navalInterface.add(removeDestroyer);
		navalInterface.add(cargoShip);
		navalInterface.add(purchaseCargoShip);
		navalInterface.add(removeCargoShip);
		navalInterface.add(dividerShort);
		navalInterface.add(admiral);
		navalInterface.add(admiralRecommendedAmount);
		navalInterface.add(hireNavalAdmiral);
		navalInterface.add(fireNavalAdmiral);
		navalInterface.add(captain);
		navalInterface.add(captainRecommendedAmount);
		navalInterface.add(hireNavalCaptain);
		navalInterface.add(fireNavalCaptain);
		navalInterface.add(commander);
		navalInterface.add(commanderRecommendedAmount);
		navalInterface.add(hireNavalCommander);
		navalInterface.add(fireNavalCommander);
		navalInterface.add(lieutenant);
		navalInterface.add(lieutenantRecommendedAmount);
		navalInterface.add(hireNavalLieutenant);
		navalInterface.add(fireNavalLieutenant);
		navalInterface.add(ensign);
		navalInterface.add(ensignRecommendedAmount);
		navalInterface.add(hireNavalEnsign);
		navalInterface.add(fireNavalEnsign);
		navalInterface.add(seamen);
		navalInterface.add(seamenRecommendedAmount);
		navalInterface.add(hireNavalSeamen);
		navalInterface.add(fireNavalSeamen);

		navalInterface.add(returnHomeNavy);
		
		navalInterface.setLocationRelativeTo(null);
		navalInterface.setVisible(true);
		
		returnHomeNavy.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				returnHomeNavy.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e)
			{
				returnHomeNavy.setBorderPainted(false);
			}
		}
		);
		
	}//end of navyMenu()
	
/****************************************************************************************/
	
	public void marineMenu()
	{
		//set the marines base image to a label
		JLabel backgroundLabelMarine = new JLabel(new ImageIcon("images/marinesBase.png"));
		backgroundLabelMarine.setBounds(0, 0, 1100, 680);
		backgroundLabelMarine.setVisible(true);

		//create the marines interface
		marineInterface = new JFrame("Marine Corps Base");
		marineInterface.setSize(new Dimension(1100,680));
		marineInterface.setLayout(null);
		marineInterface.setContentPane(backgroundLabelMarine);
		marineInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a JLabel for the power
		String message = "Fire Power: " + formatter.format(militaries.get(militaryNumber).getMarines().calculatePower()) + " Nuketons";
		JLabel rawPowerMarine = new JLabel(message);
		rawPowerMarine.setFont(new Font("Calibri", Font.PLAIN, 25));
		rawPowerMarine.setBounds(40, 10, 400, 50);
		rawPowerMarine.setVisible(true);
		
		//create a JLabel for the current balance
		message = "Balance: $" + formatter.format(militaries.get(militaryNumber).getBalance());
		JLabel currentBalanceMarine = new JLabel(message);
		currentBalanceMarine.setFont(new Font("Calibri", Font.PLAIN, 25));
		currentBalanceMarine.setBounds(700, 10, 400, 50);
		currentBalanceMarine.setVisible(true);
		
		//create JLabels for each of the equipment types
		message = "Troop Truck...................$220k   | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumTroopTrucks());
		JLabel troopTrucks = new JLabel(message);
		troopTrucks.setFont(new Font("Calibri", Font.PLAIN, 25));
		troopTrucks.setBounds(40, 60, 630, 40);
		troopTrucks.setVisible(true);
		
		message = "Light Armored Vehicle..$2M     | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumLightArmoredVehicles());
		JLabel lightArmoredVehicle = new JLabel(message);
		lightArmoredVehicle.setFont(new Font("Calibri", Font.PLAIN, 25));
		lightArmoredVehicle.setBounds(40, 100, 630, 40);
		lightArmoredVehicle.setVisible(true);
		
		message = "Heavy Cargo Truck........$200K  | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumHeavyCargoTrucks());
		JLabel heavyCargoTruck = new JLabel(message);
		heavyCargoTruck.setFont(new Font("Calibri", Font.PLAIN, 25));
		heavyCargoTruck.setBounds(40, 140, 630, 40);
		heavyCargoTruck.setVisible(true);
		
		message = "Assault Rifle...................$1.3k    | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumAR());
		JLabel assaultRifle = new JLabel(message);
		assaultRifle.setFont(new Font("Calibri", Font.PLAIN, 25));
		assaultRifle.setBounds(40, 180, 630, 40);
		assaultRifle.setVisible(true);
		
		message = "Grenade Launcher.........$3.5k    | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumGrenadeLauncher());
		JLabel granadeLauncher = new JLabel(message); 
		granadeLauncher.setFont(new Font("Calibri", Font.PLAIN, 25));
		granadeLauncher.setBounds(40, 220, 630, 40);
		granadeLauncher.setVisible(true);
		
		message = "Sniper.............................$12k     | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumSnipers());
		JLabel sniper = new JLabel(message);
		sniper.setFont(new Font("Calibri", Font.PLAIN, 25));
		sniper.setBounds(40, 260, 630, 40);
		sniper.setVisible(true);
		
		message = "General..................$220k           | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumGenerals());
		JLabel marineGeneral = new JLabel(message);
		marineGeneral.setFont(new Font("Calibri", Font.PLAIN, 25));
		marineGeneral.setBounds(40, 330, 630, 50);
		marineGeneral.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getMarines().recommendedAmount("General"));
		JLabel generalRecommendedAmount = new JLabel(message);
		generalRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		generalRecommendedAmount.setBounds(500, 330, 400, 50);
		generalRecommendedAmount.setVisible(true);
		
		message = "Major General.......$90k             | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumMajorGenerals());
		JLabel marineMajorGeneral = new JLabel(message);
		marineMajorGeneral.setFont(new Font("Calibri", Font.PLAIN, 25));
		marineMajorGeneral.setBounds(40, 380, 630, 50);
		marineMajorGeneral.setVisible(true);

		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getMarines().recommendedAmount("Major General"));
		JLabel majorGeneralRecommendedAmount = new JLabel(message);
		majorGeneralRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		majorGeneralRecommendedAmount.setBounds(500, 380, 400, 50);
		majorGeneralRecommendedAmount.setVisible(true);
	
		message = "Colonel...................$75k             | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumColonels());
		JLabel marineColonel = new JLabel(message);
		marineColonel.setFont(new Font("Calibri", Font.PLAIN, 25));
		marineColonel.setBounds(40, 430, 630, 50);
		marineColonel.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getMarines().recommendedAmount("Colonel"));
		JLabel colonelRecommendedAmount = new JLabel(message);
		colonelRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		colonelRecommendedAmount.setBounds(500, 430, 400, 50);
		colonelRecommendedAmount.setVisible(true);
		
		message = "Major.....................$60k             | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumMajors());
		JLabel marineMajor = new JLabel(message);
		marineMajor.setFont(new Font("Calibri", Font.PLAIN, 25));
		marineMajor.setBounds(40, 480, 630, 50);
		marineMajor.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getMarines().recommendedAmount("Major"));
		JLabel majorRecommendedAmount = new JLabel(message);
		majorRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		majorRecommendedAmount.setBounds(500, 480, 400, 50);
		majorRecommendedAmount.setVisible(true);
		
		message = "Captain..................$42k             | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumCaptains());
		JLabel marineCaptain = new JLabel(message);
		marineCaptain.setFont(new Font("Calibri", Font.PLAIN, 25));
		marineCaptain.setBounds(40, 530, 630, 50);
		marineCaptain.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getMarines().recommendedAmount("Captain"));
		JLabel captainRecommendedAmount = new JLabel(message);
		captainRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		captainRecommendedAmount.setBounds(500, 530, 400, 50);
		captainRecommendedAmount.setVisible(true);
		
		message = "Lieutenant.............$26k             | QTY: " + integers.format(militaries.get(militaryNumber).getMarines().getNumLieutenants());
		JLabel marineLiutenant = new JLabel(message);
		marineLiutenant.setFont(new Font("Calibri", Font.PLAIN, 25));
		marineLiutenant.setBounds(40, 580, 630, 50);
		marineLiutenant.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getMarines().recommendedAmount("Lieutenant"));
		JLabel lieutenantRecommendedAmount = new JLabel(message);
		lieutenantRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		lieutenantRecommendedAmount.setBounds(500, 580, 400, 50);
		lieutenantRecommendedAmount.setVisible(true);
		
		
		//create dividers ----- Maybe we should have these as globally usable dividers?
		JLabel dividerShort = new JLabel("____________________________________________________");
		dividerShort.setFont(new Font("Calibri", Font.PLAIN, 25));
		dividerShort.setBounds(40, 285, 650, 50);
		dividerShort.setVisible(true);
		
		JLabel dividerLong = new JLabel("___________________________________________________________________________________");
		dividerLong.setFont(new Font("Calibri", Font.PLAIN, 25));
		dividerLong.setBounds(40, 30, 1020, 30);
		dividerLong.setVisible(true);
		
		//create the return home button
		returnHomeMarines = new JButton(new ImageIcon("images/homeIcon2.png"));
		returnHomeMarines.setBounds(980, 550, 80, 80);
		returnHomeMarines.setContentAreaFilled(false);
		returnHomeMarines.setBorderPainted(false);
		returnHomeMarines.setFocusPainted(false);
		returnHomeMarines.addActionListener(this);
		
		//create buttons for each of the equipment types
		purchaseTroopTrucks = new JButton("Purchase");
		purchaseTroopTrucks.setBounds(780, 65, 90, 25);//compare to 40, 60, 500, 50
		purchaseTroopTrucks.setFocusable(false);
		purchaseTroopTrucks.addActionListener(this);
		
		removeTroopTrucks = new JButton("Remove");
		removeTroopTrucks.setBounds(880, 65, 90, 25);//compare to 40, 60, 500, 50
		removeTroopTrucks.setFocusable(false);
		removeTroopTrucks.addActionListener(this);
		
		purchaseLightArmoredVehicle = new JButton("Purchase");
		purchaseLightArmoredVehicle.setBounds(780, 105, 90, 25);
		purchaseLightArmoredVehicle.setFocusable(false);
		purchaseLightArmoredVehicle.addActionListener(this);
		
		removeLightArmoredVehicle = new JButton("Remove");
		removeLightArmoredVehicle.setBounds(880, 105, 90, 25);
		removeLightArmoredVehicle.setFocusable(false);
		removeLightArmoredVehicle.addActionListener(this);
		
		purchaseHeavyCargoTruck = new JButton("Purchase");
		purchaseHeavyCargoTruck.setBounds(780, 145, 90, 25);
		purchaseHeavyCargoTruck.setFocusable(false);
		purchaseHeavyCargoTruck.addActionListener(this);
		
		removeHeavyCargoTruck = new JButton("Remove");
		removeHeavyCargoTruck.setBounds(880, 145, 90, 25);
		removeHeavyCargoTruck.setFocusable(false);
		removeHeavyCargoTruck.addActionListener(this);
		
		purchaseAssaultRifle = new JButton("Purchase");
		purchaseAssaultRifle.setBounds(780, 185, 90, 25);
		purchaseAssaultRifle.setFocusable(false);
		purchaseAssaultRifle.addActionListener(this);
		
		removeAssaultRifle = new JButton("Remove");
		removeAssaultRifle.setBounds(880, 185, 90, 25);
		removeAssaultRifle.setFocusable(false);
		removeAssaultRifle.addActionListener(this);
		
		purchaseGranadeLauncher = new JButton("Purchase");
		purchaseGranadeLauncher.setBounds(780, 225, 90, 25);
		purchaseGranadeLauncher.setFocusable(false);
		purchaseGranadeLauncher.addActionListener(this);
		
		removeGranadeLauncher = new JButton("Remove");
		removeGranadeLauncher.setBounds(880, 225, 90, 25);
		removeGranadeLauncher.setFocusable(false);
		removeGranadeLauncher.addActionListener(this);
		
		purchaseSniper = new JButton("Purchase");
		purchaseSniper.setBounds(780, 265, 90, 25);
		purchaseSniper.setFocusable(false);
		purchaseSniper.addActionListener(this);
		
		removeSniper = new JButton("Remove");
		removeSniper.setBounds(880, 265, 90, 25);
		removeSniper.setFocusable(false);
		removeSniper.addActionListener(this);
		
		//create buttons for each of the ranks
		hireMarineGeneral = new JButton("Hire");
		hireMarineGeneral.setBounds(780, 335, 90, 30);
		hireMarineGeneral.setFocusable(false);
		hireMarineGeneral.addActionListener(this);
		
		fireMarineGeneral = new JButton("Fire");
		fireMarineGeneral.setBounds(880, 335, 90, 30);
		fireMarineGeneral.setFocusable(false);
		fireMarineGeneral.addActionListener(this);
		
		hireMarineMajorGeneral = new JButton("Hire");
		hireMarineMajorGeneral.setBounds(780, 385, 90, 30);
		hireMarineMajorGeneral.setFocusable(false);
		hireMarineMajorGeneral.addActionListener(this);
		
		fireMarineMajorGeneral = new JButton("Fire");
		fireMarineMajorGeneral.setBounds(880, 385, 90, 30);
		fireMarineMajorGeneral.setFocusable(false);
		fireMarineMajorGeneral.addActionListener(this);
		
		hireMarineColonel = new JButton("Hire");
		hireMarineColonel.setBounds(780, 435, 90, 30);
		hireMarineColonel.setFocusable(false);
		hireMarineColonel.addActionListener(this);
		
		fireMarineColonel = new JButton("Fire");
		fireMarineColonel.setBounds(880, 435, 90, 30);
		fireMarineColonel.setFocusable(false);
		fireMarineColonel.addActionListener(this);
		
		hireMarineMajor = new JButton("Hire");
		hireMarineMajor.setBounds(780, 485, 90, 30);
		hireMarineMajor.setFocusable(false);
		hireMarineMajor.addActionListener(this);
		
		fireMarineMajor = new JButton("Fire");
		fireMarineMajor.setBounds(880, 485, 90, 30);
		fireMarineMajor.setFocusable(false);
		fireMarineMajor.addActionListener(this);
		
		hireMarineCaptain = new JButton("Hire");
		hireMarineCaptain.setBounds(780, 535, 90, 30);
		hireMarineCaptain.setFocusable(false);
		hireMarineCaptain.addActionListener(this);
		
		fireMarineCaptain = new JButton("Fire");
		fireMarineCaptain.setBounds(880, 535, 90, 30);
		fireMarineCaptain.setFocusable(false);
		fireMarineCaptain.addActionListener(this);
		
		hireMarineLiutenant = new JButton("Hire");
		hireMarineLiutenant.setBounds(780, 585, 90, 30);
		hireMarineLiutenant.setFocusable(false);
		hireMarineLiutenant.addActionListener(this);
		
		fireMarineLiutenant = new JButton("Fire");
		fireMarineLiutenant.setBounds(880, 585, 90, 30);
		fireMarineLiutenant.setFocusable(false);
		fireMarineLiutenant.addActionListener(this);
		
		//add all of the JLabels and JButtons to the Marines interface
		marineInterface.add(rawPowerMarine);
		marineInterface.add(currentBalanceMarine);
		marineInterface.add(dividerLong);
		marineInterface.add(troopTrucks);
		marineInterface.add(purchaseTroopTrucks);
		marineInterface.add(lightArmoredVehicle);
		marineInterface.add(purchaseLightArmoredVehicle);
		marineInterface.add(heavyCargoTruck);
		marineInterface.add(purchaseHeavyCargoTruck);
		marineInterface.add(assaultRifle);
		marineInterface.add(purchaseAssaultRifle);
		marineInterface.add(granadeLauncher);
		marineInterface.add(purchaseGranadeLauncher);
		marineInterface.add(sniper);
		marineInterface.add(purchaseSniper);
		marineInterface.add(dividerShort);
		marineInterface.add(marineGeneral);
		marineInterface.add(generalRecommendedAmount);
		marineInterface.add(hireMarineGeneral);
		marineInterface.add(marineMajorGeneral);
		marineInterface.add(majorGeneralRecommendedAmount);
		marineInterface.add(hireMarineMajorGeneral);
		marineInterface.add(marineColonel);
		marineInterface.add(colonelRecommendedAmount);
		marineInterface.add(hireMarineColonel);
		marineInterface.add(marineMajor);
		marineInterface.add(majorRecommendedAmount);
		marineInterface.add(hireMarineMajor);
		marineInterface.add(marineCaptain);
		marineInterface.add(captainRecommendedAmount);
		marineInterface.add(hireMarineCaptain);
		marineInterface.add(marineLiutenant);
		marineInterface.add(lieutenantRecommendedAmount);
		marineInterface.add(hireMarineLiutenant);
		marineInterface.add(returnHomeMarines);
		
		marineInterface.add(removeTroopTrucks);
		marineInterface.add(removeLightArmoredVehicle);
		marineInterface.add(removeHeavyCargoTruck);
		marineInterface.add(removeAssaultRifle);
		marineInterface.add(removeGranadeLauncher);
		marineInterface.add(removeSniper);
		marineInterface.add(fireMarineGeneral);
		marineInterface.add(fireMarineMajorGeneral);
		marineInterface.add(fireMarineColonel);
		marineInterface.add(fireMarineMajor);
		marineInterface.add(fireMarineCaptain);
		marineInterface.add(fireMarineLiutenant);

		marineInterface.setLocationRelativeTo(null);
		marineInterface.setVisible(true);
		
		returnHomeMarines.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				returnHomeMarines.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				returnHomeMarines.setBorderPainted(false);
			}
		}
		);
		
	}//end of MarinesMenu() 
	
/****************************************************************************************/
	
	public void airforceMenu() 
	{		
		//set the navy ship yard image to a label
		JLabel backgroundLabelAirforce = new JLabel(new ImageIcon("images/airforceBase.png"));
		backgroundLabelAirforce.setBounds(0, 0, 1100, 680);
		backgroundLabelAirforce.setVisible(true);

		//create the airforce interface
		airforceInterface = new JFrame("Air Force Base");
		airforceInterface.setSize(new Dimension(1100,680));
		airforceInterface.setLayout(null);
		airforceInterface.setContentPane(backgroundLabelAirforce);
		airforceInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a JLabel for the power
		String message = "Fire Power: " + formatter.format(militaries.get(militaryNumber).getAirforce().calculatePower()) + " Nuketons";
		JLabel rawPowerAirforce = new JLabel(message);
		rawPowerAirforce.setFont(new Font("Calibri", Font.PLAIN, 25));
		rawPowerAirforce.setBounds(40, 10, 400, 50);
		rawPowerAirforce.setVisible(true);
		
		//create a JLabel for the current balance
		message = "Balance: $" + formatter.format(militaries.get(militaryNumber).getBalance());
		JLabel currentBalanceAirforce = new JLabel(message);
		currentBalanceAirforce.setFont(new Font("Calibri", Font.PLAIN, 25));
		currentBalanceAirforce.setBounds(700, 10, 400, 50);
		currentBalanceAirforce.setVisible(true);
		
		//create JLabels for each of the equipment types
		message = "Bomber Plane........$423M    | QTY: " + integers.format(militaries.get(militaryNumber).getAirforce().getNumBomberPlane());
		JLabel bomberPlane = new JLabel(message);
		bomberPlane.setFont(new Font("Calibri", Font.PLAIN, 25));
		bomberPlane.setBounds(40, 60, 630, 50);
		bomberPlane.setVisible(true);
		
		message = "Fighter Jet..............$121M    | QTY: " + integers.format(militaries.get(militaryNumber).getAirforce().getNumFighterJet());
		JLabel fighterJet = new JLabel(message);
		fighterJet.setFont(new Font("Calibri", Font.PLAIN, 25));
		fighterJet.setBounds(40, 125, 630, 50);
		fighterJet.setVisible(true);
		
		message = "Attack Helicopter...$40.1M	   | QTY: " + integers.format(militaries.get(militaryNumber).getAirforce().getNumAttackHelicopter());
		JLabel attackHelicopter = new JLabel(message);
		attackHelicopter.setFont(new Font("Calibri", Font.PLAIN, 25));
		attackHelicopter.setBounds(40, 195, 630, 50);
		attackHelicopter.setVisible(true);
		
		message = "Cargo Plane............$30.1M   | QTY: " + integers.format(militaries.get(militaryNumber).getAirforce().getNumCargoPlane());
		JLabel cargoPlane = new JLabel(message);
		cargoPlane.setFont(new Font("Calibri", Font.PLAIN, 25));
		cargoPlane.setBounds(40, 255, 630, 50);
		cargoPlane.setVisible(true);
		
		//create JLabels for each of the soldier ranks	
		message = "General...................$190K     | QTY: " + integers.format(militaries.get(militaryNumber).getAirforce().getNumGenerals());
		JLabel airforceGeneral = new JLabel(message);
		airforceGeneral.setFont(new Font("Calibri", Font.PLAIN, 25));
		airforceGeneral.setBounds(40, 330, 630, 50);
		airforceGeneral.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getAirforce().recommendedAmount("General"));
		JLabel generalRecommendedAmount = new JLabel(message);
		generalRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		generalRecommendedAmount.setBounds(510, 330, 400, 50);
		generalRecommendedAmount.setVisible(true);
		
		message = "Major General........$160K     | QTY: " + integers.format(militaries.get(militaryNumber).getAirforce().getNumMajorGenerals());
		JLabel airforceMajorGeneral = new JLabel(message);
		airforceMajorGeneral.setFont(new Font("Calibri", Font.PLAIN, 25));
		airforceMajorGeneral.setBounds(40, 380, 630, 50);
		airforceMajorGeneral.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getAirforce().recommendedAmount("Major General"));
		JLabel majorGeneralRecommendedAmount = new JLabel(message);
		majorGeneralRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		majorGeneralRecommendedAmount.setBounds(510, 380, 400, 50);
		majorGeneralRecommendedAmount.setVisible(true);
		
		message = "Colonel....................$130K     | QTY: " + integers.format(militaries.get(militaryNumber).getAirforce().getNumColonels());
		JLabel airforceColonel = new JLabel(message);
		airforceColonel.setFont(new Font("Calibri", Font.PLAIN, 25));
		airforceColonel.setBounds(40, 430, 630, 50);
		airforceColonel.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getAirforce().recommendedAmount("Colonel"));
		JLabel colonelRecommendedAmount = new JLabel(message);
		colonelRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		colonelRecommendedAmount.setBounds(510, 430, 400, 50);
		colonelRecommendedAmount.setVisible(true);
		
		message = "Major.......................$90K       | QTY: " + integers.format(militaries.get(militaryNumber).getAirforce().getNumMajors());
		JLabel airforceMajor = new JLabel(message);
		airforceMajor.setFont(new Font("Calibri", Font.PLAIN, 25));
		airforceMajor.setBounds(40, 480, 630, 50);
		airforceMajor.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getAirforce().recommendedAmount("Major"));
		JLabel majorRecommendedAmount = new JLabel(message);
		majorRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		majorRecommendedAmount.setBounds(510, 480, 400, 50);
		majorRecommendedAmount.setVisible(true);
		
		message = "Captain....................$60K       | QTY: " + integers.format(militaries.get(militaryNumber).getAirforce().getNumCaptains());
		JLabel airforceCaptain = new JLabel(message);
		airforceCaptain.setFont(new Font("Calibri", Font.PLAIN, 25));
		airforceCaptain.setBounds(40, 530, 630, 50);
		airforceCaptain.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getAirforce().recommendedAmount("Captain"));
		JLabel captainRecommendedAmount = new JLabel(message);
		captainRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		captainRecommendedAmount.setBounds(510, 530, 400, 50);
		captainRecommendedAmount.setVisible(true);
		
		message = "Lieutenant...............$26K       | QTY: " + integers.format(militaries.get(militaryNumber).getAirforce().getNumLieutenants());
		JLabel airforceLieutenant = new JLabel(message);
		airforceLieutenant.setFont(new Font("Calibri", Font.PLAIN, 25));
		airforceLieutenant.setBounds(40, 580, 630, 50);
		airforceLieutenant.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getAirforce().recommendedAmount("Lieutenant"));
		JLabel lieutenantRecommendedAmount = new JLabel(message);
		lieutenantRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		lieutenantRecommendedAmount.setBounds(510, 580, 400, 50);
		lieutenantRecommendedAmount.setVisible(true);
		
		//create dividers
		JLabel dividerShort = new JLabel("____________________________________________________");
		dividerShort.setFont(new Font("Calibri", Font.PLAIN, 25));
		dividerShort.setBounds(40, 285, 650, 50);
		dividerShort.setVisible(true);
		
		JLabel dividerLong = new JLabel("___________________________________________________________________________________");
		dividerLong.setFont(new Font("Calibri", Font.PLAIN, 25));
		dividerLong.setBounds(40, 30, 1020, 30);
		dividerLong.setVisible(true);
		
		//create the return home button
		returnHomeAirforce = new JButton(new ImageIcon("images/homeIcon2.png"));
		returnHomeAirforce.setBounds(980, 550, 80, 80);
		returnHomeAirforce.setContentAreaFilled(false);
		returnHomeAirforce.setBorderPainted(false);
		returnHomeAirforce.setFocusPainted(false);
		returnHomeAirforce.addActionListener(this);
		
		//create buttons for each of the equipment types
		purchaseBomberPlane = new JButton("Purchase");
		purchaseBomberPlane.setBounds(780, 60, 90, 35);//compare to 40, 60, 630, 50
		purchaseBomberPlane.setFocusable(false);
		purchaseBomberPlane.addActionListener(this);
		
		removeBomberPlane = new JButton("Remove");
		removeBomberPlane.setBounds(880, 60, 90, 35);//compare to 40, 60, 630, 50
		removeBomberPlane.setFocusable(false);
		removeBomberPlane.addActionListener(this);
		
		purchaseFighterJet = new JButton("Purchase");
		purchaseFighterJet.setBounds(780, 125, 90, 35);
		purchaseFighterJet.setFocusable(false);
		purchaseFighterJet.addActionListener(this);
		
		removeFighterJet = new JButton("Remove");
		removeFighterJet.setBounds(880, 125, 90, 35);
		removeFighterJet.setFocusable(false);
		removeFighterJet.addActionListener(this);
		
		purchaseAttackHelicopter = new JButton("Purchase");
		purchaseAttackHelicopter.setBounds(780, 190, 90, 35);
		purchaseAttackHelicopter.setFocusable(false);
		purchaseAttackHelicopter.addActionListener(this);
		
		removeAttackHelicopter = new JButton("Remove");
		removeAttackHelicopter.setBounds(880, 190, 90, 35);
		removeAttackHelicopter.setFocusable(false);
		removeAttackHelicopter.addActionListener(this);
		
		purchaseCargoPlane = new JButton("Purchase");
		purchaseCargoPlane.setBounds(780, 255, 90, 35);
		purchaseCargoPlane.setFocusable(false);
		purchaseCargoPlane.addActionListener(this);
		
		removeCargoPlane = new JButton("Remove");
		removeCargoPlane.setBounds(880, 255, 90, 35);
		removeCargoPlane.setFocusable(false);
		removeCargoPlane.addActionListener(this);
		
		//create buttons for each of the ranks
		hireAirforceGeneral = new JButton("Hire");
		hireAirforceGeneral.setBounds(780, 335, 90, 30);
		hireAirforceGeneral.setFocusable(false);
		hireAirforceGeneral.addActionListener(this);
		
		fireAirforceGeneral = new JButton("Fire");
		fireAirforceGeneral.setBounds(880, 335, 90, 30);
		fireAirforceGeneral.setFocusable(false);
		fireAirforceGeneral.addActionListener(this);
		
		hireAirforceMajorGeneral = new JButton("Hire");
		hireAirforceMajorGeneral.setBounds(780, 385, 90, 30);
		hireAirforceMajorGeneral.setFocusable(false);
		hireAirforceMajorGeneral.addActionListener(this);
		
		fireAirforceMajorGeneral = new JButton("Fire");
		fireAirforceMajorGeneral.setBounds(880, 385, 90, 30);
		fireAirforceMajorGeneral.setFocusable(false);
		fireAirforceMajorGeneral.addActionListener(this);
		
		hireAirforceColonel = new JButton("Hire");
		hireAirforceColonel.setBounds(780, 435, 90, 30);
		hireAirforceColonel.setFocusable(false);
		hireAirforceColonel.addActionListener(this);
		
		fireAirforceColonel = new JButton("Fire");
		fireAirforceColonel.setBounds(880, 435, 90, 30);
		fireAirforceColonel.setFocusable(false);
		fireAirforceColonel.addActionListener(this);
		
		hireAirforceMajor = new JButton("Hire");
		hireAirforceMajor.setBounds(780, 485, 90, 30);
		hireAirforceMajor.setFocusable(false);
		hireAirforceMajor.addActionListener(this);
		
		fireAirforceMajor = new JButton("Fire");
		fireAirforceMajor.setBounds(880, 485, 90, 30);
		fireAirforceMajor.setFocusable(false);
		fireAirforceMajor.addActionListener(this);
		
		hireAirforceCaptain = new JButton("Hire");
		hireAirforceCaptain.setBounds(780, 535, 90, 30);
		hireAirforceCaptain.setFocusable(false);
		hireAirforceCaptain.addActionListener(this);
		
		fireAirforceCaptain = new JButton("Fire");
		fireAirforceCaptain.setBounds(880, 535, 90, 30);
		fireAirforceCaptain.setFocusable(false);
		fireAirforceCaptain.addActionListener(this);
		
		hireAirforceLieutenant = new JButton("Hire");
		hireAirforceLieutenant.setBounds(780, 585, 90, 30);
		hireAirforceLieutenant.setFocusable(false);
		hireAirforceLieutenant.addActionListener(this);
		
		fireAirforceLieutenant = new JButton("Fire");
		fireAirforceLieutenant.setBounds(880, 585, 90, 30);
		fireAirforceLieutenant.setFocusable(false);
		fireAirforceLieutenant.addActionListener(this);
		
		//add all of the JLabels and JButtons to the Airforce interface
		airforceInterface.add(rawPowerAirforce);
		airforceInterface.add(currentBalanceAirforce);
		airforceInterface.add(dividerLong);
		airforceInterface.add(bomberPlane);
		airforceInterface.add(purchaseBomberPlane);
		airforceInterface.add(fighterJet);
		airforceInterface.add(purchaseFighterJet);
		airforceInterface.add(attackHelicopter);
		airforceInterface.add(purchaseAttackHelicopter);
		airforceInterface.add(cargoPlane);
		airforceInterface.add(purchaseCargoPlane);
		airforceInterface.add(dividerShort);
		airforceInterface.add(airforceGeneral);
		airforceInterface.add(generalRecommendedAmount);
		airforceInterface.add(hireAirforceGeneral);
		airforceInterface.add(airforceMajorGeneral);
		airforceInterface.add(majorGeneralRecommendedAmount);
		airforceInterface.add(hireAirforceMajorGeneral);
		airforceInterface.add(airforceColonel);
		airforceInterface.add(colonelRecommendedAmount);
		airforceInterface.add(hireAirforceColonel);
		airforceInterface.add(airforceMajor);
		airforceInterface.add(majorRecommendedAmount);
		airforceInterface.add(hireAirforceMajor);
		airforceInterface.add(airforceCaptain);
		airforceInterface.add(captainRecommendedAmount);
		airforceInterface.add(hireAirforceCaptain);
		airforceInterface.add(airforceLieutenant);
		airforceInterface.add(lieutenantRecommendedAmount);
		airforceInterface.add(hireAirforceLieutenant);
		airforceInterface.add(returnHomeAirforce);
		
		airforceInterface.add(removeCargoPlane);
		airforceInterface.add(removeFighterJet);
		airforceInterface.add(removeBomberPlane);
		airforceInterface.add(removeAttackHelicopter);
		airforceInterface.add(fireAirforceGeneral);
		airforceInterface.add(fireAirforceMajorGeneral);
		airforceInterface.add(fireAirforceColonel);
		airforceInterface.add(fireAirforceMajor);
		airforceInterface.add(fireAirforceCaptain);
		airforceInterface.add(fireAirforceLieutenant);
		
		airforceInterface.setLocationRelativeTo(null);
		airforceInterface.setVisible(true);
		
		returnHomeAirforce.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				returnHomeAirforce.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e) {
				returnHomeAirforce.setBorderPainted(false);
			}
		}); // end returnHomeAirforce.addMouseListener
	}//end of AirforceMenu()

/****************************************************************************************/
	
	public void armyMenu() 
	{
		
		//set the army base image to a label
		JLabel backgroundLabelArmy = new JLabel(new ImageIcon("images/armyBG.jpg"));
		backgroundLabelArmy.setBounds(0, 0, 1100, 680);
		backgroundLabelArmy.setVisible(true);
		
		
		//create the army interface
		armyInterface = new JFrame("Army Base");
		armyInterface.setSize(new Dimension(1100,680));
		armyInterface.setLayout(null);
		armyInterface.setContentPane(backgroundLabelArmy);
		armyInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a JLabel for the power
		String message = "Fire Power: " + formatter.format(militaries.get(militaryNumber).getArmy().calculatePower()) + " Nuketons";
		JLabel rawPowerArmy = new JLabel(message);
		rawPowerArmy.setFont(new Font("Calibri", Font.PLAIN, 25));
		rawPowerArmy.setBounds(40, 10, 400, 50);
		rawPowerArmy.setVisible(true);
		
		//create a JLabel for the current balance
		message = "Balance: $" + formatter.format(militaries.get(militaryNumber).getBalance());
		JLabel currentBalanceArmy = new JLabel(message);
		currentBalanceArmy.setFont(new Font("Calibri", Font.PLAIN, 25));
		currentBalanceArmy.setBounds(700, 10, 400, 50);
		currentBalanceArmy.setVisible(true);
		
		//create JLabels for each of the equipment types
		message = "Tank..............................$6M      | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumTank());
		JLabel tank = new JLabel(message);
		tank.setFont(new Font("Calibri", Font.PLAIN, 25));
		tank.setBounds(40, 60, 630, 40);
		tank.setVisible(true);
		
		message = "Helicopter....................$10M    | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumHelicopter());
		JLabel helicopter = new JLabel(message);
		helicopter.setFont(new Font("Calibri", Font.PLAIN, 25));
		helicopter.setBounds(40, 100, 630, 40);
		helicopter.setVisible(true);
		
		message = "MRAP...........................$1M       | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumMRAP());
		JLabel mrap = new JLabel(message);
		mrap.setFont(new Font("Calibri", Font.PLAIN, 25));
		mrap.setBounds(40, 140, 630, 40);
		mrap.setVisible(true);
		
		message = "Grenade Launcher......$3.5K     | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumGrenadeLauncher());
		JLabel grenadeLauncher = new JLabel(message);
		grenadeLauncher.setFont(new Font("Calibri", Font.PLAIN, 25));
		grenadeLauncher.setBounds(40, 180, 630, 40);
		grenadeLauncher.setVisible(true);
		
		message = "Squad MG....................$4K        | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumSquadMG());
		JLabel squadMG = new JLabel(message);
		squadMG.setFont(new Font("Calibri", Font.PLAIN, 25));
		squadMG.setBounds(40, 220, 630, 40);
		squadMG.setVisible(true);
		
		message = "Rifle..............................$1.3K     | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumRifle());
		JLabel rifle = new JLabel(message);
		rifle.setFont(new Font("Calibri", Font.PLAIN, 25));
		rifle.setBounds(40, 260, 630, 40);
		rifle.setVisible(true);
		
		message = "General........................$220K    | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumGeneral());
		JLabel general = new JLabel(message);
		general.setFont(new Font("Calibri", Font.PLAIN, 25));
		general.setBounds(40, 330, 630, 50);
		general.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getArmy().recommendedAmount("General"));
		JLabel generalRecommendedAmount = new JLabel(message);
		generalRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		generalRecommendedAmount.setBounds(530, 330, 400, 50);
		generalRecommendedAmount.setVisible(true);
		
		message = "Colonel.........................$90K      | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumColonel());
		JLabel colonel = new JLabel(message);
		colonel.setFont(new Font("Calibri", Font.PLAIN, 25));
		colonel.setBounds(40, 380, 630, 50);
		colonel.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getArmy().recommendedAmount("Colonel"));
		JLabel colonelRecommendedAmount = new JLabel(message);
		colonelRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		colonelRecommendedAmount.setBounds(530, 380, 400, 50);
		colonelRecommendedAmount.setVisible(true);
		
		message = "Major............................$75K      | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumMajor());
		JLabel major = new JLabel(message);
		major.setFont(new Font("Calibri", Font.PLAIN, 25));
		major.setBounds(40, 430, 630, 50);
		major.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getArmy().recommendedAmount("Major"));
		JLabel majorRecommendedAmount = new JLabel(message);
		majorRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		majorRecommendedAmount.setBounds(530, 430, 400, 50);
		majorRecommendedAmount.setVisible(true);
		
		message = "Captain.........................$60K      | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumCaptain());
		JLabel captain = new JLabel(message);
		captain.setFont(new Font("Calibri", Font.PLAIN, 25));
		captain.setBounds(40, 480, 630, 50);
		captain.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getArmy().recommendedAmount("Captain"));
		JLabel captainRecommendedAmount = new JLabel(message);
		captainRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		captainRecommendedAmount.setBounds(530, 480, 400, 50);
		captainRecommendedAmount.setVisible(true);
		
		message = "Lieutenant....................$42K      | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumLieutenant());
		JLabel lieutenant = new JLabel(message);
		lieutenant.setFont(new Font("Calibri", Font.PLAIN, 25));
		lieutenant.setBounds(40, 530, 630, 50);
		lieutenant.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getArmy().recommendedAmount("Lieutenant"));
		JLabel lieutenantRecommendedAmount = new JLabel(message);
		lieutenantRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		lieutenantRecommendedAmount.setBounds(530, 530, 400, 50);
		lieutenantRecommendedAmount.setVisible(true);
		
		message = "Enlisted.........................$26K      | QTY: " + integers.format(militaries.get(militaryNumber).getArmy().getNumEnlisted());
		JLabel enlisted = new JLabel(message);
		enlisted.setFont(new Font("Calibri", Font.PLAIN, 25));
		enlisted.setBounds(40, 580, 630, 50);
		enlisted.setVisible(true);
		
		message = "Recommended: " + integers.format(militaries.get(militaryNumber).getArmy().recommendedAmount("Enlisted"));
		JLabel enlistedRecommendedAmount = new JLabel(message);
		enlistedRecommendedAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		enlistedRecommendedAmount.setBounds(530, 580, 400, 50);
		enlistedRecommendedAmount.setVisible(true);
		
		
		//create dividers ----- Maybe we should have these as globally usable dividers?
		JLabel dividerShort = new JLabel("____________________________________________________");
		dividerShort.setFont(new Font("Calibri", Font.PLAIN, 25));
		dividerShort.setBounds(40, 285, 650, 50);
		dividerShort.setVisible(true);
		
		JLabel dividerLong = new JLabel("___________________________________________________________________________________");
		dividerLong.setFont(new Font("Calibri", Font.PLAIN, 25));
		dividerLong.setBounds(40, 30, 1020, 30);
		dividerLong.setVisible(true);
		
		//create the return home button
		returnHomeArmy = new JButton(new ImageIcon("images/homeIcon2.png"));
		returnHomeArmy.setBounds(980, 550, 80, 80);
		returnHomeArmy.setContentAreaFilled(false);
		returnHomeArmy.setBorderPainted(false);
		returnHomeArmy.setFocusPainted(false);
		returnHomeArmy.addActionListener(this);
		
		//create buttons for each of the equipment types
		purchaseTank = new JButton("Purchase");
		purchaseTank.setBounds(780, 65, 90, 25);//compare to 40, 60, 500, 50
		purchaseTank.setFocusable(false);
		purchaseTank.addActionListener(this);
		
		removeTank = new JButton("Remove");
		removeTank.setBounds(880, 65, 90, 25);//compare to 40, 60, 500, 50
		removeTank.setFocusable(false);
		removeTank.addActionListener(this);
		
		purchaseHelicopter = new JButton("Purchase");
		purchaseHelicopter.setBounds(780, 105, 90, 25);
		purchaseHelicopter.setFocusable(false);
		purchaseHelicopter.addActionListener(this);
		
		removeHelicopter = new JButton("Remove");
		removeHelicopter.setBounds(880, 105, 90, 25);
		removeHelicopter.setFocusable(false);
		removeHelicopter.addActionListener(this);
		
		purchaseMRAP = new JButton("Purchase");
		purchaseMRAP.setBounds(780, 145, 90, 25);
		purchaseMRAP.setFocusable(false);
		purchaseMRAP.addActionListener(this);
		
		removeMRAP = new JButton("Remove");
		removeMRAP.setBounds(880, 145, 90, 25);
		removeMRAP.setFocusable(false);
		removeMRAP.addActionListener(this);
		
		purchaseGrenadeLauncher = new JButton("Purchase");
		purchaseGrenadeLauncher.setBounds(780, 185, 90, 25);
		purchaseGrenadeLauncher.setFocusable(false);
		purchaseGrenadeLauncher.addActionListener(this);
		
		removeGrenadeLauncher = new JButton("Remove");
		removeGrenadeLauncher.setBounds(880, 185, 90, 25);
		removeGrenadeLauncher.setFocusable(false);
		removeGrenadeLauncher.addActionListener(this);
		
		purchaseSquadMG = new JButton("Purchase");
		purchaseSquadMG.setBounds(780, 225, 90, 25);
		purchaseSquadMG.setFocusable(false);
		purchaseSquadMG.addActionListener(this);
		
		removeSquadMG = new JButton("Remove");
		removeSquadMG.setBounds(880, 225, 90, 25);
		removeSquadMG.setFocusable(false);
		removeSquadMG.addActionListener(this);
		
		purchaseRifle = new JButton("Purchase");
		purchaseRifle.setBounds(780, 265, 90, 25);
		purchaseRifle.setFocusable(false);
		purchaseRifle.addActionListener(this);
		
		removeRifle = new JButton("Remove");
		removeRifle.setBounds(880, 265, 90, 25);
		removeRifle.setFocusable(false);
		removeRifle.addActionListener(this);
		
		//create buttons for each of the ranks
		hireArmyGeneral = new JButton("Hire");
		hireArmyGeneral.setBounds(780, 335, 90, 30);
		hireArmyGeneral.setFocusable(false);
		hireArmyGeneral.addActionListener(this);
		
		fireArmyGeneral = new JButton("Fire");
		fireArmyGeneral.setBounds(880, 335, 90, 30);
		fireArmyGeneral.setFocusable(false);
		fireArmyGeneral.addActionListener(this);
		
		hireArmyColonel = new JButton("Hire");
		hireArmyColonel.setBounds(780, 385, 90, 30);
		hireArmyColonel.setFocusable(false);
		hireArmyColonel.addActionListener(this);
		
		fireArmyColonel = new JButton("Fire");
		fireArmyColonel.setBounds(880, 385, 90, 30);
		fireArmyColonel.setFocusable(false);
		fireArmyColonel.addActionListener(this);
		
		hireArmyMajor = new JButton("Hire");
		hireArmyMajor.setBounds(780, 435, 90, 30);
		hireArmyMajor.setFocusable(false);
		hireArmyMajor.addActionListener(this);
		
		fireArmyMajor = new JButton("Fire");
		fireArmyMajor.setBounds(880, 435, 90, 30);
		fireArmyMajor.setFocusable(false);
		fireArmyMajor.addActionListener(this);
		
		hireArmyCaptain = new JButton("Hire");
		hireArmyCaptain.setBounds(780, 485, 90, 30);
		hireArmyCaptain.setFocusable(false);
		hireArmyCaptain.addActionListener(this);
		
		fireArmyCaptain = new JButton("Fire");
		fireArmyCaptain.setBounds(880, 485, 90, 30);
		fireArmyCaptain.setFocusable(false);
		fireArmyCaptain.addActionListener(this);
		
		hireArmyLieutenant = new JButton("Hire");
		hireArmyLieutenant.setBounds(780, 535, 90, 30);
		hireArmyLieutenant.setFocusable(false);
		hireArmyLieutenant.addActionListener(this);
		
		fireArmyLieutenant = new JButton("Fire");
		fireArmyLieutenant.setBounds(880, 535, 90, 30);
		fireArmyLieutenant.setFocusable(false);
		fireArmyLieutenant.addActionListener(this);
		
		hireArmyEnlisted = new JButton("Hire");
		hireArmyEnlisted.setBounds(780, 585, 90, 30);
		hireArmyEnlisted.setFocusable(false);
		hireArmyEnlisted.addActionListener(this);
		
		fireArmyEnlisted = new JButton("Fire");
		fireArmyEnlisted.setBounds(880, 585, 90, 30);
		fireArmyEnlisted.setFocusable(false);
		fireArmyEnlisted.addActionListener(this);

		
		//add all of the JLabels and JButtons to the Marines interface
		armyInterface.add(rawPowerArmy);
		armyInterface.add(currentBalanceArmy);
		armyInterface.add(dividerLong);
		armyInterface.add(tank);
		armyInterface.add(purchaseTank);
		armyInterface.add(removeTank);
		armyInterface.add(helicopter);
		armyInterface.add(purchaseHelicopter);
		armyInterface.add(removeHelicopter);
		armyInterface.add(mrap);
		armyInterface.add(purchaseMRAP);
		armyInterface.add(removeMRAP);
		armyInterface.add(grenadeLauncher);
		armyInterface.add(purchaseGrenadeLauncher);
		armyInterface.add(removeGrenadeLauncher);
		armyInterface.add(squadMG);
		armyInterface.add(purchaseSquadMG);
		armyInterface.add(removeSquadMG);
		armyInterface.add(rifle);
		armyInterface.add(purchaseRifle);
		armyInterface.add(removeRifle);
		armyInterface.add(dividerShort);
		armyInterface.add(general);
		armyInterface.add(generalRecommendedAmount);
		armyInterface.add(hireArmyGeneral);
		armyInterface.add(fireArmyGeneral);
		armyInterface.add(colonel);
		armyInterface.add(colonelRecommendedAmount);
		armyInterface.add(hireArmyColonel);
		armyInterface.add(fireArmyColonel);
		armyInterface.add(major);
		armyInterface.add(majorRecommendedAmount);
		armyInterface.add(hireArmyMajor);
		armyInterface.add(fireArmyMajor);
		armyInterface.add(captain);
		armyInterface.add(captainRecommendedAmount);
		armyInterface.add(fireArmyCaptain);
		armyInterface.add(hireArmyCaptain);
		armyInterface.add(lieutenant);
		armyInterface.add(lieutenantRecommendedAmount);
		armyInterface.add(fireArmyLieutenant);
		armyInterface.add(hireArmyLieutenant);
		armyInterface.add(enlisted);
		armyInterface.add(enlistedRecommendedAmount);
		armyInterface.add(hireArmyEnlisted);
		armyInterface.add(fireArmyEnlisted);

		armyInterface.add(returnHomeArmy);
		
		armyInterface.setLocationRelativeTo(null);
		armyInterface.setVisible(true);
		
		returnHomeArmy.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				returnHomeArmy.setBorderPainted(true);
			}
			
			public void mouseExited(MouseEvent e) {
				returnHomeArmy.setBorderPainted(false);
			}
		}
		);
		
	}//end of ArmyMenu() 
	
/****************************************************************************************/	
	
	public void worldMap()
	{
		//set the world map image to a label
		JLabel backgroundLabelWorldMap = new JLabel(new ImageIcon("images/mapOfTheWorld.jpg"));
		backgroundLabelWorldMap.setBounds(0, 0, 1100, 680);
		backgroundLabelWorldMap.setVisible(true);
		
		//create some labels / buttons
		USFlag = new JButton(new ImageIcon("images/usFlag2.gif"));
		USFlag.setContentAreaFilled(false);
		USFlag.setBorderPainted(false);
		USFlag.setFocusPainted(false);
		USFlag.setBounds(198, 198, 100, 80);
		USFlag.addActionListener(this);
		USFlag.setVisible(true);
		
		chineseFlag = new JButton(new ImageIcon("images/chineseFlag.gif"));
		chineseFlag.setContentAreaFilled(false);
		chineseFlag.setBorderPainted(false);
		chineseFlag.setFocusPainted(false);
		chineseFlag.setBounds(850, 190, 80, 100);
		chineseFlag.addActionListener(this);
		chineseFlag.setVisible(true);
		
		russianFlag = new JButton(new ImageIcon("images/russianFlag.gif"));
		russianFlag.setContentAreaFilled(false);
		russianFlag.setBorderPainted(false);
		russianFlag.setFocusPainted(false);
		russianFlag.setBounds(820, 85, 100, 80);
		russianFlag.addActionListener(this);
		russianFlag.setVisible(true);
		
		
		returnHomeWorldMap = new JButton(new ImageIcon("images/homeIcon2.png"));
		returnHomeWorldMap.setBounds(25, 535, 80, 80);
		returnHomeWorldMap.setContentAreaFilled(false);
		returnHomeWorldMap.setBorderPainted(false);
		returnHomeWorldMap.setFocusPainted(false);
		returnHomeWorldMap.addActionListener(this);
		
		JLabel crossedSwords = new JLabel(new ImageIcon("images/crossedSwords2.png"));
		crossedSwords.setBounds(180, 180, 120, 120);
		crossedSwords.setVisible(true);
		
		JLabel crossedSwords2 = new JLabel(new ImageIcon("images/crossedSwords2.png"));
		crossedSwords2.setBounds(802, 68, 120, 120);
		crossedSwords2.setVisible(true);
		
		JLabel crossedSwords3 = new JLabel(new ImageIcon("images/crossedSwords2.png"));
		crossedSwords3.setBounds(832, 164, 120, 120);
		crossedSwords.setVisible(true);
		
		worldInterface = new JFrame("World Map");
		worldInterface.setSize(new Dimension(1100,680));
		worldInterface.setLayout(null);
		worldInterface.setContentPane(backgroundLabelWorldMap);
		worldInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		worldInterface.add(russianFlag);
		worldInterface.add(chineseFlag);
		worldInterface.add(USFlag);
		worldInterface.add(returnHomeWorldMap);
		
		worldInterface.setLocationRelativeTo(null);
		worldInterface.setVisible(true);
		
		returnHomeWorldMap.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				returnHomeWorldMap.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e)
			{
				returnHomeWorldMap.setBorderPainted(false);
			}
		}
		);
		USFlag.addMouseListener(new MouseAdapter() 
		{
		    public void mouseEntered(MouseEvent e) 
		    {
		    	worldInterface.remove(USFlag);
		        worldInterface.add(crossedSwords);
		        worldInterface.add(USFlag);
		    }
		    public void mouseExited(MouseEvent e)
		    {
		    	worldInterface.remove(crossedSwords);
		    }
		}
		);
		
		chineseFlag.addMouseListener(new MouseAdapter() 
		{
		    public void mouseEntered(MouseEvent e) 
		    {
		    	worldInterface.remove(chineseFlag);
		        worldInterface.add(crossedSwords3);
		        worldInterface.add(chineseFlag);
		    }
		    public void mouseExited(MouseEvent e)
		    {
		    	worldInterface.remove(crossedSwords3);
		    }
		}
		);
		
		russianFlag.addMouseListener(new MouseAdapter() 
		{
		    public void mouseEntered(MouseEvent e) 
		    {
		    	worldInterface.remove(russianFlag);
		        worldInterface.add(crossedSwords2);
		        worldInterface.add(russianFlag);
		    }
		    public void mouseExited(MouseEvent e)
		    {
		    	worldInterface.remove(crossedSwords2);
		    }
		}
		);
		//create the naval interface
	}//end of worldMap()
	
/****************************************************************************************/
	
	public void homeBase()
	{
		JLabel backgroundLabelHomeBase = new JLabel(new ImageIcon("images/fireplaceRoom2.gif"));
		backgroundLabelHomeBase.setBounds(0,0,1100,680);
		backgroundLabelHomeBase.setVisible(true);
		
		homeInterface = new JFrame("Home Base");
		homeInterface.setSize(new Dimension(1100,680));
		homeInterface.setLayout(null);
		homeInterface.setContentPane(backgroundLabelHomeBase);
		homeInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		globeSpinning = new JButton(new ImageIcon("images/globeSpinning.gif"));
		globeSpinning.setBounds(730, 240, 160, 160);
		globeSpinning.setVisible(true);
		globeSpinning.setContentAreaFilled(false);
		globeSpinning.setBorderPainted(false);
		globeSpinning.setFocusPainted(false);
		globeSpinning.addActionListener(this);
		
		armyEmblem = new JButton(new ImageIcon("images/armyEmblem2.png"));
		armyEmblem.setBounds(10, 50, 160, 160);
		armyEmblem.setVisible(true);
		armyEmblem.setContentAreaFilled(false);
		armyEmblem.setBorderPainted(false);
		armyEmblem.setFocusPainted(false);
		armyEmblem.addActionListener(this);
		
		navyEmblem = new JButton(new ImageIcon("images/gldenAnchor2.png"));
		navyEmblem.setBounds(160, 50, 160, 160);
		navyEmblem.setVisible(true);
		navyEmblem.setContentAreaFilled(false);
		navyEmblem.setBorderPainted(false);
		navyEmblem.setFocusPainted(false);
		navyEmblem.addActionListener(this);
		
		switchMilitary = new JButton(new ImageIcon("images/arrows.png"));
		switchMilitary.setBounds(730, 420, 160, 160);
		switchMilitary.setVisible(true);
		switchMilitary.setContentAreaFilled(false);
		switchMilitary.setBorderPainted(false);
		switchMilitary.setFocusPainted(false);
		switchMilitary.addActionListener(this);
		
		displayTheStrongestBranch = new JButton(new ImageIcon("images/biceps.png"));
		displayTheStrongestBranch.setBounds(540, 420, 160, 160);
		displayTheStrongestBranch.setVisible(true);
		displayTheStrongestBranch.setContentAreaFilled(false);
		displayTheStrongestBranch.setBorderPainted(false);
		displayTheStrongestBranch.setFocusPainted(false);
		displayTheStrongestBranch.addActionListener(this);
		
		marinesEmblem = new JButton(new ImageIcon("images/marines2.png"));
		marinesEmblem.setBounds(310, 50, 160, 160);
		marinesEmblem.setVisible(true);
		marinesEmblem.setContentAreaFilled(false);
		marinesEmblem.setBorderPainted(false);
		marinesEmblem.setFocusPainted(false);
		marinesEmblem.addActionListener(this);
		
		airforceEmblem = new JButton(new ImageIcon("images/airforce2.png"));
		airforceEmblem.setBounds(460, 50, 160, 160);
		airforceEmblem.setVisible(true);
		airforceEmblem.setContentAreaFilled(false);
		airforceEmblem.setBorderPainted(false);
		airforceEmblem.setFocusPainted(false);
		airforceEmblem.addActionListener(this);
		
		homeInterface.add(switchMilitary);
		homeInterface.add(armyEmblem);
		homeInterface.add(navyEmblem);
		homeInterface.add(marinesEmblem);
		homeInterface.add(airforceEmblem);
		homeInterface.add(globeSpinning);
		homeInterface.add(displayTheStrongestBranch);
		homeInterface.setLocationRelativeTo(null);
		homeInterface.setVisible(true);
		
		switchMilitary.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				switchMilitary.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e)
			{
				switchMilitary.setBorderPainted(false);
			}
		}
		);
		globeSpinning.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				globeSpinning.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e)
			{
				globeSpinning.setBorderPainted(false);
			}
		}
		);
		armyEmblem.addMouseListener(new MouseAdapter() 
		{
		    public void mouseEntered(MouseEvent e) 
		    {
		    	armyEmblem.setBorderPainted(true);
		    }
		    public void mouseExited(MouseEvent e)
		    {
		    	armyEmblem.setBorderPainted(false);
		    }
		}
		);
		navyEmblem.addMouseListener(new MouseAdapter() 
		{
		    public void mouseEntered(MouseEvent e) 
		    {
				navyEmblem.setBorderPainted(true);
		    }
		    public void mouseExited(MouseEvent e)
		    {
				navyEmblem.setBorderPainted(false);
		    }
		}
		);
		marinesEmblem.addMouseListener(new MouseAdapter() 
		{
		    public void mouseEntered(MouseEvent e) 
		    {
				marinesEmblem.setBorderPainted(true);
		    }
		    public void mouseExited(MouseEvent e)
		    {
				marinesEmblem.setBorderPainted(false);
		    }
		}
		);
		airforceEmblem.addMouseListener(new MouseAdapter() 
		{
		    public void mouseEntered(MouseEvent e) 
		    {
				airforceEmblem.setBorderPainted(true);
		    }
		    public void mouseExited(MouseEvent e)
		    {
				airforceEmblem.setBorderPainted(false);
		    }
		}
		);
		displayTheStrongestBranch.addMouseListener(new MouseAdapter() 
		{
		    public void mouseEntered(MouseEvent e) 
		    {
		    	displayTheStrongestBranch.setBorderPainted(true);
		    }
		    public void mouseExited(MouseEvent e)
		    {
		    	displayTheStrongestBranch.setBorderPainted(false);
		    }
		}
		);
			
	}//end of homeBase()
	
/****************************************************************************************/
	
	public void displayStrongestBranchMenu(Military military)
	{
		strongestBranchInterface = new JFrame("Strongest Branch");
		strongestBranchInterface.setSize(new Dimension(800,200));
		strongestBranchInterface.setLayout(null);
		strongestBranchInterface.setContentPane(new JLabel(new ImageIcon("images/woodBackground.jpg")));
		strongestBranchInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel strongestBranch = new JLabel(Methods.displayBranchPower(military));
		strongestBranch.setFont(new Font("Calibri", Font.PLAIN, 25));
		strongestBranch.setSize(new Dimension(800, 150));
		strongestBranch.setForeground(Color.white);
		strongestBranch.setHorizontalAlignment(JLabel.CENTER);
		strongestBranch.setVerticalAlignment(JLabel.CENTER);
		strongestBranch.setVisible(true);
		
		strongestBranchInterface.add(strongestBranch);
		strongestBranchInterface.setLocationRelativeTo(null);
		strongestBranchInterface.setVisible(true);
		
		strongestBranchInterface.addWindowListener(new WindowAdapter() 
		{
			
			public void windowClosing(WindowEvent e)
			{
				homeInterface.setEnabled(true);
				e.getWindow().dispose();
			}
		});
	}//end of displayStrongestBranchMenu()
	
/****************************************************************************************/
	/* Switch Military methods */
/****************************************************************************************/
	
	public void switchMilitaryMenu() {
		
		JLabel woodBackground = new JLabel(new ImageIcon("images/woodBackground.jpg"));
		
		currentMilitary = new JLabel("Your current military is " + militaries.get(militaryNumber).getName());
		currentMilitary.setFont(new Font("Calibri", Font.BOLD, 30));
		currentMilitary.setSize(new Dimension(800, 100));
		currentMilitary.setForeground(Color.WHITE);
		currentMilitary.setHorizontalAlignment(JLabel.CENTER);
		currentMilitary.setVerticalAlignment(JLabel.CENTER);
		currentMilitary.setVisible(true);
		
		returnHomeSwitchMilitary = new JButton(new ImageIcon("images/homeIcon2.png"));
		returnHomeSwitchMilitary.setBounds(670, 350, 80, 80);
		returnHomeSwitchMilitary.addActionListener(this);
		returnHomeSwitchMilitary.setFocusable(false);
		returnHomeSwitchMilitary.setContentAreaFilled(false);
		returnHomeSwitchMilitary.setBorderPainted(false);
		returnHomeSwitchMilitary.setFocusPainted(false);
		
		createMilitary = new JButton("Create a new Military");
		createMilitary.setFont(new Font("Arial", Font.ITALIC, 20));
		createMilitary.setBackground(new Color(249, 229, 31));
		createMilitary.setBounds(70, 100, 300, 100);
		createMilitary.setFocusable(false);
		createMilitary.addActionListener(this);
		
		chooseMilitaryAvailable = new JButton("Change between militaries");
		chooseMilitaryAvailable.setFont(new Font("Arial", Font.ITALIC, 20));
		chooseMilitaryAvailable.setBackground(new Color(249, 229, 31));
		chooseMilitaryAvailable.setBounds(420, 100, 300, 100);
		chooseMilitaryAvailable.setFocusable(false);
		chooseMilitaryAvailable.addActionListener(this);
		
		switchMilitaryInterface = new JFrame("Switch Military");
		switchMilitaryInterface.setSize(new Dimension(800, 500));
		switchMilitaryInterface.setContentPane(woodBackground);
		switchMilitaryInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		switchMilitaryInterface.setLocationRelativeTo(null);
		switchMilitaryInterface.setLayout(null);
		switchMilitaryInterface.setVisible(true);
		switchMilitaryInterface.setResizable(false);
		
		switchMilitaryInterface.add(currentMilitary);
		switchMilitaryInterface.add(createMilitary);
		switchMilitaryInterface.add(chooseMilitaryAvailable);
		switchMilitaryInterface.add(returnHomeSwitchMilitary);
		
		switchMilitaryInterface.addWindowListener(new WindowAdapter() {
            
            public void windowClosing(WindowEvent e)
            {
            	homeInterface.setEnabled(true);
            
            	e.getWindow().dispose();
            }
        });
		
		returnHomeSwitchMilitary.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent e) {
					
					returnHomeSwitchMilitary.setBorderPainted(true);
				}
				public void mouseExited(MouseEvent e) {
					
					returnHomeSwitchMilitary.setBorderPainted(false);
				}
	
		});
	}
	
/****************************************************************************************/
	
	public void returnMilitaryChosen() 
	{
		
		String message = "";
		
		message += "                                       ****** Militaries Available ****** \n";
		
		for(int i = 0; i < militaries.size(); i++) {
			
			message += "["+(i)+"] " + militaries.get(i).getName() + "\n";
		}
		message += "Please enter the number that corresponds to the military you would like to choose: \n";
		
		do {
			if(militaryNumber >= militaries.size()) {
				JOptionPane.showMessageDialog(null, "Enter a number from the menu displayed");
			}
			militaryNumber = Methods.getInt(message);
			
		}while(militaryNumber >= militaries.size());
		
	}
	
/****************************************************************************************/
	
	public void createMilitary() 
	{
		String name = Methods.generateValidName();
		militaries.add(new Military(name, 1000000000000.0, new Navy(), new Airforce(), new Army(), new Marines()));
	}
	
/****************************************************************************************/
	/* Battle methods */
/****************************************************************************************/
	
	public void doYouWantToBattle(Military attackingMilitary, Military defendingMilitary)
	{
		JLabel woodBackground = new JLabel(new ImageIcon("images/woodBackground.jpg"));
		double totalFirePowerAttacking = attackingMilitary.getNavy().calculatePower() + attackingMilitary.getMarines().calculatePower() + attackingMilitary.getArmy().calculatePower() + attackingMilitary.getAirforce().calculatePower();
		double totalFirePowerDefending = defendingMilitary.getNavy().calculatePower() + defendingMilitary.getMarines().calculatePower() + defendingMilitary.getArmy().calculatePower() + defendingMilitary.getAirforce().calculatePower();
		
		//buttons and versus label
		//create a Versus JLabel
		JLabel versus = new JLabel(new ImageIcon("images/versus2.png"));
		versus.setBounds(395, 280, 120, 120);
		versus.setVisible(true);
		
		//general frame add-ons
		battleInterface1 = new JFrame("Defending Army Stats");
		battleInterface1.setSize(new Dimension(1000,680));
		battleInterface1.setLayout(null);
		battleInterface1.setContentPane(woodBackground);
		battleInterface1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		battleInterface1.setResizable(false);
		
		//create buttons to attack and NOT attack
		if(defendingMilitary.getName() == "US Military")
		{
			attackTheUS = new JButton("Attack!");
			attackTheUS.setFont(new Font("Calibri", Font.ITALIC, 20));
			attackTheUS.setBackground(new Color(249, 229, 31));
			attackTheUS.setBounds(395, 220, 120, 40);
			attackTheUS.setFocusable(false);
			attackTheUS.addActionListener(this);
			attackTheUS.setVisible(true);
			battleInterface1.add(attackTheUS);
		}
		else if(defendingMilitary.getName() == "Russian Military")
		{
			attackRussia = new JButton("Attack!");
			attackRussia.setFont(new Font("Calibri", Font.ITALIC, 20));
			attackRussia.setBackground(new Color(249, 229, 31));
			attackRussia.setBounds(395, 220, 120, 40);
			attackRussia.setFocusable(false);
			attackRussia.addActionListener(this);
			attackRussia.setVisible(true);
			battleInterface1.add(attackRussia);
		}
		else if(defendingMilitary.getName() == "Chinese Military")
		{
			attackChina = new JButton("Attack!");
			attackChina.setFont(new Font("Calibri", Font.ITALIC, 20));
			attackChina.setBackground(new Color(249, 229, 31));
			attackChina.setBounds(395, 220, 120, 40);
			attackChina.setFocusable(false);
			attackChina.addActionListener(this);
			attackChina.setVisible(true);
			battleInterface1.add(attackChina);
		}
		
		noAttack = new JButton("NO GO!");
		noAttack.setFont(new Font("Calibri", Font.ITALIC, 20));
		noAttack.setBackground(new Color(249, 229, 31));
		noAttack.setBounds(395, 430, 120, 40);
		noAttack.setFocusable(false);
		noAttack.addActionListener(this);
		noAttack.setVisible(true);
		
		//Attacking Side
		//create a JLabel for the name of the attacking military
		String message = "" + attackingMilitary.getName();
		JLabel attackingMilitaryName = new JLabel(message);
		attackingMilitaryName.setFont(new Font("Calibri", Font.PLAIN, 30));
		attackingMilitaryName.setForeground(new Color(250, 250, 250));
		attackingMilitaryName.setBounds(40, 10, 400, 50);
		attackingMilitaryName.setVisible(true);
		
		//create a JLabel for the power
		message = "Fire Power: " + formatter.format(totalFirePowerAttacking) + " Nuketons";
		JLabel rawPower = new JLabel(message);
		rawPower.setFont(new Font("Calibri", Font.PLAIN, 25));
		rawPower.setForeground(new Color(250, 250, 250));
		rawPower.setBounds(40, 55, 400, 40);
		rawPower.setVisible(true);
		
		//navy 
		JLabel militaryNameNavy = new JLabel();
		militaryNameNavy.setText("Navy");
		militaryNameNavy.setBounds(40, 95, 360, 30);
		militaryNameNavy.setFont(new Font("Calibri", Font.PLAIN, 25));
		militaryNameNavy.setForeground(new Color(250, 250, 250));
		
		long equipmentQuantityNavy = attackingMilitary.getNavy().getNumberOfAircraftCarriers() + attackingMilitary.getNavy().getNumberOfSubmarines() + attackingMilitary.getNavy().getNumberOfBattleships() + attackingMilitary.getNavy().getNumberOfDestroyers()+ attackingMilitary.getNavy().getNumberOfCargoShips();	
		JLabel totalEquipmentNavy = new JLabel("Total Equipment: " + integers.format(equipmentQuantityNavy));
		totalEquipmentNavy.setBounds(60, 125, 360, 30);
		totalEquipmentNavy.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalEquipmentNavy.setForeground(new Color(250, 250, 250));
		
		long soldiersQuantityNavy = attackingMilitary.getNavy().getNumberOfAdmirals() + attackingMilitary.getNavy().getNumberOfCaptains() + attackingMilitary.getNavy().getNumberOfCommanders()+ attackingMilitary.getNavy().getNumberOfLieutenants() + attackingMilitary.getNavy().getNumberOfEnsigns() + attackingMilitary.getNavy().getNumberOfSeamen();	
		JLabel totalSoldiersNavy = new JLabel("Total Soldiers: " + integers.format(soldiersQuantityNavy));
		totalSoldiersNavy.setBounds(60, 155, 360, 30);
		totalSoldiersNavy.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalSoldiersNavy.setForeground(new Color(250, 250, 250));
		
		JLabel totalNuketonsNavy = new JLabel("Total Nuketons: "+ formatter.format(attackingMilitary.getNavy().calculatePower())+ " Nt");
		totalNuketonsNavy.setBounds(60, 185, 360, 30);
		totalNuketonsNavy.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalNuketonsNavy.setForeground(new Color(250, 250, 250));
		//end of navy
		
		//airforce
		JLabel militaryNameAirforce = new JLabel();
		militaryNameAirforce.setText("Airforce");
		militaryNameAirforce.setBounds(40, 225, 360, 30);
		militaryNameAirforce.setFont(new Font("Calibri", Font.PLAIN, 25));
		militaryNameAirforce.setForeground(new Color(250, 250, 250));
		
		long equipmentQuantityAirforce = attackingMilitary.getAirforce().getNumAttackHelicopter() + attackingMilitary.getAirforce().getNumFighterJet() + attackingMilitary.getAirforce().getNumBomberPlane()+ attackingMilitary.getAirforce().getNumCargoPlane();
		JLabel totalEquipmentAirforce = new JLabel("Total Equipment: " + integers.format(equipmentQuantityAirforce));
		totalEquipmentAirforce.setBounds(60, 255, 360, 30);
		totalEquipmentAirforce.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalEquipmentAirforce.setForeground(new Color(250, 250, 250));
		
		long soldiersQuantityAirforce = attackingMilitary.getAirforce().getNumCaptains() + attackingMilitary.getAirforce().getNumColonels() + attackingMilitary.getAirforce().getNumGenerals()+ attackingMilitary.getAirforce().getNumMajorGenerals() + attackingMilitary.getAirforce().getNumMajors() + attackingMilitary.getAirforce().getNumLieutenants();	
		JLabel totalSoldiersAirforce = new JLabel("Total Soldiers: " + integers.format(soldiersQuantityAirforce));
		totalSoldiersAirforce.setBounds(60, 285, 360, 30);
		totalSoldiersAirforce.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalSoldiersAirforce.setForeground(new Color(250, 250, 250));
		
		JLabel totalNuketonsAirforce = new JLabel("Total Nuketons: "+ formatter.format(attackingMilitary.getAirforce().calculatePower())+ " Nt");
		totalNuketonsAirforce.setBounds(60, 315, 360, 30);
		totalNuketonsAirforce.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalNuketonsAirforce.setForeground(new Color(250, 250, 250));
		//end of airforce
		
		//army
		JLabel militaryNameArmy = new JLabel();
		militaryNameArmy.setText("Army");
		militaryNameArmy.setBounds(40, 355, 360, 30);
		militaryNameArmy.setFont(new Font("Calibri", Font.PLAIN, 25));
		militaryNameArmy.setForeground(new Color(250, 250, 250));
		
		
		long equipmentQuantityArmy = attackingMilitary.getArmy().getNumTank() + attackingMilitary.getArmy().getNumHelicopter() + attackingMilitary.getArmy().getNumMRAP()+ attackingMilitary.getArmy().getNumGrenadeLauncher() + attackingMilitary.getArmy().getNumSquadMG() + attackingMilitary.getArmy().getNumRifle();	
		JLabel totalEquipmentArmy = new JLabel("Total Equipment: " + integers.format(equipmentQuantityArmy));
		totalEquipmentArmy.setBounds(60, 385, 360, 30);
		totalEquipmentArmy.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalEquipmentArmy.setForeground(new Color(250, 250, 250));
		
		long soldiersQuantityArmy = attackingMilitary.getArmy().getNumEnlisted() + attackingMilitary.getArmy().getNumLieutenant() + attackingMilitary.getArmy().getNumCaptain()+ attackingMilitary.getArmy().getNumMajor() + attackingMilitary.getArmy().getNumColonel() + attackingMilitary.getArmy().getNumCaptain();
		JLabel totalSoldiersArmy = new JLabel("Total Soldiers: " + integers.format(soldiersQuantityArmy));
		totalSoldiersArmy.setBounds(60, 415, 360, 30);
		totalSoldiersArmy.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalSoldiersArmy.setForeground(new Color(250, 250, 250));
		
		JLabel totalNuketonsArmy = new JLabel("Total Nuketons: "+ formatter.format(attackingMilitary.getArmy().calculatePower()) + " Nt");
		totalNuketonsArmy.setBounds(60, 445, 360, 30);
		totalNuketonsArmy.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalNuketonsArmy.setForeground(new Color(250, 250, 250));
		//end of army
		
		//marines
		JLabel militaryNameMarines = new JLabel();
		militaryNameMarines.setText("Marines");
		militaryNameMarines.setBounds(40, 495, 360, 30);
		militaryNameMarines.setFont(new Font("Calibri", Font.PLAIN, 25));
		militaryNameMarines.setForeground(new Color(250, 250, 250));
		
		//sum of all equipment related getters in the military chosen
		long equipmentQuantityMarines = attackingMilitary.getMarines().getNumTroopTrucks() + attackingMilitary.getMarines().getNumLightArmoredVehicles() + attackingMilitary.getMarines().getNumHeavyCargoTrucks()+ attackingMilitary.getMarines().getNumAR() + attackingMilitary.getMarines().getNumGrenadeLauncher() + attackingMilitary.getMarines().getNumSnipers();	
		JLabel totalEquipmentMarines = new JLabel("Total Equipment: "+ integers.format(equipmentQuantityMarines));
		totalEquipmentMarines.setBounds(60, 525, 360, 30);
		totalEquipmentMarines.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalEquipmentMarines.setForeground(new Color(250, 250, 250));
		
		//sum of all soldiers related getters in the military chosen
		long soldiersQuantityMarines = attackingMilitary.getMarines().getNumCaptains() + attackingMilitary.getMarines().getNumColonels() + attackingMilitary.getMarines().getNumGenerals()+ attackingMilitary.getMarines().getNumMajorGenerals() + attackingMilitary.getMarines().getNumMajors() + attackingMilitary.getMarines().getNumLieutenants();
		JLabel totalSoldiersMarines = new JLabel("Total Soldiers: "+integers.format(soldiersQuantityMarines));
		totalSoldiersMarines.setBounds(60, 555, 360, 30);
		totalSoldiersMarines.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalSoldiersMarines.setForeground(new Color(250, 250, 250));
		
		JLabel totalNuketonsMarines = new JLabel("Total Nuketons: "+ formatter.format(attackingMilitary.getMarines().calculatePower()) + " Nt");
		totalNuketonsMarines.setBounds(60, 585, 360, 30);
		totalNuketonsMarines.setFont(new Font("Calibri", Font.PLAIN, 25));
		totalNuketonsMarines.setForeground(new Color(250, 250, 250));
		//end of marines
		//End of Attacking Side
		
		//Defending Side
		//create a JLabel for the name of the attacking and defending navies
		message = "" + defendingMilitary.getName();
		JLabel defenseMilitaryName = new JLabel(message);
		defenseMilitaryName.setFont(new Font("Calibri", Font.PLAIN, 30));
		defenseMilitaryName.setForeground(new Color(250, 250, 250));
		defenseMilitaryName.setBounds(590, 10, 400, 50);
		defenseMilitaryName.setVisible(true);
		
		//create a JLabel for the power
		message = "Fire Power: " + formatter.format(totalFirePowerDefending) + " Nuketons";
		JLabel defenseRawPower = new JLabel(message);
		defenseRawPower.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseRawPower.setForeground(new Color(250, 250, 250));
		defenseRawPower.setBounds(590, 55, 400, 40);
		defenseRawPower.setVisible(true);
		
		//navy 
		JLabel defenseMilitaryNameNavy = new JLabel();
		defenseMilitaryNameNavy.setText("Navy");
		defenseMilitaryNameNavy.setBounds(590, 95, 360, 30);
		defenseMilitaryNameNavy.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseMilitaryNameNavy.setForeground(new Color(250, 250, 250));
		
		long defenseEquipmentQuantityNavy = defendingMilitary.getNavy().getNumberOfAircraftCarriers() + defendingMilitary.getNavy().getNumberOfSubmarines() + defendingMilitary.getNavy().getNumberOfBattleships() + defendingMilitary.getNavy().getNumberOfDestroyers()+ defendingMilitary.getNavy().getNumberOfCargoShips();	
		JLabel defensetotalEquipmentNavy = new JLabel("Total Equipment: " + integers.format(defenseEquipmentQuantityNavy));
		defensetotalEquipmentNavy.setBounds(600, 125, 360, 30);
		defensetotalEquipmentNavy.setFont(new Font("Calibri", Font.PLAIN, 25));
		defensetotalEquipmentNavy.setForeground(new Color(250, 250, 250));
		
		long defenseSoldiersQuantityNavy = defendingMilitary.getNavy().getNumberOfAdmirals() + defendingMilitary.getNavy().getNumberOfCaptains() + defendingMilitary.getNavy().getNumberOfCommanders()+ defendingMilitary.getNavy().getNumberOfLieutenants() + defendingMilitary.getNavy().getNumberOfEnsigns() + defendingMilitary.getNavy().getNumberOfSeamen();	
		JLabel defenseTotalSoldiersNavy = new JLabel("Total Soldiers: " + integers.format(defenseSoldiersQuantityNavy));
		defenseTotalSoldiersNavy.setBounds(600, 155, 360, 30);
		defenseTotalSoldiersNavy.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalSoldiersNavy.setForeground(new Color(250, 250, 250));
		
		JLabel defenseTotalNuketonsNavy = new JLabel("Total Nuketons: "+ formatter.format(defendingMilitary.getNavy().calculatePower())+ " Nt");
		defenseTotalNuketonsNavy.setBounds(600, 185, 360, 30);
		defenseTotalNuketonsNavy.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalNuketonsNavy.setForeground(new Color(250, 250, 250));
		//end of navy
		
		//airforce
		JLabel defenseMilitaryNameAirforce = new JLabel();
		defenseMilitaryNameAirforce.setText("Airforce");
		defenseMilitaryNameAirforce.setBounds(590, 225, 360, 30);
		defenseMilitaryNameAirforce.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseMilitaryNameAirforce.setForeground(new Color(250, 250, 250));
		
		long defenseEquipmentQuantityAirforce = defendingMilitary.getAirforce().getNumAttackHelicopter() + defendingMilitary.getAirforce().getNumFighterJet() + defendingMilitary.getAirforce().getNumBomberPlane()+ defendingMilitary.getAirforce().getNumCargoPlane();
		JLabel defenseTotalEquipmentAirforce = new JLabel("Total Equipment: " + integers.format(defenseEquipmentQuantityAirforce));
		defenseTotalEquipmentAirforce.setBounds(600, 255, 360, 30);
		defenseTotalEquipmentAirforce.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalEquipmentAirforce.setForeground(new Color(250, 250, 250));
		
		long defenseSoldiersQuantityAirforce = defendingMilitary.getAirforce().getNumCaptains() + defendingMilitary.getAirforce().getNumColonels() + defendingMilitary.getAirforce().getNumGenerals()+ defendingMilitary.getAirforce().getNumMajorGenerals() + defendingMilitary.getAirforce().getNumMajors() + defendingMilitary.getAirforce().getNumLieutenants();	
		JLabel defenseTotalSoldiersAirforce = new JLabel("Total Soldiers: " + integers.format(defenseSoldiersQuantityAirforce));
		defenseTotalSoldiersAirforce.setBounds(600, 285, 360, 30);
		defenseTotalSoldiersAirforce.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalSoldiersAirforce.setForeground(new Color(250, 250, 250));
		
		JLabel defenseTotalNuketonsAirforce = new JLabel("Total Nuketons: "+ formatter.format(defendingMilitary.getAirforce().calculatePower())+ " Nt");
		defenseTotalNuketonsAirforce.setBounds(600, 315, 360, 30);
		defenseTotalNuketonsAirforce.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalNuketonsAirforce.setForeground(new Color(250, 250, 250));
		//end of airforce
		
		//army
		JLabel defenseMilitaryNameArmy = new JLabel();
		defenseMilitaryNameArmy.setText("Army");
		defenseMilitaryNameArmy.setBounds(590, 355, 360, 30);
		defenseMilitaryNameArmy.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseMilitaryNameArmy.setForeground(new Color(250, 250, 250));
		
		long defenseEquipmentQuantityArmy = defendingMilitary.getArmy().getNumTank() + defendingMilitary.getArmy().getNumHelicopter() + defendingMilitary.getArmy().getNumMRAP()+ defendingMilitary.getArmy().getNumGrenadeLauncher() + defendingMilitary.getArmy().getNumSquadMG() + defendingMilitary.getArmy().getNumRifle();	
		JLabel defenseTotalEquipmentArmy = new JLabel("Total Equipment: " + integers.format(defenseEquipmentQuantityArmy));
		defenseTotalEquipmentArmy.setBounds(600, 385, 360, 30);
		defenseTotalEquipmentArmy.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalEquipmentArmy.setForeground(new Color(250, 250, 250));
		
		long defenseSoldiersQuantityArmy = defendingMilitary.getArmy().getNumEnlisted() + defendingMilitary.getArmy().getNumLieutenant() + defendingMilitary.getArmy().getNumCaptain()+ defendingMilitary.getArmy().getNumMajor() + defendingMilitary.getArmy().getNumColonel() + defendingMilitary.getArmy().getNumCaptain();
		JLabel defenseTotalSoldiersArmy = new JLabel("Total Soldiers: " + integers.format(defenseSoldiersQuantityArmy));
		defenseTotalSoldiersArmy.setBounds(600, 415, 360, 30);
		defenseTotalSoldiersArmy.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalSoldiersArmy.setForeground(new Color(250, 250, 250));
		
		JLabel defenseTotalNuketonsArmy = new JLabel("Total Nuketons: "+ formatter.format(defendingMilitary.getArmy().calculatePower()) + " Nt");
		defenseTotalNuketonsArmy.setBounds(600, 445, 360, 30);
		defenseTotalNuketonsArmy.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalNuketonsArmy.setForeground(new Color(250, 250, 250));
		//end of army
		
		//marines
		JLabel defenseMilitaryNameMarines = new JLabel();
		defenseMilitaryNameMarines.setText("Marines");
		defenseMilitaryNameMarines.setBounds(590, 495, 360, 30);
		defenseMilitaryNameMarines.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseMilitaryNameMarines.setForeground(new Color(250, 250, 250));
		
		//sum of all equipment related getters in the military chosen
		long defenseEquipmentQuantityMarines = defendingMilitary.getMarines().getNumTroopTrucks() + defendingMilitary.getMarines().getNumLightArmoredVehicles() + defendingMilitary.getMarines().getNumHeavyCargoTrucks()+ defendingMilitary.getMarines().getNumAR() + defendingMilitary.getMarines().getNumGrenadeLauncher() + defendingMilitary.getMarines().getNumSnipers();	
		JLabel defenseTotalEquipmentMarines = new JLabel("Total Equipment: "+ integers.format(defenseEquipmentQuantityMarines));
		defenseTotalEquipmentMarines.setBounds(600, 525, 360, 30);
		defenseTotalEquipmentMarines.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalEquipmentMarines.setForeground(new Color(250, 250, 250));
		
		//sum of all soldiers related getters in the military chosen
		long defenseSoldiersQuantityMarines = defendingMilitary.getMarines().getNumCaptains() + defendingMilitary.getMarines().getNumColonels() + defendingMilitary.getMarines().getNumGenerals()+ defendingMilitary.getMarines().getNumMajorGenerals() + defendingMilitary.getMarines().getNumMajors() + defendingMilitary.getMarines().getNumLieutenants();
		JLabel defenseTotalSoldiersMarines = new JLabel("Total Soldiers: "+integers.format(defenseSoldiersQuantityMarines));
		defenseTotalSoldiersMarines.setBounds(600, 555, 360, 30);
		defenseTotalSoldiersMarines.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalSoldiersMarines.setForeground(new Color(250, 250, 250));
		
		JLabel defenseTotalNuketonsMarines = new JLabel("Total Nuketons: "+ formatter.format(defendingMilitary.getMarines().calculatePower()) + " Nt");
		defenseTotalNuketonsMarines.setBounds(600, 585, 360, 30);
		defenseTotalNuketonsMarines.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenseTotalNuketonsMarines.setForeground(new Color(250, 250, 250));		
		//End of defending Side
		
		//general frame add ons
		battleInterface1.add(versus);
		battleInterface1.add(noAttack);
		battleInterface1.setLocationRelativeTo(null);
		battleInterface1.setVisible(true);
		
		//attacking militaries add-ons
		battleInterface1.add(attackingMilitaryName);
		battleInterface1.add(rawPower);
		battleInterface1.add(militaryNameNavy);
		battleInterface1.add(totalEquipmentNavy);
		battleInterface1.add(totalSoldiersNavy);
		battleInterface1.add(totalNuketonsNavy);
		
		battleInterface1.add(militaryNameAirforce);
		battleInterface1.add(totalEquipmentAirforce);
		battleInterface1.add(totalSoldiersAirforce);
		battleInterface1.add(totalNuketonsAirforce);
		
		battleInterface1.add(militaryNameArmy);
		battleInterface1.add(totalEquipmentArmy);
		battleInterface1.add(totalSoldiersArmy);
		battleInterface1.add(totalNuketonsArmy);
		
		battleInterface1.add(militaryNameMarines);
		battleInterface1.add(totalEquipmentMarines);
		battleInterface1.add(totalSoldiersMarines);
		battleInterface1.add(totalNuketonsMarines);
		
		//defense military add-ons
		battleInterface1.add(defenseMilitaryName);
		battleInterface1.add(defenseRawPower);
		battleInterface1.add(defenseMilitaryNameNavy);
		battleInterface1.add(defensetotalEquipmentNavy);
		battleInterface1.add(defenseTotalSoldiersNavy);
		battleInterface1.add(defenseTotalNuketonsNavy);
		
		battleInterface1.add(defenseMilitaryNameAirforce);
		battleInterface1.add(defenseTotalEquipmentAirforce);
		battleInterface1.add(defenseTotalSoldiersAirforce);
		battleInterface1.add(defenseTotalNuketonsAirforce);
		
		battleInterface1.add(defenseMilitaryNameArmy);
		battleInterface1.add(defenseTotalEquipmentArmy);
		battleInterface1.add(defenseTotalSoldiersArmy);
		battleInterface1.add(defenseTotalNuketonsArmy);
		
		battleInterface1.add(defenseMilitaryNameMarines);
		battleInterface1.add(defenseTotalEquipmentMarines);
		battleInterface1.add(defenseTotalSoldiersMarines);
		battleInterface1.add(defenseTotalNuketonsMarines);
				
		battleInterface1.addWindowListener(new WindowAdapter() 
		{
			
			public void windowClosing(WindowEvent e)
			{
				worldInterface.setEnabled(true);
				
				e.getWindow().dispose();
			}
		});
	}//end of doYouWantToBattle
	
/****************************************************************************************/

	private void battle(Military attackingMilitary, Military defendingMilitary) 
	{				
		JLabel defenderBar = new JLabel();
		defenderBar.setBackground(new Color(0, 102, 255));//blue?
		defenderBar.setOpaque(true);
		defenderBar.setBounds(20, 20, 940, 15);
		defenderBar.setVisible(true);
		
		JLabel attackerBar = new JLabel();
		attackerBar.setBackground(new Color(230, 0, 0));
		attackerBar.setOpaque(true);
		attackerBar.setBounds(20, 20, 0, 15);
		attackerBar.setVisible(true);
		
		//stuff for the attacking side
		long equipmentQuantityNavyATK = attackingMilitary.getNavy().getNumberOfAircraftCarriers() + attackingMilitary.getNavy().getNumberOfSubmarines() + attackingMilitary.getNavy().getNumberOfBattleships() + attackingMilitary.getNavy().getNumberOfDestroyers()+ attackingMilitary.getNavy().getNumberOfCargoShips();	
		long equipmentQuantityAirforceATK = attackingMilitary.getAirforce().getNumAttackHelicopter() + attackingMilitary.getAirforce().getNumFighterJet() + attackingMilitary.getAirforce().getNumBomberPlane()+ attackingMilitary.getAirforce().getNumCargoPlane();
		long equipmentQuantityArmyATK = attackingMilitary.getArmy().getNumTank() + attackingMilitary.getArmy().getNumHelicopter() + attackingMilitary.getArmy().getNumMRAP()+ attackingMilitary.getArmy().getNumGrenadeLauncher() + attackingMilitary.getArmy().getNumSquadMG() + attackingMilitary.getArmy().getNumRifle();	
		long equipmentQuantityMarinesATK = attackingMilitary.getMarines().getNumTroopTrucks() + attackingMilitary.getMarines().getNumLightArmoredVehicles() + attackingMilitary.getMarines().getNumHeavyCargoTrucks()+ attackingMilitary.getMarines().getNumAR() + attackingMilitary.getMarines().getNumGrenadeLauncher() + attackingMilitary.getMarines().getNumSnipers();	
		
		long soldiersQuantityNavyATK = attackingMilitary.getNavy().getNumberOfAdmirals() + attackingMilitary.getNavy().getNumberOfCaptains() + attackingMilitary.getNavy().getNumberOfCommanders()+ attackingMilitary.getNavy().getNumberOfLieutenants() + attackingMilitary.getNavy().getNumberOfEnsigns() + attackingMilitary.getNavy().getNumberOfSeamen();	
		long soldiersQuantityAirforceATK = attackingMilitary.getAirforce().getNumCaptains() + attackingMilitary.getAirforce().getNumColonels() + attackingMilitary.getAirforce().getNumGenerals()+ attackingMilitary.getAirforce().getNumMajorGenerals() + attackingMilitary.getAirforce().getNumMajors() + attackingMilitary.getAirforce().getNumLieutenants();	
		long soldiersQuantityArmyATK = attackingMilitary.getArmy().getNumEnlisted() + attackingMilitary.getArmy().getNumLieutenant() + attackingMilitary.getArmy().getNumCaptain()+ attackingMilitary.getArmy().getNumMajor() + attackingMilitary.getArmy().getNumColonel() + attackingMilitary.getArmy().getNumCaptain();
		long soldiersQuantityMarinesATK = attackingMilitary.getMarines().getNumCaptains() + attackingMilitary.getMarines().getNumColonels() + attackingMilitary.getMarines().getNumGenerals()+ attackingMilitary.getMarines().getNumMajorGenerals() + attackingMilitary.getMarines().getNumMajors() + attackingMilitary.getMarines().getNumLieutenants();

		long EquipmentLeftMessageATK = equipmentQuantityNavyATK + equipmentQuantityAirforceATK + equipmentQuantityArmyATK + equipmentQuantityMarinesATK;
		long SoldiersLeftMessageATK = soldiersQuantityNavyATK + soldiersQuantityAirforceATK + soldiersQuantityArmyATK + soldiersQuantityMarinesATK;
		
		//stuff for the defending side
		long equipmentQuantityNavyDEF = defendingMilitary.getNavy().getNumberOfAircraftCarriers() + defendingMilitary.getNavy().getNumberOfSubmarines() + defendingMilitary.getNavy().getNumberOfBattleships() + defendingMilitary.getNavy().getNumberOfDestroyers()+ defendingMilitary.getNavy().getNumberOfCargoShips();	
		long equipmentQuantityAirforceDEF = defendingMilitary.getAirforce().getNumAttackHelicopter() + defendingMilitary.getAirforce().getNumFighterJet() + defendingMilitary.getAirforce().getNumBomberPlane()+ defendingMilitary.getAirforce().getNumCargoPlane();
		long equipmentQuantityArmyDEF = defendingMilitary.getArmy().getNumTank() + defendingMilitary.getArmy().getNumHelicopter() + defendingMilitary.getArmy().getNumMRAP()+ defendingMilitary.getArmy().getNumGrenadeLauncher() + defendingMilitary.getArmy().getNumSquadMG() + defendingMilitary.getArmy().getNumRifle();	
		long equipmentQuantityMarinesDEF = defendingMilitary.getMarines().getNumTroopTrucks() + defendingMilitary.getMarines().getNumLightArmoredVehicles() + defendingMilitary.getMarines().getNumHeavyCargoTrucks()+ defendingMilitary.getMarines().getNumAR() + defendingMilitary.getMarines().getNumGrenadeLauncher() + defendingMilitary.getMarines().getNumSnipers();	
		
		long soldiersQuantityNavyDEF = defendingMilitary.getNavy().getNumberOfAdmirals() + defendingMilitary.getNavy().getNumberOfCaptains() + defendingMilitary.getNavy().getNumberOfCommanders()+ defendingMilitary.getNavy().getNumberOfLieutenants() + defendingMilitary.getNavy().getNumberOfEnsigns() + defendingMilitary.getNavy().getNumberOfSeamen();	
		long soldiersQuantityAirforceDEF = defendingMilitary.getAirforce().getNumCaptains() + defendingMilitary.getAirforce().getNumColonels() + defendingMilitary.getAirforce().getNumGenerals()+ defendingMilitary.getAirforce().getNumMajorGenerals() + defendingMilitary.getAirforce().getNumMajors() + defendingMilitary.getAirforce().getNumLieutenants();	
		long soldiersQuantityArmyDEF = defendingMilitary.getArmy().getNumEnlisted() + defendingMilitary.getArmy().getNumLieutenant() + defendingMilitary.getArmy().getNumCaptain()+ defendingMilitary.getArmy().getNumMajor() + defendingMilitary.getArmy().getNumColonel() + defendingMilitary.getArmy().getNumCaptain();
		long soldiersQuantityMarinesDEF = defendingMilitary.getMarines().getNumCaptains() + defendingMilitary.getMarines().getNumColonels() + defendingMilitary.getMarines().getNumGenerals()+ defendingMilitary.getMarines().getNumMajorGenerals() + defendingMilitary.getMarines().getNumMajors() + defendingMilitary.getMarines().getNumLieutenants();

		long EquipmentLeftMessageDEF = equipmentQuantityNavyDEF + equipmentQuantityAirforceDEF + equipmentQuantityArmyDEF + equipmentQuantityMarinesDEF;
		long SoldiersLeftMessageDEF = soldiersQuantityNavyDEF + soldiersQuantityAirforceDEF + soldiersQuantityArmyDEF + soldiersQuantityMarinesDEF;

		//JLabels for the attacking side
		JLabel attackerSoldiersLeft = new JLabel("Soldiers Left: " + SoldiersLeftMessageATK);
		attackerSoldiersLeft.setBounds(20, 50, 300, 50);
		attackerSoldiersLeft.setFont(new Font("Calibri", Font.PLAIN, 25));
		attackerSoldiersLeft.setForeground(Color.BLACK);
		attackerSoldiersLeft.setVisible(true);
		
		JLabel attackerEquipmentLeft = new JLabel("Equipment Left: " + EquipmentLeftMessageATK);
		attackerEquipmentLeft.setBounds(20, 100, 300, 50);
		attackerEquipmentLeft.setFont(new Font("Calibri", Font.PLAIN, 25));
		attackerEquipmentLeft.setForeground(Color.BLACK);
		attackerEquipmentLeft.setVisible(true);	
		
		//JLabels for the defending side
		JLabel defenderSoldiersLeft = new JLabel("Soldiers Left: " + SoldiersLeftMessageDEF);
		defenderSoldiersLeft.setBounds(700, 50, 300, 50);
		defenderSoldiersLeft.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenderSoldiersLeft.setForeground(Color.BLACK);
		defenderSoldiersLeft.setVisible(true);
		
		JLabel defenderEquipmentLeft = new JLabel("Equipment Left: " + EquipmentLeftMessageDEF);
		defenderEquipmentLeft.setBounds(700, 100, 300, 50);
		defenderEquipmentLeft.setFont(new Font("Calibri", Font.PLAIN, 25));
		defenderEquipmentLeft.setForeground(Color.BLACK);
		defenderEquipmentLeft.setVisible(true);		
		
		//JLabels for victory and defeat
		JLabel youLost = new JLabel("DEFEAT...");
		youLost.setFont(new Font("Calibri", Font.PLAIN, 50));
		youLost.setForeground(Color.BLACK);
		youLost.setBounds(400, 250, 200, 100);
		youLost.setVisible(false);
		
		JLabel youWin = new JLabel("Victory!");
		youWin.setFont(new Font("Calibri", Font.PLAIN, 50));
		youWin.setForeground(Color.BLACK);
		youWin.setBounds(400, 250, 200, 100);
		youWin.setVisible(false);
			
		okButton = new JButton("OK");
		okButton.setBounds(820, 540, 100, 50);
		okButton.setVisible(false);
		okButton.setFocusable(false);
		okButton.addActionListener(this);
		
		//JFrame
		battleScreen = new JFrame("JSBC War Simulator");
		battleScreen.setSize(new Dimension(1000, 680));
		battleScreen.setContentPane(new JLabel(new ImageIcon("images/swordFighting.gif")));
		battleScreen.setLayout(null);
		battleScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		battleScreen.setLocationRelativeTo(null);
		battleScreen.setVisible(true);
		
		//add items to the Jframe
		battleScreen.add(attackerBar);
		battleScreen.add(defenderBar);
		battleScreen.add(attackerSoldiersLeft);
		battleScreen.add(attackerEquipmentLeft);
		battleScreen.add(defenderEquipmentLeft);
		battleScreen.add(defenderSoldiersLeft);
		battleScreen.add(youWin);
		battleScreen.add(youLost);
		battleScreen.add(okButton);
		
		int attackerProgress = 0;
		int previousAttackerProgress = 0;
		int stationaryCounter = 0;
		do
		{	
			//update the soldier and equipment stats
			equipmentQuantityNavyATK = attackingMilitary.getNavy().getNumberOfAircraftCarriers() + attackingMilitary.getNavy().getNumberOfSubmarines() + attackingMilitary.getNavy().getNumberOfBattleships() + attackingMilitary.getNavy().getNumberOfDestroyers()+ attackingMilitary.getNavy().getNumberOfCargoShips();	
			equipmentQuantityAirforceATK = attackingMilitary.getAirforce().getNumAttackHelicopter() + attackingMilitary.getAirforce().getNumFighterJet() + attackingMilitary.getAirforce().getNumBomberPlane()+ attackingMilitary.getAirforce().getNumCargoPlane();
			equipmentQuantityArmyATK = attackingMilitary.getArmy().getNumTank() + attackingMilitary.getArmy().getNumHelicopter() + attackingMilitary.getArmy().getNumMRAP()+ attackingMilitary.getArmy().getNumGrenadeLauncher() + attackingMilitary.getArmy().getNumSquadMG() + attackingMilitary.getArmy().getNumRifle();	
			equipmentQuantityMarinesATK = attackingMilitary.getMarines().getNumTroopTrucks() + attackingMilitary.getMarines().getNumLightArmoredVehicles() + attackingMilitary.getMarines().getNumHeavyCargoTrucks()+ attackingMilitary.getMarines().getNumAR() + attackingMilitary.getMarines().getNumGrenadeLauncher() + attackingMilitary.getMarines().getNumSnipers();	
			
			soldiersQuantityNavyATK = attackingMilitary.getNavy().getNumberOfAdmirals() + attackingMilitary.getNavy().getNumberOfCaptains() + attackingMilitary.getNavy().getNumberOfCommanders()+ attackingMilitary.getNavy().getNumberOfLieutenants() + attackingMilitary.getNavy().getNumberOfEnsigns() + attackingMilitary.getNavy().getNumberOfSeamen();	
			soldiersQuantityAirforceATK = attackingMilitary.getAirforce().getNumCaptains() + attackingMilitary.getAirforce().getNumColonels() + attackingMilitary.getAirforce().getNumGenerals()+ attackingMilitary.getAirforce().getNumMajorGenerals() + attackingMilitary.getAirforce().getNumMajors() + attackingMilitary.getAirforce().getNumLieutenants();	
			soldiersQuantityArmyATK = attackingMilitary.getArmy().getNumEnlisted() + attackingMilitary.getArmy().getNumLieutenant() + attackingMilitary.getArmy().getNumCaptain()+ attackingMilitary.getArmy().getNumMajor() + attackingMilitary.getArmy().getNumColonel() + attackingMilitary.getArmy().getNumCaptain();
			soldiersQuantityMarinesATK = attackingMilitary.getMarines().getNumCaptains() + attackingMilitary.getMarines().getNumColonels() + attackingMilitary.getMarines().getNumGenerals()+ attackingMilitary.getMarines().getNumMajorGenerals() + attackingMilitary.getMarines().getNumMajors() + attackingMilitary.getMarines().getNumLieutenants();

			EquipmentLeftMessageATK = equipmentQuantityNavyATK + equipmentQuantityAirforceATK + equipmentQuantityArmyATK + equipmentQuantityMarinesATK;
			SoldiersLeftMessageATK = soldiersQuantityNavyATK + soldiersQuantityAirforceATK + soldiersQuantityArmyATK + soldiersQuantityMarinesATK;
			
			equipmentQuantityNavyDEF = defendingMilitary.getNavy().getNumberOfAircraftCarriers() + defendingMilitary.getNavy().getNumberOfSubmarines() + defendingMilitary.getNavy().getNumberOfBattleships() + defendingMilitary.getNavy().getNumberOfDestroyers()+ defendingMilitary.getNavy().getNumberOfCargoShips();	
			equipmentQuantityAirforceDEF = defendingMilitary.getAirforce().getNumAttackHelicopter() + defendingMilitary.getAirforce().getNumFighterJet() + defendingMilitary.getAirforce().getNumBomberPlane()+ defendingMilitary.getAirforce().getNumCargoPlane();
			equipmentQuantityArmyDEF = defendingMilitary.getArmy().getNumTank() + defendingMilitary.getArmy().getNumHelicopter() + defendingMilitary.getArmy().getNumMRAP()+ defendingMilitary.getArmy().getNumGrenadeLauncher() + defendingMilitary.getArmy().getNumSquadMG() + defendingMilitary.getArmy().getNumRifle();	
			equipmentQuantityMarinesDEF = defendingMilitary.getMarines().getNumTroopTrucks() + defendingMilitary.getMarines().getNumLightArmoredVehicles() + defendingMilitary.getMarines().getNumHeavyCargoTrucks()+ defendingMilitary.getMarines().getNumAR() + defendingMilitary.getMarines().getNumGrenadeLauncher() + defendingMilitary.getMarines().getNumSnipers();	
			
			soldiersQuantityNavyDEF = defendingMilitary.getNavy().getNumberOfAdmirals() + defendingMilitary.getNavy().getNumberOfCaptains() + defendingMilitary.getNavy().getNumberOfCommanders()+ defendingMilitary.getNavy().getNumberOfLieutenants() + defendingMilitary.getNavy().getNumberOfEnsigns() + defendingMilitary.getNavy().getNumberOfSeamen();	
			soldiersQuantityAirforceDEF = defendingMilitary.getAirforce().getNumCaptains() + defendingMilitary.getAirforce().getNumColonels() + defendingMilitary.getAirforce().getNumGenerals()+ defendingMilitary.getAirforce().getNumMajorGenerals() + defendingMilitary.getAirforce().getNumMajors() + defendingMilitary.getAirforce().getNumLieutenants();	
			soldiersQuantityArmyDEF = defendingMilitary.getArmy().getNumEnlisted() + defendingMilitary.getArmy().getNumLieutenant() + defendingMilitary.getArmy().getNumCaptain()+ defendingMilitary.getArmy().getNumMajor() + defendingMilitary.getArmy().getNumColonel() + defendingMilitary.getArmy().getNumCaptain();
			soldiersQuantityMarinesDEF = defendingMilitary.getMarines().getNumCaptains() + defendingMilitary.getMarines().getNumColonels() + defendingMilitary.getMarines().getNumGenerals()+ defendingMilitary.getMarines().getNumMajorGenerals() + defendingMilitary.getMarines().getNumMajors() + defendingMilitary.getMarines().getNumLieutenants();

			EquipmentLeftMessageDEF = equipmentQuantityNavyDEF + equipmentQuantityAirforceDEF + equipmentQuantityArmyDEF + equipmentQuantityMarinesDEF;
			SoldiersLeftMessageDEF = soldiersQuantityNavyDEF + soldiersQuantityAirforceDEF + soldiersQuantityArmyDEF + soldiersQuantityMarinesDEF;
			
			//make updates to the stat labels
			attackerSoldiersLeft.setText("Soldiers Left: " + SoldiersLeftMessageATK);	
			
			attackerEquipmentLeft.setText("Equipment Left: " + EquipmentLeftMessageATK);
			
			defenderSoldiersLeft.setText("Soldiers Left: " + SoldiersLeftMessageDEF);
			
			defenderEquipmentLeft.setText("Equipment Left: " + EquipmentLeftMessageDEF);	
			
			//update the progress bar
			previousAttackerProgress = attackerProgress;//old attackerProgress is saved to previousAttackerProgress
			attackerProgress = battleCalculate(attackingMilitary, defendingMilitary);
			if(attackerProgress == previousAttackerProgress)
			{
				stationaryCounter++;
			}
			else
			{
				stationaryCounter = 0;
			}
			if(attackerProgress < 40 || (attackerProgress < 400 && stationaryCounter > 10))
			{
				attackerProgress = 0;
			}
			else if(attackerProgress > 900 || (attackerProgress > 500 && stationaryCounter > 10))
			{
				attackerProgress = 940;
			}
			attackerBar.setBounds(20, 20, attackerProgress, 15);
			
			//wait 
			try 
			{
				Thread.sleep(30);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}while(attackerProgress > 0 && attackerProgress < 940 && SoldiersLeftMessageATK > 0 && EquipmentLeftMessageATK > 0 && SoldiersLeftMessageDEF > 0 && EquipmentLeftMessageDEF > 0);
		
		if(attackerProgress <= 1)
		{
			//you lose
			youLost.setVisible(true);
		}
		else
		{
			//you win
			youWin.setVisible(true);	
		}
		
		okButton.setVisible(true);
		
		battleScreen.addWindowListener(new WindowAdapter() 
		{
			
			public void windowClosing(WindowEvent e)
			{
				doYouWantToBattle(militaries.get(militaryNumber), militaries.get(defenseMilitaryNumber));
				worldInterface.toFront();
				battleInterface1.toFront();
				e.getWindow().dispose();
			}
		});
	}//end of battle
	
/****************************************************************************************/
	
	private int battleCalculate(Military attackingMilitary, Military defendingMilitary)
	{		
		double totalAttackingPower = attackingMilitary.getNavy().calculatePower() + attackingMilitary.getAirforce().calculatePower()
				+ attackingMilitary.getArmy().calculatePower() + attackingMilitary.getMarines().calculatePower();
		double totalDefendingPower = defendingMilitary.getNavy().calculatePower() + defendingMilitary.getAirforce().calculatePower()
				+ defendingMilitary.getArmy().calculatePower() + defendingMilitary.getMarines().calculatePower();

		final double defendingBonus = 1.05;
		int lb = 0, ub = 0;
		double lossDecimal, keepDecimal;
		double mb = 0;
		double randomNumber = 0;
		
		mb = totalAttackingPower;
		ub = (int) ((int)totalAttackingPower + totalDefendingPower * defendingBonus);
		randomNumber = rand.nextInt((ub - lb + 1)) + lb;
		if(randomNumber < mb)// attacker wins
		{
			//your losses
			lossDecimal = (totalDefendingPower/totalAttackingPower)/400;//attacker loses an amount of ships equal to (defPower/atkPower *400) %
			if(lossDecimal > 1)//this is to prevent a negative keepDecimal
			{
				keepDecimal = 0;
			}
			else
			{
				keepDecimal = 1 - lossDecimal;
			}
			//apply losses to the Military
			attackingMilitary.getNavy().setNumberOfAircraftCarriers((int)Math.ceil((attackingMilitary.getNavy().getNumberOfAircraftCarriers() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfSubmarines((int)Math.ceil((attackingMilitary.getNavy().getNumberOfSubmarines() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfBattleships((int)Math.ceil((attackingMilitary.getNavy().getNumberOfBattleships() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfDestroyers((int)Math.ceil((attackingMilitary.getNavy().getNumberOfDestroyers() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfCargoShips((int)Math.ceil((attackingMilitary.getNavy().getNumberOfCargoShips() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfAdmirals((int)Math.ceil((attackingMilitary.getNavy().getNumberOfAdmirals() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfCaptains((int)Math.ceil((attackingMilitary.getNavy().getNumberOfCaptains() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfCommanders((int)Math.ceil((attackingMilitary.getNavy().getNumberOfCommanders() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfLieutenants((int)Math.ceil((attackingMilitary.getNavy().getNumberOfLieutenants() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfEnsigns((int)Math.ceil((attackingMilitary.getNavy().getNumberOfEnsigns() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfSeamen((int)Math.ceil((attackingMilitary.getNavy().getNumberOfSeamen() * keepDecimal)));
			
			attackingMilitary.getAirforce().setNumBomberPlane((int)Math.ceil((attackingMilitary.getAirforce().getNumBomberPlane() * keepDecimal)));
			attackingMilitary.getAirforce().setNumFighterJet((int)Math.ceil((attackingMilitary.getAirforce().getNumFighterJet() * keepDecimal)));
			attackingMilitary.getAirforce().setNumAttackHelicopter((int)Math.ceil((attackingMilitary.getAirforce().getNumAttackHelicopter() * keepDecimal)));
			attackingMilitary.getAirforce().setNumCargoPlane((int)Math.ceil((attackingMilitary.getAirforce().getNumCargoPlane() * keepDecimal)));
			attackingMilitary.getAirforce().setNumGenerals((int)Math.ceil((attackingMilitary.getAirforce().getNumGenerals() * keepDecimal)));
			attackingMilitary.getAirforce().setNumMajorGenerals((int)Math.ceil((attackingMilitary.getAirforce().getNumMajorGenerals() * keepDecimal)));
			attackingMilitary.getAirforce().setNumColonels((int)Math.ceil((attackingMilitary.getAirforce().getNumColonels() * keepDecimal)));
			attackingMilitary.getAirforce().setNumMajors((int)Math.ceil((attackingMilitary.getAirforce().getNumMajors() * keepDecimal)));
			attackingMilitary.getAirforce().setNumCaptains((int)Math.ceil((attackingMilitary.getAirforce().getNumCaptains() * keepDecimal)));
			attackingMilitary.getAirforce().setNumLieutenants((int)Math.ceil((attackingMilitary.getAirforce().getNumLieutenants() * keepDecimal)));
			
			attackingMilitary.getArmy().setNumHelicopter((int)Math.ceil((attackingMilitary.getArmy().getNumHelicopter() * keepDecimal)));
			attackingMilitary.getArmy().setNumMRAP((int)Math.ceil((attackingMilitary.getArmy().getNumMRAP() * keepDecimal)));
			attackingMilitary.getArmy().setNumTank((int)Math.ceil((attackingMilitary.getArmy().getNumTank() * keepDecimal)));
			attackingMilitary.getArmy().setNumSquadMG((int)Math.ceil((attackingMilitary.getArmy().getNumSquadMG() * keepDecimal)));
			attackingMilitary.getArmy().setNumGrenadeLauncher((int)Math.ceil((attackingMilitary.getArmy().getNumGrenadeLauncher() * keepDecimal)));
			attackingMilitary.getArmy().setNumRifle((int)Math.ceil((attackingMilitary.getArmy().getNumRifle() * keepDecimal)));
			attackingMilitary.getArmy().setNumGeneral((int)Math.ceil((attackingMilitary.getArmy().getNumGeneral() * keepDecimal)));
			attackingMilitary.getArmy().setNumColonel((int)Math.ceil((attackingMilitary.getArmy().getNumColonel() * keepDecimal)));
			attackingMilitary.getArmy().setNumMajor((int)Math.ceil((attackingMilitary.getArmy().getNumMajor() * keepDecimal)));
			attackingMilitary.getArmy().setNumCaptain((int)Math.ceil((attackingMilitary.getArmy().getNumCaptain() * keepDecimal)));
			attackingMilitary.getArmy().setNumLieutenant((int)Math.ceil((attackingMilitary.getArmy().getNumLieutenant() * keepDecimal)));
			attackingMilitary.getArmy().setNumEnlisted((int)Math.ceil((attackingMilitary.getArmy().getNumEnlisted() * keepDecimal)));
			
			attackingMilitary.getMarines().setNumLightArmoredVehicles((int)Math.ceil((attackingMilitary.getMarines().getNumLightArmoredVehicles() * keepDecimal)));
			attackingMilitary.getMarines().setNumHeavyCargoTrucks((int)Math.ceil((attackingMilitary.getMarines().getNumHeavyCargoTrucks() * keepDecimal)));
			attackingMilitary.getMarines().setNumTroopTrucks((int)Math.ceil((attackingMilitary.getMarines().getNumTroopTrucks() * keepDecimal)));
			attackingMilitary.getMarines().setNumAR((int)Math.ceil((attackingMilitary.getMarines().getNumAR() * keepDecimal)));
			attackingMilitary.getMarines().setNumGrenadeLauncher((int)Math.ceil((attackingMilitary.getMarines().getNumGrenadeLauncher() * keepDecimal)));
			attackingMilitary.getMarines().setNumSnipers((int)Math.ceil((attackingMilitary.getMarines().getNumSnipers() * keepDecimal)));
			attackingMilitary.getMarines().setNumGenerals((int)Math.ceil((attackingMilitary.getMarines().getNumGenerals() * keepDecimal)));
			attackingMilitary.getMarines().setNumMajorGenerals((int)Math.ceil((attackingMilitary.getMarines().getNumMajorGenerals() * keepDecimal)));
			attackingMilitary.getMarines().setNumColonels((int)Math.ceil((attackingMilitary.getMarines().getNumColonels() * keepDecimal)));
			attackingMilitary.getMarines().setNumMajors((int)Math.ceil((attackingMilitary.getMarines().getNumMajors() * keepDecimal)));
			attackingMilitary.getMarines().setNumCaptains((int)Math.ceil((attackingMilitary.getMarines().getNumCaptains() * keepDecimal)));
			attackingMilitary.getMarines().setNumLieutenants((int)Math.ceil((attackingMilitary.getMarines().getNumLieutenants() * keepDecimal)));
			
			//enemy losses
			lossDecimal = (totalAttackingPower/totalDefendingPower)/100;//defender loses an amount of ships equal to (atkPower/defPower *100) %
			if(lossDecimal > 1)//this is to prevent a negative keepDecimal
			{
				keepDecimal = 0;
			}
			else
			{
				keepDecimal = 1 - lossDecimal;
			}
			//apply the losses to the defending military
			defendingMilitary.getNavy().setNumberOfAircraftCarriers((int)Math.ceil((defendingMilitary.getNavy().getNumberOfAircraftCarriers() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfSubmarines((int)Math.ceil((defendingMilitary.getNavy().getNumberOfSubmarines() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfBattleships((int)Math.ceil((defendingMilitary.getNavy().getNumberOfBattleships() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfDestroyers((int)Math.ceil((defendingMilitary.getNavy().getNumberOfDestroyers() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfCargoShips((int)Math.ceil((defendingMilitary.getNavy().getNumberOfCargoShips() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfAdmirals((int)Math.ceil((defendingMilitary.getNavy().getNumberOfAdmirals() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfCaptains((int)Math.ceil((defendingMilitary.getNavy().getNumberOfCaptains() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfCommanders((int)Math.ceil((defendingMilitary.getNavy().getNumberOfCommanders() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfLieutenants((int)Math.ceil((defendingMilitary.getNavy().getNumberOfLieutenants() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfEnsigns((int)Math.ceil((defendingMilitary.getNavy().getNumberOfEnsigns() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfSeamen((int)Math.ceil((defendingMilitary.getNavy().getNumberOfSeamen() * keepDecimal)));
			
			defendingMilitary.getAirforce().setNumBomberPlane((int)Math.ceil((defendingMilitary.getAirforce().getNumBomberPlane() * keepDecimal)));
			defendingMilitary.getAirforce().setNumFighterJet((int)Math.ceil((defendingMilitary.getAirforce().getNumFighterJet() * keepDecimal)));
			defendingMilitary.getAirforce().setNumAttackHelicopter((int)Math.ceil((defendingMilitary.getAirforce().getNumAttackHelicopter() * keepDecimal)));
			defendingMilitary.getAirforce().setNumCargoPlane((int)Math.ceil((defendingMilitary.getAirforce().getNumCargoPlane() * keepDecimal)));
			defendingMilitary.getAirforce().setNumGenerals((int)Math.ceil((defendingMilitary.getAirforce().getNumGenerals() * keepDecimal)));
			defendingMilitary.getAirforce().setNumMajorGenerals((int)Math.ceil((defendingMilitary.getAirforce().getNumMajorGenerals() * keepDecimal)));
			defendingMilitary.getAirforce().setNumColonels((int)Math.ceil((defendingMilitary.getAirforce().getNumColonels() * keepDecimal)));
			defendingMilitary.getAirforce().setNumMajors((int)Math.ceil((defendingMilitary.getAirforce().getNumMajors() * keepDecimal)));
			defendingMilitary.getAirforce().setNumCaptains((int)Math.ceil((defendingMilitary.getAirforce().getNumCaptains() * keepDecimal)));
			defendingMilitary.getAirforce().setNumLieutenants((int)Math.ceil((defendingMilitary.getAirforce().getNumLieutenants() * keepDecimal)));
			
			defendingMilitary.getArmy().setNumHelicopter((int)Math.ceil((defendingMilitary.getArmy().getNumHelicopter() * keepDecimal)));
			defendingMilitary.getArmy().setNumMRAP((int)Math.ceil((defendingMilitary.getArmy().getNumMRAP() * keepDecimal)));
			defendingMilitary.getArmy().setNumTank((int)Math.ceil((defendingMilitary.getArmy().getNumTank() * keepDecimal)));
			defendingMilitary.getArmy().setNumSquadMG((int)Math.ceil((defendingMilitary.getArmy().getNumSquadMG() * keepDecimal)));
			defendingMilitary.getArmy().setNumGrenadeLauncher((int)Math.ceil((defendingMilitary.getArmy().getNumGrenadeLauncher() * keepDecimal)));
			defendingMilitary.getArmy().setNumRifle((int)Math.ceil((defendingMilitary.getArmy().getNumRifle() * keepDecimal)));
			defendingMilitary.getArmy().setNumGeneral((int)Math.ceil((defendingMilitary.getArmy().getNumGeneral() * keepDecimal)));
			defendingMilitary.getArmy().setNumColonel((int)Math.ceil((defendingMilitary.getArmy().getNumColonel() * keepDecimal)));
			defendingMilitary.getArmy().setNumMajor((int)Math.ceil((defendingMilitary.getArmy().getNumMajor() * keepDecimal)));
			defendingMilitary.getArmy().setNumCaptain((int)Math.ceil((defendingMilitary.getArmy().getNumCaptain() * keepDecimal)));
			defendingMilitary.getArmy().setNumLieutenant((int)Math.ceil((defendingMilitary.getArmy().getNumLieutenant() * keepDecimal)));
			defendingMilitary.getArmy().setNumEnlisted((int)Math.ceil((defendingMilitary.getArmy().getNumEnlisted() * keepDecimal)));
			
			defendingMilitary.getMarines().setNumLightArmoredVehicles((int)Math.ceil((defendingMilitary.getMarines().getNumLightArmoredVehicles() * keepDecimal)));
			defendingMilitary.getMarines().setNumHeavyCargoTrucks((int)Math.ceil((defendingMilitary.getMarines().getNumHeavyCargoTrucks() * keepDecimal)));
			defendingMilitary.getMarines().setNumTroopTrucks((int)Math.ceil((defendingMilitary.getMarines().getNumTroopTrucks() * keepDecimal)));
			defendingMilitary.getMarines().setNumAR((int)Math.ceil((defendingMilitary.getMarines().getNumAR() * keepDecimal)));
			defendingMilitary.getMarines().setNumGrenadeLauncher((int)Math.ceil((defendingMilitary.getMarines().getNumGrenadeLauncher() * keepDecimal)));
			defendingMilitary.getMarines().setNumSnipers((int)Math.ceil((defendingMilitary.getMarines().getNumSnipers() * keepDecimal)));
			defendingMilitary.getMarines().setNumGenerals((int)Math.ceil((defendingMilitary.getMarines().getNumGenerals() * keepDecimal)));
			defendingMilitary.getMarines().setNumMajorGenerals((int)Math.ceil((defendingMilitary.getMarines().getNumMajorGenerals() * keepDecimal)));
			defendingMilitary.getMarines().setNumColonels((int)Math.ceil((defendingMilitary.getMarines().getNumColonels() * keepDecimal)));
			defendingMilitary.getMarines().setNumMajors((int)Math.ceil((defendingMilitary.getMarines().getNumMajors() * keepDecimal)));
			defendingMilitary.getMarines().setNumCaptains((int)Math.ceil((defendingMilitary.getMarines().getNumCaptains() * keepDecimal)));
			defendingMilitary.getMarines().setNumLieutenants((int)Math.ceil((defendingMilitary.getMarines().getNumLieutenants() * keepDecimal)));
		}
		else// defender wins
		{
			//your losses
			lossDecimal = (totalDefendingPower/totalAttackingPower)/100;//attacker loses an amount of ships equal to (defPower/atkPower*100) %
			if(lossDecimal > 1)
			{
				keepDecimal = 0;
			}
			else
			{
				keepDecimal = 1 - lossDecimal;
			}
			attackingMilitary.getNavy().setNumberOfAircraftCarriers((int)Math.ceil((attackingMilitary.getNavy().getNumberOfAircraftCarriers() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfSubmarines((int)Math.ceil((attackingMilitary.getNavy().getNumberOfSubmarines() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfBattleships((int)Math.ceil((attackingMilitary.getNavy().getNumberOfBattleships() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfDestroyers((int)Math.ceil((attackingMilitary.getNavy().getNumberOfDestroyers() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfCargoShips((int)Math.ceil((attackingMilitary.getNavy().getNumberOfCargoShips() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfAdmirals((int)Math.ceil((attackingMilitary.getNavy().getNumberOfAdmirals() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfCaptains((int)Math.ceil((attackingMilitary.getNavy().getNumberOfCaptains() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfCommanders((int)Math.ceil((attackingMilitary.getNavy().getNumberOfCommanders() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfLieutenants((int)Math.ceil((attackingMilitary.getNavy().getNumberOfLieutenants() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfEnsigns((int)Math.ceil((attackingMilitary.getNavy().getNumberOfEnsigns() * keepDecimal)));
			attackingMilitary.getNavy().setNumberOfSeamen((int)Math.ceil((attackingMilitary.getNavy().getNumberOfSeamen() * keepDecimal)));
			
			attackingMilitary.getAirforce().setNumBomberPlane((int)Math.ceil((attackingMilitary.getAirforce().getNumBomberPlane() * keepDecimal)));
			attackingMilitary.getAirforce().setNumFighterJet((int)Math.ceil((attackingMilitary.getAirforce().getNumFighterJet() * keepDecimal)));
			attackingMilitary.getAirforce().setNumAttackHelicopter((int)Math.ceil((attackingMilitary.getAirforce().getNumAttackHelicopter() * keepDecimal)));
			attackingMilitary.getAirforce().setNumCargoPlane((int)Math.ceil((attackingMilitary.getAirforce().getNumCargoPlane() * keepDecimal)));
			attackingMilitary.getAirforce().setNumGenerals((int)Math.ceil((attackingMilitary.getAirforce().getNumGenerals() * keepDecimal)));
			attackingMilitary.getAirforce().setNumMajorGenerals((int)Math.ceil((attackingMilitary.getAirforce().getNumMajorGenerals() * keepDecimal)));
			attackingMilitary.getAirforce().setNumColonels((int)Math.ceil((attackingMilitary.getAirforce().getNumColonels() * keepDecimal)));
			attackingMilitary.getAirforce().setNumMajors((int)Math.ceil((attackingMilitary.getAirforce().getNumMajors() * keepDecimal)));
			attackingMilitary.getAirforce().setNumCaptains((int)Math.ceil((attackingMilitary.getAirforce().getNumCaptains() * keepDecimal)));
			attackingMilitary.getAirforce().setNumLieutenants((int)Math.ceil((attackingMilitary.getAirforce().getNumLieutenants() * keepDecimal)));
			
			attackingMilitary.getArmy().setNumHelicopter((int)Math.ceil((attackingMilitary.getArmy().getNumHelicopter() * keepDecimal)));
			attackingMilitary.getArmy().setNumMRAP((int)Math.ceil((attackingMilitary.getArmy().getNumMRAP() * keepDecimal)));
			attackingMilitary.getArmy().setNumTank((int)Math.ceil((attackingMilitary.getArmy().getNumTank() * keepDecimal)));
			attackingMilitary.getArmy().setNumSquadMG((int)Math.ceil((attackingMilitary.getArmy().getNumSquadMG() * keepDecimal)));
			attackingMilitary.getArmy().setNumGrenadeLauncher((int)Math.ceil((attackingMilitary.getArmy().getNumGrenadeLauncher() * keepDecimal)));
			attackingMilitary.getArmy().setNumRifle((int)Math.ceil((attackingMilitary.getArmy().getNumRifle() * keepDecimal)));
			attackingMilitary.getArmy().setNumGeneral((int)Math.ceil((attackingMilitary.getArmy().getNumGeneral() * keepDecimal)));
			attackingMilitary.getArmy().setNumColonel((int)Math.ceil((attackingMilitary.getArmy().getNumColonel() * keepDecimal)));
			attackingMilitary.getArmy().setNumMajor((int)Math.ceil((attackingMilitary.getArmy().getNumMajor() * keepDecimal)));
			attackingMilitary.getArmy().setNumCaptain((int)Math.ceil((attackingMilitary.getArmy().getNumCaptain() * keepDecimal)));
			attackingMilitary.getArmy().setNumLieutenant((int)Math.ceil((attackingMilitary.getArmy().getNumLieutenant() * keepDecimal)));
			attackingMilitary.getArmy().setNumEnlisted((int)Math.ceil((attackingMilitary.getArmy().getNumEnlisted() * keepDecimal)));
			
			attackingMilitary.getMarines().setNumLightArmoredVehicles((int)Math.ceil((attackingMilitary.getMarines().getNumLightArmoredVehicles() * keepDecimal)));
			attackingMilitary.getMarines().setNumHeavyCargoTrucks((int)Math.ceil((attackingMilitary.getMarines().getNumHeavyCargoTrucks() * keepDecimal)));
			attackingMilitary.getMarines().setNumTroopTrucks((int)Math.ceil((attackingMilitary.getMarines().getNumTroopTrucks() * keepDecimal)));
			attackingMilitary.getMarines().setNumAR((int)Math.ceil((attackingMilitary.getMarines().getNumAR() * keepDecimal)));
			attackingMilitary.getMarines().setNumGrenadeLauncher((int)Math.ceil((attackingMilitary.getMarines().getNumGrenadeLauncher() * keepDecimal)));
			attackingMilitary.getMarines().setNumSnipers((int)Math.ceil((attackingMilitary.getMarines().getNumSnipers() * keepDecimal)));
			attackingMilitary.getMarines().setNumGenerals((int)Math.ceil((attackingMilitary.getMarines().getNumGenerals() * keepDecimal)));
			attackingMilitary.getMarines().setNumMajorGenerals((int)Math.ceil((attackingMilitary.getMarines().getNumMajorGenerals() * keepDecimal)));
			attackingMilitary.getMarines().setNumColonels((int)Math.ceil((attackingMilitary.getMarines().getNumColonels() * keepDecimal)));
			attackingMilitary.getMarines().setNumMajors((int)Math.ceil((attackingMilitary.getMarines().getNumMajors() * keepDecimal)));
			attackingMilitary.getMarines().setNumCaptains((int)Math.ceil((attackingMilitary.getMarines().getNumCaptains() * keepDecimal)));
			attackingMilitary.getMarines().setNumLieutenants((int)Math.ceil((attackingMilitary.getMarines().getNumLieutenants() * keepDecimal)));
			
			//enemy losses
			lossDecimal = (totalAttackingPower/totalDefendingPower)/400;//defender loses an amount of ships equal to (atkPower/defPower*400) %
			if(lossDecimal > 1)
			{
				keepDecimal = 0;
			}
			else
			{
				keepDecimal = 1 - lossDecimal;
			}
			defendingMilitary.getNavy().setNumberOfAircraftCarriers((int)Math.ceil((defendingMilitary.getNavy().getNumberOfAircraftCarriers() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfSubmarines((int)Math.ceil((defendingMilitary.getNavy().getNumberOfSubmarines() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfBattleships((int)Math.ceil((defendingMilitary.getNavy().getNumberOfBattleships() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfDestroyers((int)Math.ceil((defendingMilitary.getNavy().getNumberOfDestroyers() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfCargoShips((int)Math.ceil((defendingMilitary.getNavy().getNumberOfCargoShips() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfAdmirals((int)Math.ceil((defendingMilitary.getNavy().getNumberOfAdmirals() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfCaptains((int)Math.ceil((defendingMilitary.getNavy().getNumberOfCaptains() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfCommanders((int)Math.ceil((defendingMilitary.getNavy().getNumberOfCommanders() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfLieutenants((int)Math.ceil((defendingMilitary.getNavy().getNumberOfLieutenants() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfEnsigns((int)Math.ceil((defendingMilitary.getNavy().getNumberOfEnsigns() * keepDecimal)));
			defendingMilitary.getNavy().setNumberOfSeamen((int)Math.ceil((defendingMilitary.getNavy().getNumberOfSeamen() * keepDecimal)));
			
			defendingMilitary.getAirforce().setNumBomberPlane((int)Math.ceil((defendingMilitary.getAirforce().getNumBomberPlane() * keepDecimal)));
			defendingMilitary.getAirforce().setNumFighterJet((int)Math.ceil((defendingMilitary.getAirforce().getNumFighterJet() * keepDecimal)));
			defendingMilitary.getAirforce().setNumAttackHelicopter((int)Math.ceil((defendingMilitary.getAirforce().getNumAttackHelicopter() * keepDecimal)));
			defendingMilitary.getAirforce().setNumCargoPlane((int)Math.ceil((defendingMilitary.getAirforce().getNumCargoPlane() * keepDecimal)));
			defendingMilitary.getAirforce().setNumGenerals((int)Math.ceil((defendingMilitary.getAirforce().getNumGenerals() * keepDecimal)));
			defendingMilitary.getAirforce().setNumMajorGenerals((int)Math.ceil((defendingMilitary.getAirforce().getNumMajorGenerals() * keepDecimal)));
			defendingMilitary.getAirforce().setNumColonels((int)Math.ceil((defendingMilitary.getAirforce().getNumColonels() * keepDecimal)));
			defendingMilitary.getAirforce().setNumMajors((int)Math.ceil((defendingMilitary.getAirforce().getNumMajors() * keepDecimal)));
			defendingMilitary.getAirforce().setNumCaptains((int)Math.ceil((defendingMilitary.getAirforce().getNumCaptains() * keepDecimal)));
			defendingMilitary.getAirforce().setNumLieutenants((int)Math.ceil((defendingMilitary.getAirforce().getNumLieutenants() * keepDecimal)));
			
			defendingMilitary.getArmy().setNumHelicopter((int)Math.ceil((defendingMilitary.getArmy().getNumHelicopter() * keepDecimal)));
			defendingMilitary.getArmy().setNumMRAP((int)Math.ceil((defendingMilitary.getArmy().getNumMRAP() * keepDecimal)));
			defendingMilitary.getArmy().setNumTank((int)Math.ceil((defendingMilitary.getArmy().getNumTank() * keepDecimal)));
			defendingMilitary.getArmy().setNumSquadMG((int)Math.ceil((defendingMilitary.getArmy().getNumSquadMG() * keepDecimal)));
			defendingMilitary.getArmy().setNumGrenadeLauncher((int)Math.ceil((defendingMilitary.getArmy().getNumGrenadeLauncher() * keepDecimal)));
			defendingMilitary.getArmy().setNumRifle((int)Math.ceil((defendingMilitary.getArmy().getNumRifle() * keepDecimal)));
			defendingMilitary.getArmy().setNumGeneral((int)Math.ceil((defendingMilitary.getArmy().getNumGeneral() * keepDecimal)));
			defendingMilitary.getArmy().setNumColonel((int)Math.ceil((defendingMilitary.getArmy().getNumColonel() * keepDecimal)));
			defendingMilitary.getArmy().setNumMajor((int)Math.ceil((defendingMilitary.getArmy().getNumMajor() * keepDecimal)));
			defendingMilitary.getArmy().setNumCaptain((int)Math.ceil((defendingMilitary.getArmy().getNumCaptain() * keepDecimal)));
			defendingMilitary.getArmy().setNumLieutenant((int)Math.ceil((defendingMilitary.getArmy().getNumLieutenant() * keepDecimal)));
			defendingMilitary.getArmy().setNumEnlisted((int)Math.ceil((defendingMilitary.getArmy().getNumEnlisted() * keepDecimal)));
			
			defendingMilitary.getMarines().setNumLightArmoredVehicles((int)Math.ceil((defendingMilitary.getMarines().getNumLightArmoredVehicles() * keepDecimal)));
			defendingMilitary.getMarines().setNumHeavyCargoTrucks((int)Math.ceil((defendingMilitary.getMarines().getNumHeavyCargoTrucks() * keepDecimal)));
			defendingMilitary.getMarines().setNumTroopTrucks((int)Math.ceil((defendingMilitary.getMarines().getNumTroopTrucks() * keepDecimal)));
			defendingMilitary.getMarines().setNumAR((int)Math.ceil((defendingMilitary.getMarines().getNumAR() * keepDecimal)));
			defendingMilitary.getMarines().setNumGrenadeLauncher((int)Math.ceil((defendingMilitary.getMarines().getNumGrenadeLauncher() * keepDecimal)));
			defendingMilitary.getMarines().setNumSnipers((int)Math.ceil((defendingMilitary.getMarines().getNumSnipers() * keepDecimal)));
			defendingMilitary.getMarines().setNumGenerals((int)Math.ceil((defendingMilitary.getMarines().getNumGenerals() * keepDecimal)));
			defendingMilitary.getMarines().setNumMajorGenerals((int)Math.ceil((defendingMilitary.getMarines().getNumMajorGenerals() * keepDecimal)));
			defendingMilitary.getMarines().setNumColonels((int)Math.ceil((defendingMilitary.getMarines().getNumColonels() * keepDecimal)));
			defendingMilitary.getMarines().setNumMajors((int)Math.ceil((defendingMilitary.getMarines().getNumMajors() * keepDecimal)));
			defendingMilitary.getMarines().setNumCaptains((int)Math.ceil((defendingMilitary.getMarines().getNumCaptains() * keepDecimal)));
			defendingMilitary.getMarines().setNumLieutenants((int)Math.ceil((defendingMilitary.getMarines().getNumLieutenants() * keepDecimal)));
		}
					
		int attackerProgress = (int) ((totalAttackingPower / (totalAttackingPower + totalDefendingPower)) * (double) 940);
		
		return attackerProgress;
	}
	
/****************************************************************************************/
	/*ACTION LISTENER*/
/****************************************************************************************/
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//NAVY MENU BUTTONS
		if(e.getSource() == purchaseAircraftCarrier)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 1, 13000000000.0, "aircraft carriers");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == removeAircraftCarrier)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 1, 13000000000.0, "aircraft carriers");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == purchaseSubmarine)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 2, 4500000000.0, "submarines");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == removeSubmarine)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 2, 4500000000.0, "submarines");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == purchaseBattleship)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 3, 2600000000.0, "battleships");
			navalInterface.dispose();
			navyMenu();		
		}
		else if(e.getSource() == removeBattleship)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 3, 2600000000.0, "battleships");
			navalInterface.dispose();
			navyMenu();		
		}
		else if(e.getSource() == purchaseDestroyer)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 4, 1800000000.0, "destroyers");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == removeDestroyer)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 4, 1800000000.0, "destroyers");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == purchaseCargoShip)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 5, 1200000000.0, "cargo ships");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == removeCargoShip)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 5, 1200000000.0, "cargo ships");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == hireNavalAdmiral)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 6, 220000.0, "admirals");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == fireNavalAdmiral)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 6, 220000.0, "admirals");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == hireNavalCaptain)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 7, 90000.0, "captains");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == fireNavalCaptain)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 7, 90000.0, "captains");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == hireNavalCommander)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 8, 75000.0, "commanders");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == fireNavalCommander)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 8, 75000.0, "commanders");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == hireNavalLieutenant)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 9, 60000.0, "lieutenants");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == fireNavalLieutenant)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 9, 60000.0, "lieutenants");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == hireNavalEnsign)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 10, 42000.0, "ensigns");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == fireNavalEnsign)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 10, 42000.0, "ensigns");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == hireNavalSeamen)
		{
			militaries.get(militaryNumber).getNavy().purchaseOrHireSomething(militaries.get(militaryNumber), 11, 26000.0, "seamen");
			navalInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == fireNavalSeamen)
		{
			militaries.get(militaryNumber).getNavy().removeOrFireSomething(militaries.get(militaryNumber), 11, 26000.0, "seamen");
			navalInterface.dispose();
			navyMenu();
		}
		//MARINE MENU BUTTONS
		else if(e.getSource() == purchaseTroopTrucks) 
		{
			String name = "Troop Trucks";
			int price  = 220000;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 1, price, name);
			marineInterface.dispose();
			
			marineMenu();

		}
		else if(e.getSource() == purchaseLightArmoredVehicle)
		{
			String name = "Light Armored Vehicles";
			int price  = 2000000;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 2, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == purchaseHeavyCargoTruck)
		{
			String name = "Heavy Cargo Trucks";
			int price  = 200000;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 3, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == purchaseAssaultRifle)
		{
			String name = "Assault Rifles";
			int price  = 1300;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 4, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == purchaseGranadeLauncher)
		{
			String name = "Granade Lauchers";
			int price  = 3500;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 5, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == purchaseSniper)
		{
			String name = "Snipers";
			int price  = 12000;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 6, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == hireMarineGeneral)
		{
			String name = "Generals";
			int price  = 220000;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 7, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == hireMarineMajorGeneral)
		{
			String name = "Major Generals";
			int price  = 90000;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 8, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == hireMarineColonel)
		{
			String name = "Colonels";
			int price  = 75000;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 9, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == hireMarineMajor)
		{
			String name = "Majors";
			int price  = 60000;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 10, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == hireMarineCaptain)
		{
			String name = "Captains";
			int price  = 42000;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 11, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == hireMarineLiutenant)
		{
			String name = "Lieutenants";
			int price  = 26000;
			
			militaries.get(militaryNumber).getMarines().purchaseOrHireSomething(militaries.get(militaryNumber), 12, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == removeTroopTrucks) 
		{
			String name = "Troop Trucks";
			int price  = 220000;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 1, price, name);
			marineInterface.dispose();
			
			marineMenu();

		}
		else if(e.getSource() == removeLightArmoredVehicle)
		{
			String name = "Light Armored Vehicles";
			int price  = 2000000;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 2, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == removeHeavyCargoTruck)
		{
			String name = "Heavy Cargo Trucks";
			int price  = 200000;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 3, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == removeAssaultRifle)
		{
			String name = "Assault Rifles";
			int price  = 1300;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 4, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == removeGranadeLauncher)
		{
			String name = "Granade Lauchers";
			int price  = 3500;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 5, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == removeSniper)
		{
			String name = "Snipers";
			int price  = 12000;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 6, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == fireMarineGeneral)
		{
			String name = "Generals";
			int price  = 220000;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 7, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == fireMarineMajorGeneral)
		{
			String name = "Major Generals";
			int price  = 90000;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 8, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == fireMarineColonel)
		{
			String name = "Colonels";
			int price  = 75000;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 9, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == fireMarineMajor)
		{
			String name = "Majors";
			int price  = 60000;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 10, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == fireMarineCaptain)
		{
			String name = "Captains";
			int price  = 42000;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 11, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}
		else if(e.getSource() == fireMarineLiutenant)
		{
			String name = "Lieutenants";
			double price  = 26000;
			
			militaries.get(militaryNumber).getMarines().removeOrFireSomething(militaries.get(militaryNumber), 12, price, name);
			marineInterface.dispose();
			
			marineMenu();
		}

		//AIRFORCE purchase buttons
		else if(e.getSource() == purchaseBomberPlane) {
			String name = "Bomber Plane";
			long price  = 423000000;
			militaries.get(militaryNumber).getAirforce().purchaseOrHireSomething(militaries.get(militaryNumber), 1, price, name);
			airforceInterface.dispose();
			airforceMenu();
		}
		else if(e.getSource() == purchaseCargoPlane) {
			String name = "Cargo Plane";
			long price  = 30100000;
			militaries.get(militaryNumber).getAirforce().purchaseOrHireSomething(militaries.get(militaryNumber), 2, price, name);
			airforceInterface.dispose();
			airforceMenu();
		}
		else if(e.getSource() == purchaseFighterJet) {
			String name = "Fighter Jet";
			long price  = 121800000;
			militaries.get(militaryNumber).getAirforce().purchaseOrHireSomething(militaries.get(militaryNumber), 3, price, name);
			airforceInterface.dispose();
			airforceMenu();
		}
		else if(e.getSource() == purchaseAttackHelicopter) {
			String name = "Attack Helicopter";
			long price  = 40100000;
			militaries.get(militaryNumber).getAirforce().purchaseOrHireSomething(militaries.get(militaryNumber), 4, price, name);
			airforceInterface.dispose();
			airforceMenu();
		}
		else if(e.getSource() == hireAirforceGeneral) {
			String name = "Generals";
			long price  = 190000;
			militaries.get(militaryNumber).getAirforce().purchaseOrHireSomething(militaries.get(militaryNumber), 5, price, name);
			airforceInterface.dispose();
			airforceMenu();
		} 
		else if(e.getSource() == hireAirforceMajorGeneral) {
			String name = "Major Generals";
			long price  = 160000;
			militaries.get(militaryNumber).getAirforce().purchaseOrHireSomething(militaries.get(militaryNumber), 6, price, name);
			airforceInterface.dispose();
			airforceMenu();
		} 
		else if(e.getSource() == hireAirforceColonel) {
			String name = "Colonels";
			long price  = 130000;
			militaries.get(militaryNumber).getAirforce().purchaseOrHireSomething(militaries.get(militaryNumber), 7, price, name);
			airforceInterface.dispose();
			airforceMenu();
		} 
		else if(e.getSource() == hireAirforceMajor) {
			String name = "Majors";
			long price  = 90000;
			militaries.get(militaryNumber).getAirforce().purchaseOrHireSomething(militaries.get(militaryNumber), 8, price, name);
			airforceInterface.dispose();
			airforceMenu();
		} 
		else if(e.getSource() == hireAirforceCaptain) {
			String name = "Captains";
			long price  = 60000;
			militaries.get(militaryNumber).getAirforce().purchaseOrHireSomething(militaries.get(militaryNumber), 9, price, name);
			airforceInterface.dispose();
			airforceMenu();
		} 
		else if(e.getSource() == hireAirforceLieutenant) {
			String name = "Liutenants";
			long price  = 26000;
			militaries.get(militaryNumber).getAirforce().purchaseOrHireSomething(militaries.get(militaryNumber), 10, price, name);
			airforceInterface.dispose();
			airforceMenu();
		}
		else if(e.getSource() == removeBomberPlane) {
			String name = "Bomber Plane";
			long price  = 423000000;
			militaries.get(militaryNumber).getAirforce().removeOrFireSomething(militaries.get(militaryNumber), 1, price, name);
			airforceInterface.dispose();
			airforceMenu();
		}
		else if(e.getSource() == removeCargoPlane) {
			String name = "Cargo Plane";
			long price  = 30100000;
			militaries.get(militaryNumber).getAirforce().removeOrFireSomething(militaries.get(militaryNumber), 2, price, name);
			airforceInterface.dispose();
			airforceMenu();
		}
		else if(e.getSource() == removeFighterJet) {
			String name = "Fighter Jet";
			long price  = 121800000;
			militaries.get(militaryNumber).getAirforce().removeOrFireSomething(militaries.get(militaryNumber), 3, price, name);
			airforceInterface.dispose();
			airforceMenu();
		}
		else if(e.getSource() == removeAttackHelicopter) {
			String name = "Attack Helicopter";
			long price  = 40100000;
			militaries.get(militaryNumber).getAirforce().removeOrFireSomething(militaries.get(militaryNumber), 4, price, name);
			airforceInterface.dispose();
			airforceMenu();
		}
		else if(e.getSource() == fireAirforceGeneral) {
			String name = "Generals";
			long price  = 190000;
			militaries.get(militaryNumber).getAirforce().removeOrFireSomething(militaries.get(militaryNumber), 5, price, name);
			airforceInterface.dispose();
			airforceMenu();
		} 
		else if(e.getSource() == fireAirforceMajorGeneral) {
			String name = "Major Generals";
			long price  = 160000;
			militaries.get(militaryNumber).getAirforce().removeOrFireSomething(militaries.get(militaryNumber), 6, price, name);
			airforceInterface.dispose();
			airforceMenu();
		} 
		else if(e.getSource() == fireAirforceColonel) {
			String name = "Colonels";
			long price  = 130000;
			militaries.get(militaryNumber).getAirforce().removeOrFireSomething(militaries.get(militaryNumber), 7, price, name);
			airforceInterface.dispose();
			airforceMenu();
		} 
		else if(e.getSource() == fireAirforceMajor) {
			String name = "Majors";
			long price  = 90000;
			militaries.get(militaryNumber).getAirforce().removeOrFireSomething(militaries.get(militaryNumber), 8, price, name);
			airforceInterface.dispose();
			airforceMenu();
		} 
		else if(e.getSource() == fireAirforceCaptain) {
			String name = "Captains";
			long price  = 60000;
			militaries.get(militaryNumber).getAirforce().removeOrFireSomething(militaries.get(militaryNumber), 9, price, name);
			airforceInterface.dispose();
			airforceMenu();
		} 
		else if(e.getSource() == fireAirforceLieutenant) {
			String name = "Liutenants";
			long price  = 26000;
			militaries.get(militaryNumber).getAirforce().removeOrFireSomething(militaries.get(militaryNumber), 10, price, name);
			airforceInterface.dispose();
			airforceMenu();
		}

		//ARMY purchase buttons
		else if(e.getSource() == purchaseTank) {
			String name = "Tanks";
			long price  = 6000000;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 1, price, name);
			armyInterface.dispose();
			armyMenu();
			
		}
		else if(e.getSource() == purchaseMRAP){
			String name = "MRAPs";
			long price  = 1000000;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 3, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == purchaseSquadMG){
			String name = "SquadMGs";
			long price  = 4000;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 5, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == purchaseGrenadeLauncher){
			String name = "Grenade Launchers";
			long price  = 3500;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 4, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == purchaseHelicopter){
			String name = "Helicopters";
			long price  = 10000000;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 2, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == purchaseRifle){
			String name = "Rifles";
			long price  = 1300;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 6, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == hireArmyGeneral){
			String name = "Generals";
			long price  = 220000;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 7, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == hireArmyColonel){
			String name = "Colonels";
			long price  = 90000;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 8, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == hireArmyMajor){
			String name = "Majors";
			long price  = 75000;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 9, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == hireArmyCaptain){
			String name = "Captains";
			long price  = 60000;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 10, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == hireArmyLieutenant){
			String name = "Lieutenants";
			long price  = 42000;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 11, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == hireArmyEnlisted){
			String name = "Enlisted";
			long price  = 26000;
			
			militaries.get(militaryNumber).getArmy().purchaseOrHireSomething(militaries.get(militaryNumber), 12, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == removeTank) {
			String name = "Tanks";
			long price  = 6000000;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 1, price, name);
			armyInterface.dispose();
			armyMenu();
			
		}
		else if(e.getSource() == removeMRAP){
			String name = "MRAPs";
			long price  = 1000000;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 3, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == removeSquadMG){
			String name = "SquadMGs";
			long price  = 4000;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 5, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == removeGrenadeLauncher){
			String name = "Grenade Launchers";
			long price  = 3500;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 4, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == removeHelicopter){
			String name = "Helicopters";
			long price  = 10000000;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 2, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == removeRifle){
			String name = "Rifles";
			long price  = 1300;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 6, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == fireArmyGeneral){
			String name = "Generals";
			long price  = 220000;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 7, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == fireArmyColonel){
			String name = "Colonels";
			long price  = 90000;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 8, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == fireArmyMajor){
			String name = "Majors";
			long price  = 75000;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 9, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == fireArmyCaptain){
			String name = "Captains";
			long price  = 60000;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 10, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == fireArmyLieutenant){
			String name = "Lieutenants";
			long price  = 42000;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 11, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		else if(e.getSource() == fireArmyEnlisted){
			String name = "Enlisted";
			long price  = 26000;
			
			militaries.get(militaryNumber).getArmy().removeOrFireSomething(militaries.get(militaryNumber), 12, price, name);
			armyInterface.dispose();
			armyMenu();
		}
		//emblems
		else if(e.getSource() == armyEmblem)
		{
			homeInterface.dispose();
			armyMenu();
		}
		//switch military menu options
		else if(e.getSource() == createMilitary) 
		{
			createMilitary();
			militaryNumber = militaries.size() -1;
			currentMilitary.setText(("Your current military is " + militaries.get(militaryNumber).getName()));
			homeInterface.toFront();
			switchMilitaryInterface.toFront();
		}
		else if(e.getSource() == chooseMilitaryAvailable) 
		{
			returnMilitaryChosen();//JOptionPane to choose military
			currentMilitary.setText(("Your current military is " + militaries.get(militaryNumber).getName()));
			homeInterface.toFront();
			switchMilitaryInterface.toFront();
		}
		//FLAGS for the world map
		else if(e.getSource() == USFlag)
		{
			worldInterface.setEnabled(false);
	    	doYouWantToBattle(militaries.get(militaryNumber), militaries.get(0));
	    }
		else if(e.getSource() == chineseFlag)
		{
			worldInterface.setEnabled(false);
	    	doYouWantToBattle(militaries.get(militaryNumber), militaries.get(2));
		}
		else if(e.getSource() == russianFlag)
		{
			worldInterface.setEnabled(false);
	    	doYouWantToBattle(militaries.get(militaryNumber), militaries.get(1));
		}
		//EMBLEMS for the home base 
		else if(e.getSource() == armyEmblem)
		{
			militaries.get(militaryNumber).getArmy().calculatePower();
		}
		else if(e.getSource() == marinesEmblem)
		{
			homeInterface.dispose();
			marineMenu();
		}
		else if(e.getSource() == navyEmblem)
		{
			homeInterface.dispose();
			navyMenu();
		}
		else if(e.getSource() == airforceEmblem)
		{
			homeInterface.dispose();
			airforceMenu();
		}
		else if(e.getSource() == globeSpinning)
		{
			homeInterface.dispose();
			worldMap();
		}
		else if(e.getSource() == switchMilitary)
		{
			homeInterface.setEnabled(false);
			switchMilitaryMenu();
		}
		else if(e.getSource() == displayTheStrongestBranch)
		{
			homeInterface.setEnabled(false);
			displayStrongestBranchMenu(militaries.get(militaryNumber));
		}
		//RETURN to homebase buttons
		else if(e.getSource() == returnHomeNavy)
		{
			navalInterface.dispose();
			homeBase();
		}
		else if(e.getSource() == returnHomeMarines)
		{
			marineInterface.dispose();
			homeBase();
		}
		else if(e.getSource() == returnHomeAirforce) 
		{
			airforceInterface.dispose();
			homeBase();
		}
		else if(e.getSource() == returnHomeArmy) 
		{
			armyInterface.dispose();
			homeBase();
		}
		else if(e.getSource() == returnHomeSwitchMilitary) 
		{
			switchMilitaryInterface.dispose();
			homeInterface.setEnabled(true);
			homeInterface.toFront();
		}
		else if(e.getSource() == returnHomeWorldMap)
		{
			worldInterface.dispose();
			homeBase();
		}
		else if(e.getSource() == attackTheUS)
		{
			//insert code here
			if(militaryNumber == 0)
			{
				JOptionPane.showMessageDialog(null, "Sorry, but you cannot battle the same country");
			}
			else
			{
				animationIndicator = 1;
			}
		}
		else if(e.getSource() == attackRussia)
		{
			if(militaryNumber == 1)
			{
				JOptionPane.showMessageDialog(null, "Sorry, but you cannot battle the same country");
			}
			else
			{
				animationIndicator = 3;
			}
		}
		else if(e.getSource() == attackChina)
		{
			if(militaryNumber == 2)
			{
				JOptionPane.showMessageDialog(null, "Sorry, but you cannot battle the same country");
			}
			else
			{
				animationIndicator = 2;
			}
		}
		else if(e.getSource() == noAttack)
		{
			worldInterface.setEnabled(true);
			battleInterface1.dispose();
		}
		else if(e.getSource() == okButton)
		{
			battleScreen.dispose();
			doYouWantToBattle(militaries.get(militaryNumber), militaries.get(defenseMilitaryNumber));
			worldInterface.toFront();
			battleInterface1.toFront();
		}
	}

/****************************************************************************************/
}//end of game

