package designpattern.GoF.factory;

import designpattern.GoF.factory.button.Button;

public abstract class Dialog {
    public void renderWindow(){
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
