package Java.java7less.serialisation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//transient variables will not be serialised.
//static variables cannot be serialised.

public class SerializationDemo {
    public static void main(String[] args) {
        File f1 = new File("Person.ser");
        FileOutputStream fout = null;
        ObjectOutputStream out = null;

        Person p1=new Person("abc",22,50.09);

        try{
            fout = new FileOutputStream(f1);
            out = new ObjectOutputStream(fout);
            out.writeObject(p1);
            System.out.println("done");
        }catch(IOException ex){
            ex.printStackTrace();
        }finally {
            try{
                if(out!=null)
                {
                    out.flush();
                    out.close();
                    out=null;
                }
            }catch (IOException ex)
            {
                ex.printStackTrace();
            }

            try{
                if(fout!=null)
                {
                    fout.close();
                    fout = null;
                }
            }catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
