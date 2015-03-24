import java.util.Scanner;

public class ItemSearch {
	private ItemManager item_mng;
	Scanner sc = new Scanner(System.in);

	public ItemSearch(ItemManager item_mng) {
		this.item_mng = item_mng;
	}

	public void searchWord() {
		System.out.println("°Ë»ö : ");
		String search_word = sc.nextLine();
		
		
		for(int i=0; i<item_mng.title_list.size();i++){
			if(item_mng.title_list.get(i).matches(".*"+search_word+".*")){
				System.out.println(item_mng.title_list.get(i));
				
			}
				
		}
		
	}

}
