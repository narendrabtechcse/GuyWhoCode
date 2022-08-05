package javamultithreadingandconcurrencysimplifiedudemythreading;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class IOUtils2 {

    public static void copy(InputStream src, OutputStream dest) throws IOException {
        int value;
        while ((value = src.read()) != -1) {
            dest.write(value);
        }
    }

    public static void copyFile(String srcFile, String destFile) throws IOException {
        FileInputStream fin = new FileInputStream(srcFile);
        FileOutputStream fout = new FileOutputStream(destFile);

        IOUtils2.copy(fin, fout);

        fin.close();
        fout.close();
    }
}


class CopyTask2 implements Runnable {

    String sourceFile;
    String destFile;

    public CopyTask2(String sourceFile, String destFile) {
        this.sourceFile = sourceFile;
        this.destFile = destFile;
    }

    public void run() {
        try {
            IOUtils2.copyFile(sourceFile, destFile);
            System.out.println("Copied from - " + sourceFile + " to " + destFile);
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
}

public class Example5 {

    public static void main(String[] args) throws IOException {

        String sourceFile1 = "a.txt";
        String sourceFile2 = "b.txt";

        String destFile1 = "c.txt";
        String destFile2 = "d.txt";

        // 100 files -> 10 threads

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new CopyTask2(sourceFile1, destFile1));
        executor.execute(new CopyTask2(sourceFile2, destFile2));

    }

}



