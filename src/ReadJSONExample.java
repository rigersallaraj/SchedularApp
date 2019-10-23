import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample {

  public static void main(String[] args) {
    JSONParser jsonParser = new JSONParser();

    try (FileReader reader = new FileReader("tasks.json")) {

      Object obj = jsonParser.parse(reader);

      JSONArray tasksList = (JSONArray) obj;
      System.out.println(tasksList);

      tasksList.forEach(task -> parseTasksObject((JSONObject) task));

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  private static void parseTasksObject(JSONObject task) {

    JSONObject taskObject = (JSONObject) task.get("task");

    Calendar date = Calendar.getInstance();
    date.set(Calendar.HOUR, 7);
    date.set(Calendar.MINUTE,0 );
    date.set(Calendar.SECOND, 0);
    date.set(Calendar.MILLISECOND, 0);

    String taskName = (String) taskObject.get("name");
    boolean daily = (Boolean) taskObject.get("daily");
    boolean weekly = (Boolean) taskObject.get("weekly");
    boolean repeated = (Boolean) taskObject.get("repeated");

    Timer timer = new Timer();

 /*   if (daily){
    //  timer.scheduleAtFixedRate( new SchedulatedTask(taskName), date.getTime(), 1000 * 60 * 60 * 24   );
      timer.scheduleAtFixedRate( new SchedulatedTask(taskName), 0, 1000  );
    }*/

    if (weekly){
   //   timer.scheduleAtFixedRate( new SchedulatedTask(taskName), date.getTime(), 1000 * 60 * 60 * 24 * 7   );
   //   timer.scheduleAtFixedRate( new SchedulatedTask(taskName), 0, 5000  );
      timer.scheduleAtFixedRate( new SchedulatedTask(taskName), 0, 5000  );

    }



  }
}
