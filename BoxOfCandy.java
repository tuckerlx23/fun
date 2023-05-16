public class BoxOfCandy {

    private Candy[][] box;

    public BoxOfCandy(Candy[][] arr) {
        box = arr;
    }

    // part (a)
    public boolean moveCandyToFirstRow(int col) {
        if(box[0][col] != null)
            return true;

        for(int i = 1; i < box.length; i++) {
            if(box[i][col] != null) {
                box[0][col] = box[i][col];
                box[i][col] = null;
                return true;
            }
        }
        return false;
    }

    //part (b)

    public Candy removeNextByFlavor(String flavor) {
        for(int r = box.length-1; r >= 0; r--) {
            for(int c = 0; c < box[r].length; c++) {
                if(box[r][c] != null && box[r][c].getFlavor().equals(flavor)) {
                    Candy candy = box[r][c];
                    box[r][c] = null;
                    return candy;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Candy[][] candies = new Candy[4][3];
        candies[0][1] = new Candy("lime");
        candies[1][1] = new Candy("orange");
        candies[2][2] = new Candy("cherry");
        candies[3][1] = new Candy("lemon");
        candies[3][2] = new Candy("grape");
        BoxOfCandy b = new BoxOfCandy(candies);
        boolean mTest = b.moveCandyToFirstRow(0);
        if(mTest != false) System.err.println("Failed moveCandyToFirstRow(0) return");
        if(b.box[0][0] != null) System.err.println("Failed moveCandyToFirstRow(0) effect: " + b.box[0][0].getFlavor());
        mTest = b.moveCandyToFirstRow(1);
        if(mTest != true) System.err.println("Failed moveCandyToFirstRow(1) return");
        if(!b.box[0][1].getFlavor().equals("lime")) System.err.println("Failed moveCandyToFirstRow(1) effect: " + b.box[0][1].getFlavor());
        mTest = b.moveCandyToFirstRow(2);
        if(mTest != true) System.err.println("Failed moveCandyToFirstRow(2) return");
        if(!(b.box[0][2].getFlavor().equals("cherry") || b.box[0][2].getFlavor().equals("grape"))) System.err.println("Failed moveCandyToFirstRow(2) effect: " + b.box[0][2].getFlavor());

        candies = new Candy[3][5];
        candies[0][0] = new Candy("lime");
        candies[0][1] = new Candy("lime");
        candies[0][3] = new Candy("lemon");
        candies[1][0] = new Candy("orange");
        candies[1][3] = new Candy("lime");
        candies[1][4] = new Candy("lime");
        candies[2][0] = new Candy("cherry");
        candies[2][2] = new Candy("lemon");
        candies[2][4] = new Candy("orange");
        b = new BoxOfCandy(candies);
        Candy cTest = b.removeNextByFlavor("cherry");
        if(cTest == null || !cTest.getFlavor().equals("cherry")) System.err.println("Failed removeNetByFlavor(\"cherry\") return");
        if(b.box[2][0] != null) System.err.println("Failed removeNetByFlavor(\"cherry\") effect");
        cTest = b.removeNextByFlavor("lime");
        if(cTest == null || !cTest.getFlavor().equals("lime")) System.err.println("Failed removeNetByFlavor(\"lime\") return");
        if(b.box[1][3] != null) System.err.println("Failed removeNetByFlavor(\"lime\") effect");
        cTest = b.removeNextByFlavor("grape");
        if(cTest != null) System.err.println("Failed removeNetByFlavor(\"grape\") return");
    }
}
