package com.example.fitnessapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Model.OutstandingPayment;
import com.example.fitnessapp.R;

import java.util.List;

public class OutstandingPaymentsAdapter extends RecyclerView.Adapter<OutstandingPaymentsAdapter.ViewHolder> {

    private List<OutstandingPayment> outstandingPaymentsList;

    public OutstandingPaymentsAdapter(List<OutstandingPayment> outstandingPaymentsList) {
        this.outstandingPaymentsList = outstandingPaymentsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.outstanding_payment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OutstandingPayment outstandingPayment = outstandingPaymentsList.get(position);

        // Set outstanding payment details to ViewHolder
        holder.paymentNameTextView.setText(outstandingPayment.getPaymentName());
        holder.amountTextView.setText(String.valueOf(outstandingPayment.getAmount()));
        holder.cardNumberTextView.setText("Card Number: " + outstandingPayment.getCardNumber());
        holder.cardHolderTextView.setText("Card Holder: " + outstandingPayment.getCardHolderName());
    }

    @Override
    public int getItemCount() {
        return outstandingPaymentsList.size();
    }

    public void addOutstandingPayment(OutstandingPayment outstandingPayment) {
        outstandingPaymentsList.add(outstandingPayment);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView paymentNameTextView;
        private TextView amountTextView;
        private TextView cardNumberTextView;
        private TextView cardHolderTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize TextViews
            paymentNameTextView = itemView.findViewById(R.id.outstandingPaymentNameTextView);
            amountTextView = itemView.findViewById(R.id.outstandingAmountTextView);
            cardNumberTextView = itemView.findViewById(R.id.outstandingCardNumberTextView);
            cardHolderTextView = itemView.findViewById(R.id.outstandingCardHolderTextView);
        }
    }
}
