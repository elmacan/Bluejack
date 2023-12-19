public class Test{
    public static void main(String[] args){
        GameDeck gd=new GameDeck();
        Player p=new Player();
        Player p2=new Player();


        System.out.println("KARILMAMIŞ GAME DECK");
        gd.printGameDeck();
        System.out.println("----------------------------------");
        System.out.println("KARILMIŞ GAME DECK");
        gd.shuffleGameDeck();
        gd.printGameDeck();
        System.out.println("----------------------------------");
        p.createPlayerCards();
        p.fromGameDeckForCpu(gd);  //
        System.out.println("before shuffle CPU PLAYER DECK");
        p.printPlayerDeck();
        System.out.println("----------------------------------");
        System.out.println("after shuffle CPU PLAYER DECK");
        p.shufflePlayerDecks();
        p.printPlayerDeck();
        System.out.println("----------------------------------");
        System.out.println("CPU HANDS");
        p.pickForPlayerHands();//içinde yazdırıyor
        System.out.println("----------------------------------");
        p2.createPlayerCards();
        p2.fromGameDeckForHuman(gd);
        System.out.println("before shuffle HUMAN PLAYER DECK");
        p2.printPlayerDeck();
        System.out.println("-----------------------------------");
        System.out.println("after shuffle HUMAN PLAYER DECK");
        p2.shufflePlayerDecks();
        p2.printPlayerDeck();
        System.out.println("-----------------------------------");
        p2.pickForPlayerHands();


    }
}
