package languageDetector;

import java.util.HashMap;
import java.util.Map;

class LeterFrequency {
    private static final Map<Character, Double[]> lettersFrequency = new HashMap<>();

    static{
        lettersFrequency.put('a', new Double[]{8.1670, 6.5160, 11.5250, 14.6340, 10.5030});
        lettersFrequency.put('b', new Double[]{1.4920, 1.8860, 2.2150, 1.0430, 1.7400});
        lettersFrequency.put('c', new Double[]{2.7820, 2.7320, 4.0190, 3.8820, 3.8950});
        lettersFrequency.put('d', new Double[]{4.2530, 5.0760, 5.01,	4.9920, 3.7250});
        lettersFrequency.put('e', new Double[]{12.7020, 16.3960, 12.1810, 12.5700, 7.3520});
        lettersFrequency.put('f', new Double[]{2.2280, 1.6560, 0.6920, 1.0230, 0.1430});
        lettersFrequency.put('g', new Double[]{2.0150, 3.0090, 1.7680, 1.3030, 1.7310});
        lettersFrequency.put('h', new Double[]{6.0940, 4.5770, 0.7030, 0.7810, 1.0150});
        lettersFrequency.put('i', new Double[]{6.9660, 6.5500, 6.2470, 6.1860, 8.3280});
        lettersFrequency.put('j', new Double[]{0.1530, 0.2680, 0.4930, 0.3970, 1.8360});
        lettersFrequency.put('k', new Double[]{0.7720, 1.4170, 0.0110, 0.0150, 2.7530});
        lettersFrequency.put('l', new Double[]{4.0250, 3.4370, 4.9670, 2.7790, 2.5640});
        lettersFrequency.put('m', new Double[]{2.4060, 2.5340, 3.1570, 4.7380, 2.5150});
        lettersFrequency.put('n', new Double[]{6.7490, 9.7760, 6.7120, 4.4460, 6.2370});
        lettersFrequency.put('o', new Double[]{7.5070, 2.5940, 8.6830, 9.7350, 6.6670});
        lettersFrequency.put('p', new Double[]{1.9290, 0.6700, 2.5100, 2.5230, 2.4450});
        lettersFrequency.put('q', new Double[]{0.0950, 0.0180, 0.8770, 1.2040, 0.0000});
        lettersFrequency.put('r', new Double[]{5.9870, 7.0030, 6.8710, 6.5300, 5.2430});
        lettersFrequency.put('s', new Double[]{6.3270, 7.2700, 7.9770, 6.8050, 5.2240});
        lettersFrequency.put('t', new Double[]{9.0560, 6.1540, 4.6320, 4.3360, 2.4750});
        lettersFrequency.put('u', new Double[]{2.7580, 4.1660, 2.9270, 3.6390, 2.0620});
        lettersFrequency.put('v', new Double[]{0.9780, 0.8460, 1.1380, 1.5750, 0.0120});
        lettersFrequency.put('w', new Double[]{2.3600, 1.9210, 0.0170, 0.0370, 5.8130});
        lettersFrequency.put('x', new Double[]{0.1500, 0.0340, 0.2150, 0.2530, 0.0040});
        lettersFrequency.put('y', new Double[]{1.9740, 0.0390, 1.0080, 0.0060, 3.2060});
        lettersFrequency.put('z', new Double[]{0.0740, 1.1340, 0.4670, 0.4700, 4.8520});
    }

    public static Map<Character, Double[]> getLettersFrequency() {
        return lettersFrequency;
    }
}
