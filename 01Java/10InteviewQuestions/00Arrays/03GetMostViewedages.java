package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetMostViewedages {

	static class Views {
		String userID;
		String page;

		public Views(String userID, String page) {
			this.page= page;
			this.userID = userID;
		}

		public String getUserID() {
			return userID;
		}

		public void setUserID(String userID) {
			this.userID = userID;
		}

		public String getPage() {
			return page;
		}

		public void setPage(String page) {
			this.page = page;
		}
	}

	public static  int getMostViewedPages(Views[] input) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		int max = 0;

		String userId, page;
		List<String> pages = null;
		for (int i = 0; i < input.length; i++) {

			userId = input[i].getUserID();
			page = input[i].getPage();
			if (!map.keySet().contains(userId)) {
				pages = new ArrayList<String>();
			}
			pages.add(page);

			map.put(userId, pages);
		}

		Map<List<String>, Integer> res = new HashMap<List<String>, Integer>();
		int counter = 0;
		for (List<String> str : map.values()) {
			for (int i = 0; i < str.size()-2; i++) {
				
				List<String> sub = str.subList(i, i+3);
	
				System.out.println(sub.toString());
				if (!res.keySet().contains(sub)) {
					res.put(sub, 0);
			
				counter++;
				res.replace(sub, counter);
				}
			}
		}

		for (int count : res.values()) {
			if (count > max)
				max = count;
		}
		return max;
	}

	public static void main(String[] args) {
		
		Views v1 = new Views("user1", "A");
		Views v2 = new Views("user1", "B");
		Views v3 = new Views("user1", "C");
		Views v4 = new Views("user1", "D");
		Views v5 = new Views("user2", "B");
		Views v6 = new Views("user2", "C");
		Views v7 = new Views("user2", "D");
		Views v8 = new Views("user3", "A");
		Views v9 = new Views("user3", "B");
		Views v10 = new Views("user3", "C");
		Views v11 = new Views("user4", "A");
		Views v12= new Views("user4", "B");
		Views v13 = new Views("user4", "C");
		Views v14= new Views("user2", "F");
		
		Views[] views = new Views[14];
		views[0] = v1;
		views[1] = v2;
		views[2] = v3;
		views[3] = v4;
		views[4] = v5;
		views[5] = v6;
		views[6] = v7;
		views[7] = v8;
		views[8] = v9;
		views[9] = v10;
		views[10] = v11;
		views[11] = v12;
		views[12] = v13;
		views[13] = v14;
		
	System.out.println(getMostViewedPages(views));	
	}
}
