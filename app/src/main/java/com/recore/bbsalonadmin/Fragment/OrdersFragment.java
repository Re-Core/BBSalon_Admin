package com.recore.bbsalonadmin.Fragment;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.recore.bbsalonadmin.Adapter.OrderAdapter;
import com.recore.bbsalonadmin.Common.Common;
import com.recore.bbsalonadmin.Model.Order;
import com.recore.bbsalonadmin.R;
import com.tiper.MaterialSpinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dmax.dialog.SpotsDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrdersFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private FloatingActionButton btnNewOrder;
    private Dialog orderDialog;
    private DatabaseReference mOrderRef;

    TextInputEditText edtUsername, edtPhone, edtBill;
    Button btnDate, btnTime;
    MaterialSpinner edtState;

    private ArrayList<Order> orderList;
    private RecyclerView orderRv;
    private OrderAdapter orderAdapter;


    public OrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_orders, container, false);
        mOrderRef = FirebaseDatabase.getInstance().getReference(Common.OrderRef);

        btnNewOrder = (FloatingActionButton)v.findViewById(R.id.btnNewOrder);
        btnNewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderDialog.show();
            }
        });

        orderRv = (RecyclerView)v.findViewById(R.id.orderRv);
        orderRv.setLayoutManager(new LinearLayoutManager(getActivity()));

        iniOrderDialog();

        return v;
    }

    private void retrieveOrder() {

        mOrderRef.child(Common.adminView).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                orderList = new ArrayList<>();

                for (DataSnapshot dp:dataSnapshot.getChildren()){
                    Order order = dp.getValue(Order.class);
                    orderList.add(order);
                }
                orderAdapter = new OrderAdapter(getActivity(),orderList);
                orderRv.setAdapter(orderAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });


    }

    private void iniOrderDialog(){

        Button btnCreateOrder;

        orderDialog = new Dialog(getActivity());
        orderDialog.setContentView(R.layout.pop_up_new_order);

        orderDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        orderDialog.getWindow().setLayout(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT);
        orderDialog.getWindow().getAttributes().gravity = Gravity.CENTER;

        edtUsername = (TextInputEditText)orderDialog.findViewById(R.id.edtUsername);
        edtPhone = (TextInputEditText)orderDialog.findViewById(R.id.edtPhone);
        btnDate = (Button)orderDialog.findViewById(R.id.btnDate);
        btnTime = (Button)orderDialog.findViewById(R.id.btnTime);
        edtState = (MaterialSpinner) orderDialog.findViewById(R.id.edtState);

        edtBill = (TextInputEditText)orderDialog.findViewById(R.id.edtBill);

        btnCreateOrder = (Button)orderDialog.findViewById(R.id.btnCreateOrder);

        String[] ITEMS = {"Accepted", "Pending", "Finished"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ITEMS);
        edtState.setAdapter(adapter);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }

        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });

        btnCreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    createOrder(edtUsername.getText().toString(),edtPhone.getText().toString(),btnDate.getText().toString()
                            ,btnTime.getText().toString(),edtState.getSelectedItem().toString(),edtBill.getText().toString());
                }catch (NullPointerException e){
                    Toast.makeText(getActivity(), "Please enter all field", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                getActivity(),
                R.style.DialogTheme,
                this,
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                false
        );
        timePickerDialog.show();
    }

    private void showDatePickerDialog() {
        android.app.DatePickerDialog datePickerDialog = new android.app.DatePickerDialog(
                getActivity(),
                R.style.DialogTheme,
                OrdersFragment.this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();

    }

    private void createOrder(String username, final String phone, String date, String time, String state, String bill) {

        if(TextUtils.isEmpty(username)){
            Toast.makeText(getActivity(), "Please enter a username", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(phone)){
            Toast.makeText(getActivity(), "Please enter a phone number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(date)){
            Toast.makeText(getActivity(), "Please enter a date", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(time)){
            Toast.makeText(getActivity(), "Please enter a time", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(state)){
            Toast.makeText(getActivity(), "Please enter a state", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(bill)){
            Toast.makeText(getActivity(), "Please enter a bill", Toast.LENGTH_SHORT).show();
            return;
        }

        if (phone.length() < 11){
            Toast.makeText(getActivity(), "Invalid phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        final SpotsDialog waitingDialog = new SpotsDialog(getActivity());
        waitingDialog.show();

        final Order order = new Order();
        order.setUsername(username);
        order.setPhone(phone);
        order.setOrderId(phone);
        order.setDate(date);
        order.setTime(time);
        order.setState(state);
        order.setBill(bill);
        order.setPaid("0.00");

        mOrderRef.child(Common.adminView)
                    .child(phone)
                    .setValue(order)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getActivity(), "Order added successfully", Toast.LENGTH_SHORT).show();
                            mOrderRef.child(Common.userView)
                                    .child(phone)
                                    .setValue(order).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    orderDialog.dismiss();
                                    waitingDialog.dismiss();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    waitingDialog.dismiss();
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    orderDialog.dismiss();
                    waitingDialog.dismiss();

                }
            });

        }

    @Override
    public void onStart() {
        super.onStart();
        retrieveOrder();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String date = i2 + "/" + i1 + "/" + i;
        btnDate.setText(date);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        String time = i + ":"+ i1;
        btnTime.setText(time);
    }
}
