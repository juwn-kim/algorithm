import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(String s) {
        int answer = 0;
        List<String> numberList = new ArrayList<>();

        while (!s.isEmpty()) {
            if (Character.isDigit(s.charAt(0))) {
                numberList.add(String.valueOf(s.charAt(0)));
                s = s.substring(1);
                continue;
            }

            for (Map.Entry<String, String> numberEntry: numberMap.entrySet()) {
                if (s.startsWith(numberEntry.getKey())) {
                    numberList.add(numberEntry.getValue());
                    s = s.substring(numberEntry.getKey().length());
                    break;
                }
            }
        }

        for (int i = 0; i < numberList.size(); i++) {
            answer += Integer.valueOf(numberList.get(i)) * Math.pow(10, numberList.size() - i - 1);
        }

        return answer;
    }

    static final Map<String, String> numberMap = Map.of(
        "zero", "0",
        "one", "1",
        "two", "2",
        "three", "3",
        "four", "4",
        "five", "5",
        "six", "6",
        "seven", "7",
        "eight", "8",
        "nine", "9"
    );
}
