package Java.java7less.externalisable;

import javax.imageio.IIOException;
import java.io.*;

public class ExternalisationDemo {

    public static void main(String[] args) {

        Employee e1 = new Employee("abc",22,45.09);

        File f1 = new File("emp.ext");

        FileOutputStream fout = null;

        ObjectOutputStream out = null;

        try{
            fout = new FileOutputStream(f1);
            out = new ObjectOutputStream(fout);
            e1.writeExternal(out);
            System.out.println("done");
        }catch(IOException  ex)
        {
            ex.printStackTrace();
        }finally {
            try{
                if(out!=null)
                {
                    out.flush();
                    out.close();
                    out=null;
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }

            try{
                if(fout!=null)
                {

                    fout.close();
                    fout=null;
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

    }
}
