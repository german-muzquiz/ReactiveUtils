package com.gmr.reactive.utils;


/**
 * Created by german on 27/04/15.
 */
public class ReactiveUtils
{

    public static ClickListener clickListener()
    {
        return ClickListener.newInstance();
    }

    public static LongClickListener longClickListener(boolean consumesEvent)
    {
        return LongClickListener.newInstance(consumesEvent);
    }

    public static TouchListener touchListener(boolean consumesEvent)
    {
        return TouchListener.newInstance(consumesEvent);
    }

    public static PictureCallback pictureCallback()
    {
        return PictureCallback.newInstance();
    }

}
