package producerconsumerproblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by TanJiaJun on 2020/8/30.
 */
class Repository {

    // 队列的最大容量是10
    private static final int MAX_SIZE = 10;
    // 创建队列
    private final Queue<Object> queue = new LinkedList<>();

    void produce() {
        // 使用关键字synchronized修饰代码块，取Queue对象作为锁对象
        synchronized (queue) {
            while (queue.size() == MAX_SIZE) {
                try {
                    System.out.println("生产者（线程名字：" + Thread.currentThread().getName() + "）：存储库已满");
                    // 当队列满了后，调用变量queue的wait()方法，生产者线程进入等待状态，并且释放Queue对象的监视器锁
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 如果队列还没满，就创建新的Object对象，并且在队尾入列
            queue.offer(new Object());
            System.out.println("生产者（线程名字：" + Thread.currentThread().getName() + "）：生产了一个产品");
            // 通知其他生产者线程和消费者线程
            queue.notifyAll();
        }
    }

    void consume() {
        // 使用关键字synchronized修饰代码块，取Queue对象作为锁对象
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    System.out.println("消费者（线程名字：" + Thread.currentThread().getName() + "）：存储库是空");
                    // 当队列空了后，调用变量queue的wait()方法，消费者线程进入等待状态，并且释放Queue对象的监视器锁
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 如果队列存在元素，就将队头元素出列
            queue.poll();
            System.out.println("消费者（线程名字：" + Thread.currentThread().getName() + "）：消费了一个产品");
            // 通知其他消费者线程和生产者线程
            queue.notifyAll();
        }
    }

}