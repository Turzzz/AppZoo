package com.example.appzoo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appzoo.R;
import com.example.appzoo.model.team;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.myviewHolder> implements Filterable {

    adapterListener listener;

    List<team> playerList;
    List<team> playerListFull;
    Context context;

    int layoutResource = R.layout.row_team_item;

    public TeamAdapter(List<team> playerList, Context context) {
        this.playerList = playerList;
        this.context = context;
        playerListFull = new ArrayList<>(playerList);

    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResource,parent,false);
        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, final int position) {

        team team = playerList.get(position);
        holder.image.setImageResource(team.getImageRes());
        holder.titleText.setText(team.getTitle());
        holder.agetext.setText( "Age : " + team.getAge());
        holder.teamText.setText("Team Name : " + team.getTeam_name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(listener != null){
//                Toast.makeText(context, "dsa " +position, Toast.LENGTH_SHORT).show();
                  listener.onIteamClick(position);
                    }
            }
        });
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    class myviewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView titleText, agetext, teamText;
        public myviewHolder(@NonNull View itemView) {

            super(itemView);


            image = itemView.findViewById(R.id.image);
            titleText = itemView.findViewById(R.id.titleText);
            agetext = itemView.findViewById(R.id.agetext);
            teamText = itemView.findViewById(R.id.teamText);

        }
    }

        public void setAdapterListener(adapterListener l){

                 this.listener=l;
        }

        public  interface adapterListener{

            void onIteamClick(int position);
        }


    @Override
    public Filter getFilter() {
        return playerfilter;
    }

    private Filter playerfilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<team> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0 ) {
                filteredList.addAll(playerListFull);
            }
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(team player : playerListFull ) {
                    if(player.getTitle().toLowerCase().contains(filterPattern)){

                        filteredList.add(player);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                 playerList.clear();
                 playerList.addAll((List)results.values);
                 notifyDataSetChanged();
        }
    };
}
