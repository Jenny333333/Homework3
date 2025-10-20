# Homework3

## 兒童學習系統

透過遊戲化的學習方式，幫助兒童在輕鬆有趣的環境中學習 時間判讀 與 金錢運算。
同時提供管理者介面，能夠檢視玩家學習紀錄、生成學習報告，並調整題庫內容。

### 系統功能
#### 玩家端

- 帳號註冊／登入

-- 可選擇或上傳頭像

--紀錄個人資料與學習進度

- 遊戲一：時間管理大師（看時鐘）

-- 初階：有數字的時鐘

-- 高階：無數字的時鐘

-- 隨機題庫、自動評分

-- 提示機制：可依次顯示時針、分針、完整答案

- 遊戲二：購物小能手（購物找錢）

-- 初階：付款金額題

-- 中階：找錢題

-- 高階：不顯示總金額，自行推算

-- 使用圖片模擬付款、解鎖成就

- 成就系統

-- 完成特定條件可獲得成就獎牌或獎盃

- 排行榜與遊玩歷史

-- 記錄每次遊玩時間與得分

-- 可匯出個人學習報告

#### 管理者端

- 登入後可管理：

-- 題庫（時鐘圖片、購物品項與金額）

-- 玩家資料

-- 成就內容與條件

- 可一鍵生成：

-- 所有玩家的學習報告

- 查看統計資訊：

-- 各遊戲類型的遊玩次數

-- 每位玩家的總時長與成就狀況


#### MySQL

- 共 11 張資料表：

-- achievement

-- achievementRecord

-- admin

-- clock

-- gameCategory

-- gameLevel

--pictureGallery

--player

--record

--report

--shoppingItem


- 主要關聯：

-- player ⬄ record （一對多）

-- player ⬄ achievementRecord （一對多）

-- achievementRecord ⬄ achievement （多對一）

-- gameLevel ⬄ clock、shoppingItem （一對多）

#### 系統架構

- 採用 MVC + DAO + Service 分層架構

src/

 ├── controller/     → 使用者介面（UI）
 
 ├── model/          → 資料模型（與資料表對應）
 
 ├── dao/            → 資料存取介面
 
 ├── dao/impl/       → 資料存取實作類別
 
 ├── service/        → 商業邏輯介面
 
 ├── service/impl/   → 商業邏輯實作
 
 ├── util/           → 工具類（如 DbConnection）
 
 └── Image/          → 遊戲圖片與頭像資源
