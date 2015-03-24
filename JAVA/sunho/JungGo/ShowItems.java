
public class ShowItems {

		private ItemManager item_mng;
	
		public ShowItems(ItemManager item_mng){
			this.item_mng = item_mng;
		}
	
		public void titleShowing(){
			Thread th = new Thread(new Runnable() {
				
				public void run() {
				
						for(String titleList: item_mng.title_list){
							System.out.println(titleList);
						}
						
				}
			});
			th.start();
		}
}
