import java.util.ArrayList;


class ItemManager {
	boolean isItem=false;
	ArrayList<String> title_list = new ArrayList<String>();
	
	public void saveItem(String title){

		title_list.add(title);
		
	}
	
	public void noticeWake(){
		synchronized(title_list){
			title_list.notifyAll();
		}	
	}
	
	public void isleep(){
		synchronized (title_list) {
			try {
				title_list.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String getItem(int num){
		
		return title_list.get(num);
	}
	
}
