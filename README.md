### 建立專案 :
建立Gradle專案,設定好 build.gradle(重要)等其它設定,建立GitHub 專案名稱(最好取一樣名稱),把建立好的URL帶到eclipse team->Share Project,
 接著注意:要在 User or create repository in parent folder of project 打勾,按下專案名稱,然後在下面按下Create Repository,讓ecilpse建立專案在  workspace的第一層(避免由GitHub 重新import專案時,會造成路徑上的錯誤),之後設定.gitignore(忽略不上傳檔案,可參考https://github.com/github/gitignore or 參考此專案的.gitignore),之後commit and push.
***
### 額外資源檔放置位址,採用 YAMl(.yml) :
路徑 : src/main/resources/application.yml 的檔案可以在裡面設定 , 現在只有設定tomcat server port
***
### 確認成功在Browser啟動專案 :
專案啟動後到 Browser 輸入: http://localhost:8090/tests , 在輸入驗證(帳號:user/密碼:啟動後可知道) , 看到Spring Boot Hello(在程式自定義) , 卽成功.
ps: port的8090是從application.yml 重新設定的,預設為8080.  
+ SecurityAutoConfiguration : 可跳過驗證帳密彈出視窗
***
### 參考資料 : 
Spring Boot Reference Guide(1.5.3.RELEASE) https://docs.spring.io/spring-boot/docs/current/reference/html/index.html
***
