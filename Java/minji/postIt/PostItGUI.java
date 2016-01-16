import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PostItGUI extends JFrame implements ActionListener{
	PostItManager post_mng = new PostItManager();
	JFrame mainfrm = new JFrame("PostIt"); //메인 프레임
	JButton btnLoad = new JButton("Load");
	JButton btnWrite = new JButton("Write");
	JButton btnDelete = new JButton("Delete");
	JButton btnExit = new JButton("EXIT");
	JButton enter = new JButton("Enter");
	//JTextArea ta_content = new JTextArea();
	public void mngGUI(){
		mainfrm.setBounds(120,120,400,100);
		mainfrm.setLayout(new BorderLayout());	
		
		btnLoad.setBackground(Color.red);
		btnWrite.setBackground(Color.yellow);
		btnDelete.setBackground(Color.green);
		btnExit.setBackground(Color.blue);
		
		JPanel menuPanel = new JPanel();	//메뉴 판넬
		menuPanel.setLayout(new FlowLayout());
		menuPanel.add(btnLoad);
		menuPanel.add(btnWrite);
		menuPanel.add(btnDelete);
		menuPanel.add(btnExit);
		
		btnLoad.addActionListener(this);
		btnWrite.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
		
		 
		 mainfrm.add(menuPanel,BorderLayout.NORTH);
		 mainfrm.setVisible(true);
	}
	
	public void inputTextInfo() {
		JFrame subfrm = new JFrame("Text info"); 
		subfrm.setBounds(120,120,400,100);
		subfrm.setLayout(new BorderLayout());
		JPanel input_text = new JPanel();
		JTextField textTitle = new JTextField();
		JTextArea textContents = new JTextArea();
		input_text.setLayout(new GridLayout());
		input_text.add(new JLabel("  Title"));
		input_text.add(textTitle);
		input_text.add(new JLabel("  Contents"));
		input_text.add(textContents);
		input_text.add(enter);
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(enter)){
					String title = textTitle.getText();
					String content = textContents.getText();
					try {
						post_mng.storePostit(title, content);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					subfrm.dispose();
				}
			}
		});
		subfrm.add(input_text,BorderLayout.CENTER);
		subfrm.setVisible(true);
	}
	public void inputDeleteInfo(){
		JFrame subfrm = new JFrame("Delete Info"); //메인 프레임
		subfrm.setBounds(120,120,400,100);
		subfrm.setLayout(new BorderLayout());
		JPanel input_text = new JPanel();
		JTextField textTitle = new JTextField();
		input_text.setLayout(new GridLayout());
		input_text.add(new JLabel("  Title"));
		input_text.add(textTitle);
		input_text.add(enter);
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(enter)){
					String title = textTitle.getText();
					post_mng.deletePostit(title);
					subfrm.dispose();
				}
			}
		});
		subfrm.add(input_text,BorderLayout.CENTER);
		subfrm.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnLoad)){
				try {
					post_mng.loadFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		else if(e.getSource().equals(btnWrite)){
				inputTextInfo();
		}
		else if(e.getSource().equals(btnDelete)){
				inputDeleteInfo();
		} 
		else
			System.exit(0);
	}
}
