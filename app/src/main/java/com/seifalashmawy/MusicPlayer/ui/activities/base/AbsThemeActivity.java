package com.seifalashmawy.MusicPlayer.ui.activities.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import android.view.View;

import com.kabouzeid.appthemehelper.ATH;
import com.kabouzeid.appthemehelper.ThemeStore;
import com.kabouzeid.appthemehelper.common.ATHToolbarActivity;
import com.kabouzeid.appthemehelper.util.ColorUtil;
import com.kabouzeid.appthemehelper.util.MaterialDialogsUtil;

import com.seifalashmawy.MusicPlayer.R;
import com.seifalashmawy.MusicPlayer.util.PreferenceUtil;
import com.seifalashmawy.MusicPlayer.util.Util;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */

public abstract class AbsThemeActivity extends ATHToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(PreferenceUtil.getInstance(this).getGeneralTheme());
        super.onCreate(savedInstanceState);
        MaterialDialogsUtil.updateMaterialDialogsThemeSingleton(this);
    }

    protected void setDrawUnderStatusbar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            Util.setAllowDrawUnderStatusBar(getWindow());
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            Util.setStatusBarTranslucent(getWindow());
    }

    /**
     * This will set the color of the view with the id "status_bar" on KitKat and Lollipop.
     * On Lollipop if no such view is found it will set the statusbar color using the native method.
     *
     * @param color the new statusbar color (will be shifted down on Lollipop and above)
     */
    public void setStatusbarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            final View statusBar = getWindow().getDecorView().getRootView().findViewById(R.id.status_bar);
            if (statusBar != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    statusBar.setBackgroundColor(ColorUtil.darkenColor(color));
                    setLightStatusbarAuto(color);
                } else {
                    statusBar.setBackgroundColor(color);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                getWindow().setStatusBarColor(ColorUtil.darkenColor(color));
                setLightStatusbarAuto(color);
            }
        }
    }

    public void setStatusbarColorAuto() {
        // we don't want to use statusbar color because we are doing the color darkening on our own to support KitKat
        setStatusbarColor(getResources().getColor(R.color.black));
    }

    public void setTaskDescriptionColor(@ColorInt int color) {
        ATH.setTaskDescriptionColor(this, color);
    }

    public void setTaskDescriptionColorAuto() {
        setTaskDescriptionColor(getResources().getColor(R.color.black));
    }

    public void setNavigationbarColor(int color) {
        if (ThemeStore.coloredNavigationBar(this)) {
            ATH.setNavigationbarColor(this, color);
        } else {
            ATH.setNavigationbarColor(this, Color.BLACK);
        }
    }

    public void setNavigationbarColorAuto() {
        setNavigationbarColor(ThemeStore.navigationBarColor(this));
    }

    public void setLightStatusbar(boolean enabled) {
        ATH.setLightStatusbar(this, enabled);
    }

    public void setLightStatusbarAuto(int bgColor) {
        setLightStatusbar(ColorUtil.isColorLight(bgColor));
    }
}
