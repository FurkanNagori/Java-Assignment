public class AccountOverdrawDemo {
    public static void main(String gg[]) {
    Account account = new Account("SBI",1000.00);
        //created new thread
        // using lambdas expression, in which it directly implements runnable interface and use run method
        Thread thread1 = new Thread(()->{
        account.withdrawWithoutSafety(300);
        account.withdrawWithoutSafety(100);
        account.withdrawWithoutSafety(70);
    },"furkan");
    //created second thread
        Thread thread2 = new Thread(()->{
            account.withdrawWithoutSafety(300);
            account.withdrawWithoutSafety(100);
            account.withdrawWithoutSafety(700);
            account.withdrawWithoutSafety(70);
        },"abhishek");
       // starting thread in synchronized way.
        thread1.start();
        thread2.start();
    }
}

