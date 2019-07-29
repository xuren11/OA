package com.xuren.oa.service;

import com.xuren.oa.entity.ExpenseAccount;
import com.xuren.oa.entity.ExpenseAccountDeal;
import com.xuren.oa.entity.ExpenseAccountDetail;

import java.util.List;

public interface ExpenseAccountService {

    void save(ExpenseAccount expenseAccount, List<ExpenseAccountDetail> items);

    ExpenseAccount get(int id);
    List<ExpenseAccountDetail> getItems(int eaid);
    List<ExpenseAccountDeal> getRecords(int eaid);

    List<ExpenseAccount> getForSelf(String sn);
    List<ExpenseAccount> getForDeal(String sn);

    void update(ExpenseAccount expenseAccount, List<ExpenseAccountDetail> items);
    void submit(int id);
    void deal(ExpenseAccountDeal ExpenseAccountDeal);
}
