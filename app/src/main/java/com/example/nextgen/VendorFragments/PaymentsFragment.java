package com.example.nextgen.VendorFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nextgen.R;

public class PaymentsFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
         View view = inflater.inflate(R.layout.fragment_payments,container, false);

        return view;
    }
}