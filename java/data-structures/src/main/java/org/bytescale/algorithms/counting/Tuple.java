package org.bytescale.algorithms.counting;

public class Tuple<T> {
    private T t1, t2, t3;

    public Tuple(T t1, T t2, T t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public T getT1() {
        return t1;
    }

    public T getT2() {
        return t2;
    }

    public T getT3() {
        return t3;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("(");
        sb.append(t1);
        sb.append(",");
        sb.append(t2);
        sb.append(",");
        sb.append(t3);
        sb.append(")");
        return sb.toString();
    }
}
