package hadj.tn.testiste;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProdAdapter extends FirebaseRecyclerAdapter<Prod,ProdAdapter.ViewHolder> {

    Context context;

    public ProdAdapter(@NonNull FirebaseRecyclerOptions<Prod> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Prod model) {


        holder.prodName.setText(model.getProductName());
        holder.prodQty.setText(model.getProductQty());
        holder.prodPrice.setText(model.getProductPrice());

        String imgURL = model.getImageUrl();
        Picasso.get().load(imgURL).into(holder.prodImage);
        
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.desgin_row, parent, false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView prodImage;
        TextView prodName, prodQty, prodPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImage = itemView.findViewById(R.id.Prod_image);
            prodName = itemView.findViewById(R.id.Prod_name);
            prodPrice = itemView.findViewById(R.id.Prod_price);
            prodQty = itemView.findViewById(R.id.Prod_qty);
        }
    }
}
