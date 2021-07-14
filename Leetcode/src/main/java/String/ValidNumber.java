package String;

import java.util.List;
import java.util.Map;
import java.util.Set;

//Deterministic Finite Automaton (DFA)
// more explanation
public class ValidNumber {
    // This is the DFA we have designed above
    private static final List<Map<String, Integer>> map = List.of(
            Map.of("digit", 1, "sign", 2, "dot", 3),
            Map.of("digit", 1, "dot", 4, "exponent", 5),
            Map.of("digit", 1, "dot", 3),
            Map.of("digit", 4),
            Map.of("digit", 4, "exponent", 5),
            Map.of("sign", 6, "digit", 7),
            Map.of("digit", 7),
            Map.of("digit", 7)
    );

    // These are all of the valid finishing states for our DFA.
    private static final Set<Integer> validFinalStates = Set.of(1, 4, 7);

    public boolean isNumber(String s) {
        int currentState = 0;
        String group = "";

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                group = "digit";
            } else if (curr == '+' || curr == '-') {
                group = "sign";
            } else if (curr == 'e' || curr == 'E') {
                group = "exponent";
            } else if (curr == '.') {
                group = "dot";
            } else {
                return false;
            }

            if (!map.get(currentState).containsKey(group)) {
                return false;
            }

            currentState = map.get(currentState).get(group);
        }

        return validFinalStates.contains(currentState);
    }
}
