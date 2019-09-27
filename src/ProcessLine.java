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

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        List<WaitingTimeLine> waitingTimeLines = new ArrayList<>();
        List<Query> queries = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        scanner.forEachRemaining(s->strings.add(s));
        strings.stream().filter(s->s.startsWith("D")).forEach((s -> queries.add(new Query(s))));
        strings.stream().filter(s->s.startsWith("C")).forEach((s->waitingTimeLines.add(new WaitingTimeLine(s))));
        queries.stream().map((s)->new ProcessLine().apply(s,waitingTimeLines)).forEach(System.out::print);

    }
}












