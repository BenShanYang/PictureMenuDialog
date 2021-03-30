package com.yk.picturemenu;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @ClassName: PictureDialog
 * @Description: 选择图片的弹窗
 * @Author: YangKuan
 * @Date: 2021/3/1 14:26
 */
public abstract class PictureDialog extends Dialog implements View.OnClickListener {

    public PictureDialog(@NonNull Context context) {
        super(context, R.style.AlphaBaseDialogTheme);
        init();
    }

    public PictureDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    public PictureDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    private void init() {
        setContentView(R.layout.dialog_picture);
        windowConfig();
        findViewById(R.id.fl_album).setOnClickListener(PictureDialog.this);
        findViewById(R.id.fl_camera).setOnClickListener(PictureDialog.this);
        findViewById(R.id.tv_cancel).setOnClickListener(PictureDialog.this);
    }

    private void windowConfig() {
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.BaseDialogWindowAnim);
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(params);
            window.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fl_album) {
            album(PictureDialog.this);
        } else if (id == R.id.fl_camera) {
            camera(PictureDialog.this);
        } else if (id == R.id.tv_cancel) {
            if (isShowing()) {
                dismiss();
            }
        }
    }

    /**
     * 获取选择图片菜单按钮
     *
     * @return
     */
    public TextView getAlbumMenu() {
        return (TextView) findViewById(R.id.tv_album);
    }

    /**
     * 获取拍照菜单按钮
     *
     * @return
     */
    public TextView getCameraMenu() {
        return (TextView) findViewById(R.id.tv_camera);
    }

    /**
     * 设置选择图片菜单按钮文字
     *
     * @param text 菜单文字
     * @return
     */
    public PictureDialog setAlbumText(CharSequence text) {
        ((TextView) findViewById(R.id.tv_album)).setText(text);
        return PictureDialog.this;
    }

    /**
     * 设置拍照菜单按钮文字
     *
     * @param text 菜单文字
     * @return
     */
    public PictureDialog setCameraText(CharSequence text) {
        ((TextView) findViewById(R.id.tv_camera)).setText(text);
        return PictureDialog.this;
    }

    /**
     * 相册
     *
     * @param dialog
     */
    public abstract void album(PictureDialog dialog);

    /**
     * 拍照
     *
     * @param dialog
     */
    public abstract void camera(PictureDialog dialog);

}
