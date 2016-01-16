import java.io.BufferedReader;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class file_read {
    public static void main(String[] args) {
    	
    	file_store c1 = new file_store();
    	c1.f_store("hi hello");
        // ���� ����
        BufferedReader br = null;        
         
        // Input ��Ʈ�� ����
        InputStreamReader isr = null;    
         
        // File Input ��Ʈ�� ����
        FileInputStream fis = null;        
 
        // File ���
        File file = new File("./hi.txt");
 
        // ���۷� �о���� �ӽ� ����
        String temp = "";
         
        // ���� ���� ����� ���� ����
        String content = "";
         
        try {
             
            // ������ �о�鿩 File Input ��Ʈ�� ��ü ����
            fis = new FileInputStream(file);
             
            // File Input ��Ʈ�� ��ü�� �̿��� Input ��Ʈ�� ��ü�� �����ϴµ� ���ڵ��� UTF-8�� ����
            isr = new InputStreamReader(fis, "UTF-8");
             
            // Input ��Ʈ�� ��ü�� �̿��Ͽ� ���۸� ����
            br = new BufferedReader(isr);
         
            // ���۸� �������� �о�鿩 ���� ����
            while( (temp = br.readLine()) != null) {
                content += temp + "\n";
            }
             
            System.out.println("================== ���� ���� ��� ==================");
            System.out.println(content);
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
             
        } catch (Exception e) {
            e.printStackTrace();
             
        } finally {
 
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
        }
         
    }
}