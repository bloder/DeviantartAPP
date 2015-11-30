package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationJson;

/**
 * Created by denis on 18/11/15.
 */

@EViewGroup(R.layout.populardeviationlist)
public class ContentViewHolder extends RelativeLayout {

    @ViewById(R.id.txtTitle)
    protected TextView txtTitle;
    @ViewById(R.id.txtCount)
    protected TextView txtCount;
    @ViewById(R.id.imageView)
    protected ImageView imgURL;
    @ViewById(R.id.user_profile_icon)
    protected ImageView user_profile_icon;

    public ContentViewHolder(Context context) {
        super(context);
    }

    public void setContent(DeviationJson deviation) {
        try {
            txtTitle.setText(deviation.title);
            txtCount.setText(deviation.author.username);
            Picasso.with(getContext()).load(deviation.content.src).resize(900,900).into(imgURL);
            Picasso.with(getContext()).load(deviation.author.usericon).into(user_profile_icon);
        }catch (Exception ex){

        }
    }

}
