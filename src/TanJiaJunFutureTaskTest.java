import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by TanJiaJun on 2020/8/30.
 */
class TanJiaJunFutureTaskTest {

    private static class TanJiaJunCallable implements Callable<String> {

        @Override
        public String call() {
            return "谭嘉俊";
        }

    }

    public static void main(String[] args) {
        // 创建FutureTask对象
        FutureTask<String> futureTask = new FutureTask<>(new TanJiaJunCallable());
        // 创建线程
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            // 等待任务执行完毕，并且得到返回值
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}