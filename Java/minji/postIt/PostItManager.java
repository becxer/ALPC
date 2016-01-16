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
		//�����Ͽ� ���ؼ� ������ GUI �� ���� �ѷ��ش�.
			//1. ������ �о���δ�.
			//2. ������ ���ϵ��� (�����б�) GUI�� �����.
	public void loadFile() throws IOException{		//���Ͽ� ���� �ҷ�����
		txtFile.removeAll(txtFile);
		String file_loadpath;
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
		JFrame subfrm = new JFrame("Text info"); 
		subfrm.setBounds(120,120,400,400);
		subfrm.setLayout(new BorderLayout());
		JPanel postItPanel = new JPanel();	//����Ʈ�� ���̴� �ǳ�
		postItPanel.setLayout(new GridLayout());
		TextArea loadText = new TextArea();
		for(File file : txtFile){
			file_loadpath = file_path;	//�ʱ�ȭ
			System.out.println("���� �̸� : "+file.getName());
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
	
	public void storePostit(String title, String content) throws IOException{		//���Ͽ�����
		/*		���� �̸� �Ȱ�ġ�� �����Ϸ��� ������ٰ� ���� �κ�
		for(File file : txtFile){
			if(file.getName() == title){
				System.out.println("���� �̸��� ��Ĩ�ϴ�.");
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
	public void deletePostit(String title){					//�����ϱ�
			File file = new File(file_path+title+".txt");
			if(file.exists()){
				file.delete();
			}
			else{
				System.out.println("������ �����ϴ�.");
			}
	}
}
