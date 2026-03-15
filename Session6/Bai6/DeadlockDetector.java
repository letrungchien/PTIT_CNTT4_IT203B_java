package Session6.Bai6;

import java.lang.management.*;

public class DeadlockDetector implements Runnable {

    @Override
    public void run() {

        ThreadMXBean bean =
                ManagementFactory.getThreadMXBean();

        while (true) {

            long[] ids = bean.findDeadlockedThreads();

            if (ids != null) {

                System.out.println("DEADLOCK PHÁT HIỆN!");

                ThreadInfo[] infos =
                        bean.getThreadInfo(ids);

                for (ThreadInfo info : infos) {
                    System.out.println(info);
                }

            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
