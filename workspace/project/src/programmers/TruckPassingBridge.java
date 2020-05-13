package programmers;

import java.util.ArrayList;

public class TruckPassingBridge {

	static class Truck {
		int weight;
		int sec; // �ٸ� ���� �ö���� �� �� �ƴ���..
		
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
			
			// �ٸ� ���� �ö� (���� ���)
			if(passing.size() < bridge_length) {
				truck.sec++;
				passing.add(truck);
				
				// ���Ը� �ߵ� �� �ִ��� Ȯ��
				int total = getTotalWeight(passing);
				// �ߵ� �� ������ �ϳ� �� �ø�
				if(total <= weight) {
					// �ϳ� �� �ø�
					
				}
				// ���ߵ�� �������� �ö� Ʈ�� �M
				else {
					passing.remove(passing.size()-1);
					i--;
				}
				
				// ��ĭ�� �̵�
				time++;
				move(passing);
				
				// �ٸ��� �������� Ȯ��
				if(passing.get(0).sec > bridge_length) {
					passing.remove(0);
				}
			}

		}
		
		while(!passing.isEmpty()) {
			time++;
			move(passing);

			// �ٸ��� �������� Ȯ��
			if(passing.get(0).sec > bridge_length) {
				passing.remove(0);
			}

		}
		
		return time;
	}
	
	// ���� �ٸ� ���� Ʈ���� ���� �� ��ȯ
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
