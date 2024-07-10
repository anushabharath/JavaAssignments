package jsp;

public class Job implements Comparable<Job> {
    char id;
    int deadLine;
    int profit;

    public Job(char id, int deadLine, int profit) {
        this.id = id;
        this.deadLine = deadLine;
        this.profit = profit;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public int getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(int deadLine) {
        this.deadLine = deadLine;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public int compareTo(Job other) {
        // Sort in descending order of profit
        return other.profit - this.profit;
    }
}
