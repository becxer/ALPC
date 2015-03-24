package FileCleaner.src;

import java.io.File;

public class Launcher {
	public static void main(String[] args){
		
		File deleteTempFile = new File("C:\\Windows\\Temp");
		//File deleteCookieFile = new File("C:\\Users\\uesr1\\AppData\\Local\\Microsoft\\Windows\\INetCache");
		
	    File[] deleteTempFileList = deleteTempFile.listFiles(); 
	   // File[] deleteCookieFileList = deleteCookieFile.listFiles();
		for(int i =0 ; i< deleteTempFileList.length ; i++)
		{
			deleteTempFileList[i].delete();  //temp 파일 삭제
		}
		
		
		Matcher match = new Matcher();
		match.startMacth();
		
		Interface infa = new Interface(match.fileList);
		infa.startGui();
		
		
		//조건의 맞는 파일 찾기
		
		//infa.alarm(mt.findFiles());
		//사용자 interface
		
		//특정한 폴더의 특정 파일지우기
		//mt.startMacth();
		
	}
}


///1. 기능별로 나누기 작게
// 2. 하나의 기능은 한클래스
