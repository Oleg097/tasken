import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitingTimeLine  {
    String serv;
    String type;
    String pn;
    Date wtlDate;
    Integer min;

    WaitingTimeLine(String string) {
        String[] mas = string.split(" ");
        serv = mas[1];
        type = mas[2];
        pn = mas[3];

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            wtlDate = sdf.parse(mas[4]);
        }catch (ParseException e){e.printStackTrace();}

        min =Integer.parseInt(mas[5]);

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

    public Date getWtlDate() {
        return wtlDate;
    }

    public Integer getMin() {
        return min;
    }


}



