package com.project.sooraj.qunoidapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.project.sooraj.qunoidapp.ImageViewActivity;
import com.project.sooraj.qunoidapp.ProfileViewAcitvity;
import com.project.sooraj.qunoidapp.R;
import com.project.sooraj.qunoidapp.model.UnSplash;
import com.project.sooraj.qunoidapp.model.User;


import java.util.List;

/**
 * Created by skynet on 6/24/18.
 */

public class ProfileRecyclerAdapter extends RecyclerView.Adapter<ProfileRecyclerAdapter.ProfileViewHolder> {
    List<UnSplash> eventList;
    Context context;

    public ProfileRecyclerAdapter(List<UnSplash> list, Context context) {
        this.eventList = list;
        this.context = context;
    }


    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);

        return new ProfileViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        final UnSplash unSplash = eventList.get(position);

        if (!checkNull(unSplash.getUser().getUsername())) {
            holder.name.setText(unSplash.getUser().getUsername());
        } else
            holder.name.setText("Lorem Ipsum");

        if (!checkNull(unSplash.getUser().getBio())) {
            holder.description.setText(unSplash.getUser().getBio().toString());
        } else
            holder.description.setText("Lorem Ipsum");


        if (!checkNull(unSplash.getUser().getProfileImage().getLarge())) {
        Glide.with(context).load(unSplash.getUser().getProfileImage().getLarge()).apply(new RequestOptions().transform(new RoundedCorners(16))).into(holder.profile);}
        if (!checkNull(unSplash.getUrls().getFull())) {
        Glide.with(context).load(unSplash.getUrls().getFull()).apply(new RequestOptions().override(600, 200)).into(holder.largeImage);}
        holder.largeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkNull(unSplash.getUser().getBio())&&!checkNull(unSplash.getUrls().getFull())) {
                    Intent intent = new Intent(view.getContext(), ImageViewActivity.class);
                    intent.putExtra("url", unSplash.getUrls().getRegular());
                    intent.putExtra("bio", unSplash.getUser().getBio().toString());
                    view.getContext().startActivity(intent);
                }else
                    Toast.makeText(view.getContext(),"Empty fields",Toast.LENGTH_SHORT).show();
            }
        });
        holder.divSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!checkNull(unSplash.getUser().getBio())&&!checkNull(unSplash.getUser().getUsername())&&!checkNull(unSplash.getUser().getProfileImage().getLarge())) {
                    Intent intent = new Intent(view.getContext(), ProfileViewAcitvity.class);
                    intent.putExtra("url", unSplash.getUser().getProfileImage().getLarge());
                    intent.putExtra("name", unSplash.getUser().getUsername());
                    intent.putExtra("bio", unSplash.getUser().getBio().toString());
                    view.getContext().startActivity(intent);
                }else
                    Toast.makeText(view.getContext(),"Empty fields",Toast.LENGTH_SHORT).show();

            }
        });

    }

    private boolean checkNull(String input) {
        if (TextUtils.isEmpty(input)) {
            return true;

        }
        return false;
    }


    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class ProfileViewHolder extends RecyclerView.ViewHolder {
        ImageView profile, largeImage;
        TextView description, name;
        LinearLayout divSection;

        public ProfileViewHolder(View itemView) {
            super(itemView);
            profile = (ImageView) itemView.findViewById(R.id.proilepic);
            largeImage = (ImageView) itemView.findViewById(R.id.imagebanner);
            description = (TextView) itemView.findViewById(R.id.description);
            name = (TextView) itemView.findViewById(R.id.username);
            divSection = (LinearLayout) itemView.findViewById(R.id.divSectiontwo);


        }
    }
}
