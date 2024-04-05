import java.util.ArrayList;
import java.util.List;

public class Ogrenci {
    public int no;
    public String adsoyad;
    public String kullaniciad;
    public String sifre;
    public List<Ders> gecmisDersler;
    public List<String> gecmisDerslerNot;
    public List<String> ilgialani;
    public float agno;
    
    public Ogrenci() {
        gecmisDersler = new ArrayList<>();
        gecmisDerslerNot = new ArrayList<>();
        ilgialani = new ArrayList<>();
    }
}
