class Amplifier {
    void on() { System.out.println("Amplifier ON"); }
}

class Tv {
    void on() { System.out.println("TV ON"); }
}

class StreamingPlayer {
    void play(String movie) {
        System.out.println("Playing " + movie);
    }
}

class HomeTheaterFacade{
    private Amplifier amplifier;
    private Tv tv;
    private StreamingPlayer player;

    public HomeTheaterFacade(Amplifier amp, Tv tv, StreamingPlayer player) {
        this.amplifier = amp;
        this.tv = tv;
        this.player = player;
    }

    public void watchMovie(String movie){
        System.out.println("Get ready...");
        amplifier.on();
        tv.on();
        player.play(movie);
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        Tv tv = new Tv();
        StreamingPlayer player = new StreamingPlayer();

        HomeTheaterFacade facade = new HomeTheaterFacade(amp, tv, player);
        facade.watchMovie("Inception");
    }
}

