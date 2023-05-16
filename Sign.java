import java.util.ArrayList;

public class Sign {

    private ArrayList<String> lines;

    public Sign(String msg, int width) {
        lines = new ArrayList<String>();
        while(msg.length() > 0) {
            if(msg.length() < width) {
                lines.add(msg.substring(0));
                break; //alternate: msg = "";
            }
            else {
                lines.add(msg.substring(0, width));
                msg = msg.substring(width);
            }
        }
    }

    public int numberOfLines() {
        return lines.size();
    }

    public String getLines() {
        String result = null;
        if(lines.size() > 0) {
            result = "";
            for(String s : lines)
                result += s + ";";
            result = result.substring(0, result.length()-1);
        }
        return result;
    }

    public static void main(String[] args) {
        Sign example15 = new Sign("Everything on sale, please come in", 15);
        int nOLTest = example15.numberOfLines();
        if(nOLTest != 3) System.err.println("Failed example15.numberOfLines(): " + nOLTest);
        String gLTest = example15.getLines();
        if(!gLTest.equals("Everything on s;ale, please com;e in")) System.err.println("Failed example15.getLines(): " + gLTest);
        Sign example17 = new Sign("Everything on sale, please come in", 17);
        nOLTest = example17.numberOfLines();
        if(nOLTest != 2) System.err.println("Failed example17.numberOfLines(): " + nOLTest);
        gLTest = example17.getLines();
        if(!gLTest.equals("Everything on sal;e, please come in")) System.err.println("Failed example17.getLines(): " + gLTest);
        Sign example40 = new Sign("Everything on sale, please come in", 40);
        nOLTest = example40.numberOfLines();
        if(nOLTest != 1) System.err.println("Failed example40.numberOfLines(): " + nOLTest);
        gLTest = example40.getLines();
        if(!gLTest.equals("Everything on sale, please come in")) System.err.println("Failed example40.getLines(): " + gLTest);

        String str;
        int x;
        Sign sign1 = new Sign("ABC222DE", 3);
        x = sign1.numberOfLines();
        if(x != 3) System.err.println("Failed sign1.numberOfLines(): " + x);
        str = sign1.getLines();
        if(!str.equals("ABC;222;DE")) System.err.println("Failed first sign1.getLines(): " + str);
        str = sign1.getLines();
        if(!str.equals("ABC;222;DE")) System.err.println("Failed second sign1.getLines(): " + str);
        Sign sign2 = new Sign("ABCD", 10);
        x = sign2.numberOfLines();
        if(x != 1) System.err.println("Failed sign2.numberOfLines(): " + x);
        str = sign2.getLines();
        if(!str.equals("ABCD")) System.err.println("Failed sign2.getLines(): " + str);
        Sign sign3 = new Sign("ABCDEF", 6);
        x = sign3.numberOfLines();
        if(x != 1) System.err.println("Failed sign3.numberOfLines(): " + x);
        str = sign3.getLines();
        if(!str.equals("ABCDEF")) System.err.println("Failed sign3.getLines(): " + str);
        Sign sign4 = new Sign("", 4);
        x = sign4.numberOfLines();
        if(x != 0) System.err.println("Failed sign4.numberOfLines(): " + x);
        str = sign4.getLines();
        if(str != null) System.err.println("Failed sign4.getLines(): " + str);
        Sign sign5 = new Sign("AB_CD_EF", 2);
        x = sign5.numberOfLines();
        if(x != 4) System.err.println("Failed sign5.numberOfLines(): " + x);
        str = sign5.getLines();
        if(!str.equals("AB;_C;D_;EF")) System.err.println("Failed sign5.getLines(): " + str);
    }
}
