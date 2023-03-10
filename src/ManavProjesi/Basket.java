package ManavProjesi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    public Map<Urun, Integer> urunler = new HashMap<Urun, Integer>();
    /*
    urunler isminde boş bir hashMap oluşturduk.
    Sepete ekleyeceğimiz ürünleri tek tek buraya ekleyeceğiz
     */

    public void urunEkle(Urun urun, int miktar){ // Urun ekle metotu ile sepete ekleyeceğimiz ürünleri alıyoruz
        if(urunler.containsKey(urun)){ // Urunun sepette daha önce olup olmadığını kontrol ediyoruz, boolean sonuç dönecektir
            int eskiMiktar = urunler.get(urun);
            urunler.put(urun, eskiMiktar + miktar); // Urun sepette varsa miktarını artırıyoruz
        } else {
            urunler.put(urun, miktar); // Urun sepette yoksa doğrudan ekleme yapıyoruz
        }
    }

    public void urunCikar(Urun urun, int miktar){ // Burada da yukarıdaki işlemin tersini gerçekleştiriyoruz
        if(urunler.containsKey(urun)){ // Urunun sepette olup olmadığına bakıyoruz
            int eskiMiktar = urunler.get(urun); // Urun sepetteki miktarı, silmek istediğimiz miktardan küçük veya eşitse ürünü tamamen siliyoruz
            if(eskiMiktar<=miktar){
                urunler.remove(urun);
            } else {
                urunler.put(urun, eskiMiktar-miktar); //Cıkarmak istediğimiz miktar sepettekinden az ise, miktarı azaltıyoruz
            }
        }
    }

    public Map<Urun, Integer> getUrunler(){
        return urunler;
    }

    public double toplamFiyat() {
        double toplam = 0;
        for(Map.Entry<Urun, Integer> entry : urunler.entrySet()) {
            Urun urun = entry.getKey();
            int miktar = entry.getValue();
            toplam += urun.getFiyat()*miktar;
        }
        System.out.println("Toplam fiyat : " + toplam);
        return toplam;
    }

    public List<Urun> getEklenebilirUrunler() { // Ürünlerin olduğu listeyi çağıran metot oluşturduk
        List<Urun> eklenebilirUrunler = new ArrayList<>();
        eklenebilirUrunler.add(new Urun("Elma", 2.50,100));
        eklenebilirUrunler.add(new Urun("Armut", 3.00,100));
        eklenebilirUrunler.add(new Urun("Muz", 4.00,100));
        eklenebilirUrunler.add(new Urun("Kivi", 2.00,100));
        eklenebilirUrunler.add(new Urun("Erik", 1.00,100));
        return eklenebilirUrunler;
    }

    public void eklenebilirUrunleriGoster() { //Ürünleri kullanıcıya göstermek için metot oluşturduk
        List<Urun> eklenebilirUrunler = getEklenebilirUrunler();
        System.out.println("Sepete eklenebilecek ürünler:");
        for (Urun urun : eklenebilirUrunler) {
            System.out.println(urun.getAd() + " - " + urun.getFiyat());
        }
    }

}

