package com.gmr.reactive.utils;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by german on 27/04/15.
 */
public class TouchEvent
{
    private View view;
    private MotionEvent motionEvent;

    public TouchEvent(View view, MotionEvent motionEvent)
    {
        this.view = view;
        this.motionEvent = motionEvent;
    }

    public View getView()
    {
        return view;
    }

    public MotionEvent getMotionEvent()
    {
        return motionEvent;
    }
}
