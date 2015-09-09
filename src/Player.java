import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{

    public Card thisCard;
    public ArrayList<Card> hand;
    public int points;


    /**
     * Constructor for objects of class Player
     */
    public Player()
    {

        hand = new ArrayList<Card>();

    }

    public void insert(Card pthisCard)
    {
        hand.add(pthisCard);
    }

    public int points()
    {
        points = 0;
        for(Card thisCard:hand)
        {
            points = points + thisCard.getFaceValue();
        }
        
        return points;
    }
    
    public void printHand()
    {
        for(Card thisCard:hand)
        {
            thisCard.print();
            
        }
        
        
    }
}
