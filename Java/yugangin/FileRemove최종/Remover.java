
import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Remover {

	ArrayList<File> removeFile = new ArrayList<File>();
	
	/*public Remover(ArrayList<File> removeFileList){
		this.removeFile =removeFileList;
	}*/
	
	public void doRemove(){
	// ���� �����
		
		
		

		
	/*	for(int i=0 ; i< deleteCookieFileList.length ; i++)
		{
			deleteCookieFileList[i].delete(); // ���ͳ� ��Ű����
		}
		*/
		for(int i =0 ; i<removeFile.size() ; i++)
		{
			removeFile.get(i).delete();
		}
	
		 JOptionPane.showMessageDialog(null, "�����Ϸ�.");
		
	}
	 
	
}
