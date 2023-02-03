package General;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

public class TopKFrequentELements {
	
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
        
		PriorityQueue<Pair> pq = new PriorityQueue<>(new CountComparator());
		for(int key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
			int count = map.get(key);
			pq.add(new Pair(key, count));
		}
		
		System.out.println();
		int[] res = new int[k];
		for(int i=0 ;i<k ; i++) {
			System.out.println(pq.peek().element);
			res[i] = pq.poll().element;
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {5,2,5,3,5,3,1,1,3};
		System.out.println(Arrays.toString( TopKFrequentELements.topKFrequent(nums, 2) ));
	}
}

class Pair {
	int element, count;
	
	Pair(int e, int c) {
		element = e;
		count = c;
	}
}

class CountComparator implements Comparator<Pair> {
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.count < o2.count) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
}
