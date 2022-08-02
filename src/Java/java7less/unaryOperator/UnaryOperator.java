package Java.java7less.unaryOperator;

public class UnaryOperator {

    public static void main(String[] args)
    {
        int i=0;
        int j = i--;//in this statement operation will not take place.
        System.out.println("i : "+i);
        System.out.println("j : "+j);


        int l = 0;
        int m = --l;
        System.out.println("l : "+l);
        System.out.println("m : "+m);

        int p = 0;
        int q =  p++ + p++ + p;

        System.out.println("p : " +p);
        System.out.println("q : "+q);

        int r = 0;
        int s = --r + r-- + r;

        System.out.println("r : "+r);
        System.out.println("s : "+s);

    }
}
