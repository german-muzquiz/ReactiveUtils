package com.gmr.reactive.utils;

import android.hardware.Camera;

import rx.Observable;
import rx.Subscriber;


/**
 * Created by german on 27/04/15.
 */
public class PictureCallback implements Observable.OnSubscribe<PictureTakenEvent>, Camera.PictureCallback
{
    private Subscriber<? super PictureTakenEvent> subscriber;


    static PictureCallback newInstance()
    {
        return new PictureCallback();
    }

    public Observable<PictureTakenEvent> toObservable()
    {
        return Observable.create(this);
    }


    @Override
    public void call(Subscriber<? super PictureTakenEvent> subscriber)
    {
        this.subscriber = subscriber;
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera)
    {
        if (this.subscriber != null)
        {
            this.subscriber.onNext(new PictureTakenEvent(data, camera));
        }
    }
}
