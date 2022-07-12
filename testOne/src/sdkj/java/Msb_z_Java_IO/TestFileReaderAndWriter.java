package sdkj.java.Msb_z_Java_IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileReaderAndWriter {

    public static void main(String[] args) {

        try {
            FileWriter fileWriter = new FileWriter("d:\\java_writer\\a.txt");
            for (int i = 0; i < 200; i++) {
                fileWriter.write("写入"+i);
            }
            fileWriter.close();
            Integer fr;
            FileReader fileReader = new FileReader("d:\\java_writer\\a.txt");
            while ((fr = fileReader.read()) != -1){
                System.out.println(fr.toString());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取/写入错误");
        }
    }
}
