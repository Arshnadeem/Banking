package com.pay.arsh.services;

import com.pay.arsh.bean.User;

public interface UserService {
	public void login();
	
	public void checkAccount(User fromUser,User toUser);

	public void createAccount();

	public void Logout(User user);

	public void MyAccountDetail();

	public void AccountActivity();

	public void FundTransfer(int amount,int pin , User fromUser, User toUser);

	public void withdraw(User user);

	public void ChangePin(User user);
	
	public void createLog(User user,String msg);

}
