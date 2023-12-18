import java.util.Random;
public class GameDeck {
    private String[] colours = {"blue", "yellow", "red", "green"};
    private Card[] deck ;


    public GameDeck(){
        deck=new Card[40];
    }


    public void createGameDeck() {
        int index=0;
        for (String p : colours) {
            for(int i=1;i<=10;i++){
                deck[index++]=new Card(p,i);
                //index++;
            }
        }

    }

    public void printGameDeck(){
        for(Card c:deck){
            System.out.println("colour: " +c.getColour()+ "  value: "+c.getValue());
        }
		//System.out.println(deck[1].getColour());

    }
	
	  public void shuffleGameDeck() {


        //Card[] deck2 = new Card[40];
        //int j=this.deck.length;
        for (int i = 1; i <deck.length; i++) {
            Random r=new Random();
            int ri=r.nextInt(i+1);
            Card temp= this.deck[i];
            deck[i]=deck[ri];
            deck[ri]=temp;

        }
    }


}