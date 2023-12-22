public class Card {
    private String colour;
    private int value;
    private int sign;
    private int special; //double and flip card

    public Card(String colour,int value){
        setColour(colour);
        setValue(value);
    }

    public Card(String colour,int value,int sign){
        setColour(colour);
        setValue(value);
        setSign(sign);

    }


    public Card(int special){
        this.special=special;
    }

    //yapamadım karıştı sonra uğraş
    /*public void printDeck(Card[] deck){
        for(Card c: deck){
            System.out.println("colour: " + getColour() + "      value: " + getValue() + " sign: " + getSign()+"    special: "+getSpecial());

        }
    } */



    public void setColour(String colour) {

            this.colour = colour;

    }
    public void setValue(int value){
        this.value=value;
    }
    public void setSign(int sign){this.sign=sign;}

    public String getColour(){

        return colour ;

    }
    public int getValue(){return value;}
    public int getSign(){return sign;}



    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }
}



