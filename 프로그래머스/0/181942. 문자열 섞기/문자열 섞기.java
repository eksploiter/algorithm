class Solution {
    public String solution(String str1, String str2) {
        // StringBuilder를 사용하여 결과 문자열을 생성
        StringBuilder answer = new StringBuilder();
        
        // 두 문자열의 길이는 같으므로 하나의 반복문으로 처리 가능
        for (int i = 0; i < str1.length(); i++) {
            // str1의 i번째 문자 추가
            answer.append(str1.charAt(i));
            // str2의 i번째 문자 추가
            answer.append(str2.charAt(i));
        }
        
        // 최종 문자열을 반환
        return answer.toString();
    }
}
