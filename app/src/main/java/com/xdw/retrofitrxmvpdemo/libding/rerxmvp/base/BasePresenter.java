package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.base;

import rx.Subscription;

public class BasePresenter<V> {
    public V mView;
    protected Subscription mSubscription;

    public void attach(V view) {
        mView = view;
    }

    public void detach() {
        mView = null;
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }
}