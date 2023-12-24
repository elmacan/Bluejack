public class Card {
    private String colour;
    private int value;
    private boolean positiveSign; //eger boolean degeri true ise: positive, degilse negative sign
    private int special; //double and flip card için

    public Card(){
    }

    public Card(String colour,int value,boolean isPositiveSign){    //playerdecktekiler
        setColour(colour);
        setValue(value);
        setPositiveSign(isPositiveSign);
    }


    public Card(int special){   //özel kart için
        this.special = special;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isPositiveSign() {
        return positiveSign;
    }

    public void setPositiveSign(boolean positiveSign) {
        this.positiveSign = positiveSign;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }
