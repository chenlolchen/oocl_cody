package com.oocl.service.impl;

import com.oocl.service.WorkService;
import org.springframework.stereotype.Component;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Component(value = "ws")
public class WorkServiceImpl implements WorkService {
    public void work(String s) {
        System.out.println("work: " + s);
    }
}
