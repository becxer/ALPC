import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
class gui {
 
	public static void main(String[] args)
	{
		JFrame frm = new JFrame("�α������α׷�");
		JButton btn = new JButton("�α���");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel idlabel = new JLabel("���̵�   :");
		JLabel pwlabel = new JLabel("��й�ȣ :");
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
				        JOptionPane.showMessageDialog(null, "�α��μ���.");
					}
			else{
				 JOptionPane.showMessageDialog(null, "�α��ν���.");
			}
		}
		}
	
	
}
