import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> freq = new HashMap<>();
        Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+"); /*
        Bu scanner doc objesi kullanıcından bir string inputu alıp .useDelimeter() fonksiyonu ile onu parçalama özelliğine sahip oluyor
        ve burada da harflere göre parçaladık yani bunun tuttuğu değer şu anda girilecek olan stringin harflerinin ayrılmış bir hali*/
        while (doc.hasNext()) {
            String word = doc.next().toLowerCase(); // burada biz doc nesnesinden cümleyi almış olduk next() methodu ile
            Integer count = freq.get(word);/* burada ise biz her bir harfin veya harf dizisinin Mapimizde kaç tane olduğunu alıyoruz.
            Bu da şöyle oluyor freq mapimize gidiyor key olan wordü veriyoruz zaten value olarak biz wordün sayısını tutuyoruz.*/
            if (count == null) {
                count = 0;
            }
            freq.put(word, count + 1);// burada da o word'ün valuesini bir arttırıyoruz.
        }
        int maxCount = 0;
        String maxWord = "";
        for (Map.Entry<String, Integer> entry : freq.entrySet()) { /*burada da freq mapimizin üstünde dolaşmak için bir entry tanımladık tabiki geçici olarak ve bu sayede
          mapimizin value ve keyine rahatça ulaşıp kontroller yaptık

        */
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
            System.out.print("The most frequent word is '" + maxWord);
            System.out.println("' with " + maxCount + " occurrences.");
        }
    }
}