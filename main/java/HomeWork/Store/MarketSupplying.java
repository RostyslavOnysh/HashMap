package HomeWork.Store;

import java.util.Map;

public class MarketSupplying {
    public Map<String, Integer> supplyFruits(Map<String, Integer> storage, int supply) {
        //write your code here
      for (String key : storage.keySet()) {
          int actualValue = storage.get(key);
          int updatedValue = actualValue + supply;
          storage.put(key,updatedValue);
      }
        return storage;
    }
}


/*
Це другий варіант рішення :

 for (Map.Entry<String, Integer> entry : storage.entrySet()) {
      String key = entry.getKey();
      int actualValue = entry.getValue();
      int updatedValue = actualValue + supply;
      storage.put(key, updatedValue);
    }
    return storage;
  }
}
 */


/*
Це третій варіант рішення :
  for (Map.Entry<String, Integer> fruit : storage.entrySet()) {
      fruit.setValue(fruit.getValue() + supply);
    }
    return storage;
  }
 */
