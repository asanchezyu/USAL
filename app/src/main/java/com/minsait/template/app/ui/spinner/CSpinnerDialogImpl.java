package com.minsait.template.app.ui.spinner;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimatedImageDrawable;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

import com.minsait.template.R;

import javax.inject.Inject;

/**
 * Class Description.
 *
 * @author asanchezy.
 * @version 1.0.
 * @since 24/5/17.
 */
public class CSpinnerDialogImpl{

    private static final String TAG = CSpinnerDialogImpl.class.getSimpleName();

    private Dialog dialog;

    @Inject
    public CSpinnerDialogImpl(Context context) {
        this.dialog = new Dialog(context);
        setup(context);
    }

    private void setup(Context context) {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
        dialog.setContentView(R.layout.dialog_wait);

        dialog.setCancelable(false);
    }

    public void dismiss() {
        try {
            dialog.dismiss();
        }catch (Exception ex){
            Log.d(TAG, "show: ", ex);
        }
    }

    public void show() {
        try {
            dialog.show();
        }catch (Exception ex){
            Log.d(TAG, "show: ", ex);
        }
    }



    public boolean isShowing(){
        if(dialog != null){
            return dialog.isShowing();
        }
        return false;
    }

}
