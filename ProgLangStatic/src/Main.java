
public class Main {
    public static void main(String[] args) {
        Test t1= new Test(5,10); //şimdi burada t1 objesi oluşturuyoruz ve constructor gereği x ve y'ye değer atıyoruz
        //şimdi bu şekilde t1.yazdir yaparsak x:5 y:10 olur bizim x variable'ımız objeye ait y variable'ımız classa ait bunu unutmamaız gerek.
        t1.yazdir();//X:5 Y:10
        Test t2= new Test(9,21); /*şimdi de burada t2 diye bir obje yarattık ve x ve y variable2larına değer ataması yaptık t2 objesinin x değeri 9 oldu.
        Burada t2 objesinin x değeri dedim özellikle çünkü x değişkeni non-static olduğu için objeye aittir. Y değişkeni classa ait olduğu için y değişkeninin değeri de 21 oluyor.
        Şu anda biz t1.yazdir() desek de Y:21 olur çünkü classa ait ve onu değiştirdik.
         */
        t1.yazdir();//X:5 Y:21
        t2.yazdir();//X:9 Y:21
        t1.x=11; //Burada non-static olan x değişkeninin değerini 11 olarak atama yaptık. Yine tekrar edelim x değişkeni objeye aittir.
        t1.y=66; //burada static olan y değişkeninin değerini 66 olarak atama yaptık Yine hatırlıyoruz Y değişkeni classa aittir ve şu anda mesela t2'nin üstünden Y değişkenini de çağırsak 66 yazılır çünkü classtan alıyoruz bilgiyi.
        t1.yazdir(); //X:11 Y:21
        t2.yazdir();//X:9 Y:66
        Test.yazdir1(); //Y:66
        Test.y=99;
        Test.yazdir1();//99
        t1.yazdir();//X:11 Y:99
        t2.yazdir();//X:9 Y:99


    }
}