package documentFactory;

import document.Document;
import document.Powerpoint;

public class PowerPointFactory extends AbstractDocumentFactory{
    public Document documentFactory(){
        return new Powerpoint();
    }
}
