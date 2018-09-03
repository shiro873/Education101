package projects.shiro.education101.utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import projects.shiro.education101.R;
import projects.shiro.education101.activity.Home.MasterActivity;

public class NotificationHelper {
    NotificationCompat.Builder notificationBuilder;
    Context context;
    private static NotificationHelper INSTANCE = null;
    private String CHANNEL_ID = "wut";
    private String title;

    private NotificationHelper(Context context){
        this.context = context;
        title = context.getResources().getString(R.string.title_notification);

    }

    public synchronized NotificationHelper newInstance(Activity activity){
        if(INSTANCE == null){
            INSTANCE = newInstance(activity);
        }
        return INSTANCE;
    }

    public void buildNotification(String word){
        Intent intent = new Intent(context, MasterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        notificationBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle(title)
                .setContentText(word)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }

    public void showNotification(int notificationId){
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
