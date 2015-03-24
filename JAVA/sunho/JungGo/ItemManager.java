import java.util.ArrayList;


public class ItemManager {
	
	
	//Template의 개념에 대해서 공부해보기.
	ArrayList<String> title_list = new ArrayList<String>();
	
	public synchronized void saveItem(String title){
		title_list.add(title);
	}
	
	public synchronized String getItem(){
		return title_list.get(title_list.size()-1);
	}
	
	
}
