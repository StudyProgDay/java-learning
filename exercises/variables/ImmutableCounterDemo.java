package exercises.variables;

import java.util.concurrent.atomic.AtomicReference;

public class ImmutableCounterDemo {
    
    // 1. 中身が絶対に変わらない（final）クラスを作る
    // これを「不変オブジェクト（Immutable Object）と呼ぶ
    // 一度作成したら、絶対に値を書き換えられない板のようなもの
    static class Counter {
        // 板に書き込まれた数字。絶対に書き換えられない。
        final int value;  // finalなので一度決まったら変えられない

        Counter(int value){
            this.value = value;
        }

        // 値を増やすのではなく、「増えた値を持つ新しいCountre」を返す
        // 今の板の隣に新しい板を用意する
        Counter increment() {
            return new Counter(this.value + 1);
        }
    }

    // 展示台。皆が見える場所にあり、一枚だけ貼る。
    // 一瞬で板を張り替える特殊なAtomicを使用する。
    private static AtomicReference<Counter> currentCounter = new AtomicReference<>(new Counter(0));

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 100000; i++){
                // 現在のCounterを取得し、新しいCoutnerに差し替える
                currentCounter.updateAndGet(Counter::increment);
            }
        };

        Thread th1 = new Thread(task);
        Thread th2 = new Thread(task);
        th1.start();
        th2.start();
        th1.join();
        th2.join();

        System.out.println("最終的なカウント:" + currentCounter.get().value);
    }
}