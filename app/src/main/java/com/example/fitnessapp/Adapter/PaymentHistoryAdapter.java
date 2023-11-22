package com.example.fitnessapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Model.Payment;
import com.example.fitnessapp.R;

import java.util.List;

public class PaymentHistoryAdapter extends RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder> {

    private List<Payment> paymentList;

    public PaymentHistoryAdapter(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Payment payment = paymentList.get(position);

        // Set payment details to ViewHolder
        holder.paymentNameTextView.setText(payment.getPaymentName());
        holder.amountTextView.setText(String.valueOf(payment.getAmount()));
        holder.dateTextView.setText(payment.getDate());
        holder.cardNumberTextView.setText(payment.getCardNumber());  // Displaying card number for demonstration purposes
    }

    @Override
    public int getItemCount() {
        return paymentList.size();
    }

    public void addPayment(Payment payment) {
        paymentList.add(payment);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView paymentNameTextView;
        private TextView amountTextView;
        private TextView dateTextView;
        private TextView cardNumberTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize TextViews
            paymentNameTextView = itemView.findViewById(R.id.paymentNameTextView);
            amountTextView = itemView.findViewById(R.id.amountTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            cardNumberTextView = itemView.findViewById(R.id.cardNumberTextView);
        }
    }
}
