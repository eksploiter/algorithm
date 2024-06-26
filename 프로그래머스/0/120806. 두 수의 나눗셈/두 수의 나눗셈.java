class Solution {
    public int solution(int num1, int num2) {
        // num1을 num2로 나눈 값을 저장합니다.
        double divisionResult = (double) num1 / num2;
        
        // 결과에 1000을 곱합니다.
        double multipliedResult = divisionResult * 1000;
        
        // 정수 부분을 추출합니다.
        int answer = (int) multipliedResult;
        
        return answer;
    }
}
