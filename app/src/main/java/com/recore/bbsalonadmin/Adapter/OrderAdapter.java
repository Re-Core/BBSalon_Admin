package com.recore.bbsalonadmin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recore.bbsalonadmin.Activity.OrderDetailActivity;
import com.recore.bbsalonadmin.Model.Order;
import com.recore.bbsalonadmin.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    Context mContext;
    ArrayList<Order> orderList;

    public OrderAdapter(Context mContext, ArrayList<Order> orderList) {
        this.mContext = mContext;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_order,parent,false);

        return new OrderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        holder.txtUsername.setText(orderList.get(position).getUsername());
        holder.txtPhone.setText(orderList.get(position).getPhone());
        holder.txtDate.setText(orderList.get(position).getDate());
        holder.txtTime.setText(orderList.get(position).getTime());
        holder.txtState.setText(orderList.get(position).getState());
        holder.txtBill.setText(orderList.get(position).getBill());

        if(orderList.get(position).getState().equals("Accepted")){
            holder.txtState.setTextColor(mContext.getResources().getColor(R.color.green));
        }else if (orderList.get(position).getState().equals("Pending")) {
            holder.txtState.setTextColor(mContext.getResources().getColor(R.color.yellow));
        }else {
            holder.txtState.setTextColor(mContext.getResources().getColor(R.color.red));
        }

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {

        private TextView txtUsername, txtPhone, txtDate, txtTime, txtState, txtBill;

        public OrderViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtUsername =(TextView)itemView.findViewById(R.id.txtAppointmentUsername);
            txtPhone =(TextView)itemView.findViewById(R.id.txtAppointmentPhoneNumber);
            txtDate =(TextView)itemView.findViewById(R.id.txtAppointmentDate);
            txtTime =(TextView)itemView.findViewById(R.id.txtAppointmentTime);
            txtBill =(TextView)itemView.findViewById(R.id.txtAppointmentBill);
            txtState =(TextView)itemView.findViewById(R.id.txtAppointmentState);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int postition = getAdapterPosition();
                    Toast.makeText(mContext, "Clicked", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mContext, OrderDetailActivity.class);

                    i.putExtra("username",orderList.get(postition).getUsername());
                    i.putExtra("phone",orderList.get(postition).getUsername());
                    i.putExtra("date",orderList.get(postition).getUsername());
                    i.putExtra("time",orderList.get(postition).getUsername());
                    i.putExtra("state",orderList.get(postition).getUsername());
                    i.putExtra("bill",orderList.get(postition).getUsername());
                    i.putExtra("paid",orderList.get(postition).getPaid());
                    mContext.startActivity(i);

                }
            });

        }


    }

}
