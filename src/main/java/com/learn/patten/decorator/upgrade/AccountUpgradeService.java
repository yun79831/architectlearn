package com.learn.patten.decorator.upgrade;

import com.learn.patten.decorator.old.AccountService;

/**
 * 功能增强 添加
 * Created by ghost on 2018-03-21.
 */
public interface AccountUpgradeService extends AccountService {
    //注册登录
    void registerOrLogin();

    void pay();
}
