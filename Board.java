public class Board {
    private Player p;
    private Card[] boardCards=new Card[9];


    public Board(Player p){   //player a göre board oluşturma
        this.p=p;
        //this.boardCards=boardCards;

    }




    public void addCardToBoard(Card addedCard){
        /*for(int i=0;i<9;i++){
            if(getBoardCards()[i]==null){
                getBoardCards()[i]=addedCard;
            }
        }*/
        int addedCardCounter=0;
        getBoardCards()[addedCardCounter]=addedCard;
        addedCardCounter++;
        }
        //System.out.println(card.getColour()+card.getValue()+card.getSign()+card.getSpecial());


    public void printBoard(){
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
}
