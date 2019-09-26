import java.util.*;
import java.util.function.*;

public class ProcessLine implements BiFunction<Query,List<WaitingTimeLine>,String> {

    public String apply(Query q, List<WaitingTimeLine> w) {

        int count = 0;
        int interCount = 0;
        for (WaitingTimeLine wtl : w) {
            if (((wtl.getServ().contains(q.getServ()) || q.getServ().equals("*"))) &&
                    (wtl.getType().contains(q.getType()) || q.getType().contains("*")) &&
                    wtl.getPn().contains(q.getPn()) &&
                    !q.getStart().after(wtl.getWtlDate()) && !q.getEnd().before(wtl.getWtlDate())) {
                count+= wtl.getMin();
                interCount+=1;
            }
        }
        return interCount != 0 ? (count/interCount) + "\n" : "-" + "\n";
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner("7" + "\n" +
                "7" + "\n" +

                "C 1.1 8.15.1 P 15.10.2012 83" + "\n" +
                "C 1.1 8.15.1 P 15.10.2012 83" + "\n" +
                "C 1.1 8.15.1 P 15.10.2012 83" + "\n" +
                "C 1.1 8.15.1 P 15.10.2012 83" + "\n" +
                "C 1.1 8.15.1 P 15.10.2012 83" + "\n" +
                "C 1 10.1 P 01.12.2012 65" + "\n" +
                "C 1.1 5.5.1 P 01.11.2012 117" + "\n" +
                "C 1.1 5.5.1 P 01.11.2012 117" + "\n" +
                "D 1.1 8 P 01.01.2012-01.12.2012" + "\n" +
                "C 3 10.2 N 02.10.2012 100" + "\n" +
                "D 1 * P 8.10.2012-20.11.2012" + "\n" +
                "D 3.1 10.15 P 01.12.2012").useDelimiter("\n");


        List<WaitingTimeLine> waitingTimeLines = new ArrayList<>();
        List<Query> queries = new ArrayList<>();
        List<String> strings = new ArrayList<>();



        scanner.forEachRemaining(s->strings.add(s));
        strings.stream().filter(s->s.startsWith("D")).forEach((s -> queries.add(new Query(s))));
        strings.stream().filter(s->s.startsWith("C")).forEach((s->waitingTimeLines.add(new WaitingTimeLine(s))));
        queries.stream().map((s)->new ProcessLine().apply(s,waitingTimeLines)).forEach(System.out::print);


    }
}












