### firstGradle所使用技術 :
- 語言 : jdk8
- 版控 : GitHub
- 運行平台 : Heroku 
- 資料庫(NO SQL) : mlab(MongoDB的雲端服務)
***
### 建立專案 :
建立Gradle專案,設定好 build.gradle(重要)等其它設定,建立GitHub 專案名稱(最好取一樣名稱),把建立好的URL帶到eclipse team->Share Project,
 接著注意:要在 User or create repository in parent folder of project 打勾,按下專案名稱,然後在下面按下Create Repository,讓ecilpse建立專案在  workspace的第一層(避免由GitHub 重新import專案時,會造成路徑上的錯誤),之後設定.gitignore(忽略不上傳檔案,可參考https://github.com/github/gitignore or 參考此專案的.gitignore),之後commit and push.
***
### 額外資源檔放置位址,採用 YAMl(.yml) :
路徑 : src/main/resources/application.yml 的檔案可以在裡面設定 , 現在只有設定tomcat server port
***
### 確認成功在Browser啟動專案 :
專案啟動後到 Browser 輸入: http://localhost:8090/test , 在輸入驗證(帳號:user/密碼:啟動後可知道) , 看到Spring Boot Hello(在程式自定義) , 卽成功.
ps: port的8090是從application.yml 重新設定的,預設為8080.  
+ SecurityAutoConfiguration : 可跳過驗證帳密彈出視窗
***
### 參考資料 : 
Spring Boot Reference Guide(1.5.3.RELEASE) https://docs.spring.io/spring-boot/docs/current/reference/html/index.html
***
### 佈署到 Heroku :
1. Create New App
2. Deployment method: 選 GitHub
3. Search 出現GitHub專案列表,點要佈署的專案
4. Enable Automatic Deploys
5. 讓專案build
+ 1. 按 Overview , 按 More -> View Logs 看Spring Boot 的圖有沒有跑起來了,有圖級代表server有啟動
+ 2. 若沒有,上個cdoe,讓Heroku自動幫忙佈署
+ 3. 按Open App 上面的URL就是專案的網址
6. 若是已設定隱藏connect MongoDB URI的話,需在Settings->Config Variables->點選Reveal Config Vars,去作Heroku的設定,這樣才能讓Heroku連到mongodb
***
### 設定隱藏connect MongoDB URI(不讓java code上到GitHub時會把MongoDB帳密顯示出來) :
1. 把 MongoDB URI 放到run configurations 的專案
2. 點Java Application的專案名稱(這裡是RunFirstGradle)
3. 點上面Arguments
4. 在VM argument裡輸入自定義的變數名稱,前面加-D,例:-D變數名稱=值
+ -DMONGODB_URI=mongodb://dbuser:dbpassword@ds161041.mlab.com:61041/dbName,即可取代在yaml裡連接MongoDB數據庫的uri的位址;會是 spring:data:mongodb:uri:${MONGODB_URI}
***
