package exercises.variables;

import java.util.*;

public class OrderService {
    public static void main(String[] args) {
        OrderService service = new OrderService();
        
        // テストケース：正常に動いているように見える
        List<String> userOrders = Arrays.asList("iPhone", "Case", "Protector");
        System.out.println("Result 1: " + service.processOrders("UserA", userOrders));

        // 【問題】ここでエラーが発生する、または期待した動きをしない
        try {
            List<String> emptyOrders = new ArrayList<>();
            System.out.println("Result 2: " + service.processOrders("UserB", emptyOrders));
            
            List<String> nullOrders = null;
            System.out.println("Result 3: " + service.processOrders("UserC", nullOrders));
        } catch (Exception e) {
            e.printStackTrace(); // 現場でよく見る「とりあえずスタックトレース」
        }
    }

    public List<String> processOrders(String user, List<String> items) {
        // ログ出力（現場のデバッグログを再現）
        System.out.println("[DEBUG] Processing orders for user: " + user + ", item count: " + items.size());

        List<String> processed = new ArrayList<>();
        for (String item : items) {
            if (!item.isEmpty()) {
                processed.add(item.toUpperCase());
            }
        }
        return processed;
    }
    public void process(String traceId) {
        // 処理の入口でIDをログに含める
        logger.info("[{}] 処理開始", traceId);
        
        try {
            doSomething(); // 子要素(Span)
            logger.info("[{}] 処理成功", traceId);
        } catch (Exception e) {
            logger.error("[{}] 異常終了: {}", traceId, e.getMessage());
        }
    }
}