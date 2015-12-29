package classes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nimgade.pk.mytestapplication.R;

import java.util.ArrayList;

import classes.Customer;

/**
 * This is the adapter ehich is used with RecyclerView to make a list of
 * Customers who have been assigned a PhoneNumber
 * @author Pankaj Nimgade
 */
public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Customer> customers;

    public CustomerAdapter(Context context, ArrayList<Customer> customers) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.customers = customers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.single_list_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.customer_Name.setText("" + customers.get(i).getCustomer_Name());
        viewHolder.customer_Phone_Number.setText("" + customers.get(i).getPhoneNumber().getPhone_Number());
    }

    @Override
    public int getItemCount() {
        return this.customers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView customer_Name;
        TextView customer_Phone_Number;

        public ViewHolder(View itemView) {
            super(itemView);
            customer_Name = (TextView) itemView.findViewById(R.id.single_list_item_Medium_textView);
            customer_Phone_Number = (TextView) itemView.findViewById(R.id.single_list_item_small_textView);
        }
    }
}
