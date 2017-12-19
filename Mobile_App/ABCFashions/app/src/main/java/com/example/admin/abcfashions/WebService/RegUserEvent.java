package com.example.admin.abcfashions.WebService;

import com.example.admin.abcfashions.WebService.pojo.Reg_User;
import com.example.admin.abcfashions.WebService.pojo.User;

/**
 * Created by admin on 12/17/17.
 */

public class RegUserEvent {

    private Reg_User reg_user;

    public Reg_User getReg_user() {
        return reg_user;
    }

    public void setReg_user(Reg_User reg_user) {
        this.reg_user = reg_user;
    }

    public RegUserEvent(Reg_User reg_user) {
        this.reg_user = reg_user;
    }
}
