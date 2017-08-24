package com.sly.mq;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class TestLKist {

	public static void main(String[] args) {
        AtomicLong consumeTimes = new AtomicLong(0);
        consumeTimes.incrementAndGet();
        System.err.println(consumeTimes.get()%2);
	}
	
}
