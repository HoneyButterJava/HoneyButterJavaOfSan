package hash;

import java.util.HashMap;

public class pg_1845 {
	public int solution(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]))	// key값이 존재하면
				map.replace(nums[i], map.get(nums[i] + 1));
			else
				map.put(nums[i], 1);
		}

		int canMaxGet = nums.length / 2;
		if (map.size() < canMaxGet)
			return map.size();
		else
			return canMaxGet;
	}
}
