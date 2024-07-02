class Solution {
    public int solution(int order) {
        int answer = 0;
        String strOrder = String.valueOf(order);  // order를 문자열로 변환합니다.

        for (int i = 0; i < strOrder.length(); i++) {
            char ch = strOrder.charAt(i);
            if (ch == '3' || ch == '6' || ch == '9') {
                answer++;
            }
        }

        return answer;
    }
}