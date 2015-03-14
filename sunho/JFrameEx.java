import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

class PWHandler implements ActionListener
{
	
	JTextField id;
	JPasswordField pw;
	
	public PWHandler(JTextField id, JPasswordField pw)
	{
		this.id = id;
		this.pw = pw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("ID : "+id.getText());
		System.out.println("Password : "+new String(pw.getPassword()));
		id.setText("");
		pw.setText("");
	}
	
}

class ActionEventHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("버튼눌림");
	}
}


class JFrameEx 
{
	public static void main(String[] args)
	{
		JFrame frm = new JFrame("연습");
		frm.setBounds(120, 120, 250, 120);
		frm.setLayout(new BorderLayout());
		
		JLabel idLabel = new JLabel("ID ",SwingConstants.RIGHT);
		JTextField idText = new JTextField(10);
		JLabel pwLabel = new JLabel("PW ", SwingConstants.RIGHT);
		JPasswordField pwText = new JPasswordField(10);
		pwText.setEchoChar('*');
		
		pwText.addActionListener(new PWHandler(idText, pwText));
		
		JButton btn = new JButton("확인버튼");
		
		ActionListener buttonHandler = new ActionEventHandler();
		btn.addActionListener(buttonHandler);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2, 2));
		pan1.add(idLabel); pan1.add(idText);
		pan1.add(pwLabel); pan1.add(pwText);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new FlowLayout());
		pan2.add(btn);
		
		frm.add(pan1, BorderLayout.NORTH);
		frm.add(pan2, BorderLayout.SOUTH);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		}

}
