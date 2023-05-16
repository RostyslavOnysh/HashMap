package HomeWork.Store;

import java.util.Map;

public class MarketSupplying {
    public Map<String, Integer> supplyFruits(Map<String, Integer> storage, int supply) {
      for (String key : storage.keySet()) {
          int actualValue = storage.get(key);
          int updatedValue = actualValue + supply;
          storage.put(key,updatedValue);
      }
        return storage;
    }
}
