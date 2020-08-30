package producerconsumerproblem;

/**
 * Created by TanJiaJun on 2020/8/30.
 */
class ProducerConsumerProblemTest {

    // 生产者线程
    private static class Producer implements Runnable {

        private Repository repository;

        Producer(Repository repository) {
            this.repository = repository;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // 让生产者线程睡眠一秒
                    Thread.sleep(1000);
                    // 调用存储库的produce()方法，生产者生产产品
                    repository.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

    }

    // 消费者线程
    private static class Consumer implements Runnable {

        private Repository repository;

        Consumer(Repository repository) {
            this.repository = repository;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // 让消费者线程睡眠三秒
                    Thread.sleep(3000);
                    // 调用存储库的consume()方法，消费者消费产品
                    repository.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        // 创建存储库
        Repository repository = new Repository();

        // 创建三个生产者线程，并且让它们运行
        for (int i = 0; i < 3; i++) {
            new Thread(new Producer(repository)).start();
        }

        // 创建三个消费者线程，并且让它们运行
        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(repository)).start();
        }
    }

}