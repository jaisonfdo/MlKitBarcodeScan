package com.droidmentor.mlkitbarcodescan.Util.AlertDialog;

/**
 * Created by Jaison.
 * Used to pass the text values of the Alert Dialog
 */

public class AlertDialogModel
{
    String title;
    String desc;
    String positiveText;
    String negativeText;
    String neutralText;
    boolean isCancelable;


    public AlertDialogModel() {
    }

    public AlertDialogModel(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }


    public AlertDialogModel(String title, String desc, String positiveText) {
        this.title = title;
        this.desc = desc;
        this.positiveText = positiveText;
    }

    public AlertDialogModel(String title, String desc, String positiveText, boolean isCancelable) {
        this.title = title;
        this.desc = desc;
        this.positiveText = positiveText;
        this.isCancelable = isCancelable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPositiveText() {
        return positiveText;
    }

    public void setPositiveText(String positiveText) {
        this.positiveText = positiveText;
    }

    public String getNegativeText() {
        return negativeText;
    }

    public void setNegativeText(String negativeText) {
        this.negativeText = negativeText;
    }

    public String getNeutralText() {
        return neutralText;
    }

    public void setNeutralText(String neutralText) {
        this.neutralText = neutralText;
    }

    public boolean isCancelable() {
        return isCancelable;
    }

    public void setCancelable(boolean cancelable) {
        isCancelable = cancelable;
    }
}
