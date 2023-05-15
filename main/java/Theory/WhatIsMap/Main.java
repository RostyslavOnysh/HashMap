package Theory.WhatIsMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /* интерфейс map описує інтерфейс при роботі структур данних які оперують таким поняттям
        як пара  ключ значення.Тобто має бути ключ і по цьому ключу буде знаходитись певне значення.
        Ключі в мапах будуть унікальними.
         1. Країна це ключ
         2. Столиця це значення
         */

        Map<String, String> capitalSities = new HashMap<>();
        // інтерфейс map параметризований двума generics
        // K - key, V - value

        capitalSities.put("England", "London");
        capitalSities.put("Ireland", "Dublin");
        capitalSities.put("Ukraine", "Kyiv");
        capitalSities.put("Poland", "Warsaw");
        capitalSities.put("Norway", "Oslo");
        System.out.println(capitalSities);

        Map<String, Integer> population = new HashMap<>();
        population.put("Ukraine", 35_000_000);

        String ukraineCapital = capitalSities.get("Ukraine");
        Integer ukrainePopulation = population.get("Ukraine");
        System.out.println("Capital of Ukraine : "
                + ukraineCapital
                + " , and population of this country : "
                + ukrainePopulation + " people");

    }
}
