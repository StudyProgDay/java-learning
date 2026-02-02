package exercises.variables;

public class Practice {
    public static void main(String[] args) {
        // 1. 変数の宣言と初期化（代入）
        String name = "あなたの名前";      // 文字列型：ダブルクォーテーションで囲む
        int age = 25;                    // 整数型：小数点なし
        double height = 170.5;           // 浮動小数点型：小数点あり
        boolean isJavaFun = true;        // 論理型：true(真) または false(偽)

        // 2. コンソールへの出力
        System.out.println("--- 自己紹介 ---");
        System.out.println("名前: " + name);
        System.out.println("年齢: " + age + "歳");
        System.out.println("身長: " + height + "cm");
        System.out.println("Javaは楽しいですか？: " + isJavaFun);

        // 3. 組み合わせた文章の出力
        System.out.println("\nこんにちは、" + name + "です。" 
            + age + "歳で、身長は" + height + "cmです。");
    }
}