import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Query extends Line  {

    Date start;
    Date end;

    Query(String string) {
        super(string);
        String[] mas = string.split(" ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        if (mas[4].contains("-")) {
            String[] dates;
            dates = mas[4].split("-");
            try {
                start = sdf.parse(dates[0]);
                end = sdf.parse(dates[1]);
            } catch (ParseException e) {e.printStackTrace();}
        } else {
            try {
                start = sdf.parse(mas[4]);
                end = sdf.parse(mas[4]);
            } catch (Exception e) {e.printStackTrace();}
        }
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

}

