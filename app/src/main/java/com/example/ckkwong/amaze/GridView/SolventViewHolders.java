package com.example.ckkwong.amaze.GridView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ckkwong.amaze.R;

public class SolventViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "chelseaMsg";
    public ItemObjects object;
    public ImageView countryPhoto;
    public ImageButton favoriteButton;
//    public String itemId;
//    public Boolean isFavorite;
//    public Double price;
    public TextView priceUI;

    public SolventViewHolders(final View itemView) {
        super(itemView);
        favoriteButton = (ImageButton) itemView.findViewById(R.id.favorite);
        countryPhoto = (ImageView) itemView.findViewById(R.id.country_photo);
        itemView.setOnClickListener(this);
        favoriteButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v == favoriteButton){
                            if (object.getIsFavorite()){
                                favoriteButton.setImageResource(R.drawable.ic_favorite_black_24dp);
                                addItemToFavorites();
                            }
                            else{
                                favoriteButton.setAlpha((float)0.8);
                                removeItemFromFavorites();
                            }
                        }
                    }
                });
    }


    @Override
    public void onClick(View view) {
//        Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        Toast.makeText(view.getContext(), "price = " + object.getPrice().toString(), Toast.LENGTH_SHORT).show();
    }

    private void addItemToFavorites(){
        //TODO
    }

    private void removeItemFromFavorites(){
        //TODO
    }
}
