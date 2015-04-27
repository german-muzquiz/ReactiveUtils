package com.gmr.reactive.utils;

import android.hardware.Camera;

/**
 * Created by german on 27/04/15.
 */
public class PictureTakenEvent
{
    private byte[] data;
    private Camera camera;

    public PictureTakenEvent(byte[] data, Camera camera)
    {
        this.data = data;
        this.camera = camera;
    }

    public byte[] getData()
    {
        return data;
    }

    public Camera getCamera()
    {
        return camera;
    }
}
