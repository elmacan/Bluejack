public class Test{
    public static void main(String[] args){
        GameDeck gd=new GameDeck();
        Player p=new Player();

        //gd.shuffleGameDeck();
        System.out.println("KARILMAMIŞ GAME DECK");
        gd.printGameDeck();
        System.out.println("----------------------------------");
        p.createPlayerCards();
        p.fromGameDeckForCpu(gd);
        System.out.println("before shuffle CPU PLAYER DECK");

        p.printPlayerDeck();
        System.out.println("----------------------------------");
        System.out.println("after shuffle CPU PLAYER DECK");
          p.shufflePlayerDecks();
          p.printPlayerDeck();
        System.out.println("----------------------------------");
        System.out.println("PLAYER HANDS");
        p.pickForPlayerHands();

    }
}
