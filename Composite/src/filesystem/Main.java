package filesystem;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent{
    // The core operation, which acts uniformly on both files and directories
    void print(String indent);
    // An operation that might only be fully implemented by the Composite,
    // but must be present in the interface for uniformity.
    void add(FileSystemComponent component);
}

class File implements FileSystemComponent{
    private String name;
    public File(String name){
        this.name = name;
    }
    @Override
    public void print(String indent) {
        // Simple operation: just print the file name.
        System.out.println(indent + "📄 File: " + name);
    }

    @Override
    public void add(FileSystemComponent component) {
        System.out.println("Error: Cannot add component to a File.");
    }
}

class Directory implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name){
        this.name = name;
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📁 Directory: " + name);
        String childIndent = indent + "    "; // Increase indentation for children

        // Iterate through all children and call the 'print' method recursively
        for (FileSystemComponent component : children) {
            component.print(childIndent); // Calls print on a File or another Directory
        }
    }
}

public class Main {
    static void main(String[] args) {
        // --- Create Leaves (Files) ---
        FileSystemComponent readme = new File("README.md");
        FileSystemComponent license = new File("LICENSE.txt");
        FileSystemComponent profile = new File("profile.jpg");
        FileSystemComponent index = new File("index.html");

        Directory src = new Directory("src");
        src.add(new File("main.java"));
        src.add(new File("utils.java"));

        Directory images = new Directory("images");
        images.add(profile);
        images.add(new File("logo.png"));

        Directory web = new Directory("web");
        web.add(index);
        web.add(images);

        // --- Create the Root Composite ---
        Directory root = new Directory("MyProject");
        root.add(readme);   // Add a Leaf
        root.add(license);  // Add a Leaf
        root.add(src);      // Add a Composite (src)
        root.add(web);      // Add a Composite (web)

        // The magic: Call 'print' on the root component.
        // It recursively handles printing all files and subdirectories.
        root.print("");
    }
}
