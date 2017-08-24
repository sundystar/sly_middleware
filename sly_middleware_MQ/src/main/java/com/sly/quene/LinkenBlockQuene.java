package com.sly.quene;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkenBlockQuene {

	private LinkedBlockingDeque<String> basket = new LinkedBlockingDeque<String>();
	
	public void produce() throws InterruptedException{
		basket.put("An apple");
	}
	
	public String getResult() throws InterruptedException{
		return basket.take();
	}
	
	class Producer implements Runnable{
		private String instance;
		private LinkenBlockQuene basket;
		
		public Producer(String instance,LinkenBlockQuene basket){
			this.instance=instance;
			this.basket=basket;
		}
		
		public void run() {
			while(true){
				System.err.println("生产者准备是国内产"+instance);
				try {
					basket.produce();
					System.err.println("生产者生产一个苹果"+instance);
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	class Consumer   implements Runnable{

		private String instance;
        private LinkenBlockQuene basket; 
        public Consumer(String instance, LinkenBlockQuene basket) {
            this.instance = instance;
            this.basket = basket;
        }
		public void run() {
			 try {
	                while (true) {
	                    // 消费苹果
	                    System.out.println("消费者准备消费苹果：" + instance);
	                    System.out.println(basket.getResult());
	                    System.out.println("!消费者消费苹果完毕：" + instance);
	                    // 休眠1000ms
	                    Thread.sleep(1000);
	                }
	            } catch (InterruptedException ex) {
	                System.out.println("Consumer Interrupted");
	            }
			
		}
		
	}
	
	
	  public static void main(String[] args) {

	        // 建立一个装苹果的篮子
		  LinkenBlockQuene basket = new LinkenBlockQuene();

	        ExecutorService service = Executors.newCachedThreadPool();
	        Producer producer = basket.new Producer("生产者001", basket);
	        Producer producer2 = basket.new Producer("生产者002", basket);
	        Consumer consumer = basket.new Consumer("消费者001", basket);
	        service.submit(producer);
	        service.submit(producer2);
	        service.submit(consumer);

	    }
	
}
