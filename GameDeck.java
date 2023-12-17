public class GameDeck {
    private String[] colours = {"blue", "yellow", "red", "green"};
    private Card[] deck ;


    public GameDeck(){
        deck=new Card[40];
    }


    public void createDeck() {
        int index=0;
        for (String p : colours) {
            for(int i=1;i<=10;i++){
                deck[index++]=new Card(p,i);
                //index++;
            }
        }

    }

      public void printDeck(){
        for(Card c:deck){
            System.out.println("colour: " +c.getColour()+ "  value: "+c.getValue());
        }

    }






}