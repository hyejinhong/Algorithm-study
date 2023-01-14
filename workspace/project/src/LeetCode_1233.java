import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode_1233 {

	public static void main(String[] args) {
		String[] folder = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
		 System.out.println(removeSubfolders(folder).toString());		
	}

	public static List<String> removeSubfolders(String[] folder) {
		Arrays.sort(folder);
		ArrayList<String> result = new ArrayList<>();
		
		for (String path : folder) {
			// 아무것도 안 들어있을 때나
			// 바로 이전 경로와 현재 경로가 서브 관계가 아닌 경우
			if (result.isEmpty() || !path.startsWith(result.get(result.size()-1) + "/")) {
				result.add(path);
			}
			
		}
		return result;
	}
}
