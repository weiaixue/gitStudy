package cn.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableThreadTest implements Callable<Integer>{
	public static void main(String[] args) {
		Callable<Integer> callableThread = new CallableThreadTest();
		FutureTask<Integer> ft = new FutureTask<>(callableThread);
		for(int i = 0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+i);
			if(i==20) {
				new Thread(ft,"含返回值的线程").start();
			}
		}
		try {
			System.out.println(ft.get());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Integer call() throws Exception {
		int i = 0;
		for(;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+i);			
		}
		return i;
	}

}
