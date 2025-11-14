package documentFactory;

import document.Document;
import document.Word;

public class WordFactory extends AbstractDocumentFactory{
    @Override
    public Document documentFactory() {
        return new Word();
    }
}
