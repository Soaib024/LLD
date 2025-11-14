//package ui;

interface Button{
    void paint();
    void onClick();
}

interface Checkbox{
    void paint();
    void onSelect();
}

class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Painting a Windows-style button.");
    }

    @Override
    public void onClick() {
        System.out.println("Windows button clicked.");
    }
}

class WindowsCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("Painting a Windows-style checkbox.");
    }

    @Override
    public void onSelect() {
        System.out.println("Windows checkbox selected.");
    }
}

class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a macOS-style button.");
    }

    @Override
    public void onClick() {
        System.out.println("MacOS button clicked.");
    }
}

class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Painting a macOS-style checkbox.");
    }

    @Override
    public void onSelect() {
        System.out.println("MacOS checkbox selected.");
    }
}

interface GUIFactory{
    Button createButton();
    Checkbox createCheckBox();
}

class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckBox() {
        return new WindowsCheckbox();
    }
}

class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckBox() {
        return new MacOSCheckbox();
    }
}

class Application{
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckBox();
    }

    public void renderUI(){
        button.paint();
        checkbox.paint();
    }
}

void main(){
    String os = System.getProperty("os.name");
    GUIFactory factory;

    if(os.contains("Windows")){
        factory = new WindowsFactory();
    }else{
        factory = new MacOSFactory();
    }

    Application app = new Application(factory);
    app.renderUI();
}
