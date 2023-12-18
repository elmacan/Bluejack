import java.util.Random;
public class Player {
    private Card[] playerCards=new Card[4];
    //Player hand
    //Player board

    public Player(){
        //String[] colours={"blue","yellow","red","green"};



    }

    public void createPlayerCards() {
        String[] colours = {"blue", "yellow", "red", "green"};
        int[] signs = {1, -1};
        Random r = new Random(System.currentTimeMillis());


        for (int i = 0; i < 4; i++) {
            int n = r.nextInt(6) + 1;
            int c = r.nextInt(4);
            String rc = colours[c];
            int s = r.nextInt(2);
            int rs = signs[s];
            playerCards[i] = new Card(rc, c, rs);
        }

        


    }

        public void printPlayerDeck() {
            for (Card a : playerCards) {
                System.out.println("colour: " + a.getColour() + "      value: " + a.getValue() + " sign: " + a.getSign());
            }

        }







}
