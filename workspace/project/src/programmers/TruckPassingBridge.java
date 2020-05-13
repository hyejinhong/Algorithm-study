package programmers;

import java.util.ArrayList;

public class TruckPassingBridge {

	static class Truck {
		int weight;
		int sec; // 다리 위에 올라온지 몇 초 됐는지..
		
		Truck(int weight, int sec) {
			this.weight = weight;
			this.sec = sec;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		ArrayList<Truck> passing = new ArrayList<>();
		
		int time = 1;
		
		for(int i=0; i<truck_weights.length; i++) {
			Truck truck = new Truck(truck_weights[i], 0);
			
			// 다리 위로 올라감 (길이 고려)
			if(passing.size() < bridge_length) {
				truck.sec++;
				passing.add(truck);
				
				// 무게를 견딜 수 있는지 확인
				int total = getTotalWeight(passing);
				// 견딜 수 있으면 하나 더 올림
				if(total <= weight) {
					// 하나 더 올림
					
				}
				// 못견디면 마지막에 올라간 트럭 뻄
				else {
					passing.remove(passing.size()-1);
					i--;
				}
				
				// 한칸씩 이동
				time++;
				move(passing);
				
				// 다리를 지났는지 확인
				if(passing.get(0).sec > bridge_length) {
					passing.remove(0);
				}
			}

		}
		
		while(!passing.isEmpty()) {
			time++;
			move(passing);

			// 다리를 지났는지 확인
			if(passing.get(0).sec > bridge_length) {
				passing.remove(0);
			}

		}
		
		return time;
	}
	
	// 현재 다리 위의 트럭의 무게 합 반환
	public static int getTotalWeight(ArrayList<Truck> passing) {
		int sum = 0;
		
		for(int i=0; i<passing.size(); i++) {
			sum += passing.get(i).weight;
		}
		
		return sum;
	}
	
	public static void move(ArrayList<Truck> passing) {
		for(int i=0; i<passing.size(); i++) {
			passing.get(i).sec++;
		}
	}

}
