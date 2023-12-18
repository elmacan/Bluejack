public class Test{
    public static void main(String[] args){
        GameDeck gd=new GameDeck();
        //gd.shuffleGameDeck();
        //gd.printGameDeck();
		
		Player p=new Player();
        p.createPlayerCards();
        p.printPlayerDeck();
  }
    }

