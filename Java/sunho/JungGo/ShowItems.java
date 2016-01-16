class ShowItems extends Thread {

	private ItemManager item_mng;
	String save;

	public ShowItems(ItemManager item_mng) {
		this.item_mng = item_mng;
	}

	public void run() {
		while (true) {
			item_mng.isleep();
			System.out.println("<제목 목록>");
			for (int i = 0; i < item_mng.title_list.size(); i++) {
				save = item_mng.getItem(i);
				System.out.println(item_mng.getItem(i));
			
			}
		}
	
	}

}
