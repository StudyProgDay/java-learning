package exercises.variables;

public class AsyncTraceFailure {
    // Trace IDを保持するための入れ物を用意
    private static final ThreadLocal<String> traceContext = new InheritableThreadLocal<>();
 
    public static void main(String[] args) throws InterruptedException {
        //　親スレッドを用意する。
        traceContext.set("Trace-12345");
        // 親スレッド情報を表示する
        System.out.println("【親スレッド】ID: " + traceContext.get());

        //　次に新しいスレッドを作って処理を投げる
        Thread childThread = new Thread(() -> {
            //ここでスレッドIDを表示しようとする
            System.out.println("【子スレッド】ID：" + traceContext.get());
        });

        childThread.start();
        //子スレッドが終わるまで処理が終わらないようにする
        childThread.join();
    }
}