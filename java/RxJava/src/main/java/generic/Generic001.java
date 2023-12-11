package generic;

import java.util.ArrayList;
import java.util.List;

// class generic type
class NonGenericType {
    private Object value;

    NonGenericType(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}


class GenericType<T> {
    private T t;

    public GenericType(T t) {
        this.t = t;
    }

    public T getValue() {
        return t;
    }
}

class MultiType<K, V> {
    private K k;
    private V v;

    public void setK(K k) {
        this.k = k;
    }

    public void setV(V v) {
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    public MultiType(K k, V v) {
        this.k = k;
        this.v = v;
    }
}

// extends generice type
class A{}
class B extends A{}
class C extends B{}

public class Generic001 {



    public static void test001() {
        NonGenericType nonGenericType1 = new NonGenericType("A");
        String value1 = (String) nonGenericType1.getValue();
        NonGenericType nonGenericType2 = new NonGenericType(1);
        int value2 = (int) nonGenericType2.getValue();
    }

    public static void test002() {
        GenericType<String> genericType1 = new GenericType<>("1");
        String value = genericType1.getValue();
    }

    public static void test003() {
        MultiType<String, Integer> multiType = new MultiType<>("1", 1);
        String key = multiType.getK();
        Integer value = multiType.getV();
    }

    public static void getB(GenericType<?> genericType){}

    public static void getExtendWildCard(GenericType<? extends B> genericType){}

    public static void getSuperWildCard(GenericType<? super B> genericType){}

    // method generic type
    public static <K, V, R> List getA(MultiType<K, V> multiType, R r) {
        List<R> list = new ArrayList<>();
        return list;
    }

    public static void main(String[] arg) {
        GenericType<A> a = new GenericType<>(new A());
        GenericType<B> b = new GenericType<>(new B());
        GenericType<C> c = new GenericType<>(new C());

        getB(a);
        getB(b);
        getB(c);

        getExtendWildCard(b);
        getExtendWildCard(c);

        getSuperWildCard(b);
        getSuperWildCard(a);
    }
}