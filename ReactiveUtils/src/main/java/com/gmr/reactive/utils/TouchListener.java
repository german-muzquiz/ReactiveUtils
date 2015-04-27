package com.gmr.reactive.utils;

import android.view.MotionEvent;
import android.view.View;

import rx.Observable;
import rx.Subscriber;


/**
 * Created by german on 27/04/15.
 */
public class TouchListener implements Observable.OnSubscribe<TouchEvent>, View.OnTouchListener
{
    private Subscriber<? super TouchEvent> subscriber;
    private boolean consumesEvent;


    static TouchListener newInstance(boolean consumesEvent)
    {
        TouchListener myInstance = new TouchListener();
        myInstance.consumesEvent = consumesEvent;
        return myInstance;
    }

    public Observable<TouchEvent> toObservable(View aView)
    {
        aView.setOnTouchListener(this);
        return Observable.create(this);
    }


    @Override
    public void call(Subscriber<? super TouchEvent> subscriber)
    {
        this.subscriber = subscriber;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if (this.subscriber != null)
        {
            this.subscriber.onNext(new TouchEvent(v, event));
        }

        return consumesEvent;
    }
}
