package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.almuhtazibah11.DAl.ShowCustomersDAL;
import com.example.almuhtazibah11.R;

import java.util.List;

public class CustomerDetailsAdapterAL extends RecyclerView.Adapter<CustomerDetailsAdapterAL.ViewHolder>  {

    private Context context;
    private List<CustomerModel> customerList;
    public CustomerDetailsAdapterAL(Context context, List<CustomerModel> customerList) {
        this.context = context;
        this.customerList = customerList;
    }


    @NonNull
    @Override
    public CustomerDetailsAdapterAL.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_items,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomerDetailsAdapterAL.ViewHolder holder, int position) {

        CustomerModel pro=customerList.get(position);
        holder.txtname.setText("customer Name: "+pro.getCname());
        holder.txtemail.setText( "customer Email: "+pro.getEmail());

        holder.txtphone.setText("customer Phone: "+pro.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }



    public void showCustomerdata(RecyclerView recyclerView) {
        ShowCustomersDAL showCustomersDAL=new ShowCustomersDAL(context,customerList);
        showCustomersDAL.loadCustomerdata(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname;
        TextView txtphone;
        TextView txtemail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname=itemView.findViewById(R.id.cnametxt);
            txtphone=itemView.findViewById(R.id.cphonetxt);
            txtemail=itemView.findViewById(R.id.cemailtxt);
        }
    }
}
