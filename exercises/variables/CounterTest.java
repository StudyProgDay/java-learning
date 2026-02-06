package exercises.variables;

// 1. まず Counter クラス（補助的なクラスなので public は付けない）
record Counter(int value) {
    Counter add(int n) {
        return new Counter(this.value + n);
    }
}

// 2. 次に CounterTest クラス（ファイル名と同じ名前にし、public を付ける）
public class CounterTest {
    public static void main(String[] args) {
        Counter c = new Counter(10);
        Counter result = c.add(5); 

        if (result.value() == 15) {
            System.out.println("TEST PASSED! 🎉");
        } else {
            System.out.println("TEST FAILED! ❌ 期待値: 15, 実際: " + result.value());
        }
    }
}