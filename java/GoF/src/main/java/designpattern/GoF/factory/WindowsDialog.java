package designpattern.GoF.factory;

import designpattern.GoF.factory.button.Button;
import designpattern.GoF.factory.button.WindowButton;

public class WindowsDialog extends Dialog{

    @Override
    public Button createButton() {
        return new WindowButton();
    }
}
