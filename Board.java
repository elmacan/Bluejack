public class Board {
    private Card[] boardCards =new Card[9];



    public void addCardToBoard(Card card){
        for(int i=0;i<9;i++){
            if(boardCards[i]==null){
                boardCards[i]=card;
            }
        }
        System.out.println(card.getColour()+card.getValue()+card.getSign()+card.getSpecial());
    }



    public void resetBoard(){
        this.boardCards=new Card[9];
    }

    
    }


