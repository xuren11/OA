package com.xuren.oa.dto;


import com.xuren.oa.entity.ExpenseAccount;
import com.xuren.oa.entity.ExpenseAccountDetail;

import java.util.List;

public class ExpenseAccountInfo {
    private ExpenseAccount expenseAccount;
    private List<ExpenseAccountDetail> items;

    public ExpenseAccount getExpenseAccount() {
        return expenseAccount;
    }

    public void setExpenseAccount(ExpenseAccount expenseAccount) {
        this.expenseAccount = expenseAccount;
    }

    public List<ExpenseAccountDetail> getItems() {
        return items;
    }

    public void setItems(List<ExpenseAccountDetail> items) {
        this.items = items;
    }
}
