
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Interface extends JFrame{
	
   ArrayList<File> listFile = new ArrayList<File>();
	
	public Interface(ArrayList<File> listFile){
	
		this.listFile = listFile;
		
}
	
	
	JButton button = new JButton("선택삭제");
	JTextArea ta = new JTextArea();
	JFrame frm = new JFrame("파일목록");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	JLabel label1 = new JLabel("선택");
	JLabel label2 = new JLabel("경로");
   
	
	ArrayList<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
	ArrayList<File> removeFilelist = new ArrayList<File>();
		
	
	String[] fileToRemove = null;
	
	public void startGui(){
		
		frm.setLayout(new BorderLayout());
		frm.setBounds(360, 120, 1200, 800);
		//System.out.println(listFile.size());
	
		panel1.setLayout(new GridLayout(1,2));
		panel1.add(label1); panel1.add(label2);  
		panel2.setLayout(new GridLayout(0,1)); 
		
	  
		for(int i =0 ; i< listFile.size() ; i++)
	    {
	      
	      
	       
	        checkBoxList.add(new JCheckBox(listFile.get(i).getAbsolutePath()));
	    	
	    	panel2.add(checkBoxList.get(i));
	    }
		 JScrollPane scrollpane = new JScrollPane(panel2);
		 panel3.setLayout(new FlowLayout());
		 panel3.add(button);
		
		 button.addActionListener(new ActionHandler(button, listFile,removeFilelist ,checkBoxList));
		frm.add(panel1,BorderLayout.NORTH);
		frm.add(scrollpane,BorderLayout.CENTER);
		frm.add(panel3,BorderLayout.SOUTH);
		frm.setVisible(true);
		;
	}
	
	/*public Interface(){
		this.add(btn);
		this.add(ta);
	}

	public void alarm(String[] fileToRemove){
		this.fileToRemove = fileToRemove;
		for(String str : fileToRemove){
			ta.append(str+"\n");
		}	
	}
	
	public void confirm(){
		Remover rm = new Remover();
		rm.doRemove(fileToRemove);
	}
	
	*/
}

 class ActionHandler implements ActionListener{

	JButton btn = new JButton();
	ArrayList<File> fileLists = new ArrayList<File>();
	ArrayList<File> removeFileList = new ArrayList<File>();
	ArrayList<JCheckBox> checkboxs = new ArrayList<JCheckBox>();
	
	Remover remove = new Remover();
	
	
	public ActionHandler(JButton btn ,ArrayList<File> fileLists,ArrayList<File> removeFileList,ArrayList<JCheckBox> checkboxs ) {
		// TODO Auto-generated constructor stub
	     this.btn = btn;
	     this.fileLists = fileLists;
	     this.removeFileList = removeFileList;
	     this.checkboxs = checkboxs;
	
 	}
	
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn)
		{
			
			for(int i =0 ; i<fileLists.size() ; i++)
			{
				if(checkboxs.get(i).isSelected()){
					
				remove.removeFile.add(fileLists.get(i));
				
					
				}
			}
			
			
			remove.doRemove();
			
		    System.exit(0);
		
			
			
		}
		
	}
	
}
