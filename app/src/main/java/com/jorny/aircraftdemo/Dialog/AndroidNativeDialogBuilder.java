package com.jorny.aircraftdemo.Dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.support.v7.app.AlertDialog;

public class AndroidNativeDialogBuilder implements AirCraftDialogBuilder {

    @Override
    public void ShowAlertDialog(Context context, Canvas canvas, final AirCraftDialogBuilderInfo dialogDisPlayVo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(dialogDisPlayVo.getTitle());
        builder.setMessage(dialogDisPlayVo.getMessage());
        builder.setCancelable(false);
        builder.setPositiveButton(dialogDisPlayVo.getPostiveText(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogDisPlayVo.getListener().onClick();
            }
        });
        builder.show();
    }

    @Override
    public boolean isClickPostiveButton(float x, float y) {
        return false;
    }

    @Override
    public void clickPostiveButton() {
    }


}
