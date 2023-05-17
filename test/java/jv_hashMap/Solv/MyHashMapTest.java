package jv_hashMap.Solv;

import HomeWork.jv_hashMap.Solv.MyHashMap;
import HomeWork.jv_hashMap.Solv.MyMap;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class MyHashMapTest {
    private static final Car firstCar = new Car("Audi", "black");
    private static final Car secondCar = new Car("Bmw", "red");
    private static final Car thirdCar = new Car("Mercedes", "grey");

    private static final Car sameFirstCar = new Car("Audi", "black");
    private static final Car sameSecondCar = new Car("Bmw", "red");
    private static final Car sameThirdCar = new Car("Mercedes", "grey");

    private static final Plane firstPlane = new Plane("Mria", "white");
    private static final Plane secondPlane = new Plane("Boing", "white");
    private static final Plane thirdPlane = new Plane("F3T", "grey");

    private static final Bus firstBus = new Bus("FirstBus", "white");
    private static final Bus secondBus = new Bus("SecondBus", "white");
    private static final Bus thirdBus = new Bus("ThirdBus", "grey");

    @Test
    public void getByNonExistedKey() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        Assert.assertNull("Test failed! If key doesn't exist, we should return null.",
                myHashMap.getValue(firstCar));
    }

    @Test
    public void putAndGetOk() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstCar, 3);
        myHashMap.put(secondCar, 5);
        myHashMap.put(thirdCar, 1);

        Assert.assertEquals("Test failed! The size isn't correct. Expected 3 but was "
                + myHashMap.getSize(), 3, myHashMap.getSize());

        Integer firstActualValue = myHashMap.getValue(firstCar);
        Integer secondActualValue = myHashMap.getValue(secondCar);
        Integer thirdActualValue = myHashMap.getValue(thirdCar);
        Assert.assertEquals("Test failed! HashMap expects to contain value 3 for key `firstCar`,"
                + " but was " + firstActualValue, Integer.valueOf(3), firstActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 5 for key `secondCar`,"
                + " but was " + secondActualValue, Integer.valueOf(5), secondActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 1 for key `thirdCar`,"
                + " but was " + thirdActualValue, Integer.valueOf(1), thirdActualValue);
    }

    @Test
    public void putTheSameElement() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstCar, 3);
        myHashMap.put(secondCar, 5);
        myHashMap.put(thirdCar, 1);
        myHashMap.put(sameFirstCar, 3);
        myHashMap.put(sameSecondCar, 5);
        myHashMap.put(sameThirdCar, 1);

        Assert.assertEquals("Test failed! We should add checking if the same element "
                + "exists in the map", 3, myHashMap.getSize());

        Integer firstActualValue = myHashMap.getValue(firstCar);
        Integer secondActualValue = myHashMap.getValue(secondCar);
        Integer thirdActualValue = myHashMap.getValue(thirdCar);
        Assert.assertEquals("Test failed! HashMap expects to contain value 3 for key `firstCar`,"
                + " but was " + firstActualValue, Integer.valueOf(3), firstActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 5 for key `secondCar`,"
                + " but was " + secondActualValue, Integer.valueOf(5), secondActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 1 for key `thirdCar`,"
                + " but was " + thirdActualValue, Integer.valueOf(1), thirdActualValue);
    }

    @Test
    public void putAndGetByNullKey() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(null, 3);
        Integer firstActualValue = myHashMap.getValue(null);
        Assert.assertEquals("Test failed! HashMap expects to contain value 3 for null key,"
                + " but was " + firstActualValue, Integer.valueOf(3), firstActualValue);
        Assert.assertEquals("Test failed! The size isn't correct. Expected 1 but was "
                + myHashMap.getSize(), 1, myHashMap.getSize());
        myHashMap.put(null, 5);
        Integer secondActualValue = myHashMap.getValue(null);
        Assert.assertEquals("Test failed! HashMap expects to contain value 5  for null key,"
                + " but was " + secondActualValue, Integer.valueOf(5), secondActualValue);
        Assert.assertEquals("Test failed! The size isn't correct. Expected 1 but was "
                + myHashMap.getSize(), 1, myHashMap.getSize());
    }

    @Test
    public void putAndGetWithCollision() {
        MyMap<Plane, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstPlane, 3);
        myHashMap.put(secondPlane, 5);
        myHashMap.put(thirdPlane, 1);

        Assert.assertEquals("Test failed! The size isn't correct. Expected 3 but was "
                + myHashMap.getSize(), 3, myHashMap.getSize());

        Integer firstActualValue = myHashMap.getValue(firstPlane);
        Integer secondActualValue = myHashMap.getValue(secondPlane);
        Integer thirdActualValue = myHashMap.getValue(thirdPlane);
        Assert.assertEquals("Test failed! HashMap expects to contain value 3 for key `firstPlane`,"
                + " but was " + firstActualValue, Integer.valueOf(3), firstActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 5 for key `secondPlane`,"
                + " but was " + secondActualValue, Integer.valueOf(5), secondActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 1 for key `thirdPlane`,"
                + " but was " + thirdActualValue, Integer.valueOf(1), thirdActualValue);
    }

    @Test
    public void putAndGetWithCollisionAndReplaceValue() {
        MyMap<Plane, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstPlane, 3);
        myHashMap.put(secondPlane, 5);
        myHashMap.put(thirdPlane, 1);
        myHashMap.put(firstPlane, 4);

        Assert.assertEquals("Test failed! The size isn't correct. Expected 3 but was "
                + myHashMap.getSize(), 3, myHashMap.getSize());

        Integer firstActualValue = myHashMap.getValue(firstPlane);
        Integer secondActualValue = myHashMap.getValue(secondPlane);
        Integer thirdActualValue = myHashMap.getValue(thirdPlane);
        Assert.assertEquals("Test failed! HashMap expects to contain value 3 for key `firstPlane`,"
                + " but was " + firstActualValue, Integer.valueOf(4), firstActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 5 for key `secondPlane`,"
                + " but was " + secondActualValue, Integer.valueOf(5), secondActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 1 for key `thirdPlane`,"
                + " but was " + thirdActualValue, Integer.valueOf(1), thirdActualValue);
    }

    @Test
    public void putAndGetByNullKeyWithCollision() {
        MyMap<Bus, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstBus, 3);
        myHashMap.put(null, 4);
        myHashMap.put(secondBus, 5);
        myHashMap.put(null, 10);
        myHashMap.put(thirdBus, 1);

        Assert.assertEquals("Test failed! The size isn't correct. Expected 4 but was "
                + myHashMap.getSize(), 4, myHashMap.getSize());

        Integer firstActualValue = myHashMap.getValue(firstBus);
        Integer secondActualValue = myHashMap.getValue(secondBus);
        Integer thirdActualValue = myHashMap.getValue(thirdBus);
        Integer fourthActualValue = myHashMap.getValue(null);
        Assert.assertEquals("Test failed! HashMap expects to contain value 3 for key `firstBus`,"
                + " but was " + firstActualValue, Integer.valueOf(3), firstActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 5 for key `secondBus`,"
                + " but was " + secondActualValue, Integer.valueOf(5), secondActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 1 for key `thirdBus`,"
                + " but was " + thirdActualValue, Integer.valueOf(1), thirdActualValue);
        Assert.assertEquals("Test failed! HashMap expects to contain value 10 for null key,"
                + " but was " + fourthActualValue, Integer.valueOf(10), fourthActualValue);
    }

    @Test
    public void putAndGetTheOverriddenValueByKey() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstCar, 3);
        Assert.assertEquals("Test failed! The size isn't correct. Expected 1 but was "
                + myHashMap.getSize(), 1, myHashMap.getSize());
        Integer firstActualValue = myHashMap.getValue(firstCar);
        Assert.assertEquals("Test failed! HashMap expects to contain value 3 for key `firstCar`,"
                + " but was " + firstActualValue, Integer.valueOf(3), firstActualValue);
        myHashMap.put(firstCar, 5);
        Assert.assertEquals("Test failed! The size isn't correct. Expected 1 but was "
                + myHashMap.getSize(), 1, myHashMap.getSize());
        Integer secondActualValue = myHashMap.getValue(firstCar);
        Assert.assertEquals("Test failed! HashMap expects to contain value 5  for key `firstCar`,"
                + " but was " + secondActualValue, Integer.valueOf(5), secondActualValue);
    }

    @Test
    public void checkTheHashMapIncrease() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 1000; i++) {
            Car car = new Car("model_" + i, "color_" + i);
            myHashMap.put(car, i);
        }
        Assert.assertEquals("Test failed! The size isn't correct. Expected 1000 but was "
                + myHashMap.getSize(), 1000, myHashMap.getSize());
        for (int i = 0; i < 1000; i++) {
            Assert.assertEquals(Integer.valueOf(i),
                    myHashMap.getValue(new Car("model_" + i, "color_" + i)));
        }
    }

    @Test
    public void getSizeOfEmptyHashMap() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        Assert.assertEquals("Test failed! The size isn't correct. Expected 0 but was "
                + myHashMap.getSize(), 0, myHashMap.getSize());
    }

    @Test
    public void getSizeWithCollision() {
        MyMap<Plane, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstPlane, 3);
        myHashMap.put(secondPlane, 5);
        Assert.assertEquals("Test failed! The size isn't correct. Expected 2 but was "
                + myHashMap.getSize(), 2, myHashMap.getSize());
    }

    @Test
    public void getSizeWithCollisionAtZeroPosition() {
        MyMap<Bus, Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 1000; i++) {
            Bus bus = new Bus("model_" + i, "color_" + i);
            myHashMap.put(bus, i);
        }
        Assert.assertEquals("Test failed! The size isn't correct. Expected 1000 but was "
                + myHashMap.getSize(), 1000, myHashMap.getSize());
        for (int i = 0; i < 1000; i++) {
            Assert.assertEquals(Integer.valueOf(i),
                    myHashMap.getValue(new Bus("model_" + i, "color_" + i)));
        }
    }

    @Test
    public void getSizeWithCollisionAtFirstPosition() {
        MyMap<Plane, Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 1000; i++) {
            Plane plane = new Plane("model_" + i, "color_" + i);
            myHashMap.put(plane, i);
        }
        Assert.assertEquals("Test failed! The size isn't correct. Expected 1000 but was "
                + myHashMap.getSize(), 1000, myHashMap.getSize());
        for (int i = 0; i < 1000; i++) {
            Assert.assertEquals(Integer.valueOf(i),
                    myHashMap.getValue(new Plane("model_" + i, "color_" + i)));
        }
    }

    @Test
    public void existOnlyOneArrayFieldTest() {
        MyHashMap<?, ?> hashMap = new MyHashMap<>();
        Field[] declaredFields = hashMap.getClass().getDeclaredFields();
        int count = 0;
        for (Field field : declaredFields) {
            if (field.getType().isArray()) {
                count++;
            }
        }
        Assert.assertEquals("Class MyHashMap shouldn't consist more then one array as a field",
                1, count);
    }

    @Test
    public void checkArrayLengthAfterResizingTest() throws IllegalAccessException {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 14; i++) {
            Car car = new Car("model_" + i, "color_" + i);
            myHashMap.put(car, i);
        }
        for (int i = 0; i < 14; i++) {
            Assert.assertEquals(Integer.valueOf(i),
                    myHashMap.getValue(new Car("model_" + i, "color_" + i)));
        }
        Field[] declaredFields = myHashMap.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getType().isArray()) {
                field.setAccessible(true);
                int length = Array.getLength(field.get(myHashMap));
                Assert.assertEquals("After first resizing, length of array should be " + 32,
                        32, length);
            }
        }
    }
}
