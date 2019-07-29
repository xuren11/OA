package com.xuren.oa.controller;

import com.xuren.oa.dto.ExpenseAccountInfo;
import com.xuren.oa.entity.Employee;
import com.xuren.oa.entity.ExpenseAccountDeal;
import com.xuren.oa.service.ExpenseAccountService;
import constant.ConstantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("claimVoucherController")
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {
    @Autowired
    private ExpenseAccountService expenseAccountService;
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("items", ConstantType.getItems());
        map.put("info",new ExpenseAccountInfo());
        return "claim_voucher_add";
    }
    @RequestMapping("/add")
    public String add(HttpSession session, ExpenseAccountInfo info){
        Employee employee = (Employee)session.getAttribute("employee");
        info.getExpenseAccount().setCreateSn(employee.getSn());
        expenseAccountService.save(info.getExpenseAccount(),info.getItems());
        return "redirect:deal";
    }
    @RequestMapping("/detail")
    public String detail(int id, Map<String,Object> map){
        map.put("claimVoucher",expenseAccountService.get(id));
        map.put("items",expenseAccountService.getItems(id));
        map.put("records",expenseAccountService.getRecords(id));
        return "claim_voucher_detail";
    }
    @RequestMapping("/self")
    public String self(HttpSession session, Map<String,Object> map){
        Employee employee = (Employee)session.getAttribute("employee");
        map.put("list",expenseAccountService.getForSelf(employee.getSn()));
        return "claim_voucher_self";
    }
    @RequestMapping("/deal")
    public String deal(HttpSession session, Map<String,Object> map){
        Employee employee = (Employee)session.getAttribute("employee");
        map.put("list",expenseAccountService.getForDeal(employee.getSn()));
        return "claim_voucher_deal";
    }

    @RequestMapping("/to_update")
    public String toUpdate(int id,Map<String,Object> map){
        map.put("items", ConstantType.getItems());
        ExpenseAccountInfo info =new ExpenseAccountInfo();
        info.setExpenseAccount(expenseAccountService.get(id));
        info.setItems(expenseAccountService.getItems(id));
        map.put("info",info);
        return "claim_voucher_update";
    }
    @RequestMapping("/update")
    public String update(HttpSession session, ExpenseAccountInfo info){
        Employee employee = (Employee)session.getAttribute("employee");
        info.getExpenseAccount().setCreateSn(employee.getSn());
        expenseAccountService.update(info.getExpenseAccount(),info.getItems());
        return "redirect:deal";
    }
    @RequestMapping("/submit")
    public String submit(int id){
        expenseAccountService.submit(id);
        return "redirect:deal";
    }

    @RequestMapping("/to_check")
    public String toCheck(int id,Map<String,Object> map){
        map.put("claimVoucher",expenseAccountService.get(id));
        map.put("items",expenseAccountService.getItems(id));
        map.put("records",expenseAccountService.getRecords(id));
        ExpenseAccountDeal dealRecord =new ExpenseAccountDeal();
        dealRecord.setExpenseAccountId(id);
        map.put("record",dealRecord);
        return "claim_voucher_check";
    }
    @RequestMapping("/check")
    public String check(HttpSession session, ExpenseAccountDeal dealRecord){
        Employee employee = (Employee)session.getAttribute("employee");
        dealRecord.setDealSn(employee.getSn());
        expenseAccountService.deal(dealRecord);
        return "redirect:deal";
    }
}
