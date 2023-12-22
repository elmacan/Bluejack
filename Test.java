import java.util.Scanner;
public class Test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        GameDeck gd=new GameDeck();
        Player cpu=new Player();
        Player player=new Player();
        //Board b=new Board();
        Board playerBoard=new Board(player);
        Board cpuBoard=new Board(cpu);

        gd.shuffleGameDeck();

        cpu.createPlayerCards();    //gamdeck ten gelmeyen kısım
        cpu.fromGameDeckForCpu(gd); //gamedeckten gelen 5 kart
        cpu.shufflePlayerDecks();  //rastgele 4ünü seçmek için
        cpu.pickForPlayerHands();  //elinde 4kart


        player.createPlayerCards();
        player.fromGameDeckForHuman(gd);
        player.shufflePlayerDecks();
        player.pickForPlayerHands();


        System.out.print("COMPUTER HAND:  ");cpu.printHand();
        System.out.println();
        //System.out.println("COMPUTER BOARD: "+cpuBoard);
        //System.out.println("YOUR BOARD:     "+playerBoard);
        System.out.print("YOUR HAND:      ");player.printHand();
        System.out.println();
        System.out.print("choose:");
        //System.out.println("BOARD: ");
        int chosen= sc.nextInt();


        switch (chosen){
            case 0: playerBoard.addCardToBoard(player.getPlayerHands()[0]);
            break;
            case 1:playerBoard.addCardToBoard(player.getPlayerHands()[1]);
            break;
            case 2:playerBoard.addCardToBoard(player.getPlayerHands()[2]);
            break;
            case 3:playerBoard.addCardToBoard(player.getPlayerHands()[3]);
            break;
            default:
                System.out.println("yanlış sayi");
                break;
        }
        playerBoard.printBoard(player);
        player.removeCardInPlayerHands(chosen);
        System.out.println();
        player.printHand();


        /*System.out.println("KARILMAMIŞ GAME DECK");
        gd.printGameDeck();
        System.out.println("----------------------------------");
        System.out.println("KARILMIŞ GAME DECK");
        gd.shuffleGameDeck();
        gd.printGameDeck();
        System.out.println("----------------------------------");
        cpu.createPlayerCards();
        cpu.fromGameDeckForCpu(gd);  //
        System.out.println("before shuffle CPU PLAYER DECK");
        cpu.printPlayerDeck();
        System.out.println("----------------------------------");
        System.out.println("after shuffle CPU PLAYER DECK");
        cpu.shufflePlayerDecks();
        cpu.printPlayerDeck();
        System.out.println("----------------------------------");
        System.out.println("CPU HANDS");
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
        player.pickForPlayerHands();
        System.out.println("-------------------------------------");
        System.out.println("AFTER DEALİNG");
        gd.gameDeckAfterDealing();
        System.out.println("--------------------------------------");
        //gd.getCardFromTop();


        player.pickForPlayerHands();


        //System.out.println("0 ıncı kart"+player.getPlayerHands()[0].getColour()+player.getPlayerHands()[0].getValue()+player.getPlayerHands()[0].getSign());

        //b.addCardToBoard(player.getPlayerHands()[0]);
        //b.addCardToBoard(gd.getCardFromTop());  */
	}
}
