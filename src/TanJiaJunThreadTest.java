/**
 * Created by TanJiaJun on 2020/8/30.
 */
class TanJiaJunThreadTest {

    private static class TanJiaJunThread extends Thread {

        @Override
        public void run() {
            super.run();
            System.out.println("谭嘉俊");
        }

    }

    public static void main(String[] args) {
        // 创建线程
        TanJiaJunThread thread = new TanJiaJunThread();
        // 启动线程
        thread.start();
    }

}