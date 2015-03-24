import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class HomepageReader {

	private ItemManager item_mng;
	URL url = null;
	String urlAddress;
	String fullContents = null;
	String[] first_arr = null;
	String[] second_arr = null;
	String titleContents;
	String[] first_text = null;
	String[] second_text = null;
	LinkedList<String> title_list = new LinkedList<>();
	

	public HomepageReader(ItemManager itemManager) {
		this.item_mng = itemManager;
		
	}

	public void homepageReading() {// ���̹��� �����ؼ� �� �о����
		Thread th = new Thread(new Runnable() {

			public void run() {
				while (true) {
					
					try {
						url = new URL("http://www.ajou.ac.kr/kr/ajou/notice.jsp?mode=list&board_no=33&pager.offset=10");
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}

					ArrayList<String> lines_list = new ArrayList<String>();
					String readLine = null;
					try {
						InputStreamReader isr = new InputStreamReader(url.openStream(), "UTF-8");
						BufferedReader br = new BufferedReader(isr);

						while ((readLine = br.readLine()) != null) {
							lines_list.add(readLine);
						}

						for (int i = 0; i < lines_list.size(); i++) {// line�����Ǽҽ� �ϳ���String���� ��ġ��
							fullContents += lines_list.get(i);
						}

						first_arr = fullContents.split("list_wrap");// �ϳ��� String�� split�ϱ�_1
																	
						for (int j = 0; j < first_arr.length; j++) {// String split_2
							if (first_arr[j].matches(".*" + "pager_wrap" + ".*")) {
								second_arr = first_arr[j].split("pager_wrap");
							}
						}
						
						titleContents = second_arr[0];// ����κи� �߶󳻼� �����ϱ�
						//System.out.println(titleContents);
						first_text = titleContents.split("board_no=33\">");
						
						for(int k=1; k<first_text.length; k++){
							 second_text = first_text[k].split("</a>");
							 item_mng.saveItem(second_text[0]);
						
						}
							

					} catch (IOException e) {
						e.printStackTrace();
					}

					// item_mng.saveItem("naver cralwed");

				}
			}

		});
		th.start();
	}

}