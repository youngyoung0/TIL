package designpattern.GoF.abstractfactory.factory;

import designpattern.GoF.abstractfactory.button.Button;
import designpattern.GoF.abstractfactory.button.MacOsButton;
import designpattern.GoF.abstractfactory.button.WindowsButton;
import designpattern.GoF.abstractfactory.checkbox.Checkbox;
import designpattern.GoF.abstractfactory.checkbox.MacOSCheckbox;

public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
