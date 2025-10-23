package com.siwy.zad3;

import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> users;

    public UserAdapter(List<User> users) { this.users = users; }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView name;
        public ViewHolder(View v) {
            super(v);
            avatar = v.findViewById(R.id.avatar);
            name = v.findViewById(R.id.name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User u = users.get(position);
        holder.name.setText(u.getName());
        holder.avatar.setImageResource(u.getAvatarId());
    //ZADANIE 4
        holder.itemView.setOnClickListener(v ->
                Toast.makeText(v.getContext(), "Kliknięto: " + u.getName(), Toast.LENGTH_SHORT).show()
        );
    }
    //KONIEC


    @Override
    public int getItemCount() { return users.size(); }
}

