package designpattern.GoF.abstractfactory.app;

import designpattern.GoF.abstractfactory.button.Button;
import designpattern.GoF.abstractfactory.checkbox.Checkbox;
import designpattern.GoF.abstractfactory.factory.GUIFactory;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint(){
        button.paint();
        checkbox.paint();
    }
}
