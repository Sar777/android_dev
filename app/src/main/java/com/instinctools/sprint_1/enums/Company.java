package com.instinctools.sprint_1.enums;

import com.instinctools.sprint_1.R;

/**
 * Created by orion on 12.12.16.
 */

public enum Company {
    APPLY(R.drawable.i_logo_apple,  R.string.title_apply),
    LG(R.drawable.i_logo_lg, R.string.title_lg),
    SAMSUNG(R.drawable.i_logo_samsung, R.string.title_samsung),
    XIAOMI(R.drawable.i_logo_xiaomi, R.string.title_xiaomi);

    private int mDrawableId;
    private int mResId;

    Company(int drawableId, int resId) {
        this.mDrawableId = drawableId;
        this.mResId = resId;
    }

    public int getDrawableId() {
        return mDrawableId;
    }

    public int getResId() {
        return mResId;
    }
}
