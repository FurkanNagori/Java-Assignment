public class Account {
    private String name;
    private double balance;
    Account(String name,double balance){
        this.name=name;
        this.balance=balance;
    }
    public void withdrawWithoutSafety(double ammount) {
       System.out.println(Thread.currentThread().getName()+" doing withdraw");
        if (ammount > this.balance) {
            System.out.println("insufficient balance");
            return;
        }
    else
        {
         System.out.println("your balance : "+this.balance);
         System.out.println("withdrawing amount : "+ammount);
            this.balance -= ammount;
            if(this.balance<0){System.out.println("negative balance");}
        }
        System.out.println("remaining balance : "+this.balance);
    }
}
