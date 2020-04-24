package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class BestAlbum {
		
	static class Song implements Comparable<Song> {
		int index;
		String genreName;
		int genre; // �帣 �����
		int plays;
		
		public Song(int index, String genreName, int plays) {
			super();
			this.index = index;
			this.genreName = genreName;
			this.plays = plays;
		}
		
		void setGenre(int genre) {
			this.genre = genre;
		}

		@Override
		public int compareTo(Song o) {
			// TODO Auto-generated method stub
			// �帣 �켱
			
			// �� �帣�� �� ���� ����� (��������)
			if(this.genre > o.genre) {
				return -1;
			}
			// �帣�� ���� ���
			else if(this.genre == o.genre) {
				// ���� ����� �� �켱 (��������)
				if(this.plays > o.plays) {
					return -1;
				}
				// ��� Ƚ�� ������ ������ȣ (�ø�����)
				else if(this.plays == o.plays) {
					return this.index - o.index;
 				}
				else {
					return 1;
				}
			}
			// �� �帣�� �� ���� �����
			else {
				return 1;
			}
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String str = this.index + ": " + this.genreName + ", " + this.genre + ", plays: " + this.plays;
			return str + "\n";
					
		}
	}
	
	static HashMap<String, Integer> map = new HashMap<>();
	static HashMap<String, Integer> countMap = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {
				"classic", "pop", "classic", "classic", "pop"	
		};
		int[] plays = {
				500, 600, 150, 800, 2500
		};
		
		System.out.println(Arrays.toString(solution(genres, plays)));
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		// input
		ArrayList<Song> songs = new ArrayList<>();
		for(int i=0; i<genres.length; i++) {
			// ó�� �ִ� �帣
			if(map.get(genres[i]) == null) {
				map.put(genres[i], plays[i]);
			}
			// �̹� �־��� �帣
			else {
				int value = map.get(genres[i]);
				value += plays[i];
				map.put(genres[i], value);
				
			}
			
			songs.add(new Song(i, genres[i], plays[i]));
		}
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			int genre = map.get(key);
			
			for(int i=0; i<songs.size(); i++) {
				if(songs.get(i).genreName.equals(key)) {
					songs.get(i).setGenre(genre);
				}
			}
		}
		
		// ����
		ArrayList<Integer> answer = new ArrayList<>();
		System.out.println(songs.toString());
		Collections.sort(songs);
		System.out.println(songs.toString());
		for(int i=0; i<plays.length; i++) {
			Song s = songs.get(i);
			
			if(countMap.get(s.genreName) == null) {
				countMap.put(s.genreName, 1);
				answer.add(s.index);
			}
			// �̹� �� �帣���� 2�� ������ ������
			else if(countMap.get(s.genreName) == 2) {
				continue;
			}
			else {
				int value = countMap.get(s.genreName);
				value++;
				countMap.put(s.genreName, value);
				answer.add(s.index);
			}
		}
		
		int[] ret = new int[answer.size()];
		
		for(int i=0; i<ret.length; i++) {
			ret[i] = answer.get(i);
		}
		
		return ret;
	}
}
