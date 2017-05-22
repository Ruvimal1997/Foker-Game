
package forker.game.dto;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Card {
   
    private String facename,suit;
    private int facevalue;
    private BufferedImage cardImage;
    
    /**
     * constructor for the card class
     * @param suit  ="Spades","Clubs","Diamonds","Hearts"
     * @param face  =2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace
     * @param value =2,3,4,5,6,7,8,9,10,11,12,13,14
     * @param card  to store the image of the card
     */
    public Card(String suit,String face,int value,BufferedImage card)
    {
        this.suit=suit;
        this.facename=face;
        facevalue=value;
        cardImage=card;
    }
    /**
     * return the string representation
     * @return 
     */
    public String tostring()
    {
        return facename+"of"+suit;
    }
    /**
     * return the face value of the card
     * @return 
     */
    public int getFacevalue()
    {
        return facevalue;
    }
     public BufferedImage getCardImage() 
     {
            return cardImage;
        }
    public static void main (String[] args) throws IOException
    {
        Card aceofspades=new Card("Spades","Ace",14,ImageIO.read(new File("Ace_Spades.png")));
        System.out.println(aceofspades.toString());
        System.out.println("the ace of spades has a value of "+aceofspades.getFacevalue());
        
        //create a jframe to display card
        JFrame window=new JFrame("Display Card");
        window.setSize(400,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        JPanel conentpane=new JPanel(new BorderLayout());
        
        JLabel cardLabel=new JLabel(new ImageIcon(aceofspades.getCardImage()));
        cardLabel.setSize(300,400);
        
        conentpane.add(cardLabel);
        window.add(conentpane); 
    }
    
}
