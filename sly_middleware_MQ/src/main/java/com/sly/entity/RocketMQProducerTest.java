package com.sly.entity;
import com.alibaba.rocketmq.common.message.Message;  
  
/** 
 * Created by zhangzh on 2017/2/10. 
 */  
public class RocketMQProducerTest {  
  
    public static void main(String[] args) {  
  
        String mqNameServer = "10.0.0.33:9876";  
        String mqTopics = "MQ-MSG-TOPICS-TEST";  
  
        String producerMqGroupName = "CONSUMER-MQ-GROUP";  
        RocketMqService mqProducer = new RocketMqService(mqNameServer, producerMqGroupName, mqTopics);  
        mqProducer.init();  
  
  
        for (int i = 0; i < 5; i++) {  
  
            Message message = new Message();  
            message.setBody(("I send message to RocketMQ " + i).getBytes());  
            mqProducer.send(message);  
        }  
  
  
    }  
  
}  