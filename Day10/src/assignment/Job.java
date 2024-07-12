package assignment;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}
