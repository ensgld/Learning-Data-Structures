public class Test {
    public int x;
    public static int y;

    public Test(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void yazdir() {
        System.out.println("X:" + x + " Y:" + y);
    }
    public static void yazdir1(){//static method içinden static olmayan bir şeye erişilemez.
        //System.out.println("X:" + x + " Y:" + y);
        System.out.println("Y:" + y);
    }


}
