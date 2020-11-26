package com.example.hw1.broadcast;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.hw1.R;

import java.sql.Struct;

public class BatteryReceiver extends BroadcastReceiver {
    private int messageId = 1000;

    @Override
    public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Низкий уровень заряда ", Toast.LENGTH_LONG).show();

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, "battery")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Battery Receiver")
                        .setContentText("Низкий заряд батареи!");
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(messageId++, builder.build());




    }
}