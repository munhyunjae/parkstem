package com.trams.parkstem.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.trams.parkstem.R;
import com.trams.parkstem.others.Essentials;
import com.trams.parkstem.server.ServerClient;

import java.util.Calendar;

/**
 * Created by JaeHyo on 2016-07-13.
 */
public class HistoryPaymentView extends LinearLayout {
    public HistoryPaymentView (Context context, ServerClient.Payment payment) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.history_payment_item, this);

        TextView name = (TextView) findViewById(R.id.history_payment_item_bank);
        name.setText(payment.card_name);

        name = (TextView) findViewById(R.id.history_payment_item_price);

        name.setText((char)0xffe6 + Essentials.numberWithComma(payment.price));

        name = (TextView) findViewById(R.id.history_payment_item_date);
        Calendar ca = payment.pay_date;


        Log.e("TAG", payment.card_name + " " + payment.pay_date.toString());


        String date =(int)(payment.pay_date.get(Calendar.MONTH)+1) + "." +payment.pay_date.get(Calendar.DAY_OF_MONTH);
        name.setText(date);

        name = (TextView) findViewById(R.id.history_payment_item_time);
        // hours and minutes sb to input
    }
}