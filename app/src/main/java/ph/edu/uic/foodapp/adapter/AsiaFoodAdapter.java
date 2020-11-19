package ph.edu.uic.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ph.edu.uic.foodapp.DetailsActivity;
import ph.edu.uic.foodapp.DetailsActivity2;
import ph.edu.uic.foodapp.R;
import ph.edu.uic.foodapp.model.AsiaFood;
import ph.edu.uic.foodapp.model.PopularFood;

public class AsiaFoodAdapter extends RecyclerView.Adapter<AsiaFoodAdapter.AsiaFoodViewHolder> {

    Context context;
    List<AsiaFood> asiaFoodList;

    public AsiaFoodAdapter (Context context, List<AsiaFood> asiaFoodList){
        this.context = context;
        this.asiaFoodList = asiaFoodList;
    }

    @NonNull
    @Override
    public AsiaFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.asia_food_row_item, parent, false);
        return new AsiaFoodViewHolder(view);
    }
    @Override
    public void onBindViewHolder( AsiaFoodViewHolder holder, int position) {

        holder.foodImage.setImageResource(asiaFoodList.get(position).getImageUrl());
        holder.name.setText(asiaFoodList.get(position).getName());
        holder.price.setText(asiaFoodList.get(position).getPrice());
        holder.rating.setText(asiaFoodList.get(position).getRating());
        holder.restaurantName.setText(asiaFoodList.get(position).getRestaurantname());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailsActivity.class);
                Intent j = new Intent(context, DetailsActivity2.class);
                i.putExtra("name", asiaFoodList.get(position).getName());
                i.putExtra("price", asiaFoodList.get(position).getPrice());
                i.putExtra("image", asiaFoodList.get(position).getImageUrl());

                context.startActivity(j);
            }
        });
    }
    @Override
    public int getItemCount() {
        return asiaFoodList.size();
    }

    public static final class AsiaFoodViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView price, name, rating, restaurantName;

        public AsiaFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.food_image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            rating = itemView.findViewById(R.id.rating);
            restaurantName = itemView.findViewById(R.id.restaurant_name);

        }
    }
}

