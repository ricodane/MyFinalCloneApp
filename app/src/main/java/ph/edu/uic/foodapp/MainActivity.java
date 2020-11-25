package ph.edu.uic.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ph.edu.uic.foodapp.adapter.AsiaFoodAdapter;
import ph.edu.uic.foodapp.adapter.PopularFoodAdapter;
import ph.edu.uic.foodapp.model.AsiaFood;
import ph.edu.uic.foodapp.model.PopularFood;

public class MainActivity extends AppCompatActivity {

    RecyclerView popularRecycler, asiaRecycler;
    PopularFoodAdapter popularFoodAdapter;
    AsiaFoodAdapter asiaFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<PopularFood> popularFoodList = new ArrayList<>();

        popularFoodList.add(new PopularFood("Kikiam", "₱10.00", R.drawable.popularfood1));
        popularFoodList.add(new PopularFood("Qwek qwek", "₱15.00", R.drawable.popularfood2));
        popularFoodList.add(new PopularFood("Fish Ball", "₱8.50", R.drawable.popularfood3));
        popularFoodList.add(new PopularFood("Lumpia", "₱20.00", R.drawable.popularfood4));
        popularFoodList.add(new PopularFood("Banana Cue", "₱6.75", R.drawable.popularfood5));
        popularFoodList.add(new PopularFood("Taco", "₱35.00", R.drawable.popularfood6));


        setPopularRecycler(popularFoodList);

        List<AsiaFood> asiaFoodList = new ArrayList<>();
        asiaFoodList.add(new AsiaFood("Pizza", "₱105.00", R.drawable.asiafood1, "4.5", "SNR"));
        asiaFoodList.add(new AsiaFood("Sinigang", "₱95.00", R.drawable.asiafood2, "5.0", "Mama Sita's"));
        asiaFoodList.add(new AsiaFood("Adobo", "₱80.00", R.drawable.asiafood3, "4.8", "Czed Kitchen House"));
        asiaFoodList.add(new AsiaFood("Japanese Prawn Tempura", "₱78.00", R.drawable.asiafood4, "4.2", "Gian Japanese Restaurant"));
        asiaFoodList.add(new AsiaFood("Hazelnut Asian Lettuce Wrap", "₱45.00", R.drawable.asiafood5, "4.0", "Ronell Chinese House"));

        setAsiaRecycler(asiaFoodList);
    }

    private void setPopularRecycler(List<PopularFood> popularFoodList) {

        popularRecycler = findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularFoodAdapter = new PopularFoodAdapter(this, popularFoodList);
        popularRecycler.setAdapter(popularFoodAdapter);
    }

    private void setAsiaRecycler(List<AsiaFood> asiaFoodList) {

        asiaRecycler = findViewById(R.id.asia_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        asiaRecycler.setLayoutManager(layoutManager);
        asiaFoodAdapter = new AsiaFoodAdapter(this, asiaFoodList);
        asiaRecycler.setAdapter(asiaFoodAdapter);
    }
}