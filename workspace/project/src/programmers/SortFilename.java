package programmers;

import java.util.Arrays;

public class SortFilename {
    static class File implements Comparable<File> {
        String head;
        String strNumber;
        int number;
        int index; // 입력 순서
        
        File(String head, String strNumber, int index) {
            this.head = head;
            this.strNumber = strNumber;
            this.number = Integer.parseInt(strNumber);
            this.index = index;
        }
        
        @Override
        public int compareTo(File o) {
            // 1. head 기준
            int result = this.head.toLowerCase().compareTo(o.head.toLowerCase());
            
            // head가 같으면
            if(result == 0) {
                // 넘버로 정렬
                result = this.number - o.number;
                return result;
            }
            else {
                return result;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] files = {
				{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"},
				{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}
		};
		for(int i=0; i<files.length; i++) {
			System.out.println(Arrays.toString(solution(files[i])));
		}
	}
	
	public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        File[] arr = new File[files.length];
        
        // input
        for(int i=0; i<files.length; i++) {
            String filename = files[i];
            String head = "";
            String strNumber = "";
            String tail = "";
            
            int index = 0;
            // head 찾기
            for(int j=0; j<filename.length(); j++) {
                char ch = filename.charAt(j);
                
                if(((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) || 
                   ch == '.' || ch == '.' || ch == '-' || ch == ' ') {
                    head += ch;
                }
                else {
                    index = j;
                    break;
                }
            }

            // number 찾기
            for(int j=index; j<filename.length(); j++) {
                char ch = filename.charAt(j);
                
                // 숫자라면
                if(ch >= '0' && ch <= '9') {
                    strNumber += ch;
                }
                else {
                    index = j;
                    break;
                }
                if(strNumber.length() == 5) {
                    index = j+1;
                    break;
                }

            }
            
            // 그 아래는 tail
            // tail = filename.substring(index);
            
            // 저장
            arr[i] = new File(head, strNumber, i);
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<files.length; i++) {
            answer[i] = files[arr[i].index];
        }

        return answer;
	}

}
