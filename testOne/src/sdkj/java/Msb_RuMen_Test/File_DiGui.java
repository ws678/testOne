package sdkj.java.Msb_RuMen_Test;

import java.io.File;

public class File_DiGui {

    static File f = new File("D:/Program Files");
    static String cengji = "·->";
    public static void main(String[] args) {

        tree(f,cengji);
    }

    static void tree(File f,String cengji){

        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println(cengji + file.getName());
            if (file.isDirectory()) {
                String concat = cengji.concat(" ");
                tree(file,concat);
            }
        }
    }
}
