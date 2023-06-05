package designpattern.GoF.singleton;

import java.io.Serializable;

public class Settings implements Serializable {

    private static Settings instace;

    private Settings(){}

    public static synchronized Settings getInstance(){
        if(instace == null){
            instace = new Settings();
        }
        return instace;
    }

    // 역질렬화 대응 방법
    protected Object readResolve(){
        return getInstance();
    }
}
