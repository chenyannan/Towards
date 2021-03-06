package cn.droidlover.xdroid.base;

import android.content.Context;
import android.view.View;

/**
 * Created by wanglei on 2016/12/1.
 */

public class VDelegateBase implements VDelegate {

    public Context context;

    private VDelegateBase(Context context) {
        this.context = context;
    }

    public static VDelegateBase create(Context context) {
        return new VDelegateBase(context);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }


    @Override
    public void visible(boolean flag, View view) {
        if (flag) view.setVisibility(View.VISIBLE);
    }

    @Override
    public void gone(boolean flag, View view) {
        if (flag) view.setVisibility(View.GONE);
    }

    @Override
    public void inVisible(View view) {
        view.setVisibility(View.INVISIBLE);
    }
}
