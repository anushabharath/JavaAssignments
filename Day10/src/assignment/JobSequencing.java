package assignment;

import java.util.*;

public class JobSequencing {

    public static List<Job> jobSequencing(List<Job> jobs) {
        // Sort jobs by profit in descending order
        jobs.sort((a, b) -> b.profit - a.profit);

        // Find the maximum deadline to size the time slots array
        int maxDeadline = jobs.stream().mapToInt(job -> job.deadline).max().orElse(0);

        // Array to keep track of free time slots (0-based indexing)
        Job[] timeSlots = new Job[maxDeadline];

        // Iterate through all given jobs
        for (Job job : jobs) {
            // Find a free time slot for this job (starting from the last possible slot)
            for (int j = job.deadline - 1; j >= 0; j--) {
                if (timeSlots[j] == null) {
                    // Assign this job to the free time slot
                    timeSlots[j] = job;
                    break;
                }
            }
        }

        // Collect the scheduled jobs
        List<Job> result = new ArrayList<>();
        for (Job job : timeSlots) {
            if (job != null) {
                result.add(job);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 2, 100));
        jobs.add(new Job(2, 1, 19));
        jobs.add(new Job(3, 2, 27));
        jobs.add(new Job(4, 1, 25));
        jobs.add(new Job(5, 3, 15));

        List<Job> result = jobSequencing(jobs);

        System.out.println("The maximum profit sequence of jobs is:");
        for (Job job : result) {
            System.out.println(job);
        }
    }
}

