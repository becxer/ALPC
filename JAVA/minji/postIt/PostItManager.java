import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PostItManager {
	ArrayList<File> txtFile = new ArrayList<File>();
	private String default_path = "postfiles";
		//�����Ͽ� ���ؼ� ������ GUI �� ���� �ѷ��ش�.
			//1. ������ �о���δ�.
			//2. ������ ���ϵ��� (�����б�) GUI�� �����.
	public void loadFile() throws IOException{		//���Ͽ� ���� �ҷ�����
		String file_path = "C:/Users/HMJ/Documents/postIt/";
		
		File f = new File(file_path);
		if(!f.exists()){
			System.out.println("������ �����ϴ�");
			return ;
		}
		File[] allFiles = f.listFiles();
		for(File file : allFiles){
			if(file.getName().endsWith(".txt")){
				txtFile.add(file);
			}
		}
		for(File file : txtFile){
			file_path = "C:/Users/HMJ/Documents/postIt/";	//�ʱ�ȭ
			System.out.println("���� �̸� : "+file.getName());
			file_path += file.getName();
			File inFile = new File(file_path);
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			String line = null;
				
			while((line = br.readLine())!= null){
				System.out.println(line);
			}
			br.close();
			}	
	}
	
	public void storePostit(String title, String content) throws IOException{
		///
		//���Ͽ�����
		String makeFile = "C:/Users/HMJ/Documents/postIt/";
		makeFile += title+".txt";
		File file = new File(makeFile);
		FileWriter  fw = new FileWriter(file, true);
		fw.write(content);
		fw.flush();
		fw.close();
	}
	public void deletePostit(String title){
			File file = new File("C:/Users/HMJ/Documents/postIt/"+title+".txt");
			if(file.exists()){
				file.delete();
			}
			else{
				System.out.println("������ �����ϴ�.");
			}
			
	}
}
