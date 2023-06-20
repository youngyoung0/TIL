package designpattern.GoF.abstractfactory.button;

public class WindowsButton implements Button{

    @Override
    public void paint() {
        System.out.println("You have created WindowsButton");
    }
}
