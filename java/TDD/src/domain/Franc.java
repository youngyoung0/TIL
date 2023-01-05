package domain;

public class Franc {
    int amount;
    public Franc(int amount){
        this.amount = amount;
    }
    Franc times(int multiplier){
        return new Franc(amount * multiplier);
    }

    public boolean equals(Object object){
        Franc dollar = (Franc) object;
        return amount == dollar.amount;
    }


}
