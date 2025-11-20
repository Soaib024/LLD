package LazyLoading;

interface Image{
    void display();
}

class HighResolutionImage implements Image{
    private final String filename;
    public HighResolutionImage(String filename){
        this.filename = filename;
        loadFromDisk(filename);
    }
    @Override
    public void display() {
        System.out.println("Displaying: " + filename);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void loadFromDisk(String filename){
        System.out.println(">>> Loading " + filename + " from storage... (This is expensive!)");
    }
}

class VirtualImageProxy implements Image{
    private final String filename;
    private volatile HighResolutionImage realImage;
    private final Object initLock = new Object();

    public VirtualImageProxy(String filename){
        this.filename = filename;
    }

    @Override
    public void display() {
        if(realImage == null){
            synchronized (initLock){
                if (realImage == null){
                    System.out.println("Proxy detected display request. Creating RealSubject...");
                    realImage = new HighResolutionImage(filename);
                }
            }
        }
        realImage.display();
    }
}
public class Main {
    public static void main(String[] args) {
        // Create the proxy objects. Notice the file loading is NOT triggered yet.
        Image image1 = new VirtualImageProxy("photo_a.jpg");
        Image image2 = new VirtualImageProxy("photo_b.jpg");

        System.out.println("\n--- Document loaded. The expensive images have not loaded yet. ---");

        // The user scrolls to the first image. Loading happens NOW.
        System.out.println("\nClient calls display on image 1:");
        image1.display();

        System.out.println("\n--- The client scrolls away. Image 2 is still not loaded. ---");

        // The user scrolls to the second image. Loading happens NOW.
        System.out.println("\nClient calls display on image 2:");
        image2.display();
    }
}
