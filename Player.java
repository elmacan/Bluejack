
import java.util.Random;
import java.util.Scanner;
public class Player {
    // fields
    private String name;
    private int setWinCount = 0;
    private Card[] playerCards = new Card[10];
    private Card[] playerHands = new Card[4];


    private Board playerBoard = new Board();
    private Board cpuBoard = new Board();

    private Scanner sc = new Scanner(System.in);

    public void createPlayerCards() {    //random ürettiğimiz 5 kart
        String[] colours = {"B", "Y", "R", "G"};
        Random random = new Random(System.currentTimeMillis());

        //ilk 3kart için
        for (int i = 0; i < 4; i++) {
            int randomValue = random.nextInt(6) + 1;    //rastgele card value'su 1den 6ya
            int randomIndex = random.nextInt(4);       //rastgele index seçiyor colours dizisi için
            String randomColor = colours[randomIndex];           //içindeki rengi atıyor
            int randomSignIndex = random.nextInt(2);      //pozitif ya da negatif olmasını seçiyor
            getPlayerCards()[i] = new Card(randomColor, randomValue, isRandomBooleanPositive(randomSignIndex));   //sonuç olarak rastgele ürettiği özellik değerlerini kart a atıyor
        }

        String intString = "5";
        int intValue = Integer.parseInt(intString);

        //geri kalan 2kart
        int[] percent = {8, 8, 8, 8, 8, 8, 8, 8, 2, 2};
        for (int i = 3; i <= 4; i++) {
            int randomPercentage = random.nextInt(10);
            //System.out.println("%"+percent[p]+"0 chance ");

            if (percent[randomPercentage] == 2) {   //create special card
                System.out.println("you are lucky!");
                getPlayerCards()[3] = new Card(11);  //flip card için rastgele bir değer atadım sonra ayarlancak
                getPlayerCards()[4] = new Card(2);   //double card
            }
            if (percent[randomPercentage] == 8) {   //diğer ürettiği kartlardan tekrar
                int randomValue = random.nextInt(6) + 1;
                int randomIndex = random.nextInt(4);
                String randomColor = colours[randomIndex];
                int randomSignIndex = random.nextInt(2);
                getPlayerCards()[i] = new Card(randomColor, randomValue, isRandomBooleanPositive(randomSignIndex));
            }
        }
    }

    // randomSignIndex deger 0 ise true, degilse false
    private boolean isRandomBooleanPositive(int randomSignIndex) {
        return randomSignIndex == 0;
    }

    public void fromGameDeckForHuman(GameDeck gd) {   //alttan alınan kısım oyuncuya verdiğimiz    gamedeckten gelen 5kart
        for (int i = 5; i < 10; i++) {
            getPlayerCards()[i] = gd.getCards()[i + 30];
        }
    }

    public void fromGameDeckForCpu(GameDeck gd) {    //üstten alınan kısım bilgisayara verdiğimiz  gamedeckten gelen 5kart
        int j = 0;
        for (int i = 5; i < 10; i++) {
            getPlayerCards()[i] = gd.getCards()[j];
            j++;
        }
    }

