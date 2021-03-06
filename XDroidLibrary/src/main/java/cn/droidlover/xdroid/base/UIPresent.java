package cn.droidlover.xdroid.base;

/**
 * Created by waitou on 17/1/9.
 */

public interface UIPresent<V extends IView> {
    void start();

    V getV();

    void attachV(V v);

    void detachV();
}
