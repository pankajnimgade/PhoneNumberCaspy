package classes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nimgade.pk.mytestapplication.R;

import java.util.ArrayList;

import classes.PhoneNumber;

/**
 * This is the adapter which is used with RecyclerView to make a list of
 * PhoneNumber who have not been assigned to any Customers
 * @author Pankaj Nimgade
 */
public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<PhoneNumber> phoneNumbers;

    public PhoneAdapter(Context context, ArrayList<PhoneNumber> phoneNumbers) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.single_list_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.phone_Number.setText("" + phoneNumbers.get(i).getPhone_Number());
        viewHolder.phone_Number_Serial_Number.setText("" + phoneNumbers.get(i).getPhone_Number_Serial_Number());
    }

    @Override
    public int getItemCount() {
        return this.phoneNumbers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView phone_Number;
        TextView phone_Number_Serial_Number;

        public ViewHolder(View itemView) {
            super(itemView);
            phone_Number = (TextView) itemView.findViewById(R.id.single_list_item_Medium_textView);
            phone_Number_Serial_Number = (TextView) itemView.findViewById(R.id.single_list_item_small_textView);
        }
    }
}