    public void shufflePlayerDecks() {            //shuffle yaptıktan sonra ilk dördünü almak =rastgele 4ünü seçmek
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int ri = r.nextInt(i + 1); // random 0 to i    nextInt(100) 0,1,....99
            Card temp = getPlayerCards()[i];
            getPlayerCards()[i] = getPlayerCards()[ri];       //swap
            getPlayerCards()[ri] = temp;

        }
    }

    public void pickForPlayerHands() {   //cardlardan rastgele 4ünü eline alıyor
        for (int i = 0; i < 4; i++) {
            getPlayerHands()[i] = getPlayerCards()[i];

            //System.out.println("colour: " + playerHands[i].getColour() + "      value: " + playerHands[i].getValue() + " sign: " + playerHands[i].getSign()+"    special: "+playerHands[i].getSpecial());
        }

    }


    public void printPlayerDeck() {
        for (Card a : getPlayerCards()) {
            System.out.println(a);
//            System.out.println("colour:" + a.getColour() + " value:" + a.getValue() + " sign:" + a.getSign() + "  special:" + a.getSpecial());
        }

    }

    //bir sonraki tur tahtayı yazdırırken bu kartı içini sıfırlamış olarak yazdırıyor düzeltemedim??????????????????????????
    public void removeCardInPlayerHands(int chosen) {   //kartı ın yerine ___ yazdırıyor attığını göstermek için
        //elindeki kartlar için yeni bir dizi üretip kopyalamadım

        getPlayerHands()[chosen].setValue(0);


    }


    public void printHand() {
        for (int i = 0; i < playerHands.length; i++) {
            if (playerHands[i].getSpecial() == 11) {
                System.out.print("(+/-) ");
            } else if (playerHands[i].getSpecial() == 2) {
                System.out.print("(x2) ");
            } else if (playerHands[i].getValue() == 0) {
                System.out.print("__ ");
            } else if (playerHands[i].isPositiveSign()) {
                System.out.print(playerHands[i].getColour() + "(+" + playerHands[i].getValue() + ") ");
            } else {
                System.out.print(playerHands[i].getColour() + "(-" + playerHands[i].getValue() + ") ");
            }
        }
    }


    //düzenlencek olan ana kısım
    //kartların gerçek puanları düzenlencek
    /*public void playerTurn(GameDeck gd) {
        boolean turnActive = true;
        while (turnActive) {
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

            boolean numberIsInvalid = true;
            int chosen = 0;
            do {
                System.out.println("Enter number between 1 and 10: ");
                String number = sc.nextLine();
                try {
                    chosen = Integer.parseInt(number);
                    if (chosen < 1 || chosen > 10) {
                        System.out.println("You have entered a number which is NOT between 1 and 10!: " + number);
                        System.out.println("Please try again: ");
                    } else {
                        numberIsInvalid = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You have entered an invalid number!: " + number);
                    System.out.println("Please try again: ");
                }
            } while(numberIsInvalid);

            switch (chosen) {
                case 0:
                case 1:
                case 2:
                case 3:

                    getPlayerBoard().addCardToBoard(playerHands[chosen]);
                    System.out.print("YOUR BOARD: ");
                    getPlayerBoard().printBoard();
                    System.out.println();
                    removeCardInPlayerHands(chosen);

                    turnActive = false;
                    break;

                case 4:
                    System.out.println("you chose to stand");
                    turnActive = false;
                    break;

                case 5:
                    System.out.println("you drew a card");
                    getPlayerBoard().addCardToBoard(gd.getCardFromTop());
                    if (getPlayerBoard().getTotalValue() > 20) {
                        System.out.println("bust");
                        turnActive = false;
                    }
                    break;

                default:
                    System.out.println("invalid input");
                    break;
            }


        }

    }*/
    //düzenlencek olan ana kısım
   /* public void cpuTurn(GameDeck gd) {
        boolean turnActive = true;
        while (turnActive) {
            System.out.print("COMPUTER HAND: ");
            printHand();
            int chosen = new Random().nextInt(4);
            if (getPlayerHands()[chosen] != null) {
                getCpuBoard().addCardToBoard(getPlayerHands()[chosen]);
                System.out.println("Computer played a card");
                System.out.print("COMPUTER BOARD: ");
                getCpuBoard().printBoard();
                System.out.println();
                removeCardInPlayerHands(chosen);

                if (getCpuBoard().getTotalValue() > 20) {
                    System.out.println("Bust! Computer's total is over 20.");
                    break;
                }
            }
            turnActive = false;
        }
    }*/


    public void playerTurn(GameDeck gd) {
        boolean turnActive = true;
        while (turnActive) {
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

            int chosen = -1;

            do {
                System.out.print("Enter number between 0 and 5: ");
                try {
                    chosen = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            } while (chosen < 0 || chosen > 5);

            switch (chosen) {
                case 0:
                case 1:
                case 2:
                case 3:
                    getPlayerBoard().addCardToBoard(playerHands[chosen]);
                    System.out.print("YOUR BOARD: ");
                    getPlayerBoard().printBoard();
                    System.out.println();
                    removeCardInPlayerHands(chosen);
                    turnActive = false;
                    break;

                case 4:
                    System.out.println("You chose to stand.");
                    turnActive = false;
                    break;

                case 5:
                    System.out.println("You drew a card.");
                    Card drawnCard = gd.getCardFromTop();
                    getPlayerBoard().addCardToBoard(drawnCard);
                    if (getPlayerBoard().getTotalValue() > 20) {
                        System.out.println("Bust! Your total is over 20.");
                        turnActive = false;
                    }
                    break;

                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }
    public void cpuTurn(GameDeck gd) {
        boolean turnActive = true;
        while (turnActive) {
            System.out.print("COMPUTER HAND: ");
            printHand();

            int chosen = new Random().nextInt(4);
            if (getPlayerHands()[chosen] != null) {
                getCpuBoard().addCardToBoard(getPlayerHands()[chosen]);
                System.out.println("Computer played a card.");
                System.out.print("COMPUTER BOARD: ");
                getCpuBoard().printBoard();
                System.out.println();
                removeCardInPlayerHands(chosen);

                if (getCpuBoard().getTotalValue() > 20) {
                    System.out.println("Bust! Computer's total is over 20.");
                    turnActive = false;
                }
            } else {
                turnActive = false; // Exit the loop if CPU cannot play a card
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

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public void setPlayerBoard(Board playerBoard) {
        this.playerBoard = playerBoard;
    }

    public Board getCpuBoard() {
        return cpuBoard;
    }

    public void setCpuBoard(Board cpuBoard) {
        this.cpuBoard = cpuBoard;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSetWinCount() {
        return setWinCount;
    }

    public void setSetWinCount(int setWinCount) {
        this.setWinCount = setWinCount;
    }


}

