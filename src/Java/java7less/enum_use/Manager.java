package Java.java7less.enum_use;

enum Day{
    SUN,MON,TUE,WED,THU,FRI,SAT;
}

public class Manager {

    public static void main(String[] args)
    {
        Day d1 = Day.FRI;
        Day d2 = Day.SAT;

        System.out.println(d1);

        System.out.println(d2);

        MONTH m1 = MONTH.APR;
        MONTH m2 = MONTH.AUG;

        System.out.println(m1);
        System.out.println(m2);

        MONTH all[] = MONTH.values();

        System.out.println(m1.ordinal());
    }

    enum MONTH
    {
        JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC;
    }
}
