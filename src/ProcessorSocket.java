import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

class ProcessorSocket {

    void check() {
        Scanner in = new Scanner(System.in);

        int bufferSize = in.nextInt();
        int n = in.nextInt();

        Socket[] sockets = new Socket[n];
        LinkedList<Socket> timeQueue = new LinkedList<>();

        for (int i = 0; i<n; i++) {
            sockets[i] = new Socket(i, in.nextInt(), in.nextInt());

            if (timeQueue.isEmpty()) {
                sockets[i].finishTime = sockets[i].arrival + sockets[i].duration;
                timeQueue.add(sockets[i]);
            }
            else if (timeQueue.size() < bufferSize) {
                int currentProcessingTime = timeQueue.getLast().finishTime;
                sockets[i].finishTime = currentProcessingTime
                        + ((currentProcessingTime >= sockets[i].arrival) ? 0 : sockets[i].arrival - currentProcessingTime)
                        + sockets[i].duration;
                timeQueue.addLast(sockets[i]);
            }
            else if (timeQueue.size() == bufferSize) {
                if (sockets[i].arrival < timeQueue.getFirst().finishTime)
                    sockets[i].finishTime = -1;
                else {
                    int currentProcessingTime = timeQueue.getLast().finishTime;
                    sockets[i].finishTime = currentProcessingTime
                            + ((currentProcessingTime >= sockets[i].arrival) ? 0 : sockets[i].arrival - currentProcessingTime)
                            + sockets[i].duration;
                    timeQueue.removeFirst();
                    timeQueue.addLast(sockets[i]);
                }
            }
        }

        Arrays.stream(sockets).forEach(s -> System.out.println("Socket " + s.number + ": " + s.finishTime));

        System.out.println();

        Arrays.stream(sockets).forEach(s -> {
            if (s.finishTime != -1) {
                System.out.println(s.finishTime - s.duration);
            }
            else
                System.out.println(s.finishTime);
        });
    }

    private class Socket {

        int number;
        int arrival;
        int duration;
        int finishTime;

        Socket(int number, int arrival, int duration) {
            this.number = number;
            this.arrival = arrival;
            this.duration = duration;
        }
    }
}