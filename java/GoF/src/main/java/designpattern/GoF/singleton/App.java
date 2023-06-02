package designpattern.GoF.singleton;

public class App {
    public static void main(String[] args){
        Setting setting = Setting.getInstance();
        System.out.println(setting == Setting.getInstance());
    }
}
