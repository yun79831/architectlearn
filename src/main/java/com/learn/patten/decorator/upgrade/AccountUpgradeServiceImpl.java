package com.learn.patten.decorator.upgrade;

import com.learn.patten.decorator.old.AccountService;

/**
 * Created by ghost on 2018-03-21.
 */
public class AccountUpgradeServiceImpl implements AccountUpgradeService {
    private AccountService accountService;

    public AccountUpgradeServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    public void login() {
        accountService.login();
    }

    public void register() {
        accountService.register();
    }

    public void registerOrLogin() {
        System.out.println("注册或者登录成功");
    }

    public void pay() {
        System.out.println("支付成功");
    }
}
