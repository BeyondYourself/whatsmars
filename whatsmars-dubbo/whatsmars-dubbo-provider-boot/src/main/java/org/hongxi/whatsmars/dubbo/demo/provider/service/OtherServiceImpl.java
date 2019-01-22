/**
 * Created by shenhongxi on 2017/12/4.
 */
package org.hongxi.whatsmars.dubbo.demo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import org.hongxi.whatsmars.dubbo.demo.api.OtherService;
import org.hongxi.whatsmars.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service(registry = "otherRegistry")
public class OtherServiceImpl implements OtherService {

    @Autowired
    private UserService userService;

    public String sayHello(String name) {
        boolean registerSuccess = userService.register(name);
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", registerSuccess:" + registerSuccess + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }
    
}