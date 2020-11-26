package com.example.hw1.broadcast;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.hw1.R;

public class AirReceiver extends BroadcastReceiver {
    private int messageId = 1000;


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Режим полета изменен!", Toast.LENGTH_LONG).show();
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, "my")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Broadcast Receiver")
                .setContentText("Режим самолёта");
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(messageId++, builder.build());

    }
}