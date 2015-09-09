import java.util.ArrayList;
/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck
{
    // instance variables - replace the example below with your own
    public Card thisCard;
    public ArrayList<Card> deck;
    public ArrayList<String> faces;
    public ArrayList<String> suits;
    public ArrayList<Integer> faceValues;
    
    public String suit;
    public String face;
    public int faceValue;

    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {
        deck = new ArrayList<Card>();
        initializeFaces();
        initializeSuits();
        initializeFaceValues();
        createADeck();
        
        
    }

    public void initializeFaces()
    {
        faces = new ArrayList<String>();
        faces.add("Ace_1");
        faces.add("Two");
        faces.add("Three");
        faces.add("Four");
        faces.add("Five");
        faces.add("Six");
        faces.add("Seven");
        faces.add("Eight");
        faces.add("Nine");
        faces.add("Ace_10");
        faces.add("Jack");
        faces.add("Queen");
        faces.add("King");      
   }
    
    
    public void initializeSuits()
    {
        suits = new ArrayList<String>();
        suits.add("Spades");
        suits.add("Hearts");
        suits.add("Clubs");
        suits.add("Diamonds");
    }
    
    
    public void initializeFaceValues()
    {
        faceValues = new ArrayList<Integer>();
        faceValues.add(1);
        faceValues.add(2);
        faceValues.add(3);
        faceValues.add(4);
        faceValues.add(5);
        faceValues.add(6);
        faceValues.add(7);
        faceValues.add(8);
        faceValues.add(9);
        faceValues.add(10);
        faceValues.add(10);
        faceValues.add(10);
        faceValues.add(10);
    }
    
    public void createADeck()
    {

        for(String suit:suits)
        {
            int fIndex = 0;
            
            while (fIndex < faces.size())
            {
                face = faces.get(fIndex);
                faceValue = faceValues.get(fIndex);
                
                thisCard = new Card(face,suit,faceValue);
                
                deck.add(thisCard);
                
                fIndex++;
                
            }

        }
    }
    
    
    public int size()
    {
        return deck.size();
    }
    
    public Card returnCard(int pIndex)
    {
        return deck.get(pIndex);   
    }
    
    public void removeCard(int pIndex)
    {
        deck.remove(pIndex);        
    }
    
    
    
    
}
