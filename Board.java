public class Board {
    private Player p;
    private Card[] boardCards=new Card[9];  //tahtanın alabileceği max kart sayısı 9
    private int totalValue=0;


    public void addCardToBoard(Card addedCard){
        int addedCardCounter=0;
        if (addedCardCounter < 9) {
            boardCards[addedCardCounter] = addedCard;
            totalValue+=addedCard.getValue();
            addedCardCounter++;
        } else {
            System.out.println("Board is full. Cannot add more cards.");
        }
    }


    public void printBoard(Player p){
        System.out.print("BOARD: ");
        for(int i=0;i<boardCards.length;i++){
            if(boardCards[i]==null)continue;

            else if(boardCards[i].getSpecial()==11){
                System.out.print("(+/-) ");
            }
            else if(boardCards[i].getSpecial()==2){
                System.out.print("(x2) ");
            }
            else if(boardCards[i].getSign()==-1){
                System.out.print(boardCards[i].getColour()+"(-"+boardCards[i].getValue()+") ");
            }
            else{
                System.out.print(boardCards[i].getColour()+"(+"+boardCards[i].getValue()+") ");
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





