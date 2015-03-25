import java.awt.*;

import javax.swing.*;


class Gui {
	ItemManager item_mng;
	
	public Gui(ItemManager item_mng)
	{
		this.item_mng = item_mng;
	}

	public void jFrame() {

		JFrame frm = new JFrame("검색");
		frm.setBounds(120, 120, 400, 100);
		frm.setLayout(new BorderLayout());
		
		JLabel wordLabel = new JLabel("검색 할 단어 : ",SwingConstants.RIGHT);
		JTextField word = new JTextField(10); 
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(0,1));
		//JLabel titleLabel = new JLabel(item_mng.getItem(num));
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1,2));
		pan2.add(wordLabel); pan2.add(word);
	}

}
