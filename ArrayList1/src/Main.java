import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        /*
        Bu şekilde bir arrayList tanımladığımızda aslında memory de bir arrayList için yer tutuyor
        bu arrayListin eleman sayısını falan vermediğimiz için default olarak 10 elemanlı bir memoryde
        yer açıyor ve atıyorum 10 elemanı geçtiğimizde de açtığı yer 20 ye çıkıyor bu yüzden
        Arrayler O(1) iken ArrayListler worst case de O(N) ile gösterilir.Average case de yani yeni bir array
        oluşturmadığımız senaryoda da O(1)dir.
        ArrayListte bir eleman sadece kendi adresini tutar önceki ve sonraki node ile ilgilenmez.

         */
        a.add(5);
        a.add(3);
        a.add(15);
        System.out.println(a);

        LinkedList<String> b = new LinkedList<>();
        b.add("Enes");
        /*
        LinkedList'in bir elemanı içerisinde [prev,element,next] şeklinde kendinden önceki node'u kendisini ve
        sonraki node'un adresini bir link ile tutar.
        [prev,element,next]------> <------[prev,element,next]------><-------[prev,element,next] şeklindeki gibi
        Bunun böyle olmasının sebebi ise bir linked ile bağlı olması elemanların mesela ArrayListte direkt
        bir ArrayList için yer tutuldu ve yanyana elemanları dizildi ama LinkedList için öyle değil.
        Linked'ler sayesinde memoryde farklı yerlerde olan elemanları kolaylıkla bağlayabiliyoruz.

        LinkedListleri yukarıda anlattığımız gibi node bazlı memoryde tutuyoruz yani ekstra memory de yer ayırmıyoruz.
        LinkedListlerde head ve tail vardır.
        Head ilk node tail ise son node anlamına gelir.
        Bütün nodelara bu Head nodeundan erişiriz.
        3.node'a gideceksek mesela 3 kere .next işlemi yapmamız gerekir
        5.node'a gideceksek 5 kere .next işlemi yapmamız gerekir bu da LinkedListi yavaş kılar.
        Eleman bulma işlemi O(N) notation ile ifade edilir o yüzden
        Eleman ekleme ise O(1) ile ifade edilir.

        Eleman silme de de aslında elemanı değil biz linklerle ilgileniyoruz previous linkini ve next linkini değişiyoruz elemanların

        */


    }
}