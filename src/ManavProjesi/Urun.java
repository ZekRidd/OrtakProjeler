package ManavProjesi;

public class Urun {


    static Urun armut = new Urun("Armut", 2.5, 10);
    static Urun kivi = new Urun("Kivi", 1.5, 20);
    static Urun elma = new Urun("Elma", 2.5, 10);
    static Urun erik = new Urun("Erik", 1.5, 20);
    static Urun muz = new Urun("Muz", 3.5, 10);

    String ad;
    double fiyat;
    int stokAdedi;

    public Urun(String ad, double fiyat, int stokAdedi){
        this.ad=ad;
        this.fiyat=fiyat;
        this.stokAdedi=stokAdedi;

    }

    public String getAd() {
        return ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public int getStokAdedi() {
        return stokAdedi;
    }

    public void setStokAdedi(int stokAdedi) {
        this.stokAdedi = stokAdedi;
    }

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.urunEkle(elma,2);
        basket.urunEkle(kivi,4);
        basket.urunEkle(armut,5);
        basket.toplamFiyat();

        Basket basket1 = new Basket();
        basket1.eklenebilirUrunleriGoster();


    }



}
