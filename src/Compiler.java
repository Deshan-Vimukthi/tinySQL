import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Compiler {

    public static void main(String[] args) {
        if(args.length < 2) {
            throw new IllegalArgumentException("Usage: tinySQL Compiler <input file> <output file>");
        }

        File file = new File(args[0]);
        if(!file.exists()) {
            throw new IllegalArgumentException("Input file does not exist");
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            String[] lines = new String(fileInputStream.readAllBytes()).split(";");
            fileInputStream.close();

            for(String line : lines) {
                if(line.trim().length() > 0) {
                    System.out.println(line);
                }
            }


        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}
