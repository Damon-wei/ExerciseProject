package com.example.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.retrofitdemo.bean.BaseBean;
import com.example.retrofitdemo.bean.CurrentUserInfoBean;
import com.example.retrofitdemo.bean.LoginBean;
import com.example.retrofitdemo.net.MyRetrofit;
import com.example.retrofitdemo.util.T;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> user = new HashMap<String, String>();
                user.put("loginName",etUsername.getText().toString().trim());
                user.put("password","96e79218965eb72c92a549dd5a330112");

                MyRetrofit.getiService().appLogin(user)
                        .subscribeOn(Schedulers.newThread())
                        //可用于嵌套网络请求
                        .flatMap(new Func1<LoginBean, Observable<BaseBean<CurrentUserInfoBean>>>() {
                            @Override
                            public Observable<BaseBean<CurrentUserInfoBean>> call(LoginBean loginBean) {
                                return MyRetrofit.getiService().getCurrentUserInfo(loginBean.getLoginKeyCode(),"18612124664");
                            }
                        })
                        .doOnNext(new Action1<BaseBean<CurrentUserInfoBean>>() {
                            @Override
                            public void call(BaseBean<CurrentUserInfoBean> loginBean) {
                                //做一些缓存操作
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<BaseBean<CurrentUserInfoBean>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(BaseBean<CurrentUserInfoBean> currentUserInfoBean) {
                                T.showShort(MainActivity.this, currentUserInfoBean.getResult().getRealName());
                            }
                        });
            }
        });
    }
}
