import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Query  {
    String serv;
    String type;
    String pn;
    Date start;
    Date end;

    Query(String string) {
        String[] mas = string.split(" ");
        serv = mas[1];
        type = mas[2];
        pn = mas[3];
        if (mas[4].contains("-")) {
            String[] dates = new String[2];
            dates = mas[4].split("-");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                start = sdf.parse(dates[0]);
                end = sdf.parse(dates[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

                start = sdf.parse(mas[4]);
                end = sdf.parse(mas[4]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public String getServ() {
        return serv;
    }


    public String getType() {
        return type;
    }


    public String getPn() {
        return pn;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

}

