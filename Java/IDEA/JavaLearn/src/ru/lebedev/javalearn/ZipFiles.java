package ru.lebedev.javalearn;

import java.util.zip.*;
import java.io.*;

public class ZipFiles {
    public static void main(String[] args) throws Exception {

        final int BUFFER = 2048;

        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream("d:\\Projects\\Java\\Test\\output.zip");
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte data[] = new byte[BUFFER];


            File inputDir = new File("d:\\Projects\\Java\\Test\\Input");
            File files[] = inputDir.listFiles();

            for(File item : files){
                String filename = item.getName();
                System.out.println("Adding: " + filename);

                FileInputStream fi = new FileInputStream(item);
                origin = new BufferedInputStream(fi,BUFFER);
                ZipEntry entry = new ZipEntry(filename);
                out.putNextEntry(entry);
                int count;
                while((count=origin.read(data, 0, BUFFER))!=-1){
                    out.write(data,0, count);
                }
                origin.close();
            }
            out.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
