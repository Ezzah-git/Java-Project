public class TimerThread extends Thread {
    boolean timeUp = false;

    public void run() {
        try {
            Thread.sleep(30000); // 30 seconds for each puzzle
            timeUp = true;
        } catch (InterruptedException e) {
            System.out.println("Timer interrupted.");
        }
    }
}

