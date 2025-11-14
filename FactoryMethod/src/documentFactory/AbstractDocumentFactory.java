package documentFactory;

import document.Document;

public abstract class AbstractDocumentFactory {
    public abstract Document documentFactory();
    public Document getDocument(){
        return documentFactory();
    }
}
