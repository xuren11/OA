package com.xuren.oa.service.impl;


import com.xuren.oa.dao.EmployeeDao;
import com.xuren.oa.dao.ExpenseAccountDao;
import com.xuren.oa.dao.ExpenseAccountDealDao;
import com.xuren.oa.dao.ExpenseAccountDetailDao;
import com.xuren.oa.entity.Employee;
import com.xuren.oa.entity.ExpenseAccount;
import com.xuren.oa.entity.ExpenseAccountDeal;
import com.xuren.oa.entity.ExpenseAccountDetail;
import constant.ConstantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xuren.oa.service.ExpenseAccountService;

import java.util.Date;
import java.util.List;

@Service("expenseAccountService")
public class ExpenseAccountServiceImpl implements ExpenseAccountService {
    @Autowired
    private ExpenseAccountDao expenseAccountDao;
    @Autowired
    private ExpenseAccountDetailDao expenseAccountDetailDao;
    @Autowired
    private ExpenseAccountDealDao expenseAccountDealDao;
    @Autowired
    private EmployeeDao employeeDao;

    public void save(ExpenseAccount expenseAccount, List<ExpenseAccountDetail> items) {
        expenseAccount.setCreateTime(new Date());
        expenseAccount.setNextDealSn(expenseAccount.getCreateSn());
        expenseAccount.setStatus(ConstantType.EXPENSEACCOUNT_CREATED);
        expenseAccountDao.insert(expenseAccount);

        for(ExpenseAccountDetail item:items){
            item.setExpenseAccountId(expenseAccount.getId());
            expenseAccountDetailDao.insert(item);
        }
    }

    public ExpenseAccount get(int id) {
        return expenseAccountDao.select(id);
    }

    public List<ExpenseAccountDetail> getItems(int eaid) {
        return expenseAccountDetailDao.selectByExpenseAccount(eaid);
    }

    public List<ExpenseAccountDeal> getRecords(int eaid) {
        return expenseAccountDealDao.selectByExpenseAccount(eaid);
    }

    public List<ExpenseAccount> getForSelf(String sn) {
        return expenseAccountDao.selectByCreateSn(sn);
    }

    public List<ExpenseAccount> getForDeal(String sn) {
        return expenseAccountDao.selectByNextDealSn(sn);
    }

    public void update(ExpenseAccount expenseAccount, List<ExpenseAccountDetail> items) {
        expenseAccount.setNextDealSn(expenseAccount.getCreateSn());
        expenseAccount.setStatus(ConstantType.EXPENSEACCOUNT_CREATED);
        expenseAccountDao.update(expenseAccount);

        List<ExpenseAccountDetail> olds = expenseAccountDetailDao.selectByExpenseAccount(expenseAccount.getId());
        for(ExpenseAccountDetail old:olds){
            boolean isHave=false;
            for(ExpenseAccountDetail item:items){
                if(item.getId()==old.getId()){
                    isHave=true;
                    break;
                }
            }
            if(!isHave){
                expenseAccountDetailDao.delete(old.getId());
            }
        }
        for(ExpenseAccountDetail item:items){
            item.setExpenseAccountId(expenseAccount.getId());
            if(item.getId()>0){
                expenseAccountDetailDao.update(item);
            }else{
                expenseAccountDetailDao.insert(item);
            }
        }

    }

    public void submit(int id) {
        ExpenseAccount expenseAccount = expenseAccountDao.select(id);
        Employee employee = employeeDao.select(expenseAccount.getCreateSn());

        expenseAccount.setStatus(ConstantType.EXPENSEACCOUNT_SUBMIT);
        expenseAccount.setNextDealSn(employeeDao.selectByDepartmentAndPost(employee.getDepartmentSn(),ConstantType.POST_FM).get(0).getSn());
        expenseAccountDao.update(expenseAccount);

        ExpenseAccountDeal expenseAccountDeal = new ExpenseAccountDeal();
        expenseAccountDeal.setDealWay(ConstantType.DEAL_SUBMIT);
        expenseAccountDeal.setDealSn(employee.getSn());
        expenseAccountDeal.setExpenseAccountId(id);
        expenseAccountDeal.setDealResult(ConstantType.EXPENSEACCOUNT_SUBMIT);
        expenseAccountDeal.setDealTime(new Date());
        expenseAccountDeal.setComment("无");
        expenseAccountDealDao.insert(expenseAccountDeal);
    }

    public void deal(ExpenseAccountDeal expenseAccountDeal) {
        ExpenseAccount expenseAccount = expenseAccountDao.select(expenseAccountDeal.getExpenseAccountId());
        Employee employee = employeeDao.select(expenseAccountDeal.getDealSn());
        expenseAccountDeal.setDealTime(new Date());

        if(expenseAccountDeal.getDealWay().equals(ConstantType.DEAL_PASS)){
            if(expenseAccount.getTotalAmount()<=ConstantType.LIMIT_CHECK || employee.getPost().equals(ConstantType.POST_GM)){
                expenseAccount.setStatus(ConstantType.EXPENSEACCOUNT_APPROVED);
                expenseAccount.setNextDealSn(employeeDao.selectByDepartmentAndPost(null,ConstantType.POST_CASHIER).get(0).getSn());

                expenseAccountDeal.setDealResult(ConstantType.EXPENSEACCOUNT_APPROVED);
            }else{
                expenseAccount.setStatus(ConstantType.EXPENSEACCOUNT_RECHECK);
                expenseAccount.setNextDealSn(employeeDao.selectByDepartmentAndPost(null,ConstantType.POST_GM).get(0).getSn());

                expenseAccountDeal.setDealResult(ConstantType.EXPENSEACCOUNT_RECHECK);
            }
        }else if(expenseAccountDeal.getDealWay().equals(ConstantType.DEAL_BACK)){
            expenseAccount.setStatus(ConstantType.EXPENSEACCOUNT_BACK);
            expenseAccount.setNextDealSn(expenseAccount.getCreateSn());

            expenseAccountDeal.setDealResult(ConstantType.EXPENSEACCOUNT_BACK);
        }else if(expenseAccountDeal.getDealWay().equals(ConstantType.DEAL_REJECT)){
            expenseAccount.setStatus(ConstantType.EXPENSEACCOUNT_TERMINATED);
            expenseAccount.setNextDealSn(null);

            expenseAccountDeal.setDealResult(ConstantType.EXPENSEACCOUNT_TERMINATED);
        }else if(expenseAccountDeal.getDealWay().equals(ConstantType.DEAL_PAID)){
            expenseAccount.setStatus(ConstantType.EXPENSEACCOUNT_PAID);
            expenseAccount.setNextDealSn(null);

            expenseAccountDeal.setDealResult(ConstantType.EXPENSEACCOUNT_PAID);
        }

        expenseAccountDao.update(expenseAccount);
        expenseAccountDealDao.insert(expenseAccountDeal);
    }

}
