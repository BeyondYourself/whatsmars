/**
 * Created by shenhongxi on 2017/12/4.
 */
package org.hongxi.whatsmars.dubbo.demo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import org.hongxi.whatsmars.dubbo.demo.api.DemoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }
    
}