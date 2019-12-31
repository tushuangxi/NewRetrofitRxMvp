package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.view.activity;

import android.view.View;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.xdw.retrofitrxmvpdemo.R;
import com.xdw.retrofitrxmvpdemo.libding.entity.GetListRsp;
import com.xdw.retrofitrxmvpdemo.libding.http.ServiceMapParams;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.base.BaseActivity;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.presenter.GetListRspPresenterImpl;
import com.xdw.retrofitrxmvpdemo.libding.weigit.helper.EventCenter;

import butterknife.BindView;

public class TestMainActivity extends BaseActivity implements interfaceUtilsAll.GetListRspView {

    GetListRspPresenterImpl getListRspPresenter;
    @BindView(R.id.tv_content)
    TextView tv_content;

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return false;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionType() {
        return null;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_test_main;
    }

    @Override
    protected void initViewsAndEvents() {

        getListRspPresenter = new GetListRspPresenterImpl();
        getListRspPresenter.attach(this);
        getListRspPresenter.loadNewsData(ServiceMapParams.getGetListRspMapParams());
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }


    @Override
    public void onGetListRspSuccess(GetListRsp getListRsp) {
 //        showLoading(getListRsp.getFemale().iterator().next().getName());
        tv_content.setText(getListRsp.getFemale().iterator().next().getName());
    }

    @Override
    public void onGetListRspError() {

    }
}
