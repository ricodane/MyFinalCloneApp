package ph.edu.uic.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ph.edu.uic.foodapp.DetailsActivity;
import ph.edu.uic.foodapp.DetailsActivity2;
import ph.edu.uic.foodapp.MainActivity;
import ph.edu.uic.foodapp.R;
import ph.edu.uic.foodapp.model.PopularFood;


public class PopularFoodAdapter extends RecyclerView.Adapter<PopularFoodAdapter.PopularFoodViewHolder> {

    private Button button;
    Context context;
    List<PopularFood> popularFoodList;

    public PopularFoodAdapter (Context context, List<PopularFood> popularFoodList){
        this.context = context;
        this.popularFoodList = popularFoodList;
    }

    @NonNull
    @Override
    public PopularFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.popular_food_row_item, parent, false);
        return new PopularFoodViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull PopularFoodViewHolder holder, int position) {

        holder.foodImage.setImageResource(popularFoodList.get(position).getImageUrl());
        holder.name.setText(popularFoodList.get(position).getName());
        holder.price.setText(popularFoodList.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent i = new Intent(context, DetailsActivity.class);
                i.putExtra("name", popularFoodList.get(position).getName());
                i.putExtra("price", popularFoodList.get(position).getPrice());
                i.putExtra("image", popularFoodList.get(position).getImageUrl());

               context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return popularFoodList.size();
    }

    public static final class PopularFoodViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView price, name;

        public PopularFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.food_image);
            name = itemView.findViewById(R.id.price);
            price = itemView.findViewById(R.id.name);

        }
    }
}
