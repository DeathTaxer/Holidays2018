package com.clicsixdev.holidays2018;

/**
 * Created by aravind on 24-12-2017.
 */

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

/**
 * Created by aravind on 17-12-2017.
 */

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder> {

    private Context mContext;

    private List<Holiday> holidayList;

    Random random = new Random();

    public HolidayAdapter(Context mContext,List<Holiday> holidayList){
        this.mContext = mContext;
        this.holidayList = holidayList;
    }


    @Override
    public HolidayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.holiday_item,parent,false);
        return new HolidayViewHolder(view);

    }


    @Override
    public void onBindViewHolder(final HolidayViewHolder holder, final int position){
        final Holiday holiday = holidayList.get(position);

        holder.textViewName.setText(holiday.getName());
        holder.textViewMon.setText(holiday.getMon());
        holder.textViewDay.setText(holiday.getDay());


        holder.textViewOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {



                PopupMenu popup = new PopupMenu(mContext , holder.textViewOptions);

                Log.v("adapter","working");
                popup.inflate(R.menu.options_menu);
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.notify:

                                if (holidayList.get(position).getDate().getTimeInMillis()+86400000 < System.currentTimeMillis()){
                                    Snackbar snackbar = Snackbar.make(view,"Day has already passed.",Snackbar.LENGTH_SHORT);
                                    View snackBarView = snackbar.getView();
                                    snackBarView.setBackgroundColor(Color.GRAY);
                                    TextView tv = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                                    tv.setTextColor(Color.WHITE);
                                    snackbar.show();
                                    break;
                                }
                                else {

                                    scheduleNotification(getNotification(holidayList.get(position).getName()), holidayList.get(position).getDate().getTimeInMillis());
                                    Log.v("milliseconds:", holidayList.get(position).getDate().getTimeInMillis() + "");
                                    //Toast.makeText(mContext, "You will be notified.", Toast.LENGTH_LONG).show();
                                    Snackbar snackbar = Snackbar.make(view,"You'll be notified.",Snackbar.LENGTH_SHORT);
                                    snackbar.show();

                                    break;
                                }

                        }

                        return false;
                    }
                });

            }
        });




    }


    @Override
    public int getItemCount(){
        return holidayList.size();
    }

    class HolidayViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName,textViewMon,textViewDay,textViewOptions;
        RelativeLayout mainView;


        public HolidayViewHolder(View itemView) {
            super(itemView);
            mainView = itemView.findViewById(R.id.main);
            textViewName = itemView.findViewById(R.id.holiday_name);
            textViewMon = itemView.findViewById(R.id.holiday_mon);
            textViewDay = itemView.findViewById(R.id.holiday_day);
            textViewOptions = itemView.findViewById(R.id.options);


            mainView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detailsIntent = new Intent(view.getContext(),DetailsActivity.class);
                    detailsIntent.putExtra("holiday",holidayList.get(getAdapterPosition()).getName());
                    detailsIntent.putExtra("states",holidayList.get(getAdapterPosition()).getStates());
                    view.getContext().startActivity(detailsIntent);
                }
            });


        }
    }

    private void scheduleNotification(Notification notification,long delay) {
        Intent notificationIntent = new Intent(mContext,NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID,random.nextInt(1000));
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION,notification);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 0 ,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        long futureInMillis = delay;
        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP , futureInMillis , pendingIntent);


    }


    private Notification getNotification(String content){
        Notification.Builder builder = new Notification.Builder(mContext);
        builder.setContentTitle("Hurray....Today is a holiday");
        builder.setContentText(content);
        builder.setSmallIcon(R.mipmap.hp_ic_launcher_round);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            return builder.build();
        }
        else return builder.getNotification();

    }
}

