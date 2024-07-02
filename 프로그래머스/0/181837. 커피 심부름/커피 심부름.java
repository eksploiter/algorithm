class Solution {
    public int solution(String[] order) {
        int answer = 0;
        
        for (String item : order) {
            if (item.contains("americano") || item.equals("anything")) {
                // 아메리카노 또는 "anything" (차가운 아메리카노로 처리)
                answer += 4500;
            } else if (item.contains("cafelatte")) {
                // 카페 라테
                answer += 5000;
            }
        }
        
        return answer;
    }
}
