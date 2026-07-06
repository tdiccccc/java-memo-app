# 学習ログ 02: Controller単一責任・UseCase分割

## 学習テーマ

MVCからDDDへ向けた最初のリファクタリング。

ControllerとServiceを責務ごとに分割し、
ユースケース単位で処理を持つ構成へ変更した。

---

# Before

Controller

↓

MemoService

↓

Repository

↓

Entity

---

# After

ListController

↓

ListMemosUseCase

↓

Repository

---

CreateController

↓

CreateMemoUseCase

↓

Repository

---

ShowController

↓

ShowMemoUseCase

↓

Repository

---

UpdateController

↓

UpdateMemoUseCase

↓

Repository

---

DeleteController

↓

DeleteMemoUseCase

↓

Repository

---

## 学んだこと

- Controllerは1ユースケースだけ担当する
- UseCaseは1業務だけ担当する
- Serviceという大きな責務を分割する
- 変更理由ごとにクラスを分離する

---

## 実務でのメリット

### 修正箇所が明確になる

例)

メモ作成だけ変更したい

↓

CreateMemoUseCaseだけ修正

---

### Controllerが読みやすい

Controllerは

- HTTP受付
- Validation
- UseCase呼び出し
- View返却

のみになる。

---

### テストしやすい

UseCase単位でJUnitを書ける。

---

## Laravelとの違い

LaravelではControllerからServiceを呼ぶことが多い。

Spring Bootでは

Controller

↓

UseCase

↓

Repository

という構成も多く採用される。

DDDではこちらが一般的。

---

## 次のステップ

Repository InterfaceをDomainへ移動する。

Application層はSpring Data JPAを知らない構成へ変更する。
