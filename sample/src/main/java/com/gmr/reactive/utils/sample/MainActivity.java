package com.gmr.reactive.utils.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.gmr.reactive.utils.ReactiveUtils;
import com.gmr.reactive.utils.TouchEvent;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;


public class MainActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<View> clickObservable = ReactiveUtils.clickListener().toObservable(findViewById(R.id.click))
                .subscribeOn(Schedulers.newThread());
        Observable<TouchEvent> touchObservable = ReactiveUtils.touchListener(true).toObservable(findViewById(R.id.touch))
                .filter(new Func1<TouchEvent, Boolean>()
                {
                    @Override
                    public Boolean call(TouchEvent touchEvent)
                    {
                        return touchEvent.getMotionEvent().getAction() == MotionEvent.ACTION_UP;
                    }
                });

        Observable.combineLatest(clickObservable, touchObservable, new Func2<View, TouchEvent, String>()
        {
            @Override
            public String call(View view, TouchEvent touchEvent)
            {
                return "Clicked and touched!";
            }
        })
        .subscribe(new Action1<String>()
        {
            @Override
            public void call(String s)
            {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
