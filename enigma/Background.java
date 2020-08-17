package enigma;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface Background {
    Map<Integer, List<Integer>> back_plug = new LinkedHashMap<Integer, List<Integer>>();
    Map<Integer, List<Integer>> back_slow = new LinkedHashMap<Integer, List<Integer>>();
    Map<Integer, List<Integer>> back_medium = new LinkedHashMap<Integer, List<Integer>>();
    Map<Integer, List<Integer>> back_fast = new LinkedHashMap<Integer, List<Integer>>();
    Map<Integer, List<Integer>> main_plug = new LinkedHashMap<Integer, List<Integer>>();
}