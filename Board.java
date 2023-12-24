public class Board {
    private Player p;
    private Card[] boardCards = new Card[9];  //tahtanın alabileceği max kart sayısı 9
    private int totalValue = 0;
    int addedCardCounter = 0;


    public void addCardToBoard(Card addedCard) {
        //gerçek puanlar yazılcak if koşullarıyla sign olmasına falan bağlı olarak
        //if card.special==11  bir önceki kartın değerini tersiyle çarpcak
        //if card.specail ==2 bir önceki kartın değerini 2yle çarpcak
        if (addedCardCounter < 9) {
            boardCards[addedCardCounter] = addedCard;
            //şimdilik özel kartlarsız olan puan kısmı
            if(addedCard.isPositiveSign()) {
                totalValue += (addedCard.getValue());
            } else {
                totalValue -= addedCard.getValue();
            }

            addedCardCounter++;
        } else {
            System.out.println("Board is full. Cannot add more cards.");
        }
    }



    public void printBoard() {
        for(int i=0;i<boardCards.length;i++) {
            if(boardCards[i] == null)continue;

            else if(boardCards[i].getSpecial() == 11){
                System.out.print("(+/-) ");
            }
            else if(boardCards[i].getSpecial() ==2) {
                System.out.print("(x2) ");
            }
            else if(boardCards[i].isPositiveSign()){
                System.out.print(boardCards[i].getColour()+"(+"+boardCards[i].getValue()+") ");
            } else{
                System.out.print(boardCards[i].getColour()+"(-"+boardCards[i].getValue()+") ");
            }
        }


    }

    public void resetBoard(){

        this.setBoardCards(new Card[9]);
    }


    public Card[] getBoardCards() {
        return boardCards;
    }

    public void setBoardCards(Card[] boardCards) {
        this.boardCards = boardCards;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }
}





