class stackwithArray {
    int array[] = new int[2];
    int size = 2;
    int top = 0;//top değişkeni en üstteki elemanı tutar."0" diye initilaize etmemizin sebebi stack boş olduğu için
    //0.elemanı tutuyor gibi düşünebiliriz.


    int pop() {
        if (top <= size / 4) { /*Bu kısımda da pop ettikçe ram'de boş yere array çok yer kaplamasın daha dinamik olsun
        diye array'i küçültüyoruz*/
            int[] array2 = new int[size / 4];
            for (int i = 0; i <= top; i++) {
                array2[i] = array[i];

            }
            array = array2;
            size /= 2;

        }

        return array[--top];


    }

    void push(int a) {
        if (top >= size) { /*Burada da arraylerin boyutları değişemez olduğu için ve stack dolduğunda tekrar ekleme
            yapabilmek için Eğer top yani sonunncu eklenen listenin en başında eleman ile size eşit olursa yeni dizi
            oluşturup size'ını iki katına çıkarıp eski diziyi yeni diziye kopyalıyoruz daha sonra ekleme yapıyoruz.
            */
            int array2[] = new int[size * 2];
            for (int i = 0; i < size; i++) {
                array2[i] = array[i];
            }
            array = array2;
            size *= 2;
        }
        array[top++] = a; /*Push fonksiyonu stack'a yeni eleman ekler u yüzden kullanıcıdan parametre
        olarak bir değer almamız gerek.Ve yukarıdaki işlemdeki gibi dizimizein en üstündeki depğeri top
        tuttuğu için onun bir üstüne bu aldığımız parametreyi tutarız.
        */


    }

    void bastir() {
        System.out.println("Size:"+size);
        for (int i = 0; i < top; i++) {
            System.out.println(array[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        stackwithArray stack = new stackwithArray();
        stack.push(10);
        stack.bastir();
        stack.push(15);
        System.out.println();
        stack.bastir();
        System.out.println("Popped:" + stack.pop());
        System.out.println("Popped:" + stack.pop());
        System.out.println();
        stack.push(35);
        stack.push(40);
        stack.push(45);
        stack.push(35);
        stack.push(40);
        stack.push(45);
        stack.bastir();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        
        stack.bastir();



    }
}