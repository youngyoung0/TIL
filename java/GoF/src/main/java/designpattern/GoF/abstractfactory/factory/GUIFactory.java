package designpattern.GoF.abstractfactory.factory;

import designpattern.GoF.abstractfactory.button.Button;
import designpattern.GoF.abstractfactory.checkbox.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
