package yaser.com.ostad.library.RtLizerLibrary;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;


public class ActionBarRtlizer {

    private static final String TAG = "info.semsamot.actionbar-rtlizer";
    private final Activity mActivity;
    private final String mActionBarIdentifierName;

    public ActionBarRtlizer(Activity activity) {
        this(activity, "action_bar");
    }

    public ActionBarRtlizer(Activity activity, String actionBarIdentifierName) {
        this.mActivity = activity;
        this.mActionBarIdentifierName = actionBarIdentifierName;
    }

    public ViewGroup getActionBarView() {
        int resId;
        ViewGroup actionBarView;

        Window window = mActivity.getWindow();
        View view = window.getDecorView();

        resId = mActivity.getResources().getIdentifier(
                mActionBarIdentifierName, "id", mActivity.getPackageName());
        actionBarView = view.findViewById(resId);

        if (actionBarView == null) {
            resId = mActivity.getResources().getIdentifier(mActionBarIdentifierName, "id", "android");
            actionBarView = view.findViewById(resId);
        }
        return actionBarView;
    }

    private View findViewByClass(String className, View parent) {
        int childCount = parent instanceof ViewGroup ? ((ViewGroup) parent).getChildCount() : -1;

        if (parent == null)
            return null;

        if (parent.getClass().toString().contains(className))
            return parent;


        if (childCount < 1)
            return null;

        for (int i = 0; i < childCount; i++) {
            View child = ((ViewGroup) parent).getChildAt(i);

            View target = findViewByClass(className, child);

            if (target != null)
                return target;
        }

        return null;
    }


    public View getHomeView() {
        return findViewByClass("HomeView", getActionBarView());
    }

    public View getActionMenuView() {
        return findViewByClass("MenuView", getActionBarView());
    }

    public View getHomeViewContainer() {

        return getActionBarView().getChildAt(0);
    }
}
