import java.util.Random;

/**
 * Write a description of class Table here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Table
{
    // instance variables - replace the example below with your own
    public Deck thisDeck;
    private InputReader reader;
    private Random randomGenerator;
    public Card thisCard;

    public int personPoints;
    public int dealerPoints;
    public Person player01;
    public Dealer dealer;

    /**
     * Constructor for objects of class Table
     */
    public Table()
    {
        reader = new InputReader();
        randomGenerator = new Random();
        welcome();
        startGame();

    }

    public void welcome()
    {
        System.out.println("Welcome to the Srinivasan Gambling Den.");
        System.out.println("Please stay and have a good time.");
        System.out.println("Cheating is not permitted in this game.");
        System.out.println();

    }

    /*
     * Messages for the different ways to end the game
     */

    public void bustedMessage()
    {
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println("************* BUSTED ******************");
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println();

    }

    public void blackJackMessage()
    {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$ BLACKJACK $$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println();

    }

    /*
     * Checks for states in the game of the number of points in hands
     */

    public boolean checkBust(int pValue)
    {
        if(pValue > 21)
        {
            return true;
        }
        return false;
    }

    public Card generateCard()
    {
        // Pick a random number for the index in the deck. 
        // The number will be between 0 (inclusive) and the size
        // of the list (exclusive).
        int index = randomGenerator.nextInt(thisDeck.size());
        thisCard = thisDeck.returnCard(index);
        thisDeck.removeCard(index);
        return thisCard;
    }

    public boolean gFinishCheck(String pInput)
    {
        if(!pInput.startsWith("yes") && !pInput.startsWith("no"))
        {
            System.out.println();
            System.out.println("You have entered an invalid input. Exiting the game now.");
            return true;                
        }

        if(pInput.startsWith("no"))
        {
            // gFinished = true;
            System.out.println("Thank you for visiting the Srinivasan Gambling Den. Come again soon.");
            return true;
        }

        return false;    

    }

    public void startGame()
    {
        System.out.println("Would you like to begin playing the game? Please use \"yes\" or \"no\" to respond.");
        String gInput = reader.getInput().trim().toLowerCase();

        while(!gFinishCheck(gInput))
        {
            System.out.println();

            thisDeck = new Deck();
            boolean dealerHold = false;
            boolean playerHold = false;
            player01 = new Person();
            dealer = new Dealer();
            //players = new ArrayList<Player>();
            ///players.add(player);
            //players.add(dealer);

            //System.out.println("This is Round " + round + " of the blackjack game.");
            System.out.println();
            boolean rFinished = false; //a boolean check to see if the round is over

            System.out.println("Please use \"hit\" or \"hold\" to indicate if you would like a card or to stop.");

            while(!rFinished)
            {
                String input = reader.getInput().trim().toLowerCase();

                if(input.startsWith("hit"))
                {

                    System.out.println("The player gets a card.");
                    System.out.println();
                    Card playerCard = generateCard();
                    player01.insert(playerCard);
                    player01.printHand();
                    System.out.println("Your cards total " + player01.points() + " points.");

                    if(checkBust(player01.points()))
                    {
                        System.out.println();
                        System.out.println("*** PLAYER ************** HAS ********");    
                        bustedMessage();
                        rFinished = true;
                    }

                }

                if(player01.points() == 21)
                {
                    System.out.println();
                    System.out.println("*** PLAYER ************** HAS ********");                    
                    blackJackMessage();
                    rFinished = true;
                }

                if(input.startsWith("hold"))
                {
                    System.out.println();
                    System.out.println("#######################################");
                    System.out.println("#######################################");
                    System.out.println("############## HOLD ###################");
                    System.out.println("#######################################");
                    System.out.println("#######################################");
                    System.out.println("Player has a total of " + player01.points() + " points.");
                    playerHold = true;
                }

                if(dealer.points() <= 21 && dealer.points() >= 17)
                {
                    dealerHold = true;
                }

                if(dealer.points() <= 21 && dealerHold == false)
                {
                    Card dealerCard = generateCard();
                    dealer.insert(dealerCard);
                    System.out.println("Dealer has been dealt a card.");
                    System.out.println();

                    if(checkBust(dealer.points()))
                    {
                        System.out.println();
                        System.out.println("*** DEALER ************** HAS ********");    
                        bustedMessage();
                        rFinished = true;
                    }

                }

                if(dealer.points() == 21)
                {
                    System.out.println();
                    System.out.println("*** DEALER ************** HAS ********");                    
                    blackJackMessage();
                    rFinished = true;
                }

                if(dealerHold == true && playerHold == true)
                {
                    if (dealer.points() > player01.points())
                    {
                        System.out.println();
                        System.out.println("Dealer has won this round of the game with " + dealer.points() + " points to the player's  " + player01.points() + " points.");
                        System.out.println();
                        rFinished = true;
                    }
                    else
                    {

                        System.out.println();
                        System.out.println("Player has won this round of the game with " + player01.points() + " points to the dealer's  " + dealer.points() + " points.");
                        System.out.println();
                        rFinished = true;

                    }

                }

            }
            System.out.println("The Players hand had the following cards: ");
            player01.printHand();
            System.out.println();
            System.out.println("The Dealers hand had the following cards: ");
            dealer.printHand();
            System.out.println();
            System.out.println("Would you like to keep playing the game? Please use \"yes\" or \"no\" to respond.");
            gInput = reader.getInput().trim().toLowerCase();

        }

    }
}
