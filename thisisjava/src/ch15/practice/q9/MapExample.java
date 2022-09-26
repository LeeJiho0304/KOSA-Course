package ch15.practice.q9;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;		//최고 점수를 받은 아이디를 저장하는 변수
		int maxScore = 0;		//최고 점수를 저장하는 변수
		int totalScore = 0;		//점수 합계를 저장하는 변수
		
		//평균, 최고 점수, 최고점수를 받은 아이디
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> e : entrySet) {
			totalScore += e.getValue();
			if(e.getValue() > maxScore) {
				maxScore = e.getValue();
				name = e.getKey();
			}
		}
		
		System.out.println("평균: " + totalScore / map.size());
		System.out.println("최고 점수: " + maxScore);
		System.out.println("최고 점수를 받은 아이디: " + name);
		
	}

}
