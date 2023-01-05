package domain;

public class Dollar extends Money{
    static Dollar dollar(int amount){
        return new Dollar(amount);
    }
    public Dollar(int amount){
        this.amount = amount;
    }

    Dollar times(int multiplier){
        return new Dollar(amount * multiplier);
    }
}
