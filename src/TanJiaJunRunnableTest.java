/**
 * Created by TanJiaJun on 2020/8/30.
 */
class TanJiaJunRunnableTest {

    private static class TanJiaJunRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("谭嘉俊");
        }

    }

    public static void main(String[] args) {
        // 创建TanJiaJunRunnable对象
        TanJiaJunRunnable runnable = new TanJiaJunRunnable();
        // 创建线程
        Thread thread = new Thread(runnable);
        // 启动线程
        thread.start();
    }

}