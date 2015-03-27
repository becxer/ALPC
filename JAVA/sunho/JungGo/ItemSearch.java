import java.util.ArrayList;

class ItemSearch {
	private ItemManager item_mng;
	ArrayList<String> search_list = new ArrayList<String>();
	
	public ItemSearch(ItemManager item_mng) {
		this.item_mng = item_mng;
		
	}

	public ArrayList<String> searchWord(String word) {
		for(int i=0; i<item_mng.title_list.size();i++){
			if(item_mng.getItem(i).matches(".*"+word+".*")){
				search_list.add(item_mng.getItem(i));
			}
				
		}
		return search_list;
	}
	

}
