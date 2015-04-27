package com.gmr.reactive.utils;

import android.view.View;

import rx.Observable;
import rx.Subscriber;


/**
 * Created by german on 27/04/15.
 */
public class LongClickListener implements Observable.OnSubscribe<View>, View.OnLongClickListener
{
    private Subscriber<? super View> subscriber;
    private boolean consumesEvent;


    static LongClickListener newInstance(boolean consumesEvent)
    {
        LongClickListener myInstance = new LongClickListener();
        myInstance.consumesEvent = consumesEvent;
        return myInstance;
    }

    public Observable<View> toObservable(View aView)
    {
        aView.setOnLongClickListener(this);
        return Observable.create(this);
    }


    @Override
    public void call(Subscriber<? super View> subscriber)
    {
        this.subscriber = subscriber;
    }


    @Override
    public boolean onLongClick(View v)
    {
        if (this.subscriber != null)
        {
            this.subscriber.onNext(v);
        }

        return consumesEvent;
    }
}
