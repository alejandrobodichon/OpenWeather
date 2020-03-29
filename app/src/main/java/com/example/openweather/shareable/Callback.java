package com.example.openweather.shareable;

public interface Callback {
    void onResponseOk(Object... objs);
    void onResponseError(Object... objs);
}