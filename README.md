# PostAndLike 

**PostAndLike** は、50文字以内の投稿ができ、他のユーザーの投稿に「いいね」できるシンプルな掲示板アプリです。  
ユーザー認証機能を備えており、ログインしたユーザーのみ投稿やいいねが可能です。

---



---

## 🛠️ 使用技術
| 技術 | 詳細 |
|------|------|
| **バックエンド** | Java (Servlet & JSP) |
| **データベース** | MySQL |
| **フロントエンド** | HTML, CSS, JavaScript |
| **開発環境** | Eclipse / VSCode + Tomcat |

---

## 主な機能
 投稿機能（50文字以内のメッセージを投稿可能）  
 いいね機能（他の投稿に「いいね」できる）  
 ユーザー認証（ログイン・新規登録）  
 投稿削除機能（自分の投稿のみ削除可能）  
 並び替え機能（日付順やいいね数の多い順に投稿を表示）  

---

## セットアップ手順（ローカル環境）
### 1　必要なツール
- **Java 8以上**（JDK が必要）
- **Tomcat 9 以上**（Servlet / JSP を実行するため）
- **MySQL 5.7 以上**（データベース）
- **Eclipse または VSCode**（開発用）

### 2　リポジトリをクローン
```sh
git clone https://github.com/yamada814/PostAndLike_app.git
cd PostAndLike_app
