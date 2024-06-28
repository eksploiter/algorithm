class Solution {
    public String solution(String my_string, int n) {
        // my_string의 길이를 구합니다.
        int length = my_string.length();
        
        // 뒤에서 n글자를 추출하여 반환합니다.
        String answer = my_string.substring(length - n);
        
        return answer;
    }
}