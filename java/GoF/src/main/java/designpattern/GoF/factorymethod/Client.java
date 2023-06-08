package designpattern.GoF.factorymethod;

public class Client {
    public static void main(String[] args){
        Client client = new Client();

        Ship whiteShip = ShipFactory.orderShip("Whiteship", "kxodud10054@gmail.com");
        System.out.println(whiteShip);

        Ship blackShip = ShipFactory.orderShip("Blackship", "taeyoung@gmail.com");
        System.out.println(blackShip);
    }
}
