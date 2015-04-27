package com.gmr.reactive.utils;

import android.view.View;

import rx.Observable;
import rx.Subscriber;


/**
 * Created by german on 27/04/15.
 */
public class ClickListener implements Observable.OnSubscribe<View>, View.OnClickListener
{
    private Subscriber<? super View> subscriber;


    static ClickListener newInstance()
    {
        return new ClickListener();
    }

    public Observable<View> toObservable(View aView)
    {
        aView.setOnClickListener(this);
        return Observable.create(this);
    }


    @Override
    public void call(Subscriber<? super View> subscriber)
    {
        this.subscriber = subscriber;
    }

    @Override
    public void onClick(View v)
    {
        if (this.subscriber != null)
        {
            this.subscriber.onNext(v);
        }
    }
}
