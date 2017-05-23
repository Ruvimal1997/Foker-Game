
package forker.game.dto;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Collections;
public class Deck
{
  private Card[] deck;
  private int currentCard;
  
  public Deck() throws IOException
  {
      String[] faces={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};  
      String[] suits={"Diamonds","Clubs","Hearts","Spades"};
      
      deck=new Card[52];    
      currentCard=0;        
  
      //image card
      final int width=123;
      final int height=172;
      final int rows=4;
      final int cols=13;
      
      BufferedImage bigimage=ImageIO.read(new File("Card.png"));
      BufferedImage tempCardImage;
      
      for(int suit=0;suit<4;suit++)
      {
          for(int facenum=0;facenum<13;facenum++)
          {
              tempCardImage=bigimage.getSubimage(facenum*width+(facenum*9),suit*height+(suit*14), width, height);
              deck[(facenum+(suit*13))]=new Card(suits[suit],faces[facenum],facenum+2,tempCardImage);
          }
          
      }
  }
   public void displayDeck()
  {
      for(Card card:deck)
      {
          System.out.println(card.tostring());
      }
  }
  public void shuffle()
  {
      currentCard=0;
      SecureRandom randomNumber=new SecureRandom();
      for(int first=0;first<deck.length;first++)
      {
          int second=randomNumber.nextInt(52);
          Card temp=deck[first];
          deck[first]=deck[second];
          deck[second]=temp;
      }
      
  }
  public Card Dealcard()
  {
      if(currentCard<deck.length)
          return deck[currentCard++];
      else
          return null;
  }

  public static void main(String[] args) throws IOException
    {
        Deck thed=new Deck();
        thed.displayDeck();
        System.out.println("Shuffled");
        thed.shuffle();
        thed.displayDeck();
    }
}
