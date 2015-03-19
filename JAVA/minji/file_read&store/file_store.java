import java.io.*;

public class file_store {
  public static void f_store(String args) {

    try {
      BufferedWriter out = new BufferedWriter(new FileWriter("hi.txt"));
    
      out.write(args); out.newLine();
      out.write(args); out.newLine();

      out.close();
    } catch (IOException e) {
        System.err.println(e);
        System.exit(1);
    }

  }
}