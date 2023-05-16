import java.util.ArrayList;
import java.util.Arrays;

public class WeatherData {

    private ArrayList<Double> temperatures;

    public WeatherData(ArrayList<Double> ts) {
        temperatures = ts;
    }

    // part (a)
    public void cleanData(double lower, double upper) {
        for(int i = temperatures.size()-1; i >= 0; i--) {
            double d = temperatures.get(i);
            if(d < lower || d > upper)
                temperatures.remove(i);
        }
    }

    // part (b)
    public int longestHeatWave(double threshold) {
        int curr = 0;
        int max = 0;
        for(Double d: temperatures) {
            if(d > threshold) {
                curr++;
                if(curr > max)
                    max = curr;
            }
            else {
                curr = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(new Double[] {99.1, 142.0, 85.0, 85.1, 84.6, 94.3, 124.9, 98.0, 101.0, 102.5 }));
        WeatherData wd = new WeatherData(list);
        wd.cleanData(85.0, 120.0);
        if(!list.equals(Arrays.asList(new Double[]{99.1, 85.0, 85.1, 94.3, 98.0, 101.0, 102.5}))) System.err.println("Failed cleanData: " + list);

        list = new ArrayList<Double>(Arrays.asList(new Double[] {100.5, 98.5, 102.0, 103.9, 87.5, 105.2, 90.3, 94.8, 109.1, 102.1, 107.4, 93.2}));
        wd = new WeatherData(list);
        int len = wd.longestHeatWave(100.5);
        if(len != 3) System.err.println("Failed longestHeatWave(100.5): " + len);
        len = wd.longestHeatWave(95.2);
        if(len != 4) System.err.println("Failed longestHeatWave(95.2): " + len); 

    }
}
