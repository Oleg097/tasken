import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitingTimeLine extends Line {

    Date wtlDate;
    Integer min;

    WaitingTimeLine(String string) {
        super(string);
        String [] mas=string.split(" ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            wtlDate = sdf.parse(mas[4]);
        }catch (ParseException e){e.printStackTrace();}
        min =Integer.parseInt(mas[5]);
    }

    public Date getWtlDate() {return wtlDate;}

    public Integer getMin() {return min;}
}



