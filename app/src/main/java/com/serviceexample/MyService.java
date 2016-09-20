package com.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Ramesh on 9/20/16.
 */

public class MyService extends Service {

    protected class MyThread implements Runnable {
        private int service_id;

        public MyThread(int service_id) {
            this.service_id = service_id;
        }

        /**
         * Application NotResponding Error(ANR) is rectified
         */
        @Override
        public void run() {
            int i = 0;
            synchronized (this) {
                while (i < 10) {
                    try {
                        wait(1500);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf(service_id);
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Wait for 15 Seconds...", Toast.LENGTH_LONG).show();
        Thread thread = new Thread(new MyThread(startId));
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}
