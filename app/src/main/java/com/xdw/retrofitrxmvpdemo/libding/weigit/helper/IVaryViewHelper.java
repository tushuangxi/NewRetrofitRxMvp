package com.xdw.retrofitrxmvpdemo.libding.weigit.helper;

import android.content.Context;
import android.view.View;

public abstract interface IVaryViewHelper {

    public abstract View getCurrentLayout();

    public abstract void restoreView();

    public abstract void showLayout(View view);

    public abstract View inflate(int layoutId);

    public abstract Context getContext();

    public abstract View getView();
}
