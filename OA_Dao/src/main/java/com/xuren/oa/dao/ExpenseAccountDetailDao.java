package com.xuren.oa.dao;

import com.xuren.oa.entity.ExpenseAccountDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("claimVoucherItemDao")
public interface ExpenseAccountDetailDao {
    void insert(ExpenseAccountDetail claimVoucherItem);
    void update(ExpenseAccountDetail claimVoucherItem);
    void delete(int id);
    List<ExpenseAccountDetail> selectByExpenseAccount(int cvid);
}
