import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        try {
            // 첫 줄에 테스트 케이스의 개수 T를 입력받음
            int T = Integer.parseInt(reader.readLine());
            
            for (int i = 0; i < T; i++) {
                // 각 줄에 두 정수 A와 B를 입력받음
                String[] line = reader.readLine().split(" ");
                int A = Integer.parseInt(line[0]);
                int B = Integer.parseInt(line[1]);
                
                // A와 B의 합을 출력 버퍼에 기록
                writer.write((A + B) + "\n");
            }
            
            // 모든 출력을 완료한 후 버퍼를 플러시
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 리소스 해제
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
