package sm.educardpartners.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sm.educardpartners.R;

/**
 * Created by winify on 5/24/17.
 */

public class BarCodeAdapter extends RecyclerView.Adapter<BarCodeAdapter.VH> {

    private List<String> barcodes = new ArrayList<>();

    private Interactor mInteractor;

    public BarCodeAdapter(Interactor mInteractor) {
        this.mInteractor = mInteractor;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barcode, parent, false));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.tvBarcode.setText(barcodes.get(position));
        holder.tvBarcode.setOnClickListener(v -> mInteractor.onDataPres(barcodes.get(position)));
    }

    @Override
    public int getItemCount() {
        return barcodes.size();
    }

    public void addBarcode(Barcode barcode) {
        if (!barcodes.contains(barcode.rawValue)) {
            barcodes.add(0, barcode.rawValue);
            notifyItemInserted(0);
        }
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
        void onDataPres(String data);
    }

}
