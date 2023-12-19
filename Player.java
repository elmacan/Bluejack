import java.util.Random;
public class Player {
    private Card[] playerCards=new Card[10];
    //Player hand
    //Player board

    public void createPlayerCards(){
        String[] colours = {"blue", "yellow", "red", "green"};
        int[] signs = {1, -1};
        Random r = new Random(System.currentTimeMillis());


        for (int i = 0; i < 4; i++) {
            int n = r.nextInt(6) + 1;
            int c = r.nextInt(4);
            String rc = colours[c];
            int s = r.nextInt(2);
            int rs = signs[s];
            playerCards[i] = new Card(rc, n, rs);
        }

        //create special card
        int[] percent={8,8,8,8,8,8,8,8,2,2};
        for(int i=3;i<=4;i++) {
            int p = r.nextInt(10);
            System.out.println("%"+percent[p]+"chance ");
            if (percent[p] == 2) {
                playerCards[3] = new Card(11);  //flip card
                playerCards[4]= new Card(2);   //double card     çarpım olarak lazım ikisi de
            }
            if(percent[p]==8) {

                int n = r.nextInt(6) + 1;
                int c = r.nextInt(4);
                String rc = colours[c];
                int s = r.nextInt(2);
                int rs = signs[s];
                playerCards[i] = new Card(rc, n, rs);

            }
        }

    }

    public void fromGameDeckForHuman(GameDeck gd){   //alttan alınan kısım oyuncuya verdiğimiz
        //gd.printGameDeck();
        for(int i=5;i<10;i++){
            playerCards[i]=gd.getCards()[i+30];
        }

    }

    public void fromGameDeckForCpu(GameDeck gd){    //üstten alınan kısım bilgisayara verdiğimiz
        //gd.printGameDeck();
        int j=0;
        for(int i=5;i<10;i++){
            playerCards[i]=gd.getCards()[j];
            j++;
        }

    }

    public void shufflePlayerDecks(){            //shuffle yaptıktan sonra ilk dördünü almak =rastgele 4ünü seçmek
        for (int i = 0; i <10; i++) {
            Random r=new Random();
            int ri=r.nextInt(i+1); // random 0 to i    nextInt(100) 0,1,....99
            Card temp= playerCards[i];
            playerCards[i]= playerCards[ri];       //swap
            playerCards[ri]=temp;

        }


    }


    public void printPlayerDeck() {
        for (Card a : playerCards) {
            System.out.println("colour: " + a.getColour() + "      value: " + a.getValue() + " sign: " + a.getSign()+"    special: "+a.getSpecial());
        }

    }

}

