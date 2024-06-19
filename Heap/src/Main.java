
public class Main {
    public static void main(String[] args) {
        // İki türlü kodlaması mümkün ilki array kullanarak mümkün ikincisi ise tree kullanarak yapabiliriz
        // Heap denince aklımıza direkt ikili bir yığın gelir ama tabiki üçlü dörtlü de olabilir
        // Min Heap ve Max Heap olarak iki tanedir.
        // Min Heap: Her Parent çocuklarından küçüktür. yani root dediğimiz heap'in en küçük node'u dur.
        // Max Heap: Her parent çocuklarından büyüktür. Yani root dediğimiz heap'in en büyük node'u dur.
        // Heap treelerinde parent i'inci elaman ise sol çocuğu 2i'inci elemanı sağ çocuğu ise 2i+1. elemanda tutulur bu yüzden
        // arraylerde tutmak işimizi daha kolaylaştırır.Elemanın indexini yazarak erişim mümkün olduğu için
        // Şimdi Önemli konularımızdan birine geldik heap yapımızı iki çeşitti bunlar Min Heap ve Max Heap ve bunlardan mesela
        // Min Heap'in parentları çocuklarından daima küçük oluyordu
        // Bizim mesela bir Min Heap'imiz var ve biz buna sonradan bir eleman eklemek istedik ve ekledik bu elemana göre heapimizin yapısı değişmesi gerek
        // Çünkü ekleme prosedürü şöyle gerçekleşiyor: Biz yeni eklenecek elemanı boş olan ilk yere ekliyoruz.Daha sonrada parentlarıyla kontrol etmeye başlıyoruz.
        // Çünkü mesela biz 5 elemanını eklemeye çalışıyoruz ama parent'ı 15 ise bu Min Heap yapısına uymaz bunların yerini değişmemiz gerek değiştikten sonra da
        // tekrar parent'ı ile kontrol ediyoruz eğer parent yüksek ise tekrar değişim yapıyoruz eğer parent küçükse Min Heap yapımız doğru bir şekilde oluşmuş oluyor.
        //O(log N) ile gerçekleşir bu ekleme işlemi
        //Silme işlemini ise root'tan yapılır başta root silinir daha sonra da child'larından küçük olan root'a geçer roota geçenin altındaki child'ları da sıralama yaparız Min Heap'i o şekilde oluştururuz.
        // Silme işlemi de O(logN)
        //Yığın sıralaması da O(logN)
        //Bütün elemanları silmeye çalışıyorsak bunun maliyeti N(logN) olur



    }
}