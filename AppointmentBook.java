public class AppointmentBook {

    private boolean[][] isBooked;

    public AppointmentBook() {
        isBooked = new boolean[8][60];
    }

    // for testing part (a)
    private AppointmentBook(int period, boolean[] minutes) {
        isBooked = new boolean[8][60];
        isBooked[period-1] = minutes;
    }

    // for testing part (b)
    private AppointmentBook(boolean[][] allperiods) {
        isBooked = allperiods;
    }

    private boolean isMinuteFree(int period, int minute) {
        return !isBooked[period-1][minute];
    }

    private void reserveBlock(int period, int startMinute, int duration) {
        for(int i = 0; i < duration; i++) {
            isBooked[period-1][startMinute+i] = true;
        }
    }

    // part (a)
    public int findFreeBlock(int period, int duration) {
        for(int s = 0; s <= 60 - duration; s++) {
            int d;
            for(d=0; d < duration; d++)
                if(!isMinuteFree(period, s+d))
                    break;
            if(d == duration)
                return s;
        }
        return -1;
    }

    // part (b)
    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
        for(int p = startPeriod; p <= endPeriod; p++) {
            int firstFree = findFreeBlock(p, duration);
            if(firstFree != -1) {
                reserveBlock(p, firstFree, duration);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        //part (a) sample
        boolean[] bookedA = new boolean[60];
        for(int i = 0; i < 10; i++) bookedA[i] = true;
        for(int i = 15; i < 30; i++) bookedA[i] = true;
        for(int i = 45; i < 50; i++) bookedA[i] = true;
        AppointmentBook partA = new AppointmentBook(2, bookedA);
        int testA = partA.findFreeBlock(2, 15);
        if(testA != 30) System.err.println("Failed findFreeBlock(2, 15): " + testA);
        testA = partA.findFreeBlock(2, 9);
        if(testA != 30) System.err.println("Failed findFreeBlock(2, 9): " + testA);
        testA = partA.findFreeBlock(2, 20);
        if(testA != -1) System.err.println("Failed findFreeBlock(2, 9): " + testA);

        //part (b) sample
        boolean[][] bookedB = new boolean[8][60];
        for(int i = 0; i < 25; i++) bookedB[1][i] = true;
        for(int i = 30; i < 60; i++) bookedB[1][i] = true;
        for(int i = 15; i < 41; i++) bookedB[2][i] = true;
        for(int i = 0; i < 5; i++) bookedB[3][i] = true;
        for(int i = 30; i < 44; i++) bookedB[3][i] = true;
        AppointmentBook partB = new AppointmentBook(bookedB);
        boolean testB = partB.makeAppointment(2, 4, 22);
        if(!testB) System.err.println("Failed makeAppointment(2, 4, 22) return");
        for(int i = 5; i <= 26; i++) if(!partB.isBooked[3][i]) {System.err.println("Failed makeAppointment(2, 4, 22) effect at " + i); break;}
        testB = partB.makeAppointment(3, 4, 3);
        if(!testB) System.err.println("Failed makeAppointment(3, 4, 3) return");
        for(int i = 0; i <= 2; i++) if(!partB.isBooked[2][i]) {System.err.println("Failed makeAppointment(3, 4, 3) effect at " + i); break;}
        testB = partB.makeAppointment(2, 4, 30);
        if(testB) System.err.println("Failed makeAppointment(2, 4, 30) return");
    }
}
