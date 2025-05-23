import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int deleteNode;
    static int leafCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        deleteNode = sc.nextInt();

        if (deleteNode == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(leafCount);
        }
    }

    static void dfs(int current) {
        if (current == deleteNode) {
            return;
        }

        if (tree[current].isEmpty()) {
            leafCount++;
            return;
        }

        boolean isLeaf = true;
        for (int child : tree[current]) {
            if (child != deleteNode) {
                isLeaf = false;
                dfs(child);
            }
        }

        if (isLeaf) {
            leafCount++;
        }
    }
}
