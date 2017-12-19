package com.example.admin.abcfashions.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Window;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.admin.abcfashions.R;


/**
 * Created by kanishka on 2017-06-04.
 */

public class BaseFragment extends Fragment {

    public Dialog mProgress;



    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mProgress != null) {
            mProgress.dismiss();
            mProgress = null;
        }
    }

    public void showAlert(String error) {

        MaterialDialog.Builder builder = new MaterialDialog.Builder(getActivity())
                .title("ABC Fashions")
                .content(error)
                .positiveText("Ok")
                .positiveColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));

        MaterialDialog dialog = builder.build();
        dialog.show();
    }

    public void dismissWaiting() {
        if (mProgress != null && mProgress.isShowing()) {
            mProgress.dismiss();
            mProgress = null;
        }
    }
}
