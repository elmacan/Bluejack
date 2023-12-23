import java.util.Random;
import java.util.Scanner;
public class Player {
    private Card[] playerCards=new Card[10];
    private Card[] playerHands=new Card[4];
    Board playerBoard=new Board();
    Board cpuBoard=new Board();

    Scanner sc=new Scanner(System.in);

    //Player type  Player name
    public void createPlayerCards(){
        String[] colours = {"B", "Y", "R", "G"};
        int[] signs = {1, -1};
        Random r = new Random(System.currentTimeMillis());


        for (int i = 0; i < 4; i++) {
            int n = r.nextInt(6) + 1;
            int c = r.nextInt(4);
            String rc = colours[c];
            int s = r.nextInt(2);
            int rs = signs[s];
            getPlayerCards()[i] = new Card(rc, n, rs);
        }

        //create special card
        int[] percent={8,8,8,8,8,8,8,8,2,2};
        for(int i=3;i<=4;i++) {
            int p = r.nextInt(10);
            System.out.println("%"+percent[p]+"chance ");
            if (percent[p] == 2) {
                getPlayerCards()[3] = new Card(11);  //flip card
                getPlayerCards()[4]= new Card(2);   //double card     çarpım olarak lazım ikisi de
            }
            if(percent[p]==8) {

                int n = r.nextInt(6) + 1;
                int c = r.nextInt(4);
                String rc = colours[c];
                int s = r.nextInt(2);
                int rs = signs[s];
                getPlayerCards()[i] = new Card(rc, n, rs);

            }
        }

    }

    public void fromGameDeckForHuman(GameDeck gd){   //alttan alınan kısım oyuncuya verdiğimiz
        //gd.printGameDeck();
        for(int i=5;i<10;i++){
            getPlayerCards()[i]=gd.getCards()[i+30];
        }

    }

    public void fromGameDeckForCpu(GameDeck gd){    //üstten alınan kısım bilgisayara verdiğimiz
        //gd.printGameDeck();
        int j=0;
        for(int i=5;i<10;i++){
            getPlayerCards()[i]=gd.getCards()[j];
            j++;
        }

    }

    public void shufflePlayerDecks(){            //shuffle yaptıktan sonra ilk dördünü almak =rastgele 4ünü seçmek
        for (int i = 0; i <10; i++) {
            Random r=new Random();
            int ri=r.nextInt(i+1); // random 0 to i    nextInt(100) 0,1,....99
            Card temp= getPlayerCards()[i];
            getPlayerCards()[i]= getPlayerCards()[ri];       //swap
            getPlayerCards()[ri]=temp;

        }


    }

        public void pickForPlayerHands(){
            for(int i=0;i<4;i++){
                getPlayerHands()[i]= getPlayerCards()[i];
                //if(getPlayerHands()[i].getColour()==null) System.out.println("value: " + getPlayerHands()[i].getValue() + " sign: " + getPlayerHands()[i].getSign()+"    special: "+ getPlayerHands()[i].getSpecial());
                System.out.println("colour: " + playerHands[i].getColour() + "      value: " + playerHands[i].getValue() + " sign: " + playerHands[i].getSign()+"    special: "+playerHands[i].getSpecial());
            }

        }









    public void printPlayerDeck() {
        for (Card a : getPlayerCards()) {

            System.out.println("colour:" + a.getColour() + " value:" + a.getValue() + " sign:" + a.getSign()+"  special:"+a.getSpecial());
        }

    }
	public void removeCardInPlayerHands(int chosen){
            getPlayerHands()[chosen].setValue(0);

        }


    public void printHand(){
        for(int i=0;i<playerHands.length;i++){
            if(playerHands[i].getSpecial()==11){
                System.out.print("(+/-) ");
            }
            else if(playerHands[i].getSpecial()==2){
                System.out.print("(x2) ");
            }
            else if(playerHands[i].getValue()==0){
                System.out.print("__ ");
            }
            else if(playerHands[i].getSign()==-1){
                System.out.print(playerHands[i].getColour()+"(-"+playerHands[i].getValue()+") ");
            }
            else{
                System.out.print(playerHands[i].getColour()+"(+"+playerHands[i].getValue()+") ");
            }
        }
    }
	
	public void playerTurn(GameDeck gd){
        boolean turnActive=true;
        while (turnActive){
            System.out.print("YOUR HAND: ");
            printHand();
            System.out.println();
            System.out.println("Choose an action:");
            System.out.println("0. Play card 1");
            System.out.println("1. Play card 2");
            System.out.println("2. Play card 3");
            System.out.println("3. Play card 4");
            System.out.println("4. Stand");
            System.out.println("5. Draw a card");

            int chosen=sc.nextInt();
            switch (chosen){
                case 0:
                case 1:
                case 2:
                case 3:
                    playerBoard.addCardToBoard(getPlayerHands()[chosen]);
                    System.out.print("YOUR BOARD: ");
                    playerBoard.printBoard();
                    System.out.println();
                    removeCardInPlayerHands(chosen);
                    turnActive=false;
                    break;

                case 4:
                    System.out.println("you chose to stand");
                    turnActive=false;
                    break;

                case 5:
                    System.out.println("you drew a card");
                    gd.getCardFromTop();
                    break;

                default:
                    System.out.println("invalid input");
                    break;
            }

           if(playerBoard.getTotalValue()>20){  //düzenlencek
               System.out.println("bust");
               turnActive=false;
           }


        }
	}
	
	public void cpuTurn(GameDeck gd){
        while(cpuBoard.getTotalValue()<17){
            int chosen=r.nextInt(4);
            cpuBoard.addCardToBoard(getPlayerHands()[chosen]);
            System.out.println("computer played card");
            System.out.print("COMPUTER BOARD: ");
            cpuBoard.printBoard();

            removeCardInPlayerHands(chosen);

            if(cpuBoard.getTotalValue()>20){
                System.out.println("bust");
                break;
            }

        }
    }



    public Card[] getPlayerHands() {
        return playerHands;
    }

    public void setPlayerHands(Card[] playerHands) {
        this.playerHands = playerHands;
    }

    public Card[] getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(Card[] playerCards) {
        this.playerCards = playerCards;
    }
}
