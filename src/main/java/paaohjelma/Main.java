package paaohjelma;
import ohtu.ohtuvarasto.*;

public class Main {

    public static void main(String[] args) {

        Varasto mehua = new Varasto(100.0);
        
        mehua.lisaaVarastoon(50.7);
        
        mehua.otaVarastosta(3.14);
        
    }
}
