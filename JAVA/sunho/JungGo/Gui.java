import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


class Gui {
	ItemManager item_mng;
	ItemSearch item_search;
	String[] search_arr;
	JFrame frm = new JFrame("검색창");
	JLabel wordLabel = new JLabel("검색 할 단어 ",SwingConstants.LEFT);
	JTextField word = new JTextField(10);
	JButton btn = new JButton("검색");
	JPanel pan1 = new JPanel();
	JScrollPane scroll = new JScrollPane(pan1);
	JPanel pan2 = new JPanel();
	String save;
	
	public Gui(ItemManager item_mng, ItemSearch item_search)
	{
		this.item_mng = item_mng;
		this.item_search = item_search;
	}

	public void jFrame() {
		
		
		
		frm.setBounds(120, 120, 400, 150);
		frm.setLayout(new BorderLayout());
		
		pan1.setLayout(new GridLayout(0,1));
		
		pan2.setLayout(new GridLayout(1,3));
		pan2.add(wordLabel); pan2.add(word); pan2.add(btn);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> save_list = new ArrayList<String>();
				save = word.getText();
				word.setText("");
				System.out.println("검색할단어>>"+save);
				save_list = item_search.searchWord(save);
				for(int i=0; i<save_list.size(); i++){
					pan1.add(new JLabel(save_list.get(i)));
				}
			}
		});
		
		frm.add(scroll, BorderLayout.CENTER);
		frm.add(pan2, BorderLayout.SOUTH);
		
		frm.setVisible(true);
		
		
	}

}
