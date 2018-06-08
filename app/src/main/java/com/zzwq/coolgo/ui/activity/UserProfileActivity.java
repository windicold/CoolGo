package com.zzwq.coolgo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzwq.coolgo.R;
import com.zzwq.coolgo.model.User;
import com.zzwq.coolgo.ui.base.BaseActivity;
import com.zzwq.coolgo.ui.fragment.UserProfileFragment;

public class UserProfileActivity extends BaseActivity {

    public static final int PROFILE_RESULT_CODE = 30001;

    private ImageView mTitleBarIvBack;
    private TextView mTitleBarTvTitle;
    private TextView mTitleBarTvRight;
    private FrameLayout mContentLayout;
    private TextView mErrorTv;
    private LinearLayout mErrorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_common_info_activity);
        initView();

        getSupportFragmentManager().beginTransaction().replace(R.id.common_content_layout,new UserProfileFragment()).commit();
    }

    private void initView() {
        mTitleBarIvBack = (ImageView) findViewById(R.id.common_titleBar_iv_back);
        mTitleBarTvTitle = (TextView) findViewById(R.id.common_titleBar_tv_title);
        mTitleBarTvRight = (TextView) findViewById(R.id.common_titleBar_tv_right);
        mContentLayout = (FrameLayout) findViewById(R.id.common_content_layout);
        mErrorTv = (TextView) findViewById(R.id.common_error_tv);
        mErrorLayout = (LinearLayout) findViewById(R.id.common_error_layout);

        mTitleBarTvRight.setVisibility(View.GONE);
        mTitleBarTvTitle.setText(R.string.user_center);
        mTitleBarIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
