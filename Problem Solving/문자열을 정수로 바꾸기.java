class Solution {
  public int solution(String s) {
      int answer = 0;
      
      int index = 0;
      
      if(s.charAt(0) == '+' || s.charAt(0) == '-') {
          index = 1;
      }
      
      for(int i=index; i<s.length(); i++) {
          int n = s.charAt(i) - '0';
          int pow = (int) Math.pow(10, s.length()-1-i);
          n = n * pow;
          answer += n;
      }
      
      if(index == 1 && s.charAt(0) == '-') {
          answer = 0 - answer;
      }
      return answer;
  }
}