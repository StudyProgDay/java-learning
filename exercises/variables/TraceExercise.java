package exercises.variables;

import java.util.UUID;

public class TraceExercise {
    // 1. Trace IDを保持するための入れ物（ThreadLoacl）
    private static final ThreadLocal<String> traceContext = new ThreadLocal<>();

    public static void main(String[] args) {
        // リクエストが届いた瞬間、Trace IDを発行してコンテキストにセット

        // リクエストが届いた瞬間、Trace IDを発行してコンテキストにセットする
        String traceId = UUID.randomUUID().toString().substring(0, 8);
        traceContext.set(traceId);

        log("Webリクエストを受信しました。");

        OrderProcessor processor = new OrderProcessor();
        processor.processOrder("iPhone");

        // 最後にコンテキストをクリア（メモリリーク防止！）
        traceContext.remove();
    }

    // 2. ログ出力時に常にTrace IDを付与する共通メソッド
    public static void log(String message) {
        String id = traceContext.get();
        System.out.printf("[%s] %s%n", id, message);
    }
}

class OrderProcessor {
    public void processOrder(String item) {
        TraceExercise.log("注文処理を開始: " + item);
        
        InventoryService inventory = new InventoryService();
        inventory.checkStock(item);
        
        TraceExercise.log("注文処理を完了しました。");
    }
}

class InventoryService {
    public void checkStock(String item) {
        // 深い階層のメソッドでも、引数で渡さずにIDを保持できている
        TraceExercise.log("在庫確認中... [在庫あり]");
    }
}