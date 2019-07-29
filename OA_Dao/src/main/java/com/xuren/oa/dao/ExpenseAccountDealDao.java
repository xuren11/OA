package com.xuren.oa.dao;

import com.xuren.oa.entity.ExpenseAccountDeal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("expenseAccountDealDao")
public interface ExpenseAccountDealDao {
    void insert(ExpenseAccountDeal dealRecord);
    List<ExpenseAccountDeal> selectByExpenseAccount(int eaid);
}
