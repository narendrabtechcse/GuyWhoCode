package Java.java7less.objectClass;

public class C {

    int i;

    public boolean equals(Object obj)
    {
        if(! (obj instanceof C))
        {
            return  false;
        }

        return this.i == ((C) obj).i;
    }

    public String toString()
    {
        return "i : "+i;
    }

    public int hashCode()
    {
        return Integer.toString(i).hashCode();
    }
}
