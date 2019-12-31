package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.base;

public interface BaseView {

    void showLoading(String msg);

    void hideLoading();

    void showError(String msg);

    void showException(String msg);

    void showNetError();
}
