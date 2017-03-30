package com.example.servicetest;

/**
 * Created by Damon on 2017/3/30.
 * Description :
 */

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();
}
