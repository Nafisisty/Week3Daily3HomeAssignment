package com.example.week3daily3homeassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week3daily3homeassignment.model.user.Result;
import com.example.week3daily3homeassignment.model.user.User;
import com.google.gson.Gson;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    User userArrayList;

    public RecyclerViewAdapter(User userArrayList) {
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int postion) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int postion) {

        Result result = userArrayList.getResults().get(postion);
        ItemUser itemUser = new ItemUser();

        itemUser.setName(result.getName().getTitle()+ " " + result.getName().getFirst() + " " + result.getName().getLast());
        itemUser.setSmallImage(result.getPicture().getMedium());
        itemUser.setLargeImage(result.getPicture().getLarge());
        itemUser.setGender(result.getGender());
        itemUser.setAge(result.getDob().getAge());
        itemUser.setDob(result.getDob().getDate());
        itemUser.setEmail(result.getEmail());
        itemUser.setLocation(result.getLocation().getStreet() + " " + result.getLocation().getCity()+ " " + result.getLocation().getState()+ " " + result.getLocation().getPostcode());
        itemUser.setPhone(result.getPhone());
        itemUser.setCell(result.getCell());
        itemUser.setNat(result.getNat());

        if(result != null) {
            viewHolder.setItemUser(itemUser);

            viewHolder.userNameTextView.setText(itemUser.getName());

            Glide.with(viewHolder.imageView)
                    .load("" + itemUser.getSmallImage())
                    .into(viewHolder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return userArrayList != null ? userArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView userNameTextView;
        ItemUser itemUser;

        public void setItemUser(ItemUser itemUser) {
            this.itemUser = itemUser;
        }

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.userImageViewId);
            userNameTextView = itemView.findViewById(R.id.userNameTextViewId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), UserDetails.class);
                    intent.putExtra("user", new Gson().toJson(itemUser));
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
