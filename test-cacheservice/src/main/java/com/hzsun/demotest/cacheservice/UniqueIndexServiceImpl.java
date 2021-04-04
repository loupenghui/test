package com.hzsun.demotest.cacheservice;

import com.hzsun.demotest.cacheservice.api.UniqueIndexService;
import com.hzsun.demotest.commons.factorys.SnowflakeIdFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月17日  
**/
@Service
public class UniqueIndexServiceImpl implements UniqueIndexService {
    @Value(value = "${service.datacenter}")
    private  int dataCenter;
    @Value(value = "${service.serviceid}")
    private  int serviceId;
    
    private static SnowflakeIdFactory uniquefactory;
    @Override
    public String getUniqueIndex() {
            //TODO  
            if(uniquefactory==null){
                synchronized(UniqueIndexServiceImpl.class){
                    if(uniquefactory==null){
                        uniquefactory=new SnowflakeIdFactory(serviceId,dataCenter);
                    }
                }
            }
            return uniquefactory.nextId();  
            
    }

}
  
    