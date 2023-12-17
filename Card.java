public class Card {
    private String colour;
    private int value;
    //private int sign;

    public Card(String colour,int value){
        setColour(colour);
        setValue(value);
    }


    public void setColour(String colour){
        this.colour=colour;
    }
    public void setValue(int value){
        this.value=value;
    }

    public String getColour(){
        return colour;
    }
    public int getValue(){
        return value;
    }


}



