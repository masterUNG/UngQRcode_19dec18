package masterung.th.in.androidthai.ungqrcode;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProduceViewHolder>{

    private Context context;
    private ArrayList<String> nameProductStringArrayList,
            descriptionStringArrayList, amountStringArrayList, pictureStringArrayList;
    private LayoutInflater layoutInflater;

    public ProductAdapter(Context context,
                          ArrayList<String> nameProductStringArrayList,
                          ArrayList<String> descriptionStringArrayList,
                          ArrayList<String> amountStringArrayList,
                          ArrayList<String> pictureStringArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.nameProductStringArrayList = nameProductStringArrayList;
        this.descriptionStringArrayList = descriptionStringArrayList;
        this.amountStringArrayList = amountStringArrayList;
        this.pictureStringArrayList = pictureStringArrayList;
    }   // Constructor

    @NonNull
    @Override
    public ProduceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = layoutInflater.inflate(R.layout.recycler_product, viewGroup, false);
        ProduceViewHolder produceViewHolder = new ProduceViewHolder(view);

        return produceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProduceViewHolder produceViewHolder, int i) {

        String nameProductString = nameProductStringArrayList.get(i);
        String descriptionString = descriptionStringArrayList.get(i);
        String amountString = amountStringArrayList.get(i);
        String urlPictureString = pictureStringArrayList.get(i);

        produceViewHolder.nameProduceTextView.setText(nameProductString);
        produceViewHolder.descriptionTextView.setText(descriptionString);
        produceViewHolder.amountTextView.setText("Amount = " + amountString + " unit");

        Picasso.get().load(urlPictureString).into(produceViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return nameProductStringArrayList.size();
    }

    public class ProduceViewHolder extends RecyclerView.ViewHolder {

//        Explicit
        private TextView nameProduceTextView, descriptionTextView, amountTextView;
        private ImageView imageView;

        public ProduceViewHolder(@NonNull View itemView) {
            super(itemView);

            nameProduceTextView = itemView.findViewById(R.id.txtNameProduct);
            descriptionTextView = itemView.findViewById(R.id.txtDescription);
            amountTextView = itemView.findViewById(R.id.txtAmount);
            imageView = itemView.findViewById(R.id.imvProduct);


        }
    }   // ProduceViewHolder Class

}   // Main Class
