
package forker.game.dto;

public class Card {
        private String facename;
	private String suit;
        private boolean isFaceUp;
	private String sCardImage;
    
        public Card(String cardFace,String cardSuit)
        {
		facename = cardFace;
		suit = cardSuit;
	}
        public String getCardName()
        {
                return facename+suit;        
        }
	public String toString()
        {
		return facename+suit;
        }
        public void setFace(boolean isFaceUp) 
        {
                 this.isFaceUp = isFaceUp;
        }
        public boolean getFace()
        {
                 return this.isFaceUp;
        }       
        
        public void setImageName(String sImage)
        {
                 this.sCardImage = sImage;
        }
        
        public String getImageName() 
        {
                 return this.sCardImage;
        }
}
