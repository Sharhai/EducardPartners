package sm.educardpartners.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sm.educardpartners.R;
import sm.educardpartners.models.User;

/**
 * Created by winify on 5/24/17.
 */

public class BarCodeAdapter extends RecyclerView.Adapter<BarCodeAdapter.VH> {

    private List<User> users = new ArrayList<>();

    private Interactor mInteractor;

    public BarCodeAdapter(Interactor mInteractor) {
        this.mInteractor = mInteractor;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barcode, parent, false));
    }

    public static String getFormatedDate() {
//        Calendar c = Calendar.getInstance();


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd K:mm");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(  System.currentTimeMillis());
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        String name = users.get(position).name;
        String lastname = users.get(position).lastname;
        String university = users.get(position).university;



        holder.tvBarcode.setText(name + " " + lastname + ", " + university + " on "+getFormatedDate());
        holder.tvBarcode.setOnClickListener(v -> mInteractor.onDataPres(users.get(position)));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void addBarcode(User user) {
            users.add(0, user);
            notifyItemInserted(0);
    }

    public static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_barcode)
        TextView tvBarcode;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface Interactor {
        void onDataPres(User data);
    }

}
