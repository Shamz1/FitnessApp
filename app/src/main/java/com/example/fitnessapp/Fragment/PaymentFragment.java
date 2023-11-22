package com.example.fitnessapp.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Adapter.OutstandingPaymentsAdapter;
import com.example.fitnessapp.Adapter.PaymentHistoryAdapter;
import com.example.fitnessapp.Model.OutstandingPayment;
import com.example.fitnessapp.Model.Payment;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class PaymentFragment extends Fragment {

    private RecyclerView paymentHistoryRecyclerView, outstandingPaymentsRecyclerView;
    private PaymentHistoryAdapter paymentHistoryAdapter;
    private OutstandingPaymentsAdapter outstandingPaymentsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payments, container, false);

        // Initialize RecyclerViews
        paymentHistoryRecyclerView = view.findViewById(R.id.paymentHistoryRecyclerView);
        outstandingPaymentsRecyclerView = view.findViewById(R.id.outstandingPaymentsRecyclerView);

        // Set up RecyclerViews with dummy data (replace with your data)
        setupRecyclerViews();

        // Set up FAB click listener to show an alert dialog
        view.findViewById(R.id.fabAddPayment).setOnClickListener(v -> showAddPaymentDialog());

        return view;
    }

    // ... (previous methods)

    private void showAddPaymentDialog() {
        // Create an alert dialog with a custom layout
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.layout_send_payment, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(dialogView);

        // Find views in the custom layout
        EditText cardNumberEditText = dialogView.findViewById(R.id.cardNumberEditText);
        EditText cardHolderNameEditText = dialogView.findViewById(R.id.cardHolderNameEditText);
        EditText expiryDateEditText = dialogView.findViewById(R.id.expiryDateEditText);
        EditText cvvEditText = dialogView.findViewById(R.id.cvvEditText);
        EditText amount = dialogView.findViewById(R.id.amountEditText);
        Button sendPaymentButton = dialogView.findViewById(R.id.sendPaymentButton);

        // Set up Send Payment Button click listener
        sendPaymentButton.setOnClickListener(v -> {
            // Handle sending payment, e.g., get card details and process the payment
            String cardNumber = cardNumberEditText.getText().toString();
            String cardHolderName = cardHolderNameEditText.getText().toString();
            String expiryDate = expiryDateEditText.getText().toString();
            String cvv = cvvEditText.getText().toString();
            String amout = amount.getText().toString();

            // Dummy data for payment (replace with actual data)
            Payment payment = new Payment("New Payment", Integer.parseInt(amout), "2023-03-01", cardNumber, cardHolderName, expiryDate, cvv);

            // Add payment to the payment history (replace with your logic)
            paymentHistoryAdapter.addPayment(payment);

            // Notify adapter of the data change
            paymentHistoryAdapter.notifyDataSetChanged();
        });

        // Show the alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // ... (previous methods)

    private void setupRecyclerViews() {
        // Dummy data for payment history
        List<Payment> paymentHistoryList = new ArrayList<>();
        paymentHistoryList.add(new Payment("Payment 1", 100.0, "2023-01-01", "**** **** **** 1234", "John Doe", "12/25", "123"));
        paymentHistoryList.add(new Payment("Payment 2", 150.0, "2023-02-01", "**** **** **** 5678", "Jane Doe", "06/24", "456"));

        // Dummy data for outstanding payments
        List<OutstandingPayment> outstandingPaymentsList = new ArrayList<>();
        outstandingPaymentsList.add(new OutstandingPayment("Outstanding Payment 1", 75.0, "**** **** **** 9876", "Alice Doe", "09/23", "789"));
        outstandingPaymentsList.add(new OutstandingPayment("Outstanding Payment 2", 50.0, "**** **** **** 5432", "Bob Doe", "03/22", "012"));

        // Set up Payment History RecyclerView
        paymentHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        paymentHistoryAdapter = new PaymentHistoryAdapter(paymentHistoryList);
        paymentHistoryRecyclerView.setAdapter(paymentHistoryAdapter);

        // Set up Outstanding Payments RecyclerView
        outstandingPaymentsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        outstandingPaymentsAdapter = new OutstandingPaymentsAdapter(outstandingPaymentsList);
        outstandingPaymentsRecyclerView.setAdapter(outstandingPaymentsAdapter);
    }
}
