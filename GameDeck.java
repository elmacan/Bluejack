import java.util.Random;
public class GameDeck {
    private String[] colours = {"blue", "yellow", "red", "green"};
    private Card[] cards=new Card[40]; ;


    public GameDeck(){

        //cards=new Card[40];
        int index=0;
        //for each loop (type variable adı :dizinin adı)
        for (String p : colours) {
            for (int i = 1; i <= 10; i++) {
                cards[index++] = new Card(p, i);
                //index++;
            }
        }
    }

    public void printGameDeck(){
        for(Card c:cards){
            System.out.println("colour: " +c.getColour()+ "  value: "+c.getValue());

        }
        //System.out.println(deck[1].getColour());

    }
    public void shuffleGameDeck() {
    //FISHER-YATES SHUFFLE ALGORITHM

        //Card[] cards2 = new Card[40];

        for (int i = 0; i <40; i++) {
            Random r=new Random();
            int ri=r.nextInt(i+1); // random 0 to i    nextInt(100) 0,1,....99
            Card temp= cards[i];
            cards[i]=cards[ri];       //swap
            cards[ri]=temp;

        }
    }




    }


