package yaser.com.ostad.activity.taklif;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import yaser.com.ostad.R;


public class CustomDialogMessageClass extends Dialog implements View.OnClickListener {

    public Activity c;
    public ImageView bck;

    public CustomDialogMessageClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_message);
        bck = findViewById(R.id.bck);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bck:
                dismiss();
                break;
            default:
                break;
        }
    }
}