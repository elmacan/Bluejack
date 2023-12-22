import java.util.Random;
public class GameDeck {
    private String[] colours = {"B", "Y", "R", "G"};
    private Card[] cards=new Card[40];
    Card[] newCards=new Card[30];  //oyunculara 5er kart dağıttıktan sonraki gamedeck in yeni hali
    //sonra üstten kart çekilcek


    //(her renk içi 10ar adet card oluşturuyor)
    public GameDeck(){

        //cards=new Card[40];
        int index=0;
        //for each loop (type variable adı :dizinin adı)
        for (String p : getColours()) {
            for (int i = 1; i <= 10; i++) {
                getCards()[index++] = new Card(p, i);
                //index++;
            }
        }




    }

    public void printGameDeck(){
        for(Card c: getCards()){
            System.out.println("colour:"+c.getColour()+ " value:"+c.getValue());

        }
        //System.out.println(deck[1].getColour());

    }

    //tek method haline getir
    public void shuffleGameDeck() {
        //FISHER-YATES SHUFFLE ALGORITHM

        //Card[] cards2 = new Card[40];

        for (int i = 0; i <40; i++) {
            Random r=new Random();
            int ri=r.nextInt(i+1); // random 0 to i    nextInt(100) 0,1,....99
            Card temp= getCards()[i];
            getCards()[i]= getCards()[ri];       //swap
            getCards()[ri]=temp;

        }
    }




        //oyunculara 5 er kart dağıttıktan sonraki yeni gamedeck in içine eski gamedeckteki kalan cardları atıyor
    public void gameDeckAfterDealing(){
        //Card[] newCards=new Card[30];
        for(int i=0;i<30;i++){
            newCards[i]=this.cards[i+5];
        }
        for(Card c:newCards){
            System.out.println("colour:" +c.getColour()+ "  value:"+c.getValue());
        }

    }


    //en üstten card çekiyor ve sürekli yeni deck oluşturuyor

    public void getCardFromTop(){
        Card takenCard=newCards[0];
        Card[] newCardss=new Card[this.newCards.length-1];
        System.arraycopy(newCards,1,newCardss,0,newCardss.length);
        newCards=newCardss;
        System.out.println(" TAKEN CARD c:" +takenCard.getColour()+ "  v:"+takenCard.getValue());
        System.out.println("----------------------------------------");
        for(Card c:newCards){
            System.out.println("colour:" +c.getColour()+ "  value:"+c.getValue());
        }
    }




    public String[] getColours() {
        return colours;
    }

    public void setColours(String[] colours) {
        this.colours = colours;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}

