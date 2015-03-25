class ShowItems extends Thread {

	private ItemManager item_mng;

	public ShowItems(ItemManager item_mng) {
		this.item_mng = item_mng;
	}

	public void run() {
		System.out.println("보여주기");

		for (int i = 0; i < item_mng.title_list.size(); i++) {
			System.out.println(">>" + item_mng.getItem(i + 1));

		}

	}

}
