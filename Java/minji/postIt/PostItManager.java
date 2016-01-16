import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PostItManager {
	private String file_path = "C:/Users/HMJ/Documents/postIt/";
	ArrayList<File> txtFile = new ArrayList<File>();
		//각파일에 대해서 내용은 GUI 로 만들어서 뿌려준다.
			//1. 파일을 읽어들인다.
			//2. 각각의 파일들을 (내용읽기) GUI로 만든다.
	public void loadFile() throws IOException{		//파일에 내용 불러오기
		txtFile.removeAll(txtFile);
		String file_loadpath;
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
		JFrame subfrm = new JFrame("Text info"); 
		subfrm.setBounds(120,120,400,400);
		subfrm.setLayout(new BorderLayout());
		JPanel postItPanel = new JPanel();	//포스트잍 보이는 판넬
		postItPanel.setLayout(new GridLayout());
		TextArea loadText = new TextArea();
		for(File file : txtFile){
			file_loadpath = file_path;	//초기화
			System.out.println("파일 이름 : "+file.getName());
			file_loadpath += file.getName();
			File inFile = new File(file_loadpath);
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			String line = null;	
			while((line = br.readLine())!= null){
				loadText.append(line+"\n");
				System.out.println(line);
			}
			br.close();
		}
		//loadText.append(str+"\n");
		postItPanel.add(loadText);
		subfrm.add(postItPanel,BorderLayout.CENTER);
		subfrm.setVisible(true);
	}
	
	public void storePostit(String title, String content) throws IOException{		//파일에쓴다
		/*		파일 이름 안겹치게 생성하려고 만들었다가 지운 부분
		for(File file : txtFile){
			if(file.getName() == title){
				System.out.println("파일 이름이 겹칩니다.");
				while(file.getName() == title){
					title+="num";
					num++;
				}
				break;
			}
		}
		*/
		String makeFile = file_path;
		makeFile += title+".txt";
		File file = new File(makeFile);
		FileWriter  fw = new FileWriter(file, true);
		fw.write(content);
		fw.flush();
		fw.close();
	}
	public void deletePostit(String title){					//삭제하기
			File file = new File(file_path+title+".txt");
			if(file.exists()){
				file.delete();
			}
			else{
				System.out.println("파일이 없습니다.");
			}
	}
}
