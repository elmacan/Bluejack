import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GameDeck gd = new GameDeck();
        Player cpu = new Player();
        cpu.setName("CPU");
        Player player = new Player();

        System.out.println("Enter your username: ");
        String userName = sc.nextLine();
        player.setName(userName);
        gd.shuffleGameDeck();

        cpu.createPlayerCards();    //gamdeck ten gelmeyen rastgele üretilen özel 5 kart
        cpu.fromGameDeckForCpu(gd); //gamedeckten gelen 5 kartı cpu nun player cardlarına atıyor (en üstteki 5 kartı)
        cpu.shufflePlayerDecks();  //rastgele 4ünü seçmek için için shuffle yapıp ilk dördünü alıyor
        cpu.pickForPlayerHands();  //


        player.createPlayerCards();        //player için olan kısım
        player.fromGameDeckForHuman(gd);   //gamedeckten en alttaki 5 kartı player cardlarına atıyor
        player.shufflePlayerDecks();
        player.pickForPlayerHands();

        gd.gameDeckAfterDealing();     //oyunculara 5er kart verdikten sonra 30cardlık yeni dizi oluşturup eskisini içine atıyor

        System.out.print("COMPUTER HAND:");
        cpu.printHand();
        System.out.println();



        //düzenlencek
        int playerSetWinCount = 0;
        int cpuSetWinCount = 0;
        while (!isGameOver(player, cpu)) {
            boolean setFinished = false;
            player.playerTurn(gd);
            Result turnResult = evaluateSet();

            if (setFinished) {
                playerSetWinCount = playerSetWinCount;
                System.out.println("Game Over! Player wins!");
                player.getPlayerBoard().resetBoard();
            }
            cpu.cpuTurn(gd);
            //evaluateGame();
            if (cpu.getSetWinCount() > cpuSetWinCount){
                System.out.println("Game Over! cpu wins!");
                cpu.getPlayerBoard().resetBoard();
            }
        }
    }

    private static Result evaluateSet(Player player, Player cpu) {

    }

        
    public static boolean isGameOver(Player player,Player cpu){
        return player.getSetWinCount() >= 3 || cpu.getSetWinCount() >= 3;
    }
}





        //control kısımları kartların doğru ayarlandığına bakmak için
        /*System.out.println("KARILMAMIŞ GAME DECK");
        gd.printGameDeck();
        System.out.println("----------------------------------");
        System.out.println("KARILMIŞ GAME DECK");
        gd.shuffleGameDeck();
        gd.printGameDeck();
        System.out.println("----------------------------------");
        cpu.createPlayerCards();   //player için random 5kart üretilen  method
        cpu.fromGameDeckForCpu(gd);  // playerdeckteki geri kalan 5 kartın ana desteden cpu için geldiği kısım (ana destenin ilk 5 kartı)
        System.out.println("before shuffle CPU PLAYER DECK");
        cpu.printPlayerDeck();
        System.out.println("----------------------------------");
        System.out.println("after shuffle CPU PLAYER DECK");
        cpu.shufflePlayerDecks();
        cpu.printPlayerDeck();
        System.out.println("----------------------------------");
        System.out.println("CPU HANDS");   //player cardlarının shuffle yaptıktan sonra ilk 4 kartı seçmek=rastgele 4 kart seçmek
        cpu.pickForPlayerHands();//içinde yazdırıyor
        System.out.println("----------------------------------");
        player.createPlayerCards();
        player.fromGameDeckForHuman(gd);
        System.out.println("before shuffle HUMAN PLAYER DECK");
        player.printPlayerDeck();
        System.out.println("-----------------------------------");
        System.out.println("after shuffle HUMAN PLAYER DECK");
        player.shufflePlayerDecks();
        player.printPlayerDeck();
        System.out.println("-----------------------------------");
        System.out.println("HUMAN HANDS");
        player.pickForPlayerHands();     //eline 4 kart alıyor
        System.out.println("-------------------------------------");
        System.out.println("AFTER DEALİNG");
        gd.gameDeckAfterDealing();   //oyunculara kart verdikten sonra 30cardlık yeni desteye eskisini kopyaladım
        System.out.println("--------------------------------------");*/






