package masterung.th.in.androidthai.ungqrcode;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    //    Explicit
    private String nameProductString, descrittionString, pictureString, receiveString, amountString;


    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment detailInstance(String nameProduct,
                                                String description,
                                                String urlPicture,
                                                String receive,
                                                String amount) {

        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("NameProduct", nameProduct);
        bundle.putString("Description", description);
        bundle.putString("Picture", urlPicture);
        bundle.putString("Receive", receive);
        bundle.putString("Amount", amount);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Receive Value
        receiveValue();

//        Show View
        showView();

    }   // Main Method

    private void showView() {
        TextView nameTextView = getView().findViewById(R.id.txtNameProduct);
        TextView descripTextView = getView().findViewById(R.id.txtDescription);
        TextView amountTextView = getView().findViewById(R.id.txtAmount);
        TextView receiveTextView = getView().findViewById(R.id.txtReceive);
        ImageView imageView = getView().findViewById(R.id.imvProduct);

        nameTextView.setText(nameProductString);
        descripTextView.setText(descrittionString);
        amountTextView.setText("Amount ==> " + amountString + " unit");
        receiveTextView.setText(receiveString);

        Picasso.get().load(pictureString).into(imageView);

    }

    private void receiveValue() {
        nameProductString = getArguments().getString("NameProduct", "NameProduct");
        descrittionString = getArguments().getString("Description", "Description");
        pictureString = getArguments().getString("Picture", "https://firebasestorage.googleapis.com/v0/b/ungqrcode.appspot.com/o/Product%2Ficonfinder_advantage_calculator_1034351.png?alt=media&token=4f032d5f-508d-4bf4-9999-70e342d899d2");
        receiveString = getArguments().getString("Receive", "Receive");
        amountString = getArguments().getString("Amount", "Amount");
        Log.d("20decV2", "name ==> " + nameProductString);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

}
