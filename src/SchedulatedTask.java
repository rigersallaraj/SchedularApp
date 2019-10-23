
import java.util.TimerTask;

public class SchedulatedTask extends TimerTask {

  private String name;

  public SchedulatedTask(String n) {
    this.name = n;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " " + name + " the task has executed successfully ");
  }
}
