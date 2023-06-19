package designpattern.GoF.factory;

import designpattern.GoF.factory.button.Button;
import designpattern.GoF.factory.button.HtmlButton;

public class HtmlDialog extends Dialog{

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
