# Java Spring Boot Practice
## 概要
JavaおよびSpring Bootの学習を目的とした個人開発プロジェクトです。
Spring Bootを用いたWebアプリケーション開発を通じて、Javaの文法やSpringのお作法の理解を深めることを目的としています。

## 学習目標
- Javaの基本文法を実践を通して習得する
- Spring BootによるWebアプリケーション開発を学ぶ

## 技術スタック
| 分類 | 使用技術 | 用途 |
| --- | --- | --- |
| 言語 | Java 21 | アプリケーション本体の実装 |
| フレームワーク | Spring Boot 3.5.0 | Webアプリケーションの土台 |
| Web | Spring MVC | コントローラー、ルーティング、フォーム送信、リダイレクト処理 |
| テンプレートエンジン | Thymeleaf | メモ一覧・詳細・作成フォームなどのHTML画面表示 |
| データアクセス | Spring Data JPA | Repositoryを通じたメモデータのCRUD処理 |
| ORM / 永続化 | Jakarta Persistence API | `Memo`エンティティとDBテーブルのマッピング |
| データベース | H2 Database | 開発・学習用のインメモリDB |
| バリデーション | Spring Validation / Jakarta Bean Validation | フォーム入力値の必須チェック・文字数チェック |
| 例外処理 | Spring MVC `@ControllerAdvice` | メモが見つからない場合の404画面表示 |
| ビルドツール | Gradle | 依存関係管理、ビルド、テスト実行 |
| テスト | JUnit 5 / Spring Boot Test | Springコンテキストの起動確認 |
| 補助ライブラリ | Lombok | ボイラープレート削減用の依存関係 |
