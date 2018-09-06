package qin.xue.recyclerviewexpand.modules;

/**
 * Created by qinxue on 2018/9/6.
 */

public class BaseModule<T> {
    public static final int TYPE_OUT = 0;
    public static final int TYPE_IN = 1;
    protected int type;
    private T value;

    public BaseModule(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public int getType() {
        return type;
    }
}
