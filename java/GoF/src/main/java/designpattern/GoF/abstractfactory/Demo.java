package designpattern.GoF.abstractfactory;

import designpattern.GoF.abstractfactory.app.Application;
import designpattern.GoF.abstractfactory.factory.GUIFactory;
import designpattern.GoF.abstractfactory.factory.MacOSFactory;
import designpattern.GoF.abstractfactory.factory.WindowsFactory;

public class Demo {

    private static Application configureApplication(){
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("mac")){
            factory = new MacOSFactory();
        }else{
            factory = new WindowsFactory();
        }

        app = new Application(factory);
        return app;
    }

    public static void main(String[] args){
        Application app = configureApplication();
        app.paint();
    }
}
