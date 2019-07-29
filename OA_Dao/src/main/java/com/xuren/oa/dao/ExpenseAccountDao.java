package com.xuren.oa.dao;

import com.xuren.oa.entity.ExpenseAccount;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("expenseAccountDao")
public interface ExpenseAccountDao {
    void insert(ExpenseAccount claimVoucher);
    void update(ExpenseAccount claimVoucher);
    void delete(int id);
    ExpenseAccount select(int id);
    List<ExpenseAccount> selectByCreateSn(String csn);
    List<ExpenseAccount> selectByNextDealSn(String ndsn);
}
