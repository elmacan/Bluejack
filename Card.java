import java.util.Random;

public class Card {
    private String colour;
    private int value;
    private int sign;

    public Card(String colour,int value){
        setColour(colour);
        setValue(value);
    }

    public Card(String colour,int value,int sign){
        setColour(colour);
        setValue(value);
        setSign(sign);

    }


    public void setColour(String colour){
        this.colour=colour;
    }
    public void setValue(int value){
        this.value=value;
    }
    public void setSign(int sign){this.sign=sign;}

    public String getColour(){
        return colour;
    }
    public int getValue(){return value;}
    public int getSign(){return sign;}



}

