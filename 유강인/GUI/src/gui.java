import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
class gui {
 
	public static void main(String[] args)
	{
		JFrame frm = new JFrame("로그인프로그램");
		JButton btn = new JButton("로그인");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel idlabel = new JLabel("아이디   :");
		JLabel pwlabel = new JLabel("비밀번호 :");
        JTextField idtext = new JTextField(10);
        JPasswordField pwtext = new JPasswordField(10);
        pwtext.setEchoChar('*');
        
		panel1.setLayout(new GridLayout(2,1));
		panel2.setLayout(new FlowLayout());
		
		panel1.add(idlabel); panel1.add(idtext);		
		panel1.add(pwlabel); panel1.add(pwtext);
		
		panel2.add(btn);
		
		btn.addActionListener(new ActionHandler(btn,idtext,pwtext));
		
		frm.add(panel1); frm.add(panel2);
		
		frm.setBounds(120,120,400,100);
		frm.setLayout(new GridLayout(2,1));
		
		frm.setVisible(true);
	}
	
	
}
class ActionHandler implements ActionListener{

	JTextField jt;
	JPasswordField jw;
	JButton jb;

	public ActionHandler(JButton jb,JTextField jt,JPasswordField jw)
	{
	     this.jt = jt;
	     this.jw = jw;
	     this.jb = jb;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb)
		{
			if(jt.getText().equals("admin") && jw.getText().equals("1234"))
					{
				        JOptionPane.showMessageDialog(null, "로그인성공.");
					}
			else{
				 JOptionPane.showMessageDialog(null, "로그인실패.");
			}
		}
		}
	
	
}
