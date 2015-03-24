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
		//각파일에 대해서 내용은 GUI 로 만들어서 뿌려준다.
			//1. 파일을 읽어들인다.
			//2. 각각의 파일들을 (내용읽기) GUI로 만든다.
	public void loadFile() throws IOException{		//파일에 내용 불러오기
		String file_path = "C:/Users/HMJ/Documents/postIt/";
		
		File f = new File(file_path);
		if(!f.exists()){
			System.out.println("파일이 없습니다");
			return ;
		}
		File[] allFiles = f.listFiles();
		for(File file : allFiles){
			if(file.getName().endsWith(".txt")){
				txtFile.add(file);
			}
		}
		for(File file : txtFile){
			file_path = "C:/Users/HMJ/Documents/postIt/";	//초기화
			System.out.println("파일 이름 : "+file.getName());
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
		//파일에쓴다
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
				System.out.println("파일이 없습니다.");
			}
			
	}
}
