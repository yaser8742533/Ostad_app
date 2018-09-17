package yaser.com.ostad.library.RtLizerLibrary;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public class RtlizeEverything {

    public static void rtlize(ViewGroup container) {
        rtlize(container, false);
    }

    public static void rtlize(final ViewGroup container, final boolean recursive) {
        if (container == null) return;

        container.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        arrangeInRtl(container, recursive);
                        container.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                    }
                });
    }

    private static void arrangeInRtl(final ViewGroup container, boolean recursive) {
        int childCount = container.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final View child = container.getChildAt(i);

            if (recursive && child instanceof ViewGroup && ((ViewGroup) child).getChildCount() > 1)
                rtlize((ViewGroup) child, true);

            if (!(child.getLeft() == 0 && child.getRight() == 0)) {
                mirrorViewPosition(container, child);
            } else {
                child.getViewTreeObserver().addOnGlobalLayoutListener(
                        new ViewTreeObserver.OnGlobalLayoutListener() {
                            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                            @Override
                            public void onGlobalLayout() {
                                mirrorViewPosition(container, child);

                                child.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                        });
            }
        }
    }

    private static void mirrorViewPosition(ViewGroup container, final View child) {
        int containerLeft = 0;
        int containerRight = container.getWidth();

        int childLeft = child.getLeft();
        int childRight = child.getRight();

        final int newChildRight = containerRight - childLeft;
        final int newChildLeft = newChildRight - child.getWidth();


        child.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onLayoutChange(View view,
                                       int i, int i2, int i3, int i4,
                                       int i5, int i6, int i7, int i8) {
                child.setLeft(newChildLeft);
                child.setRight(newChildRight);
            }
        });
        child.requestLayout();

    }
}
