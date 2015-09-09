
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card
{
    // instance variables - replace the example below with your own
    public String face;
    public String suit;
    public int faceValue;

    /**
     * Constructor for objects of class Card
     */
    public Card(String pFace, String pSuit, int pFaceValue)
    {
        face = pFace;
        suit = pSuit;
        faceValue = pFaceValue;
        
    }

    public String getFace()
    {
        return face;
    }

    public String getSuit()
    {
        return suit;
    }
    
    public int getFaceValue()
    {
        return faceValue;
    }
    
    public void print()
    {
        System.out.println("You got dealt a " + face + " of " + suit + ".");
        
    }
    
}
