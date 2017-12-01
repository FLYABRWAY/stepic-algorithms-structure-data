import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class ProcessorSocket {

    void check() {
        Scanner in = new Scanner(System.in);

        int bufferSize = in.nextInt();
        int n = in.nextInt();

        Socket[] sockets = new Socket[n];

        LinkedList<Integer> timeQueue = new LinkedList<>();

        for (int i = 0; i<n; i++) {
            sockets[i] = new Socket(i, in.nextInt(), in.nextInt());


        }

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