

import java.io.File;

public class Launcher {
	public static void main(String[] args){
		
		File deleteTempFile = new File("C:\\Windows\\Temp");
		//File deleteCookieFile = new File("C:\\Users\\uesr1\\AppData\\Local\\Microsoft\\Windows\\INetCache");
		
	    File[] deleteTempFileList = deleteTempFile.listFiles(); 
	   // File[] deleteCookieFileList = deleteCookieFile.listFiles();
		for(int i =0 ; i< deleteTempFileList.length ; i++)
		{
			deleteTempFileList[i].delete();  //temp ���� ����
		}
		
		
		Matcher match = new Matcher();
		match.startMacth();
		
		Interface infa = new Interface(match.fileList);
		infa.startGui();
		//long startTime = System.currentTimeMillis();
		//System.out.println(System.currentTimeMillis()-startTime);
		//������ �´� ���� ã��
		
		//infa.alarm(mt.findFiles());
		//����� interface
		
		//Ư���� ������ Ư�� ���������
		//mt.startMacth();
		
	}
}


///1. ��ɺ��� ������ �۰�
// 2. �ϳ��� ����� ��Ŭ����
