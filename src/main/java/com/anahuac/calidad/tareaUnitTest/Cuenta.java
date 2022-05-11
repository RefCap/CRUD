package com.anahuac.calidad.tareaUnitTest;

public class Cuenta {
	int balance;
	String holder;
    AlertListener alerts;

    public Cuenta( int initialBalance,String holder,AlertListener alerts){
        this.holder = holder;
        this.balance = initialBalance;
      
        this.alerts = alerts;
    }
    
    public int getBalance() {
        return this.balance;
    }
    
    public String getHolder(){
        return this.holder;
    }

    void debit(int balance) {
        this.balance -= balance;
        if(this.balance < 100){
            this.alerts.sendAlert(this.holder+", your account balance is below 100");
        }
    }

    void credit(int balance) {
        this.balance += balance;
    }
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
    public AlertListener getAlerts() {
		return alerts;
	}

	public void setAlerts(AlertListener alerts) {
		this.alerts = alerts;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

}
