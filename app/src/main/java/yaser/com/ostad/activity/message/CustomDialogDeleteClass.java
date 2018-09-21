package yaser.com.ostad.activity.message;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import yaser.com.ostad.R;


public class CustomDialogDeleteClass extends Dialog implements View.OnClickListener {

    public Activity c;
    public ImageView bck;
    Button no, yes;

    public CustomDialogDeleteClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_delete);
        bck = findViewById(R.id.bck);
        no = findViewById(R.id.btn_no);
        yes = findViewById(R.id.btn_yes);
        bck.setOnClickListener(this);
        no.setOnClickListener(this);
        yes.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bck:
                dismiss();
                break;
            case R.id.btn_no:
                dismiss();
                break;
            case R.id.btn_yes:
                dismiss();
                break;
            default:
                break;
        }
    }
}