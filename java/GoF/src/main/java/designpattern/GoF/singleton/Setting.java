package designpattern.GoF.singleton;

public class Setting {

    private static Setting instace;

    private Setting(){}

    public static Setting getInstance(){
        if(instace == null){
            instace = new Setting();
        }
        return instace;
    }
}
