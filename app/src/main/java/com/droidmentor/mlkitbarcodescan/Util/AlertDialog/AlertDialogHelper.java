package com.droidmentor.mlkitbarcodescan.Util.AlertDialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;


/**
 * Created by Jaison.
 */

public class AlertDialogHelper {
    Context context;
    AlertDialog alertDialog=null;
    AlertDialogListener callBack;
    Activity current_activity;


    public AlertDialogHelper(Context context)
    {
        this.context = context;
        this.current_activity = (Activity) context;
    }

    public AlertDialogHelper(Context context,AlertDialogListener listener)
    {
        this.context = context;
        this.current_activity = (Activity) context;
        callBack = listener;
    }

    /**
     * Displays the AlertDialog with 3 Action buttons
     *
     * you can set cancelable property
     *
     * @param alertDialogModel
     * @param from
     */
    public void showAlertDialog(final AlertDialogModel alertDialogModel,int from )
    {
        showAlertDialog(alertDialogModel,from,null);
    }

    /**
     * Displays the AlertDialog with 3 Action buttons
     *
     * you can set cancelable property
     *
     * @param alertDialogModel
     * @param alertDialogCallBack
     */
    public void showAlertDialog(final AlertDialogModel alertDialogModel,AlertDialogListener alertDialogCallBack)
    {
        showAlertDialog(alertDialogModel,1,alertDialogCallBack);
    }


    /**
     * Displays the AlertDialog with 3 Action buttons
     *
     * you can set cancelable property
     *
     * @param alertDialogModel
     * @param from
     */
    public void showAlertDialog(final AlertDialogModel alertDialogModel, final int from, final AlertDialogListener alertDialogCallBack)
    {
        final AlertDialogListener alertDialogListener;

        if(alertDialogCallBack!=null)
            alertDialogListener=alertDialogCallBack;
        else if(callBack!=null)
            alertDialogListener=callBack;
        else
            alertDialogListener=null;

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(current_activity);

        if(!TextUtils.isEmpty(alertDialogModel.getTitle()))
            alertDialogBuilder.setTitle(alertDialogModel.getTitle());
        if(!TextUtils.isEmpty(alertDialogModel.getDesc()))
            alertDialogBuilder.setMessage(alertDialogModel.getDesc());

        if(!TextUtils.isEmpty(alertDialogModel.getPositiveText()))
            alertDialogBuilder.setPositiveButton(alertDialogModel.getPositiveText(), null);

        if(!TextUtils.isEmpty(alertDialogModel.getNeutralText()))
            alertDialogBuilder.setNeutralButton(alertDialogModel.getNeutralText(), null);

        if(!TextUtils.isEmpty(alertDialogModel.getNegativeText()))
            alertDialogBuilder.setNegativeButton(alertDialogModel.getNegativeText(),null);

        alertDialogBuilder.setCancelable(alertDialogModel.isCancelable());


        alertDialog = alertDialogBuilder.create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {

                if(!TextUtils.isEmpty(alertDialogModel.getPositiveText()))
                {
                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            if(alertDialogListener!=null)
                              alertDialogListener.onPositiveClick(from);
                            alertDialog.dismiss();
                        }
                    });
                }

                if(!TextUtils.isEmpty(alertDialogModel.getNegativeText()))
                {
                    Button buttonNegative = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEGATIVE);
                    buttonNegative.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            if(alertDialogListener!=null)
                                alertDialogListener.onNegativeClick(from);
                            alertDialog.dismiss();
                        }
                    });
                }

                if(!TextUtils.isEmpty(alertDialogModel.getNeutralText()))
                {
                    Button buttonNeutral = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEUTRAL);
                    buttonNeutral.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            if(alertDialogListener!=null)
                                alertDialogListener.onNeutralClick(from);

                            alertDialog.dismiss();
                        }
                    });
                }


            }
        });

        alertDialog.show();

        if(TextUtils.isEmpty(alertDialogModel.getNegativeText()))
            alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setEnabled(false);
    }

    public void dismissAll()
    {
        if(alertDialog!=null)
            alertDialog.dismiss();
    }

    public interface AlertDialogListener
    {
         void onPositiveClick(int from);
         void onNegativeClick(int from);
         void onNeutralClick(int from);
    }

}

