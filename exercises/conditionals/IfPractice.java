package exercises.conditionals;

import java.util.Scanner;

public class IfPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("年齢を入力してください：");
        int age = scanner.nextInt();

        // --- 条件分岐の開始 ---
        if (age >= 20) {
            // 条件が true (真) の時に実行
            System.out.println("成人ですね。お酒の購入が可能です。");
        } else if (age >= 0) {
            // 上の条件が false で、この条件が true の時に実行
            System.out.println("未成年ですね。ソフトドリンクをどうぞ！");
        } else {
            // どの条件にも当てはまらない（マイナスの値など）時に実行
            System.out.println("正しい年齢を入力してください。");
        }
        // --- 条件分岐の終了 ---

        scanner.close();
    }
}