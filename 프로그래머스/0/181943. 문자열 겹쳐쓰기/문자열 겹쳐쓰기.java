class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        // my_string의 앞부분 (s 이전 부분)
        String frontPart = my_string.substring(0, s);
        // my_string의 뒷부분 (overwrite_string의 길이 이후 부분)
        String backPart = my_string.substring(s + overwrite_string.length());
        
        // 앞부분 + overwrite_string + 뒷부분을 합쳐 새로운 문자열 생성
        String answer = frontPart + overwrite_string + backPart;
        
        return answer;
    }
}
