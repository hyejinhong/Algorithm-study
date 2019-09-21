class Solution {
  public String solution(String s) {
      String answer = "";
      
      char[] array = new char[s.length()];
      for(int i=0; i<s.length(); i++) {
          array[i] = s.charAt(i);
      }
      
      for(int i=0; i<s.length(); i++) {
          for(int j=0; j<s.length()-1; j++) {
              if(array[j] < array[j+1]) {
                  char temp = array[j];
                  array[j] = array[j+1];
                  array[j+1] = temp;
              }
          }
      }
      
      for(int i=0; i<s.length(); i++) {
          answer += array[i];
      }
      
      
      
      return answer;
  }
}