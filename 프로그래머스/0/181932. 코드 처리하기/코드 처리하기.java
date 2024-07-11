class Solution {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder();
        int mode = 0;

        for (int idx = 0; idx < code.length(); idx++) {
            char currentChar = code.charAt(idx);
            if (currentChar == '1') {
                // 모드를 변경
                mode = 1 - mode;
            } else {
                if (mode == 0 && idx % 2 == 0) {
                    ret.append(currentChar);
                } else if (mode == 1 && idx % 2 != 0) {
                    ret.append(currentChar);
                }
            }
        }

        // ret가 비어있으면 "EMPTY" 반환
        return ret.length() == 0 ? "EMPTY" : ret.toString();
    }
}
