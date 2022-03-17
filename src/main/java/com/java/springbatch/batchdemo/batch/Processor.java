package com.java.springbatch.batchdemo.batch;

import com.java.springbatch.batchdemo.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {
    private static final Map<String, String> DEPT_NAMES = new HashMap<>();

    public Processor(){
        DEPT_NAMES.put("110", "Technology");
        DEPT_NAMES.put("120", "Operations");
        DEPT_NAMES.put("130", "Accounts");
        DEPT_NAMES.put("140", "Business");
    }
    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDept();
        String dept = DEPT_NAMES.get(deptCode);
        user.setDept(dept);
        user.setTime(new Date());
        System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
        return user;
    }
}
