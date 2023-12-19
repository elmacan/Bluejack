public class Test{
    public static void main(String[] args){
        GameDeck gd=new GameDeck();
        Player p=new Player();

        //gd.shuffleGameDeck();

        gd.printGameDeck();
        p.createPlayerCards();
        p.fromGameDeckForCpu(gd);
        System.out.println("before shuffle");
        p.printPlayerDeck();

        System.out.println("after shuffle");
          p.shufflePlayerDecks();
          p.printPlayerDeck();

    }
}
