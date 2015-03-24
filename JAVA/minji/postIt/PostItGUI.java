import javax.swing.JFrame;
import javax.swing.JTextArea;


public class PostItGUI extends JFrame{

	JTextArea ta_content = new JTextArea();
	
	public PostItGUI(String title, String content) {
		// TODO Auto-generated constructor stub
		ta_content.append(title + "\n\n");
		ta_content.append(content);
		
		//변경됬을떄 리스너  -> 저장하는걸
		
	}
}
