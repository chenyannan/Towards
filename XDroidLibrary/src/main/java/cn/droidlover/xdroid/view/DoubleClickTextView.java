package cn.droidlover.xdroid.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by waitou on 17/1/25.
 * 封装了双击事件的textview
 */

public class DoubleClickTextView extends AppCompatTextView {

    private GestureDetector     gestureDetector;
    private doubleClickListener mDoubleClickListener;

    public DoubleClickTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public void setDoubleClickListener(doubleClickListener doubleClickListener) {
        mDoubleClickListener = doubleClickListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return gestureDetector.onTouchEvent(e);
    }


    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (mDoubleClickListener != null) {
                mDoubleClickListener.onDoubleClick(DoubleClickTextView.this);
            }
            return true;
        }
    }

    public interface doubleClickListener {
        void onDoubleClick(View view);
    }
}
