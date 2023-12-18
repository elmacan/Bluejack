import java.util.Random;

public class Card {
    private String colour;
    private int value;
    private int sign;
    private int sign1;
    private int sign2;
    private int doublecard;

    public Card(String colour,int value){
        setColour(colour);
        setValue(value);
    }

    public Card(String colour,int value,int sign){
        setColour(colour);
        setValue(value);
        setSign(sign);

    }

    public Card(int sign1,int sign2){     //flip card
        this.sign1=sign1; //1
        this.sign2=sign2; //-1
    }

    public Card(int doublecard){
        this.doublecard=doublecard;
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



