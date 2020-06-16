# Bank Account Management including : 

📙 [DESCRIPTION]
· Deposit and Withdrawal
· Account statement (date, amount, balance)
· Statement printing

⚙️ [ENVIRONNEMENT]
· IDE : INTELLIJ
· Framework : Spring Boot 2.3.1
· JDK : 11
· Tests : Mockito 1.10.19 & Junit & assertj
. Plugins : Lombok, SonarLint

⚙️ [SETUP]
· Import the folder as a project from intellij
· ⚠️ Install lombok plugin ⚠️
· Run the project

✅ [POC]
· To deposit into an account, run the following URL : 
http://localhost:9090/depositIntoAccount/[Your_FullName]/[TheAmount_To_Deposit]

· To withdraw from an account, run the following URL : 
http://localhost:9090/withdrawFromAccount/[Your_FullName]/[TheAmount_To_Withdraw]

· To view the history of all the transaction, run the following URL : 
http://localhost:9090/transactionHistory
