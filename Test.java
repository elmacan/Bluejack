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

        cpu.createPlayerCards();
        cpu.fromGameDeckForCpu(gd);
        cpu.shufflePlayerDecks();
        cpu.pickForPlayerHands();

        player.createPlayerCards();
        player.fromGameDeckForHuman(gd);
        player.shufflePlayerDecks();
        player.pickForPlayerHands();

        gd.gameDeckAfterDealing();

        System.out.print("COMPUTER HAND: ");
        cpu.printHand();
        System.out.println();

        int playerSetWinCount = 0;
        int cpuSetWinCount = 0;

        while (!isGameOver(player, cpu)) {
            // Player turn
            player.playerTurn(gd);
            int turnResult = evaluateSet(player, cpu);

            if (turnResult == 1) {
                System.out.println("Player wins the set!");
                playerSetWinCount++;
                player.getPlayerBoard().resetBoard();
            } else if (turnResult == -1) {
                System.out.println("CPU wins the set!");
                cpuSetWinCount++;
                cpu.getPlayerBoard().resetBoard();
            } else {
                // CPU turn only if the player didn't win in their turn
                cpu.cpuTurn(gd);
                int cpuTurnResult = evaluateSet(player, cpu);

                if (cpuTurnResult == 1) {
                    System.out.println("Player wins the set!");
                    playerSetWinCount++;
                    player.getPlayerBoard().resetBoard();
                } else if (cpuTurnResult == -1) {
                    System.out.println("CPU wins the set!");
                    cpuSetWinCount++;
                    cpu.getPlayerBoard().resetBoard();
                } else {
                    System.out.println("Set is tied!");
                }
            }

            // Check if the game is over
            if (playerSetWinCount >= 3 || cpuSetWinCount >= 3) {
                System.out.println("Game Over!");
                if (playerSetWinCount > cpuSetWinCount) {
                    System.out.println("Player wins the game!");
                } else if (cpuSetWinCount > playerSetWinCount) {
                    System.out.println("CPU wins the game!");
                } else {
                    System.out.println("The game is tied!");
                }
                break;
            }
        }
    }

    private static int evaluateSet(Player player, Player cpu) {
        int playerTotal = player.getPlayerBoard().getTotalValue();
        int cpuTotal = cpu.getCpuBoard().getTotalValue();

        if (playerTotal > 20 && cpuTotal <= 20) {
            return -1; // CPU wins
        } else if (cpuTotal > 20 && playerTotal <= 20) {
            return 1; // Player wins
        } else if (playerTotal > cpuTotal) {
            return 1; // Player wins
        } else if (playerTotal < cpuTotal) {
            return -1; // CPU wins
        } else {
            return 0; // Tie
        }
    }

    public static boolean isGameOver(Player player, Player cpu) {
        return player.getSetWinCount() >= 3 || cpu.getSetWinCount() >= 3;
    }
}


/*public class Test {
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

        int turnResult = evaluateSet(player, cpu);
        if (turnResult == 1) {
            System.out.println("Player wins the set!");
        } else if (turnResult == -1) {
            System.out.println("CPU wins the set!");
        } else {
            System.out.println("Set is tied!");
        }

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
        if (player.getPlayerBoard().getTotalValue() > cpu.getCpuBoard().getTotalValue()) {
            player.incrementSetWinCount();
            return 1; // Player win
        } else if (player.getPlayerBoard().getTotalValue() < cpu.getCpuBoard().getTotalValue()) {
            cpu.incrementSetWinCount();
            return -1; // CPU win
        } else {
            return 0; // Tie
        }

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






